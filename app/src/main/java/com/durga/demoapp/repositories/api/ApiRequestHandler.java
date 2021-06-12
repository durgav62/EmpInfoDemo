package com.durga.demoapp.repositories.api;

import android.util.Log;

import java.util.List;
import com.durga.demoapp.MultithreadExecutor;
import com.durga.demoapp.repositories.EmpData;
import com.durga.demoapp.repositories.database.EmployeeInfo;
import com.durga.demoapp.viewmodel.EmployeViewModel;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ApiRequestHandler {

    String apiName = "betaDailyUpdateApi/Service1.svc/getManager";
    String TAG = ApiRequestHandler.class.getSimpleName();
    EmployeViewModel employeViewModel;

    public ApiRequestHandler(EmployeViewModel employeViewModel) {
        this.employeViewModel = employeViewModel;
    }

    public void executeRequest() {
        new MultithreadExecutor(new Runnable() {
            @Override
            public void run() {
                ApiInterface apiInterface = ApiClient.getClient(apiName).create(ApiInterface.class);
                Call<EmpData> call = apiInterface.getEmployeesInfo();
                call.enqueue(new Callback<EmpData>() {
                    @Override
                    public void onResponse(Call<EmpData> call, Response<EmpData> response) {
                        if(response.isSuccessful()) {
                            List<EmployeeInfo> dataList = response.body().getData();
                            Log.v(TAG, "Datalist size : "+dataList.size());
                            employeViewModel.insertData(dataList);
                        }
                    }

                    @Override
                    public void onFailure(Call<EmpData> call, Throwable t) {
                        Log.v(TAG, t.toString());
                    }
                });
            }
        });
    }
}
