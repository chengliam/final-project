package com.bootcamp.demo.project_data_provider.entity;

import jakarta.persistence.*;
import lombok.*;
import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
@Table(name = "profiles", indexes = {
    @Index(name = "idx_profiles_exchange", columnList = "exchange"),
    @Index(name = "idx_profiles_country", columnList = "country")
})
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ProfileEntity {
    @Id  // ✅ 修正：移動到這裡
    @Column(name = "symbol", nullable = false, length = 10)
    private String symbol;
    
    @Column(name = "ticker", length = 10)
    private String ticker;
    
    @Column(name = "country", length = 100)
    private String country;
    
    @Column(name = "currency", length = 3)
    private String currency;
    
    @Column(name = "estimate_currency", length = 3)
    private String estimateCurrency;
    
    @Column(name = "exchange", length = 20)
    private String exchange;
    
    @Column(name = "finnhub_industry", length = 100)
    private String finnhubIndustry;
    
    @Column(name = "ipo")
    private LocalDate ipo;
    
    @Column(name = "logo", length = 500)
    private String logo;
    
    @Column(name = "market_capitalization")
    private BigDecimal marketCapitalization;
    
    @Column(name = "name", length = 200)
    private String name;
    
    @Column(name = "phone", length = 20)
    private String phone;
    
    @Column(name = "share_outstanding")
    private BigDecimal shareOutstanding;
    
    @Column(name = "weburl", length = 500)
    private String weburl;
}