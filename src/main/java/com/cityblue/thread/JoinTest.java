package com.cityblue.thread;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.TimeUnit;


@Slf4j(topic = "cityblue.JoinTest")
public class JoinTest {

    static int i = 0;

    public static void main(String[] args) throws InterruptedException{
//        test1();
//        test2();
        test3();
    }

    private static void test2() {
        Thread t1 = new Thread(() -> {
            try {
                TimeUnit.SECONDS.sleep(2);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });
        Thread t2 = new Thread(() -> {
            try {
                TimeUnit.SECONDS.sleep(2);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });
        t1.start();
        t2.start();
        long start = System.currentTimeMillis();
        try {
            log.debug("starting join t1");
            t1.join();
            log.debug("end join t1");

            log.debug("starting join t2");
            t2.join();
            log.debug("end join t2");
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        long end = System.currentTimeMillis();
        log.debug("time distance:{}", end - start);

    }

    public static void test1() {
        Thread t1 = new Thread(() -> {
            log.debug("starting t1....");
            try {
                TimeUnit.SECONDS.sleep(2);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            i = 10;
            log.debug("ending t1....");
        });
        t1.start();
        try {
            t1.join();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        log.debug("value of i:{}", i);
    }

    static int r1 = 0;
    static int r2 = 0;

    public static void test3() throws InterruptedException {
        Thread t1 = new Thread(() -> {
            try {
                TimeUnit.SECONDS.sleep(2);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            r1 = 1111;
        });
        long start = System.currentTimeMillis();
        t1.start();

//        t1.join(1500);
        t1.join(3000);

        long end = System.currentTimeMillis();
        log.debug("r1:{}, r2:{}, time distance:{}", r1, r2, end - start);
    }

}