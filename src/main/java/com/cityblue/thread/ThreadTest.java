package com.cityblue.thread;


import lombok.extern.slf4j.Slf4j;

@Slf4j(topic = "cityblue.ThreadTest1")
public class ThreadTest {

    public static void main(String[] args) {
        Thread t1 = new Thread("t1") {
            @Override
            public void run() {
                log.debug("starting");
            }
        };

        t1.start();
        log.debug("starting");
    }

}
