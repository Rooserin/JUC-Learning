package com.cityblue.thread;

import lombok.extern.slf4j.Slf4j;

@Slf4j(topic = "cityblue.YieldPriorityTest")
public class YieldPriorityTest {

    public static void main(String[] args) {
        Runnable task1 = () -> {
            int count = 0;
            for (int i = 0; i >= 0; i++) {
                System.out.println("----->1" + count++);
            }
        };

        Runnable task2 = () -> {
            int count = 0;
            for (int i = 0; i >= 0; i++) {
//                Thread.yield();
                System.out.println("           ----->2" + count++);
            }
        };

        Thread t1 = new Thread(task1, "t1");
        Thread t2 = new Thread(task2, "t2");
        t1.start();
        t2.start();
        t2.setPriority(Thread.MAX_PRIORITY);
        t1.setPriority(Thread.MIN_PRIORITY);
    }

}