package com.example.sun.result;

import org.springframework.stereotype.Component;

@Component
public class FailResult extends ReturnResult {


    public FailResult() {

        this.staus = "fail";

    }
}
