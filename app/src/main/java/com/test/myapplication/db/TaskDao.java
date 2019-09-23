package com.test.myapplication.db;


import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

import com.test.myapplication.Task;

import java.util.List;

@Dao
public interface TaskDao {

    @Query("SELECT * FROM Task")
    LiveData<List<Task>> getAllTasks();

    @Query("SELECT * FROM Task where id==:id")
    Task getAllTasksById(int id);

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insertTask(Task task);


    @Query("DELETE  FROM Task where completed==1")
    void deleteAllCompleatedTask();

    @Query("DELETE  FROM Task where id==:id")
    void deleteTaskById(int id);

}