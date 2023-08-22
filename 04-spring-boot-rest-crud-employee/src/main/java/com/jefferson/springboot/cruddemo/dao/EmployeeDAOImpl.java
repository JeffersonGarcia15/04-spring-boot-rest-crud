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
    @Transactional // since we are performing an update on the db
    public void save(Employee employee) {
        entityManager.persist(employee);
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
    @Transactional // since we are performing an update on the db
    public void update(Employee employee) {

    }

    @Override
    @Transactional // since we are performing an update on the db
    public void delete(int id) {

    }
}
