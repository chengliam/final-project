package com.bootcamp.demo.project_data_provider.lib;

import lombok.Getter;

@Getter
public enum Scheme {
  HTTPS("https"), HTTP("http");

  private String value;

  private Scheme(String value) {
    this.value = value;
  }
}
