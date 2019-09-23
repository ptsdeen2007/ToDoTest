package com.test.myapplication;


import android.os.Bundle;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public class TaskListFragment extends Fragment {


    public TaskListFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_task_list, container, false);
        RecyclerView recyclerViewTask = view.findViewById(R.id.rv_task_list);
        recyclerViewTask.setLayoutManager(new LinearLayoutManager(getContext()));

        return view;
    }

}
