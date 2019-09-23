package com.trilogyed.hotelbookingservice.controller;


import com.trilogyed.hotelbookingservice.model.viewmodel.BookingViewModel;
import com.trilogyed.hotelbookingservice.service.BookingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RefreshScope
public class HotelBookingServiceController {

    @Autowired
    BookingService service;

    @RequestMapping(path = "/hotelRewards/{roomId}?rewardsMember={isRewardsMember}&doubleBonusDay={isDoubleDay}", method = RequestMethod.GET)
    @ResponseStatus(value = HttpStatus.OK)
    public BookingViewModel getHotelBooking(@PathVariable int roomId, @PathVariable boolean isRewardsMember, @PathVariable boolean isDoubleDay) {


        return service.bookRoom(roomId, isRewardsMember, isDoubleDay);

    }

    @RequestMapping(path = "/hotelRewards/{roomId}", method = RequestMethod.GET)
    @ResponseStatus(value = HttpStatus.OK)
    public BookingViewModel nonMemberHotelBooking(@PathVariable int roomId) {
        return service.bookRoom(roomId, false, false);
    }

}
