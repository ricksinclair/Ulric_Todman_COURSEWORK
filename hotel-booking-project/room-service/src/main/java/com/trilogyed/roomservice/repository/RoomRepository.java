package com.trilogyed.roomservice.repository;

import com.trilogyed.roomservice.models.Room;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoomRepository extends JpaRepository<Room, Integer>{

}
