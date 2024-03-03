package com.cityblue.thread;

import com.cityblue.common.util.Sleeper;
import lombok.extern.slf4j.Slf4j;

@Slf4j(topic = "cityblue.PotTeaTest")
public class PotTeaTest {

    public static void main(String[] args) throws InterruptedException {
        Thread pot = new Thread(() -> {
            log.debug("洗水壶");
            Sleeper.sleep(1);
            log.debug("烧水");
            Sleeper.sleep(10);
        }, "pot");


        Thread otherThings = new Thread(() -> {
            log.debug("洗茶壶、洗茶杯、拿茶叶");
            Sleeper.sleep(4);
        }, "otherThings");

        pot.start();
        otherThings.start();

        otherThings.join();
        log.debug("其他事做好了");

        pot.join();
        log.debug("水烧开了");

        log.debug("泡茶");
        Thread.sleep(2000);
        log.debug("茶泡好了");
    }

}