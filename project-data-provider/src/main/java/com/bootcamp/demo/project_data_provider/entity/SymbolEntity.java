package com.bootcamp.demo.project_data_provider.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "symbols")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class SymbolEntity {
    @Id
    @Column(name = "symbol", nullable = false, length = 10)
    private String symbol;
    
    @Column(name = "currency", length = 3)
    private String currency;
    
    @Column(name = "description", length = 200)
    private String description;
    
    @Column(name = "display_symbol", length = 10)
    private String displaySymbol;
    
    @Column(name = "figi", length = 12)
    private String figi;
    
    @Column(name = "isin", length = 12)
    private String isin;
    
    @Column(name = "mic", length = 4)
    private String mic;
    
    @Column(name = "share_class_figi", length = 12)
    private String shareClassFIGI;
    
    @Column(name = "symbol2", length = 10)
    private String symbol2;
    
    @Column(name = "type", length = 50)
    private String type;
}