package com.test.myapplication.fragment;


import android.os.Bundle;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.room.Room;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.test.myapplication.R;
import com.test.myapplication.Task;
import com.test.myapplication.TaskAdapter;
import com.test.myapplication.db.AppDatabase;

import java.util.List;

public class TaskListFragment extends Fragment {


    private AppDatabase db;

    public TaskListFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        db = Room.databaseBuilder(getContext(), AppDatabase.class, "MasterImp").allowMainThreadQueries().build();
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_task_list, container, false);
        RecyclerView recyclerViewTask = view.findViewById(R.id.rv_task_list);
        recyclerViewTask.setLayoutManager(new LinearLayoutManager(getContext()));
        FloatingActionButton floatingActionButton = view.findViewById(R.id.fab);
        floatingActionButton.setOnClickListener(v->{
            FragmentManager fm = ((AppCompatActivity)v.getContext()).getSupportFragmentManager();
            FragmentTransaction ft = fm.beginTransaction();
            ft.addToBackStack("Input Screen");
            ft.replace(R.id.fragment_container, new InputFragment());
            ft.commit();
        });
        List<Task> taskList = db.getTasks().getAllTasks();
        TaskAdapter adapter = new TaskAdapter(taskList);
        recyclerViewTask.setAdapter(adapter);
        return view;
    }

}
