package com.bootcamp.demo.project_data_provider.exception;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class ErrorDTO {
  private int code;
  private String message;
}