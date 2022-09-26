package com.example.assignment.service;


import com.example.assignment.Model.Employee;

import java.util.List;

public interface EmployeeService {

    List<Employee> getAllEmployees();

    Employee addEmployee(Employee employee);

    Employee editEmployees(Employee employee);

    void deleteEmployees(Integer employeeId);
}
