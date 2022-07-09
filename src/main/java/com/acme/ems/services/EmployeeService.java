package com.acme.ems.services;


import com.acme.ems.models.Employee;

import java.util.List;

public interface EmployeeService  {
    List<Employee> listEmployees();

    Employee getEmployee(int id);

    void addEmployee(Employee employee);

    void deleteEmployee(int id);

    void updateEmployee(Employee employee);

    List<Employee> searchEmployee(String empName);

    boolean empExists(int empId);

    String getEmployeeRole(int empId);


}
