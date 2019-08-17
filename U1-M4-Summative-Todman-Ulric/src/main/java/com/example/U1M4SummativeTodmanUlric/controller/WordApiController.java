package com.example.U1M4SummativeTodmanUlric.controller;

import com.example.U1M4SummativeTodmanUlric.model.Definition;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@RestController
public class WordApiController {
    @RequestMapping(value = "/word", method = RequestMethod.GET)
    @ResponseStatus(code = HttpStatus.OK)
    public Definition getWord(){
        List<Definition> wordsList = new ArrayList<Definition>();
        Random random = new Random();
        wordsList.add(new Definition("alacrity","eager and cheerful readiness"));
        wordsList.add(new Definition("connotation", "suggestion in addition to"));
        wordsList.add(new Definition("corroboration", "additional strengthening evidence"));
        wordsList.add(new Definition("ebullient", "overflowing with enthusiasm showing excitement."));
        wordsList.add(new Definition("penury", "extreme poverty"));
        wordsList.add(new Definition("malapropism", "misuse of a word (for one that resembles it)"));
        wordsList.add(new Definition("empirical", "relying on experiment"));
        wordsList.add(new Definition("chicanery", "the use of tricks to decieve someone"));
        wordsList.add(new Definition("abeyance", "temporary cessation or suspension"));
        wordsList.add(new Definition("abstemious", "marked by temperence in indulgence"));
        wordsList.add(new Definition("commensurate", "corresponding in degree and size"));
        wordsList.add(new Definition("grandiloquent", "lofty in style"));
        wordsList.add(new Definition("gregarious", "temperamentally seeking and enjoying the company of others."));
        wordsList.add(new Definition("harangue", "a loud bombastic declaimation expressed with strong emotion"));
        wordsList.add(new Definition("alacrity", "livelyness and eagerness"));
        wordsList.add(new Definition("magnanimity", "nobility and generosity of spirit."));
        wordsList.add(new Definition("effrontery", "audacious behavior that you have no right to"));
        wordsList.add(new Definition("misanthrope", "someone who dislikes people in general"));
        wordsList.add(new Definition("imperturbable", "marked by extreme calm and composure"));
        wordsList.add(new Definition("obdurate", "stubbornly persist in wrongdoing"));
        wordsList.add(new Definition("erudite", "having or showing profound knowledge"));
        wordsList.add(new Definition("opprobrium","a state of extreme dishonor"));

        return wordsList.get(random.nextInt(wordsList.size()));
    }

}
