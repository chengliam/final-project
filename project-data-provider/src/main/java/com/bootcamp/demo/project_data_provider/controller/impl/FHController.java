package com.bootcamp.demo.project_data_provider.controller.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.bootcamp.demo.project_data_provider.controller.FHOperation;
import com.bootcamp.demo.project_data_provider.entity.*;
import com.bootcamp.demo.project_data_provider.model.dto.*;
import com.bootcamp.demo.project_data_provider.service.FHService;

@RestController
@RequestMapping("/api")
public class FHController implements FHOperation {
    
    @Autowired
    private FHService fhService;
    
    @Override
    @GetMapping(value = "/fh/symbols")
    @ResponseStatus(HttpStatus.OK)
    public List<SymbolDTO> getSymbols() {
        return fhService.getSymbols();
    }
    
    @Override
    @PostMapping(value = "/fh/database/symbols")
    @ResponseStatus(HttpStatus.CREATED)
    public List<SymbolEntity> getAndSaveSymbols() {
        return fhService.getAndSaveSymbols();
    }
    
    @Override
    @GetMapping(value = "/fh/quotes")
    @ResponseStatus(HttpStatus.OK)
    public List<QuoteDTO> getQuotes() {
        return fhService.getQuotes();
    }
    
    @Override
    @PostMapping(value = "/fh/database/quotes")
    @ResponseStatus(HttpStatus.CREATED)
    public List<QuoteEntity> getAndSaveQuotes() {
        return fhService.getAndSaveQuotes();
    }
    
    @Override
    @GetMapping(value = "/fh/profiles")
    @ResponseStatus(HttpStatus.OK)
    public List<ProfileDTO> getProfiles() {
        return fhService.getProfiles();
    }
    
    @Override
    @PostMapping(value = "/fh/database/profiles")
    @ResponseStatus(HttpStatus.CREATED)
    public List<ProfileEntity> getAndSaveProfiles() {
        return fhService.getAndSaveProfiles();
    }
}