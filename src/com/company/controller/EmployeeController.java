package com.company.controller;

import com.company.entities.Employee;
import com.company.repositories.interfaces.IEmployeeRepositories;

import java.util.List;
public class EmployeeController {
    private final IEmployeeRepositories repo;

    public EmployeeController(IEmployeeRepositories repo){this.repo=repo;}


    public String createEmployee(String name, String surname, String status, String hobby, String level)
    {
        Employee employee = new Employee(name, surname, status, hobby, level);
        boolean created= repo.createEmployee(employee);
        return  (created ?  "Employee was created!" : "Employee creation was failed!!");
    }

    public String getEmployee(int id){
        Employee employee = repo.getEmployee(id);
        return (employee == null ? "Employee was not found" : employee.toString());
    }


}
