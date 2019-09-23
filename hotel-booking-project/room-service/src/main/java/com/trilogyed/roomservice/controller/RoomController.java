package com.trilogyed.roomservice.controller;

import com.trilogyed.roomservice.exception.RoomNotFoundException;
import com.trilogyed.roomservice.models.Room;
import com.trilogyed.roomservice.repository.RoomRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
public class RoomController {

    @Autowired
    RoomRepository repo;

    @RequestMapping(value = "/room/{number}", method = RequestMethod.GET)
    public Room getRoom(@PathVariable int number) {
        Optional<Room> room = repo.findById(number);
        if (room.isPresent()) {
            return room.get();
        }
        throw new RoomNotFoundException(number);
    }
    @RequestMapping(value = "/room", method = RequestMethod.GET)
    public List<Room> getAllRooms(){
        return repo.findAll();
    }
}
