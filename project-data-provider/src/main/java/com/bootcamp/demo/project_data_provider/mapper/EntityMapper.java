package com.bootcamp.demo.project_data_provider.mapper;

import org.springframework.stereotype.Component;
import com.bootcamp.demo.project_data_provider.entity.QuoteEntity;
import com.bootcamp.demo.project_data_provider.entity.ProfileEntity;
import com.bootcamp.demo.project_data_provider.entity.SymbolEntity;
import com.bootcamp.demo.project_data_provider.model.dto.QuoteDTO;
import com.bootcamp.demo.project_data_provider.model.dto.ProfileDTO;
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
    return QuoteEntity.builder().symbol(quoteDTO.getSymbol()).c(quoteDTO.getC())
        .d(quoteDTO.getD()).dp(quoteDTO.getDp()).h(quoteDTO.getH())
        .l(quoteDTO.getL()).o(quoteDTO.getO()).pc(quoteDTO.getPc())
        .t(quoteDTO.getT()).build();
  }

  public ProfileEntity map(ProfileDTO profileDTO) {
    return ProfileEntity.builder().symbol(profileDTO.getSymbol())
        .ticker(profileDTO.getTicker()).country(profileDTO.getCountry())
        .currency(profileDTO.getCurrency())
        .estimateCurrency(profileDTO.getEstimateCurrency())
        .exchange(profileDTO.getExchange())
        .finnhubIndustry(profileDTO.getFinnhubIndustry())
        .ipo(profileDTO.getIpo()).logo(profileDTO.getLogo())
        .marketCapitalization(profileDTO.getMarketCapitalization())
        .name(profileDTO.getName()).phone(profileDTO.getPhone())
        .shareOutstanding(profileDTO.getShareOutstanding())
        .weburl(profileDTO.getWeburl()).build();
  }

}
