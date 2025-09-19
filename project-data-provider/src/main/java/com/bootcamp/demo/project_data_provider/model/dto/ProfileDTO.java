package com.bootcamp.demo.project_data_provider.model.dto;

import lombok.*;
import jakarta.validation.constraints.*;
import java.math.BigDecimal;
import java.time.LocalDate;
import org.hibernate.validator.constraints.URL;

@Getter
@Setter
@Builder
@ToString
public class ProfileDTO {
    @NotBlank(message = "Symbol cannot be blank")
    private String symbol;
    
    private String ticker;
    
    private String country;
    
    @Size(min = 3, max = 3, message = "Currency must be 3 characters")
    private String currency;
    
    private String estimateCurrency;
    
    private String exchange;
    
    private String finnhubIndustry;
    
    private LocalDate ipo;
    
    @URL(message = "Logo must be a valid URL")
    private String logo;
    
    @Positive(message = "Market capitalization must be positive")
    private BigDecimal marketCapitalization;
    
    @NotBlank(message = "Name cannot be blank")
    private String name;
    
    private String phone;
    
    @Positive(message = "Share outstanding must be positive")
    private BigDecimal shareOutstanding;
    
    @URL(message = "Weburl must be a valid URL")
    private String weburl;
}