package com.jjh.dao;

import com.jjh.entities.Employee;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import java.util.List;

@Component("employeeDao")
public class EmployeeDAOImpl implements EmployeeDAO {

    @PersistenceContext
    private EntityManager entityManager;

    public Employee findById(int id) {
        return this.entityManager.find(Employee.class, id);
    }

    public void flush() {
        this.entityManager.flush();
    }

    public List<Employee> findNative() {
        Query query = entityManager.createNativeQuery("Select * FROM employee", Employee.class);
        List<Employee> list = (List<Employee>)query.getResultList();
        return list;
    }

    public List<Employee> findAll() {
        TypedQuery<Employee> query = entityManager.createQuery("SELECT e FROM Employee e", Employee.class);
        return query.getResultList();
    }

    @Transactional
    public Employee save(Employee emp) {
        entityManager.persist(emp);
        return emp;
    }

    @Transactional
    public Employee update(Employee emp) {
        emp = entityManager.merge(emp);
        return emp;
    }

    @Transactional
    public void delete(Employee emp) {
        entityManager.remove(emp);
    }

    @Transactional
    public void refresh(Employee emp) {
        entityManager.refresh(emp);
    }

}
