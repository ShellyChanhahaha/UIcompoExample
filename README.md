# 实验三

## 实验目的

加深对UI组件应用理解，学会使用ListView，SimpleAdapter，alertdialog，menu以及ActionMode等UI组件。

## 实验内容

1.Android ListView的用法

2.创建自定义布局的AlertDialog

3.使用XML定义菜单

4.创建上下文操作模式(ActionMode)的上下文菜单

## 代码

### 主活动页 

#### IndexActivity.java

```java
package com.assignment.myapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class IndexActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_index);
    }
    public void toSimple(View view){
        Intent intent=new Intent(this,MainActivity.class);
        startActivity(intent);
    }
    public void toAlertDialog(View view) {
        Intent intent = new Intent(this, AlertDialogActivity.class);
        startActivity(intent);
    }
    public void toMenuTest(View view) {
        Intent intent = new Intent(this, MenuActivity.class);
        startActivity(intent);
    }
    public void toActionmode(View view){
        Intent intent = new Intent(this, Actionmode.class);
        startActivity(intent);
    }


}
```

#### 

### 主活动页布局

#### activity_index.xml

```xml
<?xml version="1.0" encoding="utf-8"?>
<android.support.constraint.ConstraintLayout xmlns:android="http://schemas.android.com/apk/res/android"
    xmlns:app="http://schemas.android.com/apk/res-auto"
    xmlns:tools="http://schemas.android.com/tools"
    android:layout_width="match_parent"
    android:layout_height="match_parent"
    tools:context=".IndexActivity">
    <TextView
        android:id="@+id/Type"
        android:layout_width="100dp"
        android:layout_height="50dp"
        android:text="@string/UIcomponent"
        android:layout_marginTop="10dp"
        app:layout_constraintLeft_toLeftOf="parent"
        app:layout_constraintRight_toRightOf="parent"
        app:layout_constraintTop_toTopOf="parent"
        />

    <Button
        android:id="@+id/simple"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:layout_marginTop="30dp"
        android:text="@string/simpleAdaptor"
        android:onClick="toSimple"
        app:layout_constraintLeft_toLeftOf="parent"
        app:layout_constraintRight_toRightOf="parent"
        app:layout_constraintTop_toBottomOf="@id/Type" />

    <Button
        android:id="@+id/alert"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:layout_marginTop="20dp"
        android:text="@string/alertdialog"
        android:onClick="toAlertDialog"
        app:layout_constraintLeft_toLeftOf="parent"
        app:layout_constraintRight_toRightOf="parent"
        app:layout_constraintTop_toBottomOf="@id/simple" />

    <Button
        android:id="@+id/menu"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:layout_marginTop="20dp"
        android:text="@string/menutest"
        android:onClick="toMenuTest"
        app:layout_constraintLeft_toLeftOf="parent"
        app:layout_constraintRight_toRightOf="parent"
        app:layout_constraintTop_toBottomOf="@id/alert" />

    <Button
        android:id="@+id/actionmode"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:layout_marginTop="20dp"
        android:text="@string/actionmode"
        android:onClick="toActionmode"
        app:layout_constraintLeft_toLeftOf="parent"
        app:layout_constraintRight_toRightOf="parent"
        app:layout_constraintTop_toBottomOf="@id/menu" />

</android.support.constraint.ConstraintLayout>
```

#### 

### 第一题

#### MainActivity.java

```java
package com.assignment.myapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MainActivity extends AppCompatActivity {

    private List<Map<String,Object>> list;
    private ListView listView;
    private void initData(){
        int img[]={R.drawable.lion,R.drawable.tiger,R.drawable.monkey,R.drawable.dog,R.drawable.cat,R.drawable.elephant};
        String text[]={"lion","tiger","monkey","dog","cat","elephant"};
        list=new ArrayList<Map<String,Object>>();
        for(int i=0;i<text.length;i++){
            Map<String,Object> map=new HashMap<String,Object>();
            map.put("text",text[i]);
            map.put("image",img[i]);
            list.add(map);
        }
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        listView=(ListView)findViewById(R.id.listview);
        String[] from={"text","image"};
        int[] to={R.id.name,R.id.picture};
        initData();
        final SimpleAdapter simpleAdapter=new SimpleAdapter(this,list,R.layout.contentlayout,from,to);
        listView.setAdapter(simpleAdapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                TextView textView=view.findViewById(R.id.name);
                CharSequence text=textView.getText();
                Toast toast=Toast.makeText(MainActivity.this,text,Toast.LENGTH_SHORT);
                toast.show();
            }
        });
    }
}
```

#### activity_main.xml

