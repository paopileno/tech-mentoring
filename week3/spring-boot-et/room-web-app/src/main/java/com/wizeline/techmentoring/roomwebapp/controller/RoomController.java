/*
 * Copyright (c) 2021 Nextiva, Inc. to Present.
 * All rights reserved.
 */

package com.wizeline.techmentoring.roomwebapp.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.wizeline.techmentoring.roomwebapp.service.RoomService;

import lombok.AllArgsConstructor;

@Controller
@RequestMapping("/rooms")
@AllArgsConstructor
public class RoomController {
    private final RoomService roomService;

    @GetMapping
    public String getRooms(Model model) {
        model.addAttribute("rooms", roomService.getDBRooms());
        return "rooms";
    }

}
