package com.trilogyed.roomservice.exception;

public class RoomNotFoundException extends RuntimeException {
    public RoomNotFoundException(int number) {super("There is no room number " + number);}
}
