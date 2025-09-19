package com.bootcamp.demo.project_data_provider.model.dto;

import lombok.*;
import java.math.BigDecimal;

@Getter
@Setter
@Builder
@ToString
public class QuoteDTO {
    private String symbol;
    private BigDecimal c;
    private BigDecimal d;
    private BigDecimal dp;
    private BigDecimal h;
    private BigDecimal l;
    private BigDecimal o;
    private BigDecimal pc;
    private Long t;
}