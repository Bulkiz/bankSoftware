package com.example.bankSoftware.dtos;

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
