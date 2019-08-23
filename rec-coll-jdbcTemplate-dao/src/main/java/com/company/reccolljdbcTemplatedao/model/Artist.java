package com.company.reccolljdbcTemplatedao.model;

import java.util.Objects;

public class Artist {
    private int id;
    private String name;
    private String instagram;
    private String twitter;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getInstagram() {
        return instagram;
    }

    public void setInstagram(String instagram) {
        this.instagram = instagram;
    }

    public String getTwitter() {
        return twitter;
    }

    public void setTwitter(String twitter) {
        this.twitter = twitter;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Artist artist = (Artist) o;
        return getId() == artist.getId() &&
                getName().equals(artist.getName()) &&
                getInstagram().equals(artist.getInstagram()) &&
                getTwitter().equals(artist.getTwitter());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getName(), getInstagram(), getTwitter());
    }
}
