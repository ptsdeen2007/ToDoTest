package com.test.myapplication.db;


import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import com.test.myapplication.Task;

import java.util.List;

@Dao
public interface TaskDao {

    @Query("SELECT * FROM Task")
    List<Task> getAllTasks();

    @Insert
    void insertTask(Task task);

    @Query("DELETE  FROM Task")
    void deleteAll();

}