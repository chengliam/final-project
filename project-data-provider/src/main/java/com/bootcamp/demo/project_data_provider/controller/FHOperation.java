package com.bootcamp.demo.project_data_provider.controller;

import java.util.List;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import com.bootcamp.demo.project_data_provider.entity.SymbolEntity;
import com.bootcamp.demo.project_data_provider.model.dto.SymbolDTO;

public interface FHOperation {
  @GetMapping(value = "fh/symbols")
  List<SymbolDTO> getSymbols();

  @PostMapping(value = "fh/database/symbols")
  List<SymbolEntity> getAndSaveSymbols();
}
