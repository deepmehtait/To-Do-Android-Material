package com.todo.deepmetha.todo.adapters;

import android.app.Dialog;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.drawable.GradientDrawable;
import android.os.Handler;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.todo.deepmetha.todo.R;
import com.todo.deepmetha.todo.modal.ToDoData;
import com.todo.deepmetha.todo.sqlite.SqliteHelper;
import com.todo.deepmetha.todo.utils.AppTager;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by deepmetha on 8/28/16.
 */
public class ToDoListAdapter extends RecyclerView.Adapter<ToDoListAdapter.ToDoListViewHolder> {
    List<ToDoData> ToDoDataArrayList = new ArrayList<ToDoData>();
    Context context;

    public ToDoListAdapter(String details) {
        ToDoData toDoData = new ToDoData();
        toDoData.setToDoTaskDetails(details);
        ToDoDataArrayList.add(toDoData);
    }

    public ToDoListAdapter(ArrayList<ToDoData> toDoDataArrayList, Context context) {
        this.ToDoDataArrayList = toDoDataArrayList;
        this.context = context;
    }

    @Override
    public ToDoListViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.custom_cardlayout, parent, false);
        ToDoListViewHolder toDoListViewHolder = new ToDoListViewHolder(view, context);
        return toDoListViewHolder;
    }

    @Override
    public void onBindViewHolder(ToDoListViewHolder holder, final int position) {
        final ToDoData td = ToDoDataArrayList.get(position);
        holder.todoDetails.setText(td.getToDoTaskDetails());
        String tdStatus = td.getToDoTaskStatus();
        if (tdStatus.matches("Complete")) {
            holder.todoDetails.setPaintFlags(Paint.STRIKE_THRU_TEXT_FLAG);
        }
        String type = td.getToDoTaskPrority();
        int color = 0;
        if (type.matches("Normal")) {
            color = Color.parseColor("#009EE3");
        } else if (type.matches("Low")) {
            color = Color.parseColor("#33AA77");
        } else {
            color = Color.parseColor("#FF7799");
        }
        ((GradientDrawable) holder.proprityColor.getBackground()).setColor(color);

        holder.deleteButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int id = td.getToDoID();
                SqliteHelper mysqlite = new SqliteHelper(view.getContext());
                Cursor b = mysqlite.deleteTask(id);
                if (b.getCount() == 0) {
                    Toast.makeText(view.getContext(), "Deleted", Toast.LENGTH_SHORT).show();
                    new Handler().post(new Runnable() {
                        @Override
                        public void run() {
                            // Code here will run in UI thread
                            Log.v(AppTager.getTag(), "IN UI thread");
                            /* ToDoDataArrayList.remove(position);
                            notifyItemRemoved(position);
                            notifyItemRangeChanged(position,ToDoDataArrayList.size()); */
                            //notifyDataSetChanged();
                        }
                    });
                } else {
                    Toast.makeText(view.getContext(), "Deleted else", Toast.LENGTH_SHORT).show();
                }


            }
        });
        holder.edit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final Dialog dialog = new Dialog(view.getContext());
                dialog.setContentView(R.layout.custom_dailog);
                dialog.show();
                EditText todoText = (EditText) dialog.findViewById(R.id.input_task_desc);
                CheckBox cb = (CheckBox) dialog.findViewById(R.id.checkbox);
                if (td.getToDoTaskStatus().matches("Complete")) {
                    cb.setChecked(true);
                }
                todoText.setText(td.getToDoTaskDetails());
                Log.v(AppTager.getTag(), td.toString());
                Button save = (Button) dialog.findViewById(R.id.btn_save);
                save.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        EditText todoText = (EditText) dialog.findViewById(R.id.input_task_desc);
                        CheckBox cb = (CheckBox) dialog.findViewById(R.id.checkbox);
                        if (todoText.getText().length() >= 2) {
                            RadioGroup proritySelection = (RadioGroup) dialog.findViewById(R.id.toDoRG);
                            String RadioSelection = new String();
                            if (proritySelection.getCheckedRadioButtonId() != -1) {
                                int id = proritySelection.getCheckedRadioButtonId();
                                View radiobutton = proritySelection.findViewById(id);
                                int radioId = proritySelection.indexOfChild(radiobutton);
                                RadioButton btn = (RadioButton) proritySelection.getChildAt(radioId);
                                RadioSelection = (String) btn.getText();
                            }
                            Log.v(AppTager.getTag(), "To Do -" + todoText.getText() + " prority - " + RadioSelection);
                            ContentValues contentValues = new ContentValues();
                            contentValues.put("ToDoTaskDetails", todoText.getText().toString());
                            contentValues.put("ToDoTaskPrority", RadioSelection);
                            contentValues.put("ToDoTaskStatus", "Incomplete");
                            ToDoData updateTd = new ToDoData();
                            updateTd.setToDoID(td.getToDoID());
                            updateTd.setToDoTaskDetails(todoText.getText().toString());
                            updateTd.setToDoTaskPrority(RadioSelection);
                            if (cb.isChecked()) {
                                updateTd.setToDoTaskStatus("Complete");
                            } else {
                                updateTd.setToDoTaskStatus("Incomplete");
                            }
                            SqliteHelper mysqlite = new SqliteHelper(view.getContext());
                            Cursor b = mysqlite.updateTask(updateTd);
                            ToDoDataArrayList.set(position, updateTd);
                            if (b.getCount() == 0) {
                                //Toast.makeText(view.getContext(), "Some thing went wrong", Toast.LENGTH_SHORT).show();
                                new Handler().post(new Runnable() {
                                    @Override
                                    public void run() {
                                        // Code here will run in UI thread
                                        Log.v(AppTager.getTag(), "IN UI thread");
                                        notifyDataSetChanged();
                                    }
                                });
                                dialog.hide();
                            } else {


                                dialog.hide();

                            }

                        } else {
                            Toast.makeText(view.getContext(), "Please enter To Do Task", Toast.LENGTH_SHORT).show();
                        }
                        Log.v(AppTager.getTag(), "Save Clicked of edit");
                    }
                });
                Log.v(AppTager.getTag(), "edit clicked?");
            }
        });


    }

    @Override
    public int getItemCount() {
        return ToDoDataArrayList.size();
    }

    public class ToDoListViewHolder extends RecyclerView.ViewHolder {
        TextView todoDetails;
        ImageButton proprityColor;
        ImageView edit, deleteButton;
        ToDoData toDoData;

        public ToDoListViewHolder(View view, final Context context) {
            super(view);
            todoDetails = (TextView) view.findViewById(R.id.toDoTextDetails);
            proprityColor = (ImageButton) view.findViewById(R.id.typeCircle);
            edit = (ImageView) view.findViewById(R.id.edit);
            deleteButton = (ImageView) view.findViewById(R.id.delete);
            view.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Log.v(AppTager.getTag(), "clicked on task");
                }
            });
        }
    }
}
