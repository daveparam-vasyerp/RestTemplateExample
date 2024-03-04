package com.vasy.resttemplate.dto;

import lombok.*;
import org.springframework.http.HttpStatus;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class ResponseDto {

    private String message;
    private HttpStatus status;
    private boolean success;
}
