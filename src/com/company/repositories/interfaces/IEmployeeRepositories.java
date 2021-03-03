package com.company.repositories.interfaces;
import com.company.entities.Employee;
public interface IEmployeeRepositories {
    boolean createEmployee(Employee employee);
    Employee getEmployee(int id);
    boolean removeEmployeeById(int id);
}
