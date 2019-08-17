package com.example.U1M4SummativeTodmanUlric.model;

import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@RestControllerAdvice
public class Question {

    @NotNull(message = "Question is required. Please modify request body and try again.")
    private String question;


    public Question() {
    }

    public Question(String question) {
        this.question = question;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }
}
