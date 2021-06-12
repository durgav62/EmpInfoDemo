package com.durga.demoapp.repositories.api;

import com.durga.demoapp.repositories.EmpData;
import retrofit2.Call;
import retrofit2.http.GET;

public interface ApiInterface {

    @GET("betaDailyUpdateApi/Service1.svc/getManager")
    Call<EmpData> getEmployeesInfo();
}
