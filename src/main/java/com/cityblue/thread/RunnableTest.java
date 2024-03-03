package com.cityblue.thread;

import lombok.extern.slf4j.Slf4j;

@Slf4j(topic = "cityblue.RunnableTest")
public class RunnableTest {

    public static void main(String[] args) {
        test1();
        test2();
    }

    public static void test1() {
        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                log.debug("running");
            }
        };
        Thread t2 = new Thread(runnable, "t2");
        t2.start();
    }

    public static void test2() {
        new Thread(() -> log.debug("running"), "t3").start();
    }
}
