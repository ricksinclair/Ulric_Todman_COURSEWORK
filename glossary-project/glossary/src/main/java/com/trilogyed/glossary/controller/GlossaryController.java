package com.trilogyed.glossary.controller;

import com.trilogyed.glossary.model.Definition;
import com.trilogyed.glossary.service.GlossaryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RefreshScope
public class GlossaryController {

    @Autowired
    GlossaryService glossaryService;

    @RequestMapping(path = "/glossary/term/{term}", method = RequestMethod.GET, produces = "application/json")
    @ResponseStatus(value = HttpStatus.OK)
    public List<Definition> getDefinitionByTerm(@PathVariable String term) {
        return glossaryService.getDefinitionsByTerm(term);
    }

    @RequestMapping(path = "/glossary", method = RequestMethod.POST, produces = "application/json")
    @ResponseStatus(value = HttpStatus.CREATED)
    public Definition addDefinition(@RequestBody Definition definition) {
       return  glossaryService.addDefinition(definition);
    }


}
