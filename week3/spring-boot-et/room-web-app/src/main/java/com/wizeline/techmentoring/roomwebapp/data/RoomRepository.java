package com.wizeline.techmentoring.roomwebapp.data;

import org.springframework.data.jpa.repository.JpaRepository;

import com.wizeline.techmentoring.roomwebapp.model.Room;

public interface RoomRepository extends JpaRepository<Room, Long> {

}
