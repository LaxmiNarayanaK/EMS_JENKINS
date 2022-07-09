package com.acme.ems.services;


import com.acme.ems.models.Employee;
import com.acme.ems.repositories.EmployeeRepository;
import org.assertj.core.api.Assertions;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;


@RunWith(SpringRunner.class)
@DataJpaTest
public class ServiceTests {

  @Autowired
  EmployeeRepository employeeRepository;

  @Test
  public void testCreateReadDelete() {

    Employee employee = new Employee("anu", 999999, "ASDE", "anu@ps.in", "Vizag", "Admin");
    employeeRepository.save(employee);

    Iterable<Employee> employees = employeeRepository.findAll();
    System.out.println(employees);
    Assertions.assertThat(employees).extracting(Employee::getEmpName).contains("anu");

    employeeRepository.deleteAll();
    Assertions.assertThat(employeeRepository.findAll()).isEmpty();

  }

}

