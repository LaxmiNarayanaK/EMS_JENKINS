package com.acme.ems.controllers;

import com.acme.ems.controllers.EmployeeController;
import com.acme.ems.models.Employee;
import org.assertj.core.api.Assertions;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class IntegrationTest {
    @Autowired
    EmployeeController employeeController;

    @Test
    public void testCreateReadDelete(){

        List<Employee> employees = employeeController.listAll();
        int size = employees.size();
        Employee employee = new Employee("anu",999999,"ASDE","anu@ps.in","Vizag","Admin");

        Employee employeeResult = employeeController.create(employee);
        employees = employeeController.listAll();

        Assertions.assertThat(employees).last().hasFieldOrPropertyWithValue("empName","anu");
        Assertions.assertThat(employeeController.listAll().size()==size+1);
        employeeController.delete(employeeResult.getEmpID());
    }
}