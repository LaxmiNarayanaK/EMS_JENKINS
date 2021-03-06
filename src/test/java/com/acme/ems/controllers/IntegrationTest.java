package com.acme.ems.controllers;

import com.acme.ems.controllers.EmployeeController;
import com.acme.ems.models.Employee;
import com.acme.ems.models.Login;
import com.acme.ems.models.Timesheet;
import com.acme.ems.repositories.TimesheetRepository;
import lombok.extern.java.Log;
import org.assertj.core.api.Assertions;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.sql.Date;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class IntegrationTest {
    @Autowired
    EmployeeController employeeController;
    @Autowired
    LoginController loginController;
    @Autowired
    TimesheetController timesheetController;

    @Test
    public void employeeTestCreateReadDelete(){

        List<Employee> employees = employeeController.listAll();
        int size = employees.size();
        Employee employee = new Employee("anu",999999,"ASDE","anu@ps.in","Vizag","Admin");

        Employee employeeResult = employeeController.create(employee);
        employees = employeeController.listAll();

        Assertions.assertThat(employees).last().hasFieldOrPropertyWithValue("empName","anu");
        Assertions.assertThat(employeeController.listAll().size()==size+1);
    }
    @Test
    public void LoginTestCreateReadDelete(){

        Employee employee = new Employee("anu",999999,"ASDE","anu@ps.in","Vizag","Admin");

        employeeController.create(employee);

        Login login = new Login("Anu","anu","anu","anu",employee);
        loginController.create(employee.getEmpID(),login);

        Assertions.assertThat(loginController.checkLogin("anu","anu"));
    }

    @Test
    public void TimesheetTestCreateReadDelete() {

        Employee employee = new Employee("anu", 999999, "ASDE", "anu@ps.in", "Vizag", "Admin");
        employeeController.create(employee);

        List<Timesheet> timesheets = timesheetController.listAllTimesheet();
        Timesheet timesheet = new Timesheet("Anu", 10, Date.valueOf("2022-01-01"), "abc", "abc", employee);
        timesheetController.create(employee.getEmpID(), timesheet);

        Assertions.assertThat(timesheetController.listAllTimesheet().size() == timesheets.size() + 1);
//        employeeController.delete(employeeResult.getEmpID());    }


    }

}