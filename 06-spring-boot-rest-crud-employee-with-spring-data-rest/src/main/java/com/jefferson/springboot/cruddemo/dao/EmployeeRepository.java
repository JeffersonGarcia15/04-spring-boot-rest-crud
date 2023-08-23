package com.jefferson.springboot.cruddemo.dao;

import com.jefferson.springboot.cruddemo.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

//@RepositoryRestResource(path="members") // instead of using Employee and making it employees we will use members
public interface EmployeeRepository extends JpaRepository<Employee, Integer> { // <Entity Type, Primary key>
}
