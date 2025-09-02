package com.bootcamp.demo.project_data_provider.model.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ProfileDTO {
  private String symbol;
  private String ticker;
  private String country;
  private String currency;
  private String estimateCurrency;
  private String exchange;
  private String finnhubIndustry;
  private String ipo;
  private String logo;
  private Double marketCapitalization;
  private String name;
  private String phone;
  private Double shareOutstanding;
  private String weburl;
}
