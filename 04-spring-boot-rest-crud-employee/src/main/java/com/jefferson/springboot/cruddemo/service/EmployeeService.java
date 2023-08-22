package com.jefferson.springboot.cruddemo.service;

import com.jefferson.springboot.cruddemo.entity.Employee;

import java.util.List;

public interface EmployeeService {

    Employee save(Employee employee);

    List<Employee> findAll();

    Employee findById(int id);

    void update(Employee employee);

    void delete(int id);
}
