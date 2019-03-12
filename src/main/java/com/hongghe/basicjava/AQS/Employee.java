package com.hongghe.basicjava.AQS;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

/**
 * @author: hongghe @date: 2019-03-12 10:55
 */
//分布式工作线程
public class Employee implements Runnable{

    private CyclicBarrier barrier;
    private int employeeIndex;

    public Employee(CyclicBarrier barrier,int employeeIndex){
        this.barrier = barrier;
        this.employeeIndex = employeeIndex;
    }

    @Override
    public void run() {
        try {
            System.out.println("员工："+employeeIndex+"，正在前往公司大门口集合...");
            Thread.sleep(10*employeeIndex);
            System.out.println("员工："+employeeIndex+"，已到达。");
            barrier.await();
            Thread.sleep(10);
            System.out.println("员工："+employeeIndex+"，【自驾车】前往目的地");
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (BrokenBarrierException e) {
            e.printStackTrace();
        }
    }
}
