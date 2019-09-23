package com.test.myapplication.db;

import androidx.room.Database;
import androidx.room.RoomDatabase;

import com.test.myapplication.Task;

@Database(entities = {
        Task.class}, version = 1, exportSchema = false)
public abstract class AppDatabase extends RoomDatabase {
    public abstract TaskDao getTasks();
}
