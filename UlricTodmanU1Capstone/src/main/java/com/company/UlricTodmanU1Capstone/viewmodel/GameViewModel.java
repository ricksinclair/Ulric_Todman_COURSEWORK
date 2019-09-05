package com.company.UlricTodmanU1Capstone.viewmodel;

import com.company.UlricTodmanU1Capstone.model.Game;

import java.math.BigDecimal;
import java.util.Objects;

public class GameViewModel {

    private String title;
    private String esrbRating;
    private String description;
    private String studio;


    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getEsrbRating() {
        return esrbRating;
    }

    public void setEsrbRating(String esrbRating) {
        this.esrbRating = esrbRating;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getStudio() {
        return studio;
    }

    public void setStudio(String studio) {
        this.studio = studio;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        GameViewModel that = (GameViewModel) o;
        return title.equals(that.title) &&
                esrbRating.equals(that.esrbRating) &&
                description.equals(that.description) &&
                studio.equals(that.studio);
    }

    @Override
    public int hashCode() {
        return Objects.hash(title, esrbRating, description, studio);
    }
}
