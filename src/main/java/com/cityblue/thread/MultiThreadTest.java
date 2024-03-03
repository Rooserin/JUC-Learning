package com.cityblue.thread;

import lombok.extern.slf4j.Slf4j;

@Slf4j(topic = "cityblue.MultiThreadTest")
public class MultiThreadTest {

    public static void main(String[] args) {

        new Thread(() -> {
            while (true) log.debug("running.....t1");
        }, "t1").start();

        new Thread(() -> {
            while (true) log.debug("running");
        }, "t2").start();
    }

}
