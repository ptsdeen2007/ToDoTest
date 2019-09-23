package com.test.myapplication;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.room.Room;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.Toast;

import com.test.myapplication.db.AppDatabase;
import com.test.myapplication.fragment.InputFragment;
import com.test.myapplication.fragment.TaskListFragment;

public class LandScreen extends AppCompatActivity {
    public static AppDatabase db;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.land_layout);
        default_view();
         db = Room.databaseBuilder(this, AppDatabase.class, "MasterImp").allowMainThreadQueries().build();
    }

    private void default_view() {
        FragmentManager fm = getSupportFragmentManager();
        FragmentTransaction ft = fm.beginTransaction();
        ft.replace(R.id.fragment_container, new TaskListFragment());
//        ft.replace(R.id.fragment_container, new InputFragment());
        ft.commit();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater menuInflater=new MenuInflater(this);
        menuInflater.inflate(R.menu.menu,menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if (item.getItemId() == R.id.menu_delete_all_completed) {

            db.getTasks().deleteAllCompleatedTask();
        }
        return super.onOptionsItemSelected(item);
    }
}
