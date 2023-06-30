package com.hronline.dto;

import lombok.*;
import org.apache.http.HttpStatus;

import java.io.Serializable;

@Setter
@Getter
@AllArgsConstructor
@Builder
@ToString
public class BasicResponseDto<T> implements Serializable {
    private int status;
    private String message;
    private T data;

    public BasicResponseDto() {
    }

    public static <T> BasicResponseDto<T> ok(T data) {
        BasicResponseDto<T> basicResponseDto = new BasicResponseDto<>();
        basicResponseDto.setData(data);
        basicResponseDto.setStatus(HttpStatus.SC_OK);
        basicResponseDto.setMessage("OK");
        return basicResponseDto;
    }

    public static <T> BasicResponseDto<T> ok() {
        BasicResponseDto<T> basicResponseDto = new BasicResponseDto<>();
        basicResponseDto.setStatus(HttpStatus.SC_OK);
        basicResponseDto.setMessage("OK");
        return basicResponseDto;
    }

    public static <T> BasicResponseDto<T> failed(T data) {
        BasicResponseDto<T> basicResponseDto = new BasicResponseDto<>();
        basicResponseDto.setData(data);
        basicResponseDto.setStatus(HttpStatus.SC_BAD_REQUEST);
        basicResponseDto.setMessage("BAD_REQUEST");
        return basicResponseDto;
    }

    public static <T> BasicResponseDto<T> failed() {
        BasicResponseDto<T> basicResponseDto = new BasicResponseDto<>();
        basicResponseDto.setStatus(HttpStatus.SC_BAD_REQUEST);
        basicResponseDto.setMessage("BAD_REQUEST");
        return basicResponseDto;
    }
}
