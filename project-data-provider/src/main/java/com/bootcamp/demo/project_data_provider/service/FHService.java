package com.bootcamp.demo.project_data_provider.service;

import java.util.List;
import com.bootcamp.demo.project_data_provider.entity.SymbolEntity;
import com.bootcamp.demo.project_data_provider.model.dto.SymbolDTO;

public interface FHService {
  List<SymbolDTO> getSymbols();
  List<SymbolEntity> getAndSaveSymbols();
}
