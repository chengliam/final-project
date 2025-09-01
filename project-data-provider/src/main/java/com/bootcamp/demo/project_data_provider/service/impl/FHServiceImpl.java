package com.bootcamp.demo.project_data_provider.service.impl;

import java.util.ArrayList;
// import java.util.ArrayList;
import java.util.Arrays;
// import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;
import com.bootcamp.demo.project_data_provider.entity.NextDataEntity;
import com.bootcamp.demo.project_data_provider.entity.QuoteEntity;
import com.bootcamp.demo.project_data_provider.entity.SymbolEntity;
import com.bootcamp.demo.project_data_provider.lib.Scheme;
import com.bootcamp.demo.project_data_provider.mapper.EntityMapper;
import com.bootcamp.demo.project_data_provider.model.dto.NextDataDTO;
import com.bootcamp.demo.project_data_provider.model.dto.QuoteDTO;
import com.bootcamp.demo.project_data_provider.model.dto.SymbolDTO;
import com.bootcamp.demo.project_data_provider.repository.NextDataRepository;
import com.bootcamp.demo.project_data_provider.repository.QuoteRepository;
import com.bootcamp.demo.project_data_provider.repository.SymbolRepository;
import com.bootcamp.demo.project_data_provider.service.FHService;
// import jakarta.persistence.EntityManager;

@Service
public class FHServiceImpl implements FHService {
  @Value("${service-api.finnhub.host}")
  private String domain;

  @Value("${service-api.finnhub.endpoints.stock-symbols}")
  private String symbolsEndpoint;

  @Value("${service-api.finnhub.endpoints.quote}")
  private String quotesEndpoint;

  @Value("${service-api.finnhub.api-key}")
  private String apiKey;

  @Autowired
  private RestTemplate restTemplate;
  // private String url1 = UriComponentsBuilder.newInstance()
  // .scheme(Scheme.HTTPS.getValue()).host(domain).path(symbolsEndpoint)
  // .queryParam("exchange", "US").queryParam("mic", "XNYS")
  // .queryParam("token", apiKey).build().toUriString();
  // private String url2 =
  // UriComponentsBuilder.newInstance().scheme(Scheme.HTTPS.getValue())
  // .host(domain).path(quotesEndpoint).queryParam("symbol", "{symbols}")
  // .queryParam("token", apiKey).build().toUriString();

  @Autowired
  private SymbolRepository symbolRepository;

  @Autowired
  private QuoteRepository quoteRepository;

  @Autowired
  private NextDataRepository nextDataRepository;

  @Autowired
  private EntityMapper entityMapper;

  // @Override
  // public List<SymbolDTO> getSymbols() {
  // String url =
  // UriComponentsBuilder.newInstance().scheme(Scheme.HTTPS.getValue())
  // .host(domain).path(symbolsEndpoint).build().toUriString();
  // System.out.println("url = " + url);
  // https://finnhub.io/api/v1/stock/symbol?exchange=US&mic=XNYS&token=d2iokopr01qhm15bf0h0d2iokopr01qhm15bf0hg
  @Override
  public List<SymbolDTO> getSymbols() {
    String url = UriComponentsBuilder.newInstance()
        .scheme(Scheme.HTTPS.getValue()).host(domain).path(symbolsEndpoint)
        .queryParam("exchange", "US").queryParam("mic", "XNYS")
        .queryParam("token", apiKey).build().toUriString();
    System.out.println("url = " + url);

    SymbolDTO[] symbols =
        this.restTemplate.getForObject(url, SymbolDTO[].class);
    return Arrays.asList(symbols);
  }

  @Override
  public List<SymbolEntity> getAndSaveSymbols() {
    List<SymbolEntity> symbolEntities = this.getSymbols().stream()
        .map(e -> this.entityMapper.map(e)).collect(Collectors.toList());
    this.symbolRepository.deleteAll();
    return this.symbolRepository.saveAll(symbolEntities);
  }

  // https://finnhub.io/api/v1/quote?symbol=GNL.PRB&token=d2iokopr01qhm15bf0h0d2iokopr01qhm15bf0hg
  @Override
  public List<QuoteDTO> getQuotes() {
    String url =
        UriComponentsBuilder.newInstance().scheme(Scheme.HTTPS.getValue())
            .host(domain).path(quotesEndpoint).queryParam("symbol", "AAPL")
            .queryParam("token", apiKey).build().toUriString();
    System.out.println("url = " + url);

    QuoteDTO quotes = this.restTemplate.getForObject(url, QuoteDTO.class);
    return Arrays.asList(quotes);
  }

  @Override
  public List<QuoteEntity> getAndSaveQuotes() {
    List<QuoteEntity> quoteEntities = this.getQuotes().stream()
        .map(e -> this.entityMapper.map(e)).collect(Collectors.toList());
    this.quoteRepository.deleteAll();
    return this.quoteRepository.saveAll(quoteEntities);
  }

  @Override
  public List<NextDataDTO> getNextDatas() {
    List<SymbolEntity> symbols = symbolRepository.findAll();
    List<NextDataDTO> results = new ArrayList<>();
    int id = 0;

    for (SymbolEntity symbol : symbols) {
      String url = UriComponentsBuilder.newInstance()
          .scheme(Scheme.HTTPS.getValue()).host(domain).path(quotesEndpoint)
          .queryParam("symbol", symbol.getSymbol()).queryParam("token", apiKey)
          .build().toUriString();
      System.out.println("url = " + url);

      NextDataDTO nextDataDTO =
          this.restTemplate.getForObject(url, NextDataDTO.class);
      if (nextDataDTO == null)
        continue;
      id++;
      System.out.println("id = " + id);
      nextDataDTO.setId(id);
      nextDataDTO.setSymbol(symbol.getSymbol());
      System.out.println("nextDataEntity = " + nextDataDTO);

      results.add(nextDataDTO);

      // if (id % 30 == 0) {
      // try {
      // System.out.println("Now stop a minute.");
      // Thread.sleep(60 * 1000);
      // } catch (InterruptedException e) {
      // e.printStackTrace();
      // }
      // }
      if (id == 30) {
        break;
      }
    }
    System.out.println("Finish all");
    System.out.println("results = " + results);
    return results;
  }


  // List entitiesToSave = new ArrayList<>();
  // System.out.println("entitiesToSave is = " + entitiesToSave);

  // for (SymbolEntity se : symbols) {
  // String symbol = se.getSymbol();
  // // 使用统一的 URL 模板，通过符号参数获取后续数据
  // NextDataDTO dto = restTemplate.getForObject(nextApiUrlTemplate,
  // NextDataDTO.class, symbol);
  // if (dto == null)
  // continue;
  // dto.setSymbol(symbol);

  // NextDataEntity entity = NextDataEntity.builder().symbol(symbol)
  // .c(dto.getC()).d(dto.getD()).dp(dto.getDp()).h(dto.getH())
  // .l(dto.getL()).o(dto.getO()).pc(dto.getPc()).t(dto.getT()).build();

  // entitiesToSave.add(entity);
  // results.add(dto);
  // }

  // // 保存到数据库
  // nextDataRepository.saveAll(entitiesToSave);


  @Override
  public List<NextDataEntity> getAndSaveNextDatas() {
    List<NextDataEntity> nextDataEntities = this.getNextDatas().stream()
        .map(e -> this.entityMapper.map(e)).collect(Collectors.toList());
    this.nextDataRepository.deleteAll();
    return this.nextDataRepository.saveAll(nextDataEntities);
  }

}
