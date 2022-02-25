package com.example.enocamvc.exception;

import java.text.MessageFormat;

public class EmployeeNotFoundExeption extends RuntimeException{
    public EmployeeNotFoundExeption(Long id) {
        super(MessageFormat.format("not find id:{0}",id));
    }
}
