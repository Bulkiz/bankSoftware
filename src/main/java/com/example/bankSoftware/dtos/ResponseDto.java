package com.example.bankSoftware.dtos;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class ResponseDto {

    private Integer code = 0;
    private String message = "OK";

    public ResponseDto() {
    }

    public ResponseDto(Integer code, String message) {
        this.code = code;
        this.message = message;
    }
}
