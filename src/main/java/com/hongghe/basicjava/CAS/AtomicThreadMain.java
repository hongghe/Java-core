package com.hongghe.basicjava.CAS;

import com.google.common.base.Strings;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author: hongghe @date: 2019-02-18 11:28
 */
public class AtomicThreadMain {

    private static volatile int lock = 1;

    public static void main(String[] args) {
        // The atomic integer
        AtomicInteger atomicInteger = new AtomicInteger();
        atomicInteger.incrementAndGet();
        Integer number = 1;
        System.out.println(Strings.isNullOrEmpty(number.toString()));
    }
}
