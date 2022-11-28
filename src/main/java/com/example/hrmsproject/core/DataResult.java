package com.example.hrmsproject.core;

public class DataResult<T> extends Result {

    private T data;

    DataResult(T data, boolean success, String message) {
        super(success, message);
        this.data = data;
    }

    DataResult(T data, boolean success) {
        super(success);
        this.data= data;
    }
}
