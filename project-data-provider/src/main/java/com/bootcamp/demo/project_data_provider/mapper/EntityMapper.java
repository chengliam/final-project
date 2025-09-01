package com.bootcamp.demo.project_data_provider.mapper;

import org.springframework.stereotype.Component;
import com.bootcamp.demo.project_data_provider.entity.NextDataEntity;
import com.bootcamp.demo.project_data_provider.entity.QuoteEntity;
import com.bootcamp.demo.project_data_provider.entity.SymbolEntity;
import com.bootcamp.demo.project_data_provider.model.dto.NextDataDTO;
import com.bootcamp.demo.project_data_provider.model.dto.QuoteDTO;
import com.bootcamp.demo.project_data_provider.model.dto.SymbolDTO;

@Component
public class EntityMapper {
  public SymbolEntity map(SymbolDTO symbolDTO) {
    return SymbolEntity.builder().symbol(symbolDTO.getSymbol())
        .currency(symbolDTO.getCurrency())
        .description(symbolDTO.getDescription())
        .displaySymbol(symbolDTO.getDisplaySymbol()).figi(symbolDTO.getFigi())
        .isin(symbolDTO.getIsin()).mic(symbolDTO.getMic())
        .shareClassFIGI(symbolDTO.getShareClassFIGI())
        .symbol2(symbolDTO.getSymbol2()).type(symbolDTO.getType()).build();
  }

  public QuoteEntity map(QuoteDTO quoteDTO) {
    return QuoteEntity.builder().c(quoteDTO.getC()).d(quoteDTO.getD())
        .dp(quoteDTO.getDp()).h(quoteDTO.getH()).l(quoteDTO.getL())
        .o(quoteDTO.getO()).pc(quoteDTO.getPc()).t(quoteDTO.getT()).build();
  }

  public NextDataEntity map(NextDataDTO nextDataEntity) {
    return NextDataEntity.builder().symbol(nextDataEntity.getSymbol())
        .c(nextDataEntity.getC()).d(nextDataEntity.getD())
        .dp(nextDataEntity.getDp()).h(nextDataEntity.getH())
        .l(nextDataEntity.getL()).o(nextDataEntity.getO())
        .pc(nextDataEntity.getPc()).t(nextDataEntity.getT()).build();
  }

}
