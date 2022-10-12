package com.midmarsh.spring.main;

import com.midmarsh.spring.dao.EmployeeDAO;
import com.midmarsh.spring.domain.Employee;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.ComponentScan;

import java.util.List;

@SpringBootApplication
@ComponentScan(basePackages = {"com.midmarsh.spring.config"})
public class Main {
    public static void main(String[] args) {

        System.out.println("Main - obtaining Application Context");
        ApplicationContext context =
                SpringApplication.run(Main.class, args);

        EmployeeDAO dao = context.getBean("employeeDao", EmployeeDAO.class);
        try {
          List<Employee> employees = dao.getEmployees();
          employees.forEach((Employee e) -> System.out.println(e));

//            System.out.println("Inserting a new employee");
//            Employee emp = new Employee(5, "Natalia");
//            dao.addEmployee(emp);

//            List<Employee> employees = dao.getAltEmployees();
//            employees.forEach((Employee e) -> System.out.println(e));
//
//			Employee [] employees = new Employee[] {new EmployeeImpl("6", "Joselyn") };
//			dao2.addAllEmployees(employees);

        } catch (Exception exp) {
            exp.printStackTrace();
        }

    }
}
