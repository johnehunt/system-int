package com.midmarsh.spring.dao;

import com.midmarsh.spring.domain.Employee;
import java.util.List;

public interface EmployeeDAO {
    List<Employee> getEmployees();
    int addEmployee(Employee e);

}
