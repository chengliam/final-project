package com.bootcamp.demo.project_data_provider.service;

import java.util.List;
import com.bootcamp.demo.project_data_provider.entity.QuoteEntity;
import com.bootcamp.demo.project_data_provider.entity.SymbolEntity;
// import com.bootcamp.demo.project_data_provider.model.dto.NextDataDTO;
import com.bootcamp.demo.project_data_provider.model.dto.QuoteDTO;
import com.bootcamp.demo.project_data_provider.model.dto.SymbolDTO;

public interface FHService {
  List<SymbolDTO> getSymbols();
  List<SymbolEntity> getAndSaveSymbols();
  List<QuoteDTO> getQuotes();
  List<QuoteEntity> getAndSaveQuotes();
  List getNextDatas();
  List getAndSaveNextDatas();
}
