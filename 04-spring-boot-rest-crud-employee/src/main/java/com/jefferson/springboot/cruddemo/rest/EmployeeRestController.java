package com.jefferson.springboot.cruddemo.rest;

import com.jefferson.springboot.cruddemo.entity.Employee;
import com.jefferson.springboot.cruddemo.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/api")
@RestController
public class EmployeeRestController {

    private EmployeeService employeeService;

    @Autowired
    public EmployeeRestController(EmployeeService employeeDAO) {
        this.employeeService = employeeDAO;
    }

    // expose "/employees" and return list of employees
    @GetMapping("/employees")
    public List<Employee> findEmployees() {
        return employeeService.findAll();
    }

    // expose "/employees/{employeeId}" and return employee
    @GetMapping("/employees/{employeeId}")
    public Employee findEmployeeById(@PathVariable int employeeId) {
        return employeeService.findById(employeeId);
    }

    // expose "/employees/{employeeId}" for DELETE and return a JSON {"message": "Deleted"}
    @DeleteMapping("/employees/{employeeId}")
    public String deleteEmployeeById(@PathVariable int employeeId) {
        employeeService.delete(employeeId);
        return "Success";
    }

}
