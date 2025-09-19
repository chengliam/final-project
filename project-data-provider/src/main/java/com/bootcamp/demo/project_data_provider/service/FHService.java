package com.bootcamp.demo.project_data_provider.service;

import com.bootcamp.demo.project_data_provider.entity.*;
import com.bootcamp.demo.project_data_provider.model.dto.*;
import java.util.List;

public interface FHService {
    List<SymbolDTO> getSymbols();
    List<SymbolEntity> getAndSaveSymbols();
    List<QuoteDTO> getQuotes();
    List<QuoteEntity> getAndSaveQuotes();
    List<ProfileDTO> getProfiles();
    List<ProfileEntity> getAndSaveProfiles();
}