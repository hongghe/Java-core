package com.hongghe.basicjava.lock;

/**
 * @author hongghe 2018/08/19
 */
public class AccountingSync implements Runnable {

    /** 共享资源(临界资源)*/
    private static volatile int i = 0;

    /**
     * synchronized 修饰实例方法的实现
     */
    public synchronized void increase() {
        i++;
    }

    @Override
    public void run() {
        for (int j = 0; j < 1000000; j++) {
            increase();
        }
    }

    public static void main(String[] args) {
        AccountingSync instance = new AccountingSync();
        Thread t1 = new Thread(instance);
        Thread t2 = new Thread(instance);
        t1.start();
        t2.start();
        System.out.println(i);
    }
}
