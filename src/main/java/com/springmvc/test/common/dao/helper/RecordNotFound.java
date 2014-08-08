package com.springmvc.test.common.dao.helper;

public class RecordNotFound extends RuntimeException{
    public RecordNotFound(String message) {
        super(message);
    }
}
