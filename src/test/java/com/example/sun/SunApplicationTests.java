package com.example.sun;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SunApplicationTests {

    @Before
    public void start() {
        System.out.println("--------测试开始--------");
    }

    @After
    public void after() {
        System.out.println("--------测试结束--------");
    }

}

