package com.hongghe.basicjava.thread;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

/**
 * @author hongghe 2018/11/25
 */
public class CallableThreadTest implements Callable<Integer> {

    @Override
    public Integer call() {
        int i = 0;
        for(;i<100;i++) {
            System.out.println(Thread.currentThread().getName()+" "+i);
        }
        return i;
    }

    public static void main(String[] args) {
        CallableThreadTest ctt = new CallableThreadTest();
        FutureTask<Integer> ft = new FutureTask<>(ctt);
        for(int i = 0; i < 100; i++) {
            if(i == 20) {
                new Thread(ft,"有返回值的线程").start();
            }
        }

        try {
            System.out.println("子线程的返回值："+ft.get());
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
    }
}
