package com.durga.demoapp;

import android.os.Bundle;

import com.durga.demoapp.adapters.EmpAdapter;
import com.durga.demoapp.repositories.database.EmployeeInfo;
import com.example.demoapp.R;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SearchView;
import androidx.appcompat.widget.Toolbar;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;

import android.view.Menu;
import android.view.MenuItem;
import android.widget.EditText;

import com.durga.demoapp.repositories.api.ApiRequestHandler;
import com.durga.demoapp.viewmodel.EmployeViewModel;

import java.util.List;

public class MainActivity extends AppCompatActivity {
    EmployeViewModel employeViewModel;
    RecyclerView recyclerView;
    EmpAdapter empAdapter;
    SearchView searchView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        /*Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);*/

        FloatingActionButton fab = findViewById(R.id.fab);
        recyclerView = findViewById(R.id.recycler_view);
        searchView = findViewById(R.id.search_txt);
        employeViewModel = ViewModelProviders.of(this).get(EmployeViewModel.class);
        employeViewModel.fetchDataFromUrl();

        initRecyclerView();
        employeViewModel.getEmployeeInfos().observe(this, new Observer<List<EmployeeInfo>>() {
            @Override
            public void onChanged(List<EmployeeInfo> setEmployeeInfo) {
                empAdapter.setEmployeeInfo(setEmployeeInfo);
            }
        });

        employeViewModel.getEmployeeInfoBySearch().observe(this, new Observer<List<EmployeeInfo>>() {
            @Override
            public void onChanged(List<EmployeeInfo> setEmployeeInfo) {
                empAdapter.setEmployeeInfo(setEmployeeInfo);
            }
        });

        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                employeViewModel.setEmployeeInfoBySearch(newText+"%");
                employeViewModel.getEmployeeInfoBySearch().observe(MainActivity.this, new Observer<List<EmployeeInfo>>() {
                    @Override
                    public void onChanged(List<EmployeeInfo> setEmployeeInfo) {
                        if(setEmployeeInfo.size() > 0)
                            empAdapter.setEmployeeInfo(setEmployeeInfo);
                    }
                });
                return false;
            }
        });
    }

    private void initRecyclerView() {
        empAdapter = new EmpAdapter(this);
        RecyclerView.LayoutManager linearLayoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(linearLayoutManager);
        recyclerView.setAdapter(empAdapter);
    }
}