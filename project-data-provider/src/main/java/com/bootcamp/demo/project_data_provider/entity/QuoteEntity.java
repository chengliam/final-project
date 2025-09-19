package com.bootcamp.demo.project_data_provider.entity;

import jakarta.persistence.*;
import lombok.*;
import java.math.BigDecimal;

@Entity
@Table(name = "quotes")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class QuoteEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @Column(name = "symbol", nullable = false, length = 10)
    private String symbol;
    
    @Column(name = "current_price")
    private BigDecimal c;
    
    @Column(name = "change")
    private BigDecimal d;
    
    @Column(name = "percent_change")
    private BigDecimal dp;
    
    @Column(name = "high_price")
    private BigDecimal h;
    
    @Column(name = "low_price")
    private BigDecimal l;
    
    @Column(name = "open_price")
    private BigDecimal o;
    
    @Column(name = "previous_close")
    private BigDecimal pc;
    
    @Column(name = "timestamp")
    private Long t;
}