package com.wizeline.techmentoring.roomwebapp.data;

import org.springframework.data.jpa.repository.JpaRepository;

import com.wizeline.techmentoring.roomwebapp.model.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, String> {

}
