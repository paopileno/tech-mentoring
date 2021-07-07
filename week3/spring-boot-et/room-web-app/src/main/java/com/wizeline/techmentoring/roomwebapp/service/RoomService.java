/*
 * Copyright (c) 2021 Nextiva, Inc. to Present.
 * All rights reserved.
 */

package com.wizeline.techmentoring.roomwebapp.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.wizeline.techmentoring.roomwebapp.data.RoomRepository;
import com.wizeline.techmentoring.roomwebapp.model.Room;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class RoomService {
    private static final List<Room> rooms = new ArrayList<Room>();
    private final RoomRepository roomRepository;

    static {
        for (int i = 0; i < 10; i++) {
            rooms.add(new Room(i, "Room"+i,"R"+1,"info"));
        }
    }

    public List<Room> getStaticRooms() {
        return rooms;
    }

    public List<Room> getDBRooms() {
        return roomRepository.findAll();
    }
}
