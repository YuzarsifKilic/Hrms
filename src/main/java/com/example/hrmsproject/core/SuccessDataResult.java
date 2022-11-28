package com.example.hrmsproject.core;

public class SuccessDataResult<T> extends DataResult<T>{

    SuccessDataResult(T data, String message) {
        super(data, true, message);
    }

    SuccessDataResult(T data) {
        super(data, true);
    }
}
