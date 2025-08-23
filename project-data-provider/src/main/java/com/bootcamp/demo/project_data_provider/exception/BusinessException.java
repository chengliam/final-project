package com.bootcamp.demo.project_data_provider.exception;

import lombok.Getter;

@Getter
public class BusinessException extends RuntimeException{
   private int code;

   public BusinessException(SysError sysError) {
        super(sysError.getMessage());
        this.code = sysError.getCode();
   }
}