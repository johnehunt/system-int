package com.midmarsh.spring.dao;

import com.midmarsh.spring.domain.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.core.namedparam.SqlParameterSourceUtils;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Component("employeeDao2")
public class EmployeeDAO2 {
    @Autowired
    private SimpleJdbcInsert simpleJdbcInsert;

    @Autowired
    private NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    public int addEmployee(Employee emp) {
        Map<String, Object> parameters = new HashMap<>();
        parameters.put("id", emp.getId());
        parameters.put("name", emp.getName());
        return simpleJdbcInsert.withTableName("EMPLOYEE").execute(parameters);
    }

    public int[] addAllEmployees(Employee [] employees) {
        SqlParameterSource[] batch = SqlParameterSourceUtils.createBatch(employees);
        int[] updateCounts = namedParameterJdbcTemplate.batchUpdate(
                "INSERT INTO EMPLOYEE VALUES (:id, :name)", batch);
        return updateCounts;
    }

}
