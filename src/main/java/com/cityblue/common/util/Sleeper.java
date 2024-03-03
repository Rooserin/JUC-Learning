package com.cityblue.common.util;

import java.util.concurrent.TimeUnit;

public class Sleeper {

    public static void sleep(int t) {
        try {
            TimeUnit.SECONDS.sleep(t);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void sleep(double t) {
        try {
            TimeUnit.MILLISECONDS.sleep((int) (t * 1000));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
