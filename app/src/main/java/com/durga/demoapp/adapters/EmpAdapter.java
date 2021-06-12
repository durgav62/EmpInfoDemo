package com.durga.demoapp.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.durga.demoapp.repositories.database.EmployeeInfo;
import com.example.demoapp.R;

import java.util.ArrayList;
import java.util.List;

public class EmpAdapter extends RecyclerView.Adapter {
    private List<EmployeeInfo> employeeInfo = new ArrayList<>();
    private Context context;

    public EmpAdapter(Context context) {
        this.context = context;
    }

    public void setEmployeeInfo(List<EmployeeInfo> employeeInfo) {
        this.employeeInfo = employeeInfo;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.emp_info, parent, false);
        return new PlacesViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        //set image title
        ((PlacesViewHolder)holder).empName.setText(employeeInfo.get(position).getName());
        ((PlacesViewHolder)holder).empDepartment.setText(employeeInfo.get(position).getDepartment());
    }

    @Override
    public int getItemCount() {
        return employeeInfo.size();
    }

    private class PlacesViewHolder extends RecyclerView.ViewHolder {
        TextView empName;
        TextView empDepartment;

        public PlacesViewHolder(View view) {
            super(view);
            empName = view.findViewById(R.id.empname);
            empDepartment = view.findViewById(R.id.emp_department);
        }
    }
}
