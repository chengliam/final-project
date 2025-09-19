package com.bootcamp.demo.project_data_provider.controller;

import java.util.List;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.bootcamp.demo.project_data_provider.entity.*;
import com.bootcamp.demo.project_data_provider.model.dto.*;

@RequestMapping("/api")
public interface FHOperation {
    
    @GetMapping(value = "/fh/symbols")
    @ResponseStatus(HttpStatus.OK)
    List<SymbolDTO> getSymbols();
    
    @PostMapping(value = "/fh/database/symbols")
    @ResponseStatus(HttpStatus.CREATED)
    List<SymbolEntity> getAndSaveSymbols();
    
    @GetMapping(value = "/fh/quotes")
    @ResponseStatus(HttpStatus.OK)
    List<QuoteDTO> getQuotes();
    
    @PostMapping(value = "/fh/database/quotes")
    @ResponseStatus(HttpStatus.CREATED)
    List<QuoteEntity> getAndSaveQuotes();
    
    @GetMapping(value = "/fh/profiles")
    @ResponseStatus(HttpStatus.OK)
    List<ProfileDTO> getProfiles();
    
    @PostMapping(value = "/fh/database/profiles")
    @ResponseStatus(HttpStatus.CREATED)
    List<ProfileEntity> getAndSaveProfiles();
}