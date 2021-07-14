package com.wizeline.techmentoring.roomwebapp.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.wizeline.techmentoring.roomwebapp.service.StaffService;

import lombok.AllArgsConstructor;

@Controller
@RequestMapping("/staff")
@AllArgsConstructor
public class StaffController {

    private final StaffService staffService;

    @GetMapping
    public String getStaff(Model model) {
        model.addAttribute("staff", staffService.getDBStaff());
        return "staff";
    }
}
