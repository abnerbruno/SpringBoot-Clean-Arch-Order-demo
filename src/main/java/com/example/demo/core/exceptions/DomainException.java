package com.example.demo.core.exceptions;

import lombok.Getter;

@Getter
public class DomainException extends RuntimeException {

    private final String code;

    public DomainException(String code, String message) {
        super(message);
        this.code = code;
    }

    public static DomainException orderNotFund() {
        return new DomainException("01", "Order not Found");
    }
}
