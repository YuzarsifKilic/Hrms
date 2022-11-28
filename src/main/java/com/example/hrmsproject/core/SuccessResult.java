package com.example.hrmsproject.core;

public class SuccessResult extends Result{

    SuccessResult(String message) {
        super(true, message);
    }

    SuccessResult() {
        super(true);
    }
}
