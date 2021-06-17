package com.emp.model.vo;

import lombok.Data;

import java.sql.Date;

@Data
public class Employee {
    private String emp_id;
    private String emp_name;
    private String emp_no;
    private String email;
    private String phone;
    private Department dept;
    private String job_code;
    private String sal_level;
    private int salary;
    private double bonus;
    private String manager_id;
    private Date hire_date;
}
