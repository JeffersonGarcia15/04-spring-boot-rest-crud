package com.jefferson.springboot.cruddemo.dao;

import com.jefferson.springboot.cruddemo.entity.Employee;

import java.util.List;

public interface EmployeeDAO {

    void save(Employee employee);

    List<Employee> findAll();

    Employee findById(int id);

    void update(Employee employee);

    void delete(int id);
}