```xml
<?xml version="1.0" encoding="utf-8"?>
<android.support.constraint.ConstraintLayout xmlns:android="http://schemas.android.com/apk/res/android"
    xmlns:app="http://schemas.android.com/apk/res-auto"
    xmlns:tools="http://schemas.android.com/tools"
    android:layout_width="match_parent"
    android:layout_height="match_parent"
    tools:context=".MainActivity"
    >

    <ListView
        android:id="@+id/listview"
        android:layout_width="match_parent"
        android:layout_height="match_parent"
        android:cacheColorHint="@android:color/transparent"
    />
</android.support.constraint.ConstraintLayout>
```

#### contentlayout.xml

```xml
<?xml version="1.0" encoding="utf-8"?>
<LinearLayout xmlns:android="http://schemas.android.com/apk/res/android"
    android:layout_width="match_parent"
    android:layout_height="match_parent"
    android:orientation="horizontal"
    android:background="@drawable/selector">
        <TextView
            android:id="@+id/name"
            android:layout_width="0dp"
            android:layout_height="wrap_content"
            android:layout_weight="1"
            android:layout_gravity="left"
            />
        <ImageView
            android:id="@+id/picture"
            android:layout_width="48dp"
            android:layout_height="48dp"
            android:layout_gravity="right"/>

</LinearLayout>
```

### 第二题

#### AlertDialogActivity.java

```java
import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.LinearLayout;

public class AlertDialogActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.alertpage_layout);
        LinearLayout alertdialog=(LinearLayout)getLayoutInflater().inflate(R.layout.activity_alert_dialog,null);
        new AlertDialog.Builder(this)
                .setIcon(R.drawable.header_logo)
                .setView(alertdialog)
                .setPositiveButton("sign in", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                    }
                })
                .setNegativeButton("cancel",new DialogInterface.OnClickListener(){
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                    }
                })
                .create()
                .show();

    }
}
```

#### activity_alert_dialog.xml

```xml
<?xml version="1.0" encoding="utf-8"?>
<LinearLayout xmlns:android="http://schemas.android.com/apk/res/android"
    xmlns:app="http://schemas.android.com/apk/res-auto"
    xmlns:tools="http://schemas.android.com/tools"
    android:layout_width="match_parent"
    android:layout_height="match_parent"
    android:orientation="vertical">
<EditText
    android:layout_width="match_parent"
    android:layout_height="wrap_content"
    android:id="@+id/username"
    android:hint="@string/username"
    />
<EditText
    android:layout_width="match_parent"
    android:layout_height="wrap_content"
    android:id="@+id/password"
    android:hint="@string/password"
    android:inputType="numberPassword"
    />
</LinearLayout>
```

#### alertpage_layout.xml

```xml
<?xml version="1.0" encoding="utf-8"?>
<LinearLayout xmlns:android="http://schemas.android.com/apk/res/android"
    android:layout_width="match_parent"
    android:layout_height="match_parent"
    xmlns:tools="http://schemas.android.com/tools"
    tools:context=".AlertDialogActivity">

</LinearLayout>
```

### 第三题

#### MenuActivity

```java
package com.assignment.myapplication;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.TextView;
import android.widget.Toast;

public class MenuActivity extends AppCompatActivity {

    private TextView txt;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);
        txt=(TextView)findViewById(R.id.txt);

    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu){
        MenuInflater inflater=new MenuInflater(this);
        inflater.inflate(R.menu.menu,menu);
        return super.onCreateOptionsMenu(menu);
    }
    public boolean onOptionsItemSelected(MenuItem mi){
        if(mi.isCheckable()){
            mi.setChecked(true);
        }
        switch(mi.getItemId()){
            case R.id.font_10:
                txt.setTextSize(10*2);
                break;
            case R.id.font_16:
                txt.setTextSize(16*2);
                break;
            case R.id.font_20:
                txt.setTextSize(20*2);
                break;
            case R.id.red:
                txt.setTextColor(Color.RED);
                mi.setChecked(true);
                break;
            case R.id.black:
                txt.setTextColor(Color.BLACK);
                mi.setChecked(true);
                break;
            case R.id.normal:
                Toast toast=Toast.makeText(MenuActivity.this,"您单击了普通菜单选项", Toast.LENGTH_LONG);
                toast.show();
                break;
        }
        return true;
    }

}
```

#### activity_menu.xml

```xml
<?xml version="1.0" encoding="utf-8"?>
<android.support.constraint.ConstraintLayout xmlns:android="http://schemas.android.com/apk/res/android"
    xmlns:app="http://schemas.android.com/apk/res-auto"
    xmlns:tools="http://schemas.android.com/tools"
    android:layout_width="match_parent"
    android:layout_height="match_parent"
    tools:context=".MenuActivity">
    <TextView
        android:id="@+id/txt"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:text="@string/test"
        app:layout_constraintTop_toTopOf="parent"
        app:layout_constraintStart_toStartOf="parent" />
</android.support.constraint.ConstraintLayout>
```

#### menu.xml

