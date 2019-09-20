package com.trilogyed.glossary.feign;

import com.trilogyed.glossary.model.Definition;
import feign.Headers;
import feign.Param;
import feign.RequestLine;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;
@FeignClient(name = "definition-service")
public interface DefinitionClient {
    @RequestMapping(value="/definition/term/{term}", method = RequestMethod.GET)
    public List<Definition> getDefinitionByTerm(@Param("term") String term);
    @RequestMapping(value = "/definition/{id}", method = RequestMethod.GET)
    public Definition getDefinitionById(@Param("id") int id);

    @RequestMapping(value = "/definition", method = RequestMethod.POST)
    public Definition addDefinition(Definition definition);

}
