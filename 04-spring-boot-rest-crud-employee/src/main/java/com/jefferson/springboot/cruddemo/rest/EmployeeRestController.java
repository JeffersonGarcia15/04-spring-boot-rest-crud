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
        Employee employee =  employeeService.findById(employeeId);

        if (employee == null) {
            throw new RuntimeException("Employee id not found - " + employeeId);
        }

        return employee;
    }

    // expose "/employees/{employeeId}" for DELETE and return a JSON {"message": "Deleted"}
    @DeleteMapping("/employees/{employeeId}")
    public String deleteEmployeeById(@PathVariable int employeeId) {
        employeeService.delete(employeeId);
        return "Success";
    }

    @PostMapping("/employees")
    public Employee addEmployee(@RequestBody Employee employee) {

        // if they pass an id, we force it to be 0 so that we add a new entry rather than updating one.
        employee.setId(0);

        Employee dbEmployee = employeeService.save(employee);

        return dbEmployee;
    }

}
