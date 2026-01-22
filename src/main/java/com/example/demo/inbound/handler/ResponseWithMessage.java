package com.example.demo.inbound.handler;

import com.example.demo.core.exceptions.DomainException;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
@AllArgsConstructor
public class ResponseWithMessage {

    private String code;
    private String message;

    public ResponseWithMessage(DomainException domainException) {
        this.code = domainException.getCode();
        this.message = domainException.getMessage();
    }
}
