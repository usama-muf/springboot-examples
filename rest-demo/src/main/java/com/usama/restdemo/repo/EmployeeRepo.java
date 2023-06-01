package com.usama.restdemo.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.usama.restdemo.entity.Employee;

public interface EmployeeRepo extends JpaRepository<Employee, Long>{

}
