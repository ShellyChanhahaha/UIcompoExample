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
