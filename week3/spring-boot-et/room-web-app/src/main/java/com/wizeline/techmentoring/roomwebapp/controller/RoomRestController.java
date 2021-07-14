package com.wizeline.techmentoring.roomwebapp.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.wizeline.techmentoring.roomwebapp.model.Room;
import com.wizeline.techmentoring.roomwebapp.service.RoomService;

import lombok.AllArgsConstructor;


@RestController
@RequestMapping("/api/rooms")
@AllArgsConstructor
public class RoomRestController {
    private final RoomService roomService;

    @GetMapping
    public List<Room> getAllRooms() {
        return roomService.getStaticRooms();
    }
}
