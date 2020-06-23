package com.codegym.demo.service.province;

public class ProvinceNotFoundException extends RuntimeException {
    public ProvinceNotFoundException(String message) {
        super(message);
    }
}
