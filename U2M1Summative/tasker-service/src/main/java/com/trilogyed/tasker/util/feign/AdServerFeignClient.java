package com.trilogyed.tasker.util.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@FeignClient(name = "adserver-service")
public interface AdServerFeignClient {

@RequestMapping(value = "/ad", method = RequestMethod.GET)
    public String getRandomAd();
}
