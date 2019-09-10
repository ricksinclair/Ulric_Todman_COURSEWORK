package com.company.UlricTodmanU1Capstone.model;

import com.company.UlricTodmanU1Capstone.model.interfaces.Product;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.math.BigDecimal;
import java.util.Objects;

public class Game implements Product {
    private int gameId;
    @NotEmpty(message = "Title must not be null and must have a length greater than zero")
    @Size(max = 50, message = "title must be 50 characters or less")
    private String title;
    @NotEmpty(message = "esrbRating  must not be null and must have a length greater than zero")
    @Size(max = 50, message = "esrbRating  must be 50 characters or less")
    private String esrbRating;
    @NotEmpty(message = "Description must not be null and must have a length greater than zero")
    @Size(max = 255, message = "Description must be 255 characters or less")
    private String description;
    @NotNull(message = "Must include price")


    private BigDecimal price;

    @NotEmpty(message = "Studio must not be null and must have a length greater than zero")
    @Size(max = 50, message = "Studio must be 50 characters or less")
    private String studio;
    @NotNull(message= "Quantity must not be empty and must be a non-zero value")
    private int quantity;


    public int getGameId() {
        return gameId;
    }

    public void setGameId(int gameId) {
        this.gameId = gameId;
    }

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

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public String getStudio() {
        return studio;
    }

    public void setStudio(String studio) {
        this.studio = studio;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Game game = (Game) o;
        return gameId == game.gameId &&
                quantity == game.quantity &&
                title.equals(game.title) &&
                esrbRating.equals(game.esrbRating) &&
                description.equals(game.description) &&
                price.equals(game.price) &&
                studio.equals(game.studio);
    }

    @Override
    public int hashCode() {
        return Objects.hash(gameId, title, esrbRating, description, price, studio, quantity);
    }
}
