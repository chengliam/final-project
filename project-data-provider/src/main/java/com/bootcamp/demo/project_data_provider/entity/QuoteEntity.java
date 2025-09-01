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
@Table(name = "quotes")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Builder
public class QuoteEntity {
  @Id
  private Double c;
  @Column(nullable = false)
  private Double d;
  @Column(nullable = false)
  private Double dp;
  @Column(nullable = false)
  private Double h;
  @Column(nullable = false)
  private Double l;
  @Column(nullable = false)
  private Double o;
  @Column(nullable = false)
  private Double pc;
  @Column(nullable = false)
  private Long t;
}
