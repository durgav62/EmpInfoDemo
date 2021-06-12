package com.durga.demoapp.repositories.database;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;
import java.util.List;

@Dao
public interface EmployeeDao {

    @Insert
    public void insert(List<EmployeeInfo> employeeInfos);

    @Query("SELECT * from empdata")
    LiveData<List<EmployeeInfo>> getAllEmployeeInfo();

    @Query("SELECT * from empdata where name like :searchText OR dept_name like :searchText")
    LiveData<List<EmployeeInfo>> getEmployeeInfoBySearch(String searchText);
}
