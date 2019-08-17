package com.example.U1M4SummativeTodmanUlric.controller;

import com.example.U1M4SummativeTodmanUlric.model.Quote;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@RestController
public class QuoteApiController {


    @RequestMapping(value = "/quote", method = RequestMethod.GET)
    @ResponseStatus(code = HttpStatus.OK)
    public Quote getQuote() {
        Random random = new Random();
        List<Quote> quotesList = new ArrayList<Quote>();
        quotesList.add(new Quote("No one can make you feel inferior without your consent.",
                " Eleanor Roosevelt"));
        quotesList.add(new Quote("Live as if you were to die tomorrow. Learn as if you were to live forever.",
                "Mahatma Ghandi"));
        quotesList.add(new Quote("Darkness cannot drive out darkness: only light can do that. Hate cannot drive out hate: only love can do that.",
                "Rev.Dr. Martin Luther King Jr"));
        quotesList.add(new Quote("I've learned that people will forget what you said, people will forget what you did, but people will never forget how you made them feel.",
                "Maya Angelou"));
        quotesList.add(new Quote("There are two ways to live your life. One as though nothing is a miracle. The other as though everything is a miracle.",
                "Albert Einstein"));
        quotesList.add(new Quote("I'm for truth no matter who tells it. I'm for justice no matter who it is for or against. I'm a human being, first and foremost, and as such I'm for whoever and whatever benefits humanity as a whole.",
                "Malcolm X"));
        quotesList.add(new Quote("It doesn't take great people to do great things, just unselfish ones.",
                "Anonymous"));
        quotesList.add(new Quote("Death is not the greatest loss in life. The greatest loss is what dies inside while still alive. Never surrender.",
                "Tupac Amaru Shakur"));
        quotesList.add(new Quote("Intelligence is the ability to adapt to change.",
                "Stephen Hawking"));
        quotesList.add(new Quote("If we cannot now end our differences, at least we can help make the world safe for diversity. For, in the final analysis, our most basic common  link is that we  all inhabit this small planet. We all breathe the same air. We all cherish our children's future. And we are all mortal.",
                "John Fitzgerald Kennedy"));
        return quotesList.get(random.nextInt(quotesList.size() ));
    }

}
