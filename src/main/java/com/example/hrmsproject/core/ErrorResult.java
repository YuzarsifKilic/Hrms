package com.example.hrmsproject.core;

import com.example.hrmsproject.entities.concretes.User;

public class ErrorResult extends Result {

    ErrorResult(String message) {
        super(false, message);
    }

    ErrorResult() {
        super(false);
    }
}
