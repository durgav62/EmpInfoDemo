package com.durga.demoapp.repositories.database;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

@Database(version = 1, entities = {EmployeeInfo.class})
public abstract class EmployeeDatabase extends RoomDatabase{

    public abstract EmployeeDao employeeDao();
    static String DB_NAME = "empdb";

    public static volatile EmployeeDatabase instance;

    public static EmployeeDatabase getInstance(final Context context) {
        if(instance == null) {
            synchronized (EmployeeDatabase.class) {
                instance = Room.databaseBuilder(context.getApplicationContext(), EmployeeDatabase.class, DB_NAME).build();
            }
        }
        return instance;
    }
}
