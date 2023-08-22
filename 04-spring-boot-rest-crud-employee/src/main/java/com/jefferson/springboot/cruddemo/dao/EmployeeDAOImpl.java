package com.jefferson.springboot.cruddemo.dao;

import com.jefferson.springboot.cruddemo.entity.Employee;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository // Spring will scan for this class and create a bean for it. We tell Spring that this manipulates data in db.
public class EmployeeDAOImpl implements EmployeeDAO {

    private EntityManager entityManager;
    // define constructor so that Spring can inject the entity manager. Don't forget @Autowired!!!!
    @Autowired
    public EmployeeDAOImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public Employee save(Employee employee) {
        // we can't use persist. Not only it returns void but the id won't be in employee.
        return entityManager.merge(employee); // save or update the employee to the database if id == 0, otherwise update.
    }

    @Override
    public List<Employee> findAll() {
        // We need a query
        TypedQuery<Employee> employees = entityManager.createQuery("FROM Employee", Employee.class);
        return employees.getResultList();
    }

    @Override
    public Employee findById(int id) {
        // get the employee by id
        return entityManager.find(Employee.class, id);
    }

    @Override
    public Employee update(Employee employee) {
//        int id = employee.getId();
//        Employee dbEmployee = entityManager.find(Employee.class, id);
        return entityManager.merge(employee); // id won't be 0 so we update.
    }

    @Override
    public void delete(Employee employee) {
        // delete the employee
        entityManager.remove(employee);
    }
}
