package com.crudapi.employeemanager.service;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.crudapi.employeemanager.Repository.EmployeeRepository;
import com.crudapi.employeemanager.model.Employee;

import java.util.List;

@Service
public class EmployeeService {
    public final EmployeeRepository employeeRepo;

    @Autowired
    public EmployeeService(EmployeeRepository employeeRepo) {
        this.employeeRepo = employeeRepo;
    }

    public Employee addEmployee(Employee employee){
        employee.setEmployeeCode(UUID.randomUUID().toString());
        return employeeRepo.save(employee);
    }

    public List<Employee> findAllEmployees(){
        return employeeRepo.findAll();
    }

    public Employee findEmployeeById(Long id){
        return employeeRepo.findEmployeeById(id).orElseThrow(()-> new UserNotFoundException ("User by id "+ id + " was not found"));
    }
    // public void deleteEmployee(Long id){
    //     employeeRepo.deleteById(id);
    // }
    public void deleteEmployee(Long id){
        employeeRepo.deleteEmployeeById(id);
    }


    
}
