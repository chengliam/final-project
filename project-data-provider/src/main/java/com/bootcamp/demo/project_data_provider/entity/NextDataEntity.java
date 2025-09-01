package com.bootcamp.demo.project_data_provider.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "newquotes")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Builder
public class NextDataEntity {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private int id;
  @Column(nullable = false)
  private String symbol;
  @Column(nullable = false, name = "current_price")
  private Double c;
  @Column(name = "change")
  private Double d;
  @Column(name = "percent_change")
  private Double dp;
  @Column(name = "high_price")
  private Double h;
  @Column(name = "low_price")
  private Double l;
  @Column(name = "open_price")
  private Double o;
  @Column(name = "previous_close_price")
  private Double pc;
  @Column(name = "timestamp")
  private Long t;
}
