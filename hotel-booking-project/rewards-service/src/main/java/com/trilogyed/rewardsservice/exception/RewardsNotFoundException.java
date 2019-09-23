package com.trilogyed.rewardsservice.exception;

public class RewardsNotFoundException extends RuntimeException {
    public RewardsNotFoundException(String roomType) {super("Rewards information not found for room type " + roomType);}
}
