package com.bootcamp.demo.project_data_provider.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "profiles")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Builder
public class ProfileEntity {
  @Id
  private String symbol;
  private String ticker;
  private String country;
  private String currency;
  @Column(name = "estimate_currency")
  private String estimateCurrency;
  private String exchange;
  @Column(name = "finnhub_industry")
  private String finnhubIndustry;
  private String ipo;
  private String logo;
  @Column(name = "market_capitalization")
  private Double marketCapitalization;
  private String name;
  private String phone;
  @Column(name = "share_outstanding")
  private Double shareOutstanding;
  private String weburl;
}
