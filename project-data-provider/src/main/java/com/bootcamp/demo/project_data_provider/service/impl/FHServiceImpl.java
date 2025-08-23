package com.bootcamp.demo.project_data_provider.service.impl;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;
import com.bootcamp.demo.project_data_provider.entity.SymbolEntity;
import com.bootcamp.demo.project_data_provider.lib.Scheme;
import com.bootcamp.demo.project_data_provider.mapper.EntityMapper;
import com.bootcamp.demo.project_data_provider.model.dto.SymbolDTO;
import com.bootcamp.demo.project_data_provider.repository.SymbolRepository;
import com.bootcamp.demo.project_data_provider.service.FHService;
// import jakarta.persistence.EntityManager;

@Service
public class FHServiceImpl implements FHService {
  @Value("${service-api.finnhub.host}")
  private String domain;

  @Value("${service-api.finnhub.endpoints.stock-symbols}")
  private String symbolsEndpoint;

  @Value("${service-api.finnhub.api-key}")
  private String apiKey;

  @Autowired
  private RestTemplate restTemplate;

  @Autowired
  private SymbolRepository symbolRepository;

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
    this.symbolRepository.deleteAll();;
    return this.symbolRepository.saveAll(symbolEntities);
  }
}
