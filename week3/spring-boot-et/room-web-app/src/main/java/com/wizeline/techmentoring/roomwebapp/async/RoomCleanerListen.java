package com.wizeline.techmentoring.roomwebapp.async;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.wizeline.techmentoring.roomwebapp.model.Room;
import com.wizeline.techmentoring.roomwebapp.service.RoomService;

import lombok.AllArgsConstructor;

@Component
@AllArgsConstructor
public class RoomCleanerListen {
    private static final Logger LOGGGER = LoggerFactory.getLogger(RoomCleanerListen.class);

    private final ObjectMapper mapper;
    private final RoomService roomService;

    public void receiveMessage(String message) {
        try{
            AsyncPayload payload = mapper.readValue(message, AsyncPayload.class);
            if ("ROOM".equals(payload.getModel())) {
                Room room = roomService.getById(payload.getId());
                LOGGGER.info("ROOM {}:{} needs to be cleaned", room.getNumber(), room.getName());
            } else {
                LOGGGER.warn("Unknown model type");
            }
        }catch(JsonProcessingException e){
            e.printStackTrace();
        }
    }

}
