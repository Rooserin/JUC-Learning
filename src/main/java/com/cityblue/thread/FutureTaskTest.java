package com.cityblue.thread;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

@Slf4j(topic = "cityblue.FutureTaskTest")
public class FutureTaskTest {

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        test1();
    }


    private static void test1() throws ExecutionException, InterruptedException {
        FutureTask<Integer> futureTask = new FutureTask<Integer>(new Callable<Integer>() {
            @Override
            public Integer call() throws InterruptedException {
                log.debug("running");
                Thread.sleep(2000);
                return 100;
            }
        });

        new Thread(futureTask, "t1").start();

        Integer res = futureTask.get();// 阻塞方法
        log.debug("返回值为:{}", res);

    }
}
