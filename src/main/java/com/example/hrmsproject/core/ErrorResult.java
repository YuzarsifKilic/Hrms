package com.example.hrmsproject.core;

import com.example.hrmsproject.entities.concretes.User;

public class ErrorResult extends Result {

    public ErrorResult(String message) {
        super(false, message);
    }

    public ErrorResult() {
        super(false);
    }
}
