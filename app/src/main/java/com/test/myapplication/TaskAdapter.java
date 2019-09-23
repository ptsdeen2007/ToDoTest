package com.test.myapplication;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.RecyclerView;

import com.test.myapplication.fragment.InputFragment;

import java.util.List;

public class TaskAdapter extends RecyclerView.Adapter<TaskAdapter.TaskHolder> {
    private LayoutInflater layout;
    private List<Task> taskList;

    public TaskAdapter(List<Task> taskList) {

        this.taskList = taskList;
    }

    @NonNull
    @Override
    public TaskHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        if (layout == null) {
            layout = LayoutInflater.from(parent.getContext());
        }
        View view = layout.inflate(R.layout.task_row, parent, false);
        return new TaskHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull TaskHolder holder, int position) {
        Task task = taskList.get(position);
        holder.tv_headder.setText(task.getTitle());
        holder.tv_boddy.setText(task.getDescription());
        holder.cb_id_done.setOnCheckedChangeListener((compoundButton, b) -> {

        });
        holder.itemView.setOnClickListener(view -> {
            FragmentManager fm = ((AppCompatActivity)view.getContext()).getSupportFragmentManager();
            FragmentTransaction ft = fm.beginTransaction();
            ft.addToBackStack("Input Screen");
            InputFragment fragment = new InputFragment();
            Bundle bundle=new Bundle();
            bundle.putInt("id",task.id);
            fragment.setArguments(bundle);
            ft.replace(R.id.fragment_container, fragment);
            ft.commit();
//            ((AppCompatActivity)view.getContext()).getSupportFragmentManager();

        });
    }

    @Override
    public int getItemCount() {
        return taskList.size();
    }

    class TaskHolder extends RecyclerView.ViewHolder {
        TextView tv_headder;
        TextView tv_boddy;
        CheckBox cb_id_done;

        public TaskHolder(@NonNull View itemView) {
            super(itemView);
            tv_headder = itemView.findViewById(R.id.tv_headder);
            tv_boddy = itemView.findViewById(R.id.tv_boddy);
            cb_id_done = itemView.findViewById(R.id.cb_id_done);
        }
    }
}
