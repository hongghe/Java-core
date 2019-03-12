package com.hongghe.basicjava.AQS;

import java.util.concurrent.CountDownLatch;

/**
 * @author: hongghe @date: 2019-03-12 10:51
 */
public class Player implements Runnable {

    private int id;
    private CountDownLatch begin;
    private CountDownLatch end;
    public Player(int i, CountDownLatch begin, CountDownLatch end) {
        // TODO Auto-generated constructor stub
        super();
        this.id = i;
        this.begin = begin;
        this.end = end;
    }

    @Override
    public void run() {
        // TODO Auto-generated method stub
        try{
            begin.await();        //等待begin的状态为0，这里表示等待其他选手就绪，然后一起开始比赛
            Thread.sleep((long)(Math.random()*100)*100);    //随机分配时间，即运动员完成时间
            System.out.println("Play"+id+" arrived.");//选手到达终点
        }catch (InterruptedException e) {
            // TODO: handle exception
            e.printStackTrace();
        }finally{
            end.countDown();    //使end状态减1，最终减至0，为0时比赛结束
        }
    }
}