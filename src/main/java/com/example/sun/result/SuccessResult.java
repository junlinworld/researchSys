package com.example.sun.result;

import org.springframework.stereotype.Component;

@Component
public class SuccessResult extends ReturnResult {


    public SuccessResult() {

        this.staus = "successful";

    }
}
