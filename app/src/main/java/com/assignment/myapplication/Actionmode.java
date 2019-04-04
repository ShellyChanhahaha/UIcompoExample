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
