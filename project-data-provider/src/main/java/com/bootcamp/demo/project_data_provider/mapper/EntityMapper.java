package com.bootcamp.demo.project_data_provider.mapper;

import org.springframework.stereotype.Component;
import com.bootcamp.demo.project_data_provider.entity.*;
import com.bootcamp.demo.project_data_provider.model.dto.*;

@Component
public class EntityMapper {
    public SymbolEntity map(SymbolDTO symbolDTO) {
        if (symbolDTO == null) return null;
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
    
    public QuoteEntity map(QuoteDTO quoteDTO) {
        if (quoteDTO == null) return null;
        return QuoteEntity.builder()
                .symbol(quoteDTO.getSymbol())
                .c(quoteDTO.getC())
                .d(quoteDTO.getD())
                .dp(quoteDTO.getDp())
                .h(quoteDTO.getH())
                .l(quoteDTO.getL())
                .o(quoteDTO.getO())
                .pc(quoteDTO.getPc())
                .t(quoteDTO.getT())
                .build();
    }
    
    public ProfileEntity map(ProfileDTO profileDTO) {
        if (profileDTO == null) return null;
        return ProfileEntity.builder()
                .symbol(profileDTO.getSymbol())
                .ticker(profileDTO.getTicker())
                .country(profileDTO.getCountry())
                .currency(profileDTO.getCurrency())
                .estimateCurrency(profileDTO.getEstimateCurrency())
                .exchange(profileDTO.getExchange())
                .finnhubIndustry(profileDTO.getFinnhubIndustry())
                .ipo(profileDTO.getIpo())
                .logo(profileDTO.getLogo())
                .marketCapitalization(profileDTO.getMarketCapitalization())
                .name(profileDTO.getName())
                .phone(profileDTO.getPhone())
                .shareOutstanding(profileDTO.getShareOutstanding())
                .weburl(profileDTO.getWeburl())
                .build();
    }
    
    public ProfileDTO map(ProfileEntity profileEntity) {
        if (profileEntity == null) return null;
        return ProfileDTO.builder()
                .symbol(profileEntity.getSymbol())
                .ticker(profileEntity.getTicker())
                .country(profileEntity.getCountry())
                .currency(profileEntity.getCurrency())
                .estimateCurrency(profileEntity.getEstimateCurrency())
                .exchange(profileEntity.getExchange())
                .finnhubIndustry(profileEntity.getFinnhubIndustry())
                .ipo(profileEntity.getIpo())
                .logo(profileEntity.getLogo())
                .marketCapitalization(profileEntity.getMarketCapitalization())
                .name(profileEntity.getName())
                .phone(profileEntity.getPhone())
                .shareOutstanding(profileEntity.getShareOutstanding())
                .weburl(profileEntity.getWeburl())
                .build();
    }
    
    public QuoteDTO map(QuoteEntity quoteEntity) {
        if (quoteEntity == null) return null;
        return QuoteDTO.builder()
                .symbol(quoteEntity.getSymbol())
                .c(quoteEntity.getC())
                .d(quoteEntity.getD())
                .dp(quoteEntity.getDp())
                .h(quoteEntity.getH())
                .l(quoteEntity.getL())
                .o(quoteEntity.getO())
                .pc(quoteEntity.getPc())
                .t(quoteEntity.getT())
                .build();
    }
    
    public SymbolDTO map(SymbolEntity symbolEntity) {
        if (symbolEntity == null) return null;
        return SymbolDTO.builder()
                .symbol(symbolEntity.getSymbol())
                .currency(symbolEntity.getCurrency())
                .description(symbolEntity.getDescription())
                .displaySymbol(symbolEntity.getDisplaySymbol())
                .figi(symbolEntity.getFigi())
                .isin(symbolEntity.getIsin())
                .mic(symbolEntity.getMic())
                .shareClassFIGI(symbolEntity.getShareClassFIGI())
                .symbol2(symbolEntity.getSymbol2())
                .type(symbolEntity.getType())
                .build();
    }
}