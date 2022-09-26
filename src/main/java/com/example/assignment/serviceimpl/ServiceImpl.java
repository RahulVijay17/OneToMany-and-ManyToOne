package com.example.assignment.serviceimpl;

import com.example.assignment.Model.Department;
import com.example.assignment.Model.Employee;
import com.example.assignment.Repository.DepartmentRepository;
import com.example.assignment.Repository.EmployeeRepository;
import com.example.assignment.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class ServiceImpl implements EmployeeService {

    @Autowired
    DepartmentRepository departmentRepository;

    @Autowired
    EmployeeRepository employeeRepository;

    @Override
    public List<Employee> getAllEmployees() {
        return employeeRepository.findAll();

    }

    @Override
    public Employee addEmployee(Employee employee) {
        Department dept = departmentRepository.findById(employee.getDepartment().getId()).orElse(null);
        if (null == dept) {
            dept = new Department();
        }
        dept.setDeptName(employee.getDepartment().getDeptName());
        employee.setDepartment(dept);
        return employeeRepository.save(employee);
    }

    @Override
    public Employee editEmployees(Employee employee) {
        return employeeRepository.save(employee);
    }

    @Override
    public void deleteEmployees(Integer id) {
        employeeRepository.deleteById(id);

    }
}