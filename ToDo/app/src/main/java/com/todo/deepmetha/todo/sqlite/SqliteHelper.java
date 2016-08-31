package com.todo.deepmetha.todo.sqlite;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.todo.deepmetha.todo.modal.ToDoData;

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
    public static final String Col_5 = "ToDoNotes";

    // Create DB to store To Do Tasks
    public SqliteHelper(Context context) {
        super(context, DatabaseName, null, 1);

    }

    // Create Table
    @Override
    public void onCreate(SQLiteDatabase db) {
        String createTableQuery = "create table if not exists " + TableName + " ( ToDoID INTEGER PRIMARY KEY AUTOINCREMENT, ToDoTaskDetails TEXT, ToDoTaskPrority TEXT, ToDoTaskStatus TEXT, ToDoNotes TEXT)";
        db.execSQL(createTableQuery);
    }

    // Drop Table for new table creation
    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {
        db.execSQL("DROP TABLE IF EXISTS " + TableName);
        onCreate(db);
    }

    // Insert into Table
    public boolean insertInto(ContentValues cv) {
        SQLiteDatabase db = this.getWritableDatabase();
        long results = db.insert(TableName, null, cv);
        if (results == -1) {
            return false;
        } else {
            return true;
        }
    }

    // Select * from Table i.e get all data
    public Cursor selectAllData() {
        SQLiteDatabase db = this.getWritableDatabase();
        String query = "select * from " + TableName;
        Cursor result = db.rawQuery(query, null);
        return result;
    }

    // Update specific Task
    public Cursor updateTask(ToDoData td) {
        SQLiteDatabase db = this.getWritableDatabase();
        String query = "UPDATE "
                + TableName
                + " SET "
                + Col_2 + "='" + td.getToDoTaskDetails()
                + "', "
                + Col_3 + "='" + td.getToDoTaskPrority()
                + "', "
                + Col_4 + "='" + td.getToDoTaskStatus()
                + "', "
                + Col_5 + "='" + td.getToDoNotes()
                + "' WHERE " + Col_1 + "='" + td.getToDoID() + "'";
        Cursor results = db.rawQuery(query, null);
        return results;
    }

    // Delete specific Task
    public Cursor deleteTask(int id) {
        SQLiteDatabase db = this.getWritableDatabase();
        String query = "DELETE FROM " + TableName
                + " WHERE "
                + Col_1 + "='"
                + id + "'";
        Cursor result = db.rawQuery(query, null);
        return result;
    }
}
