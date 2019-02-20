package com.example.sun.service.impl;

import com.example.sun.common.Validateunit;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public abstract class BaseServiceImpl {

    protected <T> void Validate(T obj) throws Exception {
        List<String> messages = Validateunit.Validate(obj);

        if (messages != null) {
            String str = "";
//            for (String message:messages){
//                str+=message+";";
//            }
            for (int i = 0; i < messages.size(); i++) {
                str = str + messages.get(i) + ";";
            }

            throw new Exception(str);
        }
    }
}
