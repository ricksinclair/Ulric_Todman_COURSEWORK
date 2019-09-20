package com.trilogyed.glossary.service;

import com.trilogyed.glossary.feign.DefinitionClient;
import com.trilogyed.glossary.model.Definition;
import feign.Feign;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Component
public class GlossaryService {

    private static Set<String> prohibitedWordSet = new HashSet<String>();

    static {
        prohibitedWordSet.add("darn");
        prohibitedWordSet.add("heck");
        prohibitedWordSet.add("drat");
        prohibitedWordSet.add("jerk");
        prohibitedWordSet.add("butt");

    }

    @Autowired
    private final DefinitionClient client;

    GlossaryService(DefinitionClient definitionClient) {
        this.client = definitionClient;
    }

    public List<Definition> getDefinitionsByTerm(String term) {

            return client.getDefinitionByTerm(term);
        }


    public Definition getDefinitionById(int id) {
        return client.getDefinitionById(id);
    }

    public Definition addDefinition(Definition definition) {
        String[] words = definition.getDefinition().split("\\s+");
        for (String word : words) {
            if (prohibitedWordSet.contains(word)) {
                throw new IllegalArgumentException("Prohibited word " + word + " found. Please watch your language and try again.");

            }
        }


            return client.addDefinition(definition);
        }

    }






