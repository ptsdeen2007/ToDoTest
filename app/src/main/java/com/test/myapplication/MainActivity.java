package com.test.myapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;

import com.test.myapplication.fragment.InputFragment;
import com.test.myapplication.fragment.TaskListFragment;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.land_layout);
        default_view();
    }

    private void default_view() {
        FragmentManager fm = getSupportFragmentManager();
        FragmentTransaction ft = fm.beginTransaction();
        ft.replace(R.id.fragment_container, new TaskListFragment());
//        ft.replace(R.id.fragment_container, new InputFragment());
        ft.commit();
    }
}
