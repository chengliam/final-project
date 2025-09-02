package com.bootcamp.demo.project_data_provider.model.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class QuoteDTO {
  private String symbol;
  private Double c;
  private Double d;
  private Double dp;
  private Double h;
  private Double l;
  private Double o;
  private Double pc;
  private Long t;
}
