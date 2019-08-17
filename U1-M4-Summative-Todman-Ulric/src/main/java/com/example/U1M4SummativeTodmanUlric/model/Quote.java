package com.example.U1M4SummativeTodmanUlric.model;

public class Quote {
    private String quote;
    private String Author;

    public Quote(){

    }
    public Quote(String quote, String author) {
        this.quote = quote;
        Author = author;
    }

    public String getQuote() {
        return quote;
    }

    public void setQuote(String quote) {
        this.quote = quote;
    }

    public String getAuthor() {
        return Author;
    }

    public void setAuthor(String author) {
        Author = author;
    }
}
