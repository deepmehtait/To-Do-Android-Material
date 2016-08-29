package com.todo.deepmetha.todo.adapters;

import android.content.Context;
import android.graphics.Typeface;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.todo.deepmetha.todo.R;
import com.todo.deepmetha.todo.modal.ToDoData;
import com.todo.deepmetha.todo.utils.AppTager;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by deepmetha on 8/28/16.
 */
public class ToDoListAdapter extends RecyclerView.Adapter<ToDoListAdapter.ToDoListViewHolder> {
    List<ToDoData> ToDoDataArrayList = new ArrayList<ToDoData>();
    Context context;

    public ToDoListAdapter(String details){
        ToDoData toDoData = new ToDoData();
        toDoData.setToDoTaskDetails(details);
        ToDoDataArrayList.add(toDoData);
    }

    public ToDoListAdapter(ArrayList<ToDoData> toDoDataArrayList, Context context){
        this.ToDoDataArrayList = toDoDataArrayList;
        this.context = context;
    }

    @Override
    public ToDoListViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.custom_cardlayout,parent,false);
        ToDoListViewHolder toDoListViewHolder = new ToDoListViewHolder(view,context);
        return toDoListViewHolder;
    }

    @Override
    public void onBindViewHolder(ToDoListViewHolder holder, int position) {
        ToDoData td = ToDoDataArrayList.get(position);
        holder.todoDetails.setText(td.getToDoTaskDetails());


    }

    @Override
    public int getItemCount() {
        return ToDoDataArrayList.size();
    }

    public class ToDoListViewHolder extends RecyclerView.ViewHolder {
        TextView todoDetails;
        ToDoData toDoData;

        public ToDoListViewHolder(View view, final Context context) {
            super(view);
            todoDetails = (TextView) view.findViewById(R.id.toDoTextDetails);
            view.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Log.v(AppTager.getTag(),"clicked on task");
                }
            });
        }
    }
}
