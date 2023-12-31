package com.jefferson.springboot.cruddemo.dao;

import com.jefferson.springboot.cruddemo.entity.Employee;

import java.util.List;

public interface EmployeeDAO {

    Employee save(Employee employee);

    List<Employee> findAll();

    Employee findById(int id);

    Employee update(Employee employee);

    void delete(Employee employee);
}
