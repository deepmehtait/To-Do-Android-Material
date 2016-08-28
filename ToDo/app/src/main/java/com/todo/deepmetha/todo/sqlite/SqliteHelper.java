package com.todo.deepmetha.todo.sqlite;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by deepmetha on 8/28/16.
 */
public class SqliteHelper extends SQLiteOpenHelper {
    // Constants
    public static final String DatabaseName = "ToDoDb.db";
    public static final String TableName = "ToDoTask";
    public static final String Col_1 = "ToDoID";
    public static final String Col_2 = "ToDoTaskDetails";
    public static final String Col_3 = "ToDoTaskPrority";
    public static final String Col_4 = "ToDoTaskStatus";

    // Create DB to store To Do Tasks
    public SqliteHelper(Context context) {
        super(context, DatabaseName, null, 1);

    }

    // Create Table
    @Override
    public void onCreate(SQLiteDatabase db) {
        String createTableQuery = "create table if not exists " + TableName + " ( ToDoID int NOT NULL AUTO_INCREMENT PRIMARY KEY, ToDoTaskDetails TEXT, ToDoTaskPrority TEXT, ToDoTaskStatus TEXT )";
        db.execSQL(createTableQuery);
    }

    // Drop Table for new table creation
    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {
        db.execSQL("DROP TABLE IF EXISTS "+TableName);
        onCreate(db);
    }
}
