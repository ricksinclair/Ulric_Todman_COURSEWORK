package com.trilogyed.hotelbookingservice.util.feign;

import com.trilogyed.hotelbookingservice.model.Room;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@FeignClient(name = "room-service")
public interface RoomServiceClient {

    @RequestMapping(path = "/room/{roomNumber}", method = RequestMethod.GET)
    public Room getRoomByRoomNumber(@PathVariable int roomNumber);

    @RequestMapping(path = "/room", method = RequestMethod.GET)
    public List<Room> getAllRooms();
}
