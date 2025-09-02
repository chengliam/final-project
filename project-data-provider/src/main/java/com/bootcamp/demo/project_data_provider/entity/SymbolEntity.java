package com.bootcamp.demo.project_data_provider.entity;

// import jakarta.persistence.Column;
import jakarta.persistence.Entity;
// import jakarta.persistence.GeneratedValue;
// import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
// import org.springframework.stereotype.Indexed;
// import jakarta.annotation.Generated;
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
  private String symbol;
  private String currency;
  private String description;
  private String displaySymbol;
  private String figi;
  private String isin;
  private String mic;
  private String shareClassFIGI;
  private String symbol2;
  private String type;
}
