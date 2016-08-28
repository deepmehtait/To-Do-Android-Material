package com.todo.deepmetha.todo.activity;


import android.app.Dialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageButton;

import com.todo.deepmetha.todo.R;
import com.todo.deepmetha.todo.utils.AppTager;

public class MainActivity extends AppCompatActivity {
    ImageButton addTask;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        addTask = (ImageButton) findViewById(R.id.imageButton);
        addTask.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Log.v(AppTager.getTag(),"Opening Custom Dailog");
                final Dialog dialog = new Dialog(MainActivity.this);
                dialog.setContentView(R.layout.custom_dailog);
                dialog.show();
            }
        });
    }
}
