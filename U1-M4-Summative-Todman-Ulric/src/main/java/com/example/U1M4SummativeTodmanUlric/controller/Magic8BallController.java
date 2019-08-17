package com.example.U1M4SummativeTodmanUlric.controller;


import com.example.U1M4SummativeTodmanUlric.model.Answer;
import com.example.U1M4SummativeTodmanUlric.model.Question;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@RestController
public class Magic8BallController {
    @RequestMapping(value = "/magic", method = RequestMethod.POST)
    @ResponseStatus(value = HttpStatus.OK)
    public Answer answerQuestion(@RequestBody @Valid Question question) {

        List<String> answersList = new ArrayList<String>();
        answersList.add("It is certain.");
        answersList.add("It is decidedly so.");
        answersList.add("Without a doubt");
        answersList.add("Yes - definitely");
        answersList.add("You may rely on it");
        answersList.add("As I see it, yes.");
        answersList.add("Most likely.");
        answersList.add("Outlook good.");
        answersList.add("Yes.");
        answersList.add("Signs point to yes.");
        answersList.add("Reply hazy, try again.");
        answersList.add("Ask again later.");
        answersList.add("Better not tell you now.");
        answersList.add("Can't predict now.");
        answersList.add("Concentrate and ask again.");
        answersList.add("Don't count on it.");
        answersList.add("My reply is no.");
        answersList.add("My sources say no.");
        answersList.add("Outlook not so good.");
        answersList.add("Very doubtful");


        Random random = new Random();

        return new Answer(question.getQuestion(), answersList.get(random.nextInt(answersList.size())));
    }
}
