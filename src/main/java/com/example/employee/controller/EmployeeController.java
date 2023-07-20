/*
 * You can use the following import statements
 *
 * import org.springframework.beans.factory.annotation.Autowired;
 * import org.springframework.web.bind.annotation.*;
 * import java.util.*;
 */

// Write your code here
package com.example.employee.controller;
import java.util.*;
import org.springframework.web.bind.annotation.*;
import com.example.employee.service.EmployeeJpaService;
import com.example.employee.model.Employee;
import org.springframework.beans.factory.annotation.Autowired;

@RestController
public class EmployeeController{
    
    @Autowired
    public EmployeeJpaService employeeservice ;

    @GetMapping("/employees")
    public ArrayList<Employee> getEmployee(){
        return employeeservice.getEmployee();
    }

    @GetMapping("/employees/{employeeId}")
    public Employee getEmployeeById(@PathVariable("employeeId") int employeeId){
        return employeeservice.getEmployeeById(employeeId);
    }

    @PostMapping("/employees")
    public Employee addEmployee(@RequestBody Employee employee){
        return employeeservice.addEmployee(employee);
    }

    @PutMapping("/employees/{employeeId}")
    public Employee updateEmployee(@PathVariable("employeeId") int employeeId, @RequestBody Employee employee){
        return employeeservice.updateEmployee(employeeId, employee);
    }

    @DeleteMapping("/employees/{employeeId}")
    public void deleteEmployee(@PathVariable("employeeId") int employeeId){
        employeeservice.deleteEmployee(employeeId);
    }

}