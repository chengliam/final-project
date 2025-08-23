package com.bootcamp.demo.project_data_provider.exception;

import lombok.Getter;

@Getter
public enum SysError {
  SYMBOL_NOT_FOUND(800001, "Symbol not found"),;

  private int code;
  private String message;

  private SysError(int code, String message) {
    this.code = code;
    this.message = message;
  }
}