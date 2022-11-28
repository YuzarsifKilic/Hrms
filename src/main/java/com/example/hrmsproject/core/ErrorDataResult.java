package com.example.hrmsproject.core;

public class ErrorDataResult<T> extends DataResult<T> {

    ErrorDataResult(T data, String message) {
        super(data, false, message);
    }

    ErrorDataResult(T data) {
        super(data, false);
    }
}
