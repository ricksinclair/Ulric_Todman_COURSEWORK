package com.trilogyed.ulrictodmanmagiceightballservice.controller;


import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@RestController
@RefreshScope
public class MagicEightBallController    {
    private static List<String> answerList= new ArrayList<String>();
    private Random random = new Random();
    static{
        answerList.add("No");
        answerList.add("Yes");
        answerList.add("Looking cloudy");
        answerList.add("Not sure");
        answerList.add("Absolutely!");
        answerList.add("Ask again");
        answerList.add("Ummm");
        answerList.add("Not a chance");
    }

    @RequestMapping(path = "/eightballanswer", method = RequestMethod.GET)
    @ResponseStatus(value = HttpStatus.OK)
    public String  getAnswer(){
        String answer = answerList.get(random.nextInt(answerList.size()));
        return answer;
    }
}
