package com.cityblue.thread;

import lombok.extern.slf4j.Slf4j;

import java.sql.Time;
import java.util.concurrent.TimeUnit;

@Slf4j(topic = "cityblue.InterruptTest")
public class InterruptTest {

    public static void main(String[] args) throws InterruptedException {
//        test1();
        test2();
    }


    public static void test1() {
        Thread t1 = new Thread("t1") {
            @Override
            public void run() {
                log.debug("Enter sleep...");
                try {
//                    sleep(2000);
                    TimeUnit.SECONDS.sleep(2);
                } catch (InterruptedException e) {
                    log.debug("sleep interrupted...");
                    e.printStackTrace();
                    throw new RuntimeException(e);
                }
                log.debug("exit sleep...");
            }
        };
        t1.start();
        try {
//            Thread.sleep(500);
            TimeUnit.MILLISECONDS.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        t1.interrupt();
        log.debug("打断标记为{}", t1.isInterrupted());
    }

    public static void test2() throws InterruptedException {
        Thread t1 = new Thread(() -> {
            while (true) {
                if (Thread.currentThread().isInterrupted()) {
                    log.debug("interrupted, exit loop...");
                    break;
                }
                log.debug("t1 running....");
            }
        }, "t1");
        t1.start();
        Thread.sleep(100);
        log.debug("t1 线程状态：{}", t1.getState());
        t1.interrupt();
        log.debug("打断标记：{}", t1.isInterrupted());
        Thread.sleep(100);
        log.debug("t1 线程状态：{}", t1.getState());
    }

}