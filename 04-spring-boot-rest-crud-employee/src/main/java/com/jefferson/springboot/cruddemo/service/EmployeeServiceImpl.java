package com.jefferson.springboot.cruddemo.service;

import com.jefferson.springboot.cruddemo.dao.EmployeeDAO;
import com.jefferson.springboot.cruddemo.entity.Employee;
import jakarta.persistence.EntityManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    private EmployeeDAO employeeDAO;
    // inject employee DAO(only for testing purposes) and use constructor injection
    @Autowired
    public EmployeeServiceImpl(EmployeeDAO employeeDAO) {
        this.employeeDAO = employeeDAO;
    }

    @Override
    public void save(Employee employee) {

    }

    @Override
    public List<Employee> findAll() {
        return employeeDAO.findAll();
    }

    @Override
    public Employee findById(int id) {
        return null;
    }

    @Override
    public void update(Employee employee) {

    }

    @Override
    public void delete(int id) {

    }
}
