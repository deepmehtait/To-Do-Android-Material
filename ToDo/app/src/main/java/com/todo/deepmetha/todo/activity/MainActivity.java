package com.todo.deepmetha.todo.activity;


import android.app.Dialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.ImageButton;

import com.todo.deepmetha.todo.R;
import com.todo.deepmetha.todo.adapters.ToDoListAdapter;
import com.todo.deepmetha.todo.modal.ToDoData;
import com.todo.deepmetha.todo.utils.AppTager;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    ImageButton addTask;
    RecyclerView recyclerView;
    RecyclerView.Adapter adapter;
    RecyclerView.LayoutManager layoutManager;
    ArrayList<ToDoData> tdd = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerView = (RecyclerView) findViewById(R.id.recycler_view_s);
        layoutManager = new LinearLayoutManager(getApplicationContext());
        addTask = (ImageButton) findViewById(R.id.imageButton);
        ToDoData td1 = new ToDoData();
        td1.setToDoTaskDetails("some task 1");
        tdd.add(td1);
        ToDoData td2 = new ToDoData();
        td2.setToDoTaskDetails("some task 2 \n some thing to do with color \n some other words and this is really long task");
        ToDoData td3 = new ToDoData();
        td3.setToDoTaskDetails("some task 2 \n some thing to do with color \n some other words and this is really long task");
        tdd.add(td3);
        tdd.add(td2);
        tdd.add(td1);
        tdd.add(td3);
        tdd.add(td2);
        tdd.add(td1);
        tdd.add(td3);
        tdd.add(td2);
        tdd.add(td1);
        tdd.add(td3);
        adapter = new ToDoListAdapter(tdd, getApplicationContext());
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(adapter);
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
