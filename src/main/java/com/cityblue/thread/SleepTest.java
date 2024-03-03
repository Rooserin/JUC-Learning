package com.cityblue.thread;

import lombok.extern.slf4j.Slf4j;

@Slf4j(topic = "cityblue.SleepTest")
public class SleepTest {

    public static void main(String[] args) {
        Thread t1 = new Thread("t1") {
            @Override
            public void run() {
                try {
//                    Thread.sleep(2000); 效果一样，都是使当前线程睡眠
                    sleep(2000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        };
        t1.start();
        log.debug("t1 state: {}", t1.getState());

        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        log.debug("t1 state: {}", t1.getState());
    }

}