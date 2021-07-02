/*
 * Copyright (c) 2021 Nextiva, Inc. to Present.
 * All rights reserved.
 */

package com.wizeline.techmentoring.roomwebapp.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.wizeline.techmentoring.roomwebapp.model.Room;

@Controller
@RequestMapping("/rooms")
public class RoomController {
    private static final List<Room> rooms = new ArrayList<Room>();

    static {
        for (int i = 0; i < 10; i++) {
            rooms.add(new Room(i, "Room"+i,"R"+1,"info"));
        }
    }

    @GetMapping
    public String getRooms(Model model) {
        model.addAttribute("rooms", rooms);
        return "rooms";
    }

}
