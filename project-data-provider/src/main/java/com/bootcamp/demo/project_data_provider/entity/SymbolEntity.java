package com.bootcamp.demo.project_data_provider.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import org.springframework.stereotype.Indexed;
import jakarta.annotation.Generated;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "symbols")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Builder
public class SymbolEntity {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private String symbol;
  @Column(nullable = false)
  private String currency;
  @Column(nullable = false)
  private String description;
  @Column(nullable = false)
  private String displaySymbol;
  @Column(nullable = false)
  private String figi;
  @Column
  private String isin;
  @Column(nullable = false)
  private String mic;
  @Column(nullable = false)
  private String shareClassFIGI;
  @Column
  private String symbol2;
  @Column(nullable = false)
  private String type;
}
