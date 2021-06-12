package com.durga.demoapp.repositories.database;

import androidx.annotation.NonNull;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "empdata")
public class EmployeeInfo {

    String name;
    String dept_name;

    @PrimaryKey
    @NonNull
    String user_id;

    public String getName() {
        return name;
    }

    public String getDepartment() {
        return dept_name;
    }

    @NonNull
    public String getUser_id() {
        return user_id;
    }

    public EmployeeInfo(String name, String dept_name, String user_id) {
        this.name = name;
        this.dept_name = dept_name;
        this.user_id = user_id;
    }
}
