package com.durga.demoapp.viewmodel;

import android.app.Application;

import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Transformations;

import com.durga.demoapp.MultithreadExecutor;
import com.durga.demoapp.repositories.api.ApiRequestHandler;
import com.durga.demoapp.repositories.database.EmployeeDao;
import com.durga.demoapp.repositories.database.EmployeeDatabase;
import com.durga.demoapp.repositories.database.EmployeeInfo;

import java.util.ArrayList;
import java.util.List;

public class EmployeViewModel extends AndroidViewModel {

    EmployeeDao employeeDao;
    EmployeeDatabase employeeDatabase;
    public LiveData<List<EmployeeInfo>> employeeInfos;
    public LiveData<List<EmployeeInfo>> filteredEmployeeInfos = new MutableLiveData<>();

    public EmployeViewModel(Application application) {
        super(application);
        employeeDatabase = EmployeeDatabase.getInstance(application);
        employeeDao = employeeDatabase.employeeDao();
        employeeInfos = employeeDao.getAllEmployeeInfo();
    }

    public void insertData(List<EmployeeInfo> dataList) {
        new MultithreadExecutor(new Runnable() {
            @Override
            public void run() {
                employeeDao.insert(dataList);
            }
        });
    }

    public LiveData<List<EmployeeInfo>> getEmployeeInfos() {
        return employeeInfos;
    }

    public void fetchDataFromUrl() {
        new ApiRequestHandler(this).executeRequest();
    }

    public void setEmployeeInfoBySearch(String searchText) {
        filteredEmployeeInfos = employeeDao.getEmployeeInfoBySearch(searchText);
    }

    public LiveData<List<EmployeeInfo>> getEmployeeInfoBySearch() {
        return filteredEmployeeInfos;
    }
}
