package com.midmarsh.spring.domain;

public class Employee {

    private String name;
    private Long id;

    public Employee() {
    }

    public Employee(Long id, String name) {
        this.id = id;
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long employeeId) {
        this.id = employeeId;
    }

    public String toString() {
        return name + ": " + id;
    }

}
