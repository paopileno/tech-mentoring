/*
 * Copyright (c) 2021 Nextiva, Inc. to Present.
 * All rights reserved.
 */

package com.wizeline.techmentoring.roomwebapp.service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.springframework.stereotype.Service;

import com.wizeline.techmentoring.roomwebapp.model.Employee;
import com.wizeline.techmentoring.roomwebapp.model.Position;

@Service
public class StaffService {
    private static final List<Employee> staff = new ArrayList<Employee>();

    static {
        staff.add(new Employee(UUID.randomUUID().toString(), "Juan", "Díaz", Position.CONCIERGE));
        staff.add(new Employee(UUID.randomUUID().toString(), "Arturo", "Lopez", Position.SECURITY));
        staff.add(new Employee(UUID.randomUUID().toString(), "Diego", "Martinez", Position.FRONT_DESK));
        staff.add(new Employee(UUID.randomUUID().toString(), "Antonio", "Perez", Position.HOUSEKEEPING));
    }

    public List<Employee> getStaff() {
        return staff;
    }
}
