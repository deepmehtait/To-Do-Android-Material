package com.todo.deepmetha.todo.activity;

import android.content.Intent;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.v7.app.AppCompatActivity;

import com.todo.deepmetha.todo.sqlite.SqliteHelper;

/**
 * Created by deepmetha on 8/28/16.
 */
public class SplashActivity extends AppCompatActivity {
    SqliteHelper mySqliteHelper;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // Create Sqlite DB
        mySqliteHelper = new SqliteHelper(this);
        // Go to Main Activity
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
        finish();
    }
}
