package com.bootcamp.demo.project_data_provider.mapper;

import org.springframework.stereotype.Component;
import com.bootcamp.demo.project_data_provider.entity.SymbolEntity;
import com.bootcamp.demo.project_data_provider.model.dto.SymbolDTO;

@Component
public class EntityMapper {
  public SymbolEntity map(SymbolDTO symbolDTO) {
    return SymbolEntity.builder()
        .symbol(symbolDTO.getSymbol())
        .currency(symbolDTO.getCurrency())
        .description(symbolDTO.getDescription())
        .displaySymbol(symbolDTO.getDisplaySymbol())
        .figi(symbolDTO.getFigi())
        .isin(symbolDTO.getIsin())
        .mic(symbolDTO.getMic())
        .shareClassFIGI(symbolDTO.getShareClassFIGI())
        .symbol2(symbolDTO.getSymbol2())
        .type(symbolDTO.getType())
        .build();
  }
}