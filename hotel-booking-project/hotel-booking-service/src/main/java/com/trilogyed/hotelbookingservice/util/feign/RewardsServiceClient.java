package com.trilogyed.hotelbookingservice.util.feign;

import com.trilogyed.hotelbookingservice.model.Rewards;
import com.trilogyed.hotelbookingservice.model.Room;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@FeignClient(name = "rewards-service")
public interface RewardsServiceClient {

    @RequestMapping(path = "/rewards/type/{roomType}", method = RequestMethod.GET)
    public Rewards getRoomRewards(@PathVariable String roomType);

    @RequestMapping(path = "/rewards", method = RequestMethod.GET)
    public List<Rewards> getAllRewards();
}
