package com.test.myapplication.fragment;


import android.os.Bundle;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.room.Room;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.test.myapplication.R;
import com.test.myapplication.Task;
import com.test.myapplication.db.AppDatabase;

public class InputFragment extends Fragment {


    private AppDatabase db;

    public InputFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        db = Room.databaseBuilder(getContext(), AppDatabase.class, "MasterImp").allowMainThreadQueries().build();
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_input, container, false);
        FloatingActionButton floatingActionButton = view.findViewById(R.id.fab);
        EditText et_title = view.findViewById(R.id.et_title);
        EditText et_body = view.findViewById(R.id.et_body);
        floatingActionButton.setOnClickListener(v -> {
           String str_title=et_title.getText().toString();
           String str_body=et_body.getText().toString();
            Task task=new Task(str_title,str_body,false);
            db.getTasks().insertTask(task);
            FragmentManager fm = ((AppCompatActivity)v.getContext()).getSupportFragmentManager();
            fm.popBackStack();
            Toast.makeText(getContext(), "Done", Toast.LENGTH_SHORT).show();
        });

        return view;
    }

}
