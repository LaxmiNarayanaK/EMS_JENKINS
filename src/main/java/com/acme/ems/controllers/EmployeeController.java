package com.acme.ems.controllers;
import com.acme.ems.models.Employee;
import com.acme.ems.services.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.ValidationException;
import java.util.List;

@RestController
public class EmployeeController {
    @Autowired
    private EmployeeService employeeService;

    @GetMapping("/employee")
    public List<Employee> listAll() {

        return employeeService.listEmployees();
    }

    @PostMapping("/employee")
    public Employee create( @RequestBody Employee employee) {
        if(!isValid(employee))
        throw new ValidationException("Fill out the form with Valid Data");
        else employeeService.addEmployee(employee);
        return employee;
    }

    @GetMapping("/employee/{id}")
    Employee getEmployeee(@PathVariable int empId)
    {
        if(employeeService.empExists(empId))
            return employeeService.getEmployee(empId);
        else
            throw new ValidationException("Employee do not exists with ID :"+empId);
    }

    @PutMapping("/employee")
    Employee updateEmp(@RequestBody Employee employee)
    {
        if(!isValid(employee))
            throw new ValidationException("Fill out the form with Valid Data");
        else if(employeeService.empExists(employee.getEmpID()))
            employeeService.updateEmployee(employee);
        else
            throw new ValidationException("Employee do not exists with ID :"+employee.getEmpID());

        return employee;
    }

    @DeleteMapping("/employee/{id}")
    public void delete(@PathVariable int empId)
    {
        if(employeeService.empExists(empId))
            employeeService.deleteEmployee(empId);
        else
            throw new ValidationException("Employee do not exists with ID :"+empId);
    }


    @GetMapping("/employeebyname")
    List<Employee> getEmpName( @RequestParam(value = "empname") String empName)
    {
        return employeeService.searchEmployee(empName);
    }

    public boolean isValid(Employee employee) {
        return employee.getEmpName() != null && employee.getEmpContact()!=0 && employee.getEmpEmail() != null && employee.getEmpRole() !=null;
    }

    @GetMapping("/employeerole")
    String getEmpName( @RequestParam(value = "empid") int empId)
    {
        return employeeService.getEmployeeRole(empId);
    }

}