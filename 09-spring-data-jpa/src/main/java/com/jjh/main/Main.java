package com.jjh.main;

import com.jjh.dao.EmployeeDAO;
import com.jjh.entities.Employee;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.ComponentScan;

import java.util.List;

@SpringBootApplication
@ComponentScan(basePackages = {"com.jjh.config"})
public class Main {

    public static void main(String[] args) {
        System.out.println("Starting Main Application!");
        ConfigurableApplicationContext context = null;
        try {

            System.out.println("Starting Student Repo setup");
            context = SpringApplication.run(Main.class, args);
            System.out.println("Setup finished");

            EmployeeDAO dao = context.getBean("employeeDao", EmployeeDAO.class);

            System.out.println("-------------------------------");
            Employee e = dao.findById(1);
            System.out.println(e);
            e.setName("John");
            dao.update(e);
            System.out.println(e);
            System.out.println("-------------------------------");
            e = dao.findById(1);
            System.out.println(e);
            e.setName("Albert");
            dao.update(e);
            System.out.println("-------------------------------");
            List<Employee> employees = dao.findAll();
            for (Employee employee : employees) {
                System.out.println(employee);
            }
        } finally {
            // Need to close as it is a 'resource loader'
            if (context != null)
                context.close();
        }
        System.out.println("Exiting Main Application!");
    }

}
