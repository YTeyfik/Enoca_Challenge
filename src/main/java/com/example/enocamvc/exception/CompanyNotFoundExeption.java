package com.example.enocamvc.exception;

import java.text.MessageFormat;

public class CompanyNotFoundExeption extends RuntimeException {
    public CompanyNotFoundExeption(Long id) {
        super(MessageFormat.format("Not found {0}",id));
    }
}
