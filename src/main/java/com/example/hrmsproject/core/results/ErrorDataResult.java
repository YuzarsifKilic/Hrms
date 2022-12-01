package com.example.hrmsproject.core.results;

import com.example.hrmsproject.core.results.DataResult;

public class ErrorDataResult<T> extends DataResult<T> {

    public ErrorDataResult(T data, String message) {
        super(data, false, message);
    }

    public ErrorDataResult(T data) {
        super(data, false);
    }
}
