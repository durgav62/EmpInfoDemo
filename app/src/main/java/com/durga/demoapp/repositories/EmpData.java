package com.durga.demoapp.repositories;

import com.durga.demoapp.repositories.database.EmployeeInfo;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

public class EmpData {

    @SerializedName("DATA")
    List<EmployeeInfo> dataList = new ArrayList<>();

    public List<EmployeeInfo> getData() {
        return dataList;
    }

    public class EmpDataBean {
        String TODAYS_COUNT;
        String age;
        String created_on;
        String dept_id;
        String dept_name;
        String email_id;
        String gender;
        String is_deleted;
        String mobile;
        String name;
        String password;
        String profile_img;
        String reporting_to_id;
        String reporting_to_name;
        String role_id;
        String role_name;
        String token;
        String updated_on;
        String user_id;

        public String getTODAYS_COUNT() {
            return TODAYS_COUNT;
        }

        public String getAge() {
            return age;
        }

        public String getCreated_on() {
            return created_on;
        }

        public String getEmail_id() {
            return email_id;
        }

        public String getGender() {
            return gender;
        }

        public String getIs_deleted() {
            return is_deleted;
        }

        public String getMobile() {
            return mobile;
        }

        public String getPassword() {
            return password;
        }

        public String getProfile_img() {
            return profile_img;
        }

        public String getReporting_to_id() {
            return reporting_to_id;
        }

        public String getReporting_to_name() {
            return reporting_to_name;
        }

        public String getRole_id() {
            return role_id;
        }

        public String getRole_name() {
            return role_name;
        }

        public String getToken() {
            return token;
        }

        public String getUpdated_on() {
            return updated_on;
        }

        public String getDept_id() {
            return dept_id;
        }

        public void setDept_id(String dept_id) {
            this.dept_id = dept_id;
        }

        public String getDept_name() {
            return dept_name;
        }

        public void setDept_name(String dept_name) {
            this.dept_name = dept_name;
        }

        public String getUser_id() {
            return user_id;
        }

        public void setUser_id(String user_id) {
            this.user_id = user_id;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }
    }
}
