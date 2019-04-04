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


