package com.trilogyed.hotelbookingservice.service;

import com.trilogyed.hotelbookingservice.model.Rewards;
import com.trilogyed.hotelbookingservice.model.Room;
import com.trilogyed.hotelbookingservice.model.viewmodel.BookingViewModel;
import com.trilogyed.hotelbookingservice.util.feign.RewardsServiceClient;
import com.trilogyed.hotelbookingservice.util.feign.RoomServiceClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class BookingService {

    @Autowired
    RoomServiceClient roomServiceClient;

    @Autowired
    RewardsServiceClient rewardsServiceClient;


    public BookingViewModel bookRoom(int roomNumber, boolean isRewardsMember, boolean isDoubleDay) {


        Room room = roomServiceClient.getRoomByRoomNumber(roomNumber);

        Rewards reward = rewardsServiceClient.getRoomRewards(room.getRoomType());

        BookingViewModel bvm = new BookingViewModel();

        bvm.setRoomId(roomNumber);
        bvm.setBaseRate(room.getBaseRate());


        if (!isRewardsMember) {
            bvm.setTotalRewardPoints(0);
            bvm.setMemberDiscount(0f);
            bvm.setBaseRewardPoints(0);
        } else {
            bvm.setBaseRewardPoints(reward.getPoints());
            if(reward.getCanDouble()){
                bvm.setCanDouble(true);
            }else{
                bvm.setCanDouble(false);
            }

            if (reward.getCanDouble() && isDoubleDay) {
                bvm.setTotalRewardPoints(reward.getPoints() * 2);
            } else {
                bvm.setTotalRewardPoints(reward.getPoints());
            }

            bvm.setMemberDiscount(reward.getDiscount());

            bvm.setFinalCost(bvm.getBaseRate()*(1-bvm.getMemberDiscount()));



        }
        return bvm;
    }

}