```xml
<?xml version="1.0" encoding="utf-8"?>
<menu xmlns:android="http://schemas.android.com/apk/res/android">
    <item android:title="@string/font_size">
        <menu>
          <group >
              <item
                  android:id="@+id/font_10"
                  android:title="@string/font_10">
              </item>
              <item
                  android:id="@+id/font_16"
                  android:title="@string/font_16">
              </item>
              <item
                  android:id="@+id/font_20"
                  android:title="@string/font_20">
              </item>
          </group>
        </menu>
    </item>
    <item
        android:id="@+id/normal"
        android:title="@string/normal">
    </item>
    <item android:title="@string/font_color">
        <menu>
            <group>
                <item
                    android:id="@+id/red"
                    android:title="@string/red">
                </item>
                <item
                    android:id="@+id/black"
                    android:title="@string/black">
                </item>
            </group>
        </menu>
    </item>
</menu>
```

### 第四题

#### ActionMode.java

```java
package com.assignment.myapplication;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.ActionMode;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.AbsListView;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Actionmode extends AppCompatActivity {
    private String[] text={"One","Two","Three","Four","Five"};
    private int images=R.drawable.android1;
    private String[] from={"imagess","txt"};
    private int[] to={R.id.imagess,R.id.txt1};
    ListView list;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_actionmode);
        List<Map<String,Object>> l=new ArrayList<Map<String,Object>>();
        for(int i=0;i<text.length;i++){
            Map<String,Object> m=new HashMap<String,Object>();
            m.put("imagess",images);
            m.put("txt",text[i]);
            l.add(m);
        }
        SimpleAdapter adapter=new SimpleAdapter(this,l,R.layout.action_mode_layout,from,to);
        list=findViewById(R.id.modelist);
        list.setAdapter(adapter);
        registerForContextMenu(list);
        list.setChoiceMode(ListView.CHOICE_MODE_MULTIPLE_MODAL);
        list.setMultiChoiceModeListener(new AbsListView.MultiChoiceModeListener() {
            private int count=0;

            @Override
            public void onItemCheckedStateChanged(ActionMode mode, int position, long id, boolean checked) {

                if(checked){
                    list.getChildAt(position).setBackgroundColor(Color.RED);
                    count++;
                }else{
                    list.getChildAt(position).setBackgroundColor(0);
                    count--;
                }
                mode.setTitle(count+"selected");
            }

            @Override
            public boolean onCreateActionMode(ActionMode mode, Menu menu) {
                MenuInflater inflater = mode.getMenuInflater();
                return true;
            }

            @Override
            public boolean onPrepareActionMode(ActionMode mode, Menu menu) {
                return false;
            }

            @Override
            public boolean onActionItemClicked(ActionMode mode, MenuItem item) {
                return false;
            }

            @Override
            public void onDestroyActionMode(ActionMode mode) {

            }
        });
    }
}
```

#### activity_actionmode.xml

```xml
<?xml version="1.0" encoding="utf-8"?>
<android.support.constraint.ConstraintLayout xmlns:android="http://schemas.android.com/apk/res/android"
    xmlns:app="http://schemas.android.com/apk/res-auto"
    xmlns:tools="http://schemas.android.com/tools"
    android:layout_width="match_parent"
    android:layout_height="match_parent"
    tools:context=".Actionmode">

    <ListView
        android:layout_width="match_parent"
        android:layout_height="wrap_content"
        android:id="@+id/modelist"
        android:choiceMode="multipleChoice"
        app:layout_constraintTop_toTopOf="parent">
    </ListView>
</android.support.constraint.ConstraintLayout>
```

#### actionmode_mode_layout.xml

```xml
<?xml version="1.0" encoding="utf-8"?>
<LinearLayout xmlns:android="http://schemas.android.com/apk/res/android"
    android:layout_width="match_parent"
    android:layout_height="match_parent"
    android:orientation="horizontal">
    <ImageView
        android:id="@+id/imagess"
        android:layout_width="70dp"
        android:layout_height="70dp" />
    <TextView
        android:id="@+id/txt1"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:textStyle="bold"
        android:layout_gravity="center"
        android:layout_marginLeft="50dp"/>
</LinearLayout>
```

## 结果截图

### 第一题
![Screenshot_2019-03-26-11-15-33-09.png](https://i.loli.net/2019/04/04/5ca60dd08b7d7.png)

![Screenshot_2019-03-26-11-16-02-10.png](https://i.loli.net/2019/04/04/5ca60e675d05e.png)

### 第二题
![Screenshot_2019-04-03-20-49-35-92.png](https://i.loli.net/2019/04/04/5ca61ceddae13.png)

### 第三题
![Screenshot_2019-04-03-20-49-58-62.png](https://i.loli.net/2019/04/04/5ca61d0703dda.png)
![Screenshot_2019-04-03-20-50-02-11.png](https://i.loli.net/2019/04/04/5ca61d197d739.png)

### 第四题
![Screenshot_2019-04-03-20-45-55-63.png](https://i.loli.net/2019/04/04/5ca61c7c43d4a.png)
