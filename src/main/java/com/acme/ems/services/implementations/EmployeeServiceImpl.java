package com.acme.ems.services.implementations;

import com.acme.ems.models.Employee;
import com.acme.ems.repositories.EmployeeRepository;
import com.acme.ems.services.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public class EmployeeServiceImpl implements EmployeeService {
    @Autowired
    private EmployeeRepository employeeRepository;

    @Override
    public List<Employee> listEmployees() {

        return (List<Employee>)employeeRepository.findAll();
    }

    @Override
    public Employee getEmployee(int employeeId) {
        Optional<Employee> employee = employeeRepository.findById(employeeId);
        return employee.get();
    }

    @Override
    public void addEmployee(Employee employee) {
        employeeRepository.save(employee);

    }

    @Override
    public void deleteEmployee(int employeeId) {
        employeeRepository.deleteById(employeeId);

    }
    @Override
    public void updateEmployee(Employee employee) {

        employeeRepository.save(employee);
    }

    @Override
    public List<Employee> searchEmployee(String empName){

        return employeeRepository.findByEmpName(empName);
    }

    @Override
    public boolean empExists(int empId) {

        return employeeRepository.existsById(empId);
    }

    @Override
    public String getEmployeeRole(int empId) {
        Optional<Employee> employee =  employeeRepository.findById(empId);
        return employee.get().getEmpRole();
    }


}
