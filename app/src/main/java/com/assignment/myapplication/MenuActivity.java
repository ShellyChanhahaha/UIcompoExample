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
