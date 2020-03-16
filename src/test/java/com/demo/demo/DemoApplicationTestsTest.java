package com.demo.demo;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author luwenxin
 * @create 2020-03-12
 */
@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class DemoApplicationTestsTest {

    @Test
    void test1() {
        Integer i1 = -129;
        Integer i2 = -129;
        Integer i3 = 200;
        Integer i4 = 200;

        String a = "123";
        String b = new String("123");
        System.out.println(a == b);
        System.out.println(a.equals(b));
    }

    @Test
    public void countDemo() {
        BigDecimal b1 = new BigDecimal("0.0006");
        BigDecimal b2 = new BigDecimal("0.0001");

        System.out.println("===" + b1.add(b2));
        System.out.println(1.0 - 0.42);
        System.out.println(4.015 * 100);
        System.out.println(303.1 / 1000);
    }

}