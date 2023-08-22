package com.jefferson.springboot.cruddemo.service;

import com.jefferson.springboot.cruddemo.dao.EmployeeDAO;
import com.jefferson.springboot.cruddemo.entity.Employee;
import jakarta.persistence.EntityManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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
    @Transactional // since we are performing an update on the db
    public Employee save(Employee employee) {
        return employeeDAO.save(employee);
    }

    @Override
    public List<Employee> findAll() {
        return employeeDAO.findAll();
    }

    @Override
    public Employee findById(int id) {
        return employeeDAO.findById(id);
    }

    @Override
    @Transactional // since we are performing an update on the db
    public Employee update(Employee employee) {
        return employeeDAO.update(employee);
    }

    @Override
    @Transactional
    public void delete(Employee employee) {
        employeeDAO.delete(employee);
    }
}
