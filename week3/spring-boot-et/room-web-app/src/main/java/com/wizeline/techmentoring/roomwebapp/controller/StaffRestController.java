package com.wizeline.techmentoring.roomwebapp.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.wizeline.techmentoring.roomwebapp.model.Employee;
import com.wizeline.techmentoring.roomwebapp.service.StaffService;

import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/api/staff")
@AllArgsConstructor
public class StaffRestController {
    private final StaffService staffService;

    @GetMapping
    public List<Employee> getAllStaff() {
        return staffService.getStaff();
    }
}
