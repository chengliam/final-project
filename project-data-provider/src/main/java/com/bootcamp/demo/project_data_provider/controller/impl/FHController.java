package com.bootcamp.demo.project_data_provider.controller.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;
import com.bootcamp.demo.project_data_provider.controller.FHOperation;
import com.bootcamp.demo.project_data_provider.entity.QuoteEntity;
import com.bootcamp.demo.project_data_provider.entity.ProfileEntity;
import com.bootcamp.demo.project_data_provider.entity.SymbolEntity;
import com.bootcamp.demo.project_data_provider.model.dto.QuoteDTO;
import com.bootcamp.demo.project_data_provider.model.dto.ProfileDTO;
import com.bootcamp.demo.project_data_provider.model.dto.SymbolDTO;
import com.bootcamp.demo.project_data_provider.service.FHService;

@RestController
public class FHController implements FHOperation {
  @Autowired
  private FHService fhService;

  @Override
  public List<SymbolDTO> getSymbols() {
    return this.fhService.getSymbols();
  }

  @Override
  public List<SymbolEntity> getAndSaveSymbols() {
    return this.fhService.getAndSaveSymbols();
  }

  @Override
  public List<QuoteDTO> getQuotes() {
    return this.fhService.getQuotes();
  }

  @Override
  public List<QuoteEntity> gatAndSaveQuotes() {
    return this.fhService.getAndSaveQuotes();
  }

  @Override
  public List<ProfileDTO> getProfiles() {
    return this.fhService.getProfiles();
  }

  @Override
  public List<ProfileEntity> getAndSaveProfiles() {
    return this.fhService.getAndSaveProfiles();
  }

}
