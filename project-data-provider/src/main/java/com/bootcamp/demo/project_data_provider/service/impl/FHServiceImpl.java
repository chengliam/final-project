package com.bootcamp.demo.project_data_provider.service.impl;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;
import com.bootcamp.demo.project_data_provider.entity.QuoteEntity;
import com.bootcamp.demo.project_data_provider.entity.ProfileEntity;
import com.bootcamp.demo.project_data_provider.entity.SymbolEntity;
import com.bootcamp.demo.project_data_provider.lib.Scheme;
import com.bootcamp.demo.project_data_provider.mapper.EntityMapper;
import com.bootcamp.demo.project_data_provider.model.dto.QuoteDTO;
import com.bootcamp.demo.project_data_provider.model.dto.ProfileDTO;
import com.bootcamp.demo.project_data_provider.model.dto.SymbolDTO;
import com.bootcamp.demo.project_data_provider.repository.QuoteRepository;
import com.bootcamp.demo.project_data_provider.repository.ProfileRepository;
import com.bootcamp.demo.project_data_provider.repository.SymbolRepository;
import com.bootcamp.demo.project_data_provider.service.FHService;

@Service
public class FHServiceImpl implements FHService {
  @Value("${service-api.finnhub.host}")
  private String domain;

  @Value("${service-api.finnhub.endpoints.stock-symbols}")
  private String symbolsEndpoint;

  @Value("${service-api.finnhub.endpoints.quote}")
  private String quotesEndpoint;

  @Value("${service-api.finnhub.endpoints.stock-profile}")
  private String profileEndpoint;

  @Value("${service-api.finnhub.api-key}")
  private String apiKey;

  @Autowired
  private RestTemplate restTemplate;

  @Autowired
  private SymbolRepository symbolRepository;

  @Autowired
  private QuoteRepository quoteRepository;

  @Autowired
  private ProfileRepository profileRepository;

  @Autowired
  private EntityMapper entityMapper;

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

  @Override
  public List<QuoteDTO> getQuotes() {
    List<SymbolEntity> symbols = symbolRepository.findAll();
    List<QuoteDTO> results = new ArrayList<>();
    int counter = 0;

    for (SymbolEntity symbol : symbols) {
      String url = UriComponentsBuilder.newInstance()
          .scheme(Scheme.HTTPS.getValue()).host(domain).path(quotesEndpoint)
          .queryParam("symbol", symbol.getSymbol()).queryParam("token", apiKey)
          .build().toUriString();
      System.out.println("url = " + url);

      QuoteDTO quoteDTO = this.restTemplate.getForObject(url, QuoteDTO.class);
      if (quoteDTO == null)
        continue;
      counter++;
      System.out.println("counter = " + counter);
      quoteDTO.setSymbol(symbol.getSymbol());
      System.out.println("quoteDTO = " + quoteDTO);
      results.add(quoteDTO);

      // if (counter % 30 == 0) {
      // try {
      // System.out.println("Now stop a minute.");
      // Thread.sleep(60 * 1000);
      // } catch (InterruptedException e) {
      // e.printStackTrace();
      // }
      // }

      if (counter == 10) {
        break;
      }
    }

    System.out.println("Finish all");
    System.out.println("results = " + results);
    return results;
  }

  @Override
  public List<QuoteEntity> getAndSaveQuotes() {
    List<QuoteEntity> quoteEntities = this.getQuotes().stream()
        .map(e -> this.entityMapper.map(e)).collect(Collectors.toList());
    this.quoteRepository.deleteAll();
    return this.quoteRepository.saveAll(quoteEntities);
  }

  @Override
  public List<ProfileDTO> getProfiles() {
    List<SymbolEntity> symbols = symbolRepository.findAll();
    List<ProfileDTO> results = new ArrayList<>();
    int counter = 0;

    for (SymbolEntity symbol : symbols) {
      String url = UriComponentsBuilder.newInstance()
          .scheme(Scheme.HTTPS.getValue()).host(domain).path(profileEndpoint)
          .queryParam("symbol", symbol.getSymbol()).queryParam("token", apiKey)
          .build().toUriString();
      System.out.println("url = " + url);

      ProfileDTO profileDTO =
          this.restTemplate.getForObject(url, ProfileDTO.class);
      if (profileDTO == null)
        continue;
      counter++;
      System.out.println("counter = " + counter);
      profileDTO.setSymbol(symbol.getSymbol());
      System.out.println("profileDTO = " + profileDTO);
      results.add(profileDTO);

      // if (counter % 30 == 0) {
      // try {
      // System.out.println("Now stop a minute.");
      // Thread.sleep(60 * 1000);
      // } catch (InterruptedException e) {
      // e.printStackTrace();
      // }
      // }

      if (counter == 10) {
        break;
      }
    }

    System.out.println("Finish all");
    System.out.println("results = " + results);
    return results;
  }

  @Override
  public List<ProfileEntity> getAndSaveProfiles() {
    List<ProfileEntity> profileEntities = this.getProfiles().stream()
        .map(e -> this.entityMapper.map(e)).collect(Collectors.toList());
    this.profileRepository.deleteAll();
    return this.profileRepository.saveAll(profileEntities);
  }
}
