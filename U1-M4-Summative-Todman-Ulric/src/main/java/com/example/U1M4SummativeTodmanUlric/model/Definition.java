package com.example.U1M4SummativeTodmanUlric.model;

public class Definition {
    private String word;
    private String definition;

    public Definition(){

    }
    public Definition(String word, String definition) {
        this.word = word;
        this.definition = definition;
    }

    public String getWord() {
        return word;
    }

    public void setWord(String word) {
        this.word = word;
    }

    public String getDefinition() {
        return definition;
    }

    public void setDefinition(String definition) {
        this.definition = definition;
    }
}
