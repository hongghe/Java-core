package com.hongghe.basicjava.concurrency;

import java.util.concurrent.*;
import java.util.concurrent.atomic.*;

/**
 * 原子操作
 *
 * @author hongghe 04/08/2018
 */
public class AtomicOperationDemo {

static AtomicInteger count=new AtomicInteger(0);

public static class AddThread implements Runnable{
    @Override
    public void run() {
        for(int k=0;k<1000;k++){
            count.incrementAndGet();
        }
    }
}
    public static void AtomicIntShow(){
        System.out.println("AtomicIntShow() enter");
        ExecutorService threadpool =   Executors.newFixedThreadPool(10);

        for(int k=0;k<100;k++){
            threadpool.submit(new AddThread());
        }

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

		 /* output
		  * AtomicIntShow() enter
		  * result of acumulated sum=100000
		  * AtomicIntShow() exit
		  */
        System.out.println("result of acumulated sum="+count);
        threadpool.shutdown();
        System.out.println("AtomicIntShow() exit");
        return ;

    }
}
