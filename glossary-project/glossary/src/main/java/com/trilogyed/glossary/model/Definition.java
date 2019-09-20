package com.trilogyed.glossary.model;

import javax.validation.constraints.NotNull;
import java.util.Objects;

public class Definition {

    private Integer id;
    @NotNull(message = "must include term")
    private String term;
    @NotNull(message = "must include definition")
    private String definition;

    public Definition() {
    }

    public Definition(Integer id, String term, String definition) {
        this.id = id;
        this.term = term;
        this.definition = definition;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTerm() {
        return term;
    }

    public void setTerm(String term) {
        this.term = term;
    }

    public String getDefinition() {
        return definition;
    }

    public void setDefinition(String definition) {
        this.definition = definition;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Definition that = (Definition) o;
        return getId().equals(that.getId()) &&
                getTerm().equals(that.getTerm()) &&
                getDefinition().equals(that.getDefinition());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getTerm(), getDefinition());
    }
}
