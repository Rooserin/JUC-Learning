package com.cityblue.thread;

import lombok.extern.slf4j.Slf4j;

@Slf4j(topic = "cityblue.TwoPhaseTetminationTest")
public class TwoPhaseTetminationTest {

    public static void main(String[] args) throws InterruptedException {
        TwoPhaseTermination tpt = new TwoPhaseTermination();

        tpt.start();
        Thread.sleep(3500);
        tpt.end();
    }


}

@Slf4j(topic = "cityblue.monitor")
class TwoPhaseTermination {
    private Thread monitor;

    // 启动监控线程
    public void start() {
        monitor = new Thread(() -> {
            while (true) {
                Thread current = Thread.currentThread();
                if (current.isInterrupted()) {
                    log.debug("料理后事");
                    break;
                }
                try {
                    Thread.sleep(1000);
                    log.debug("monitoring......");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                    current.interrupt(); //设置打断标记为true，使循环结束
                }
            }
        }, "monitor");
        monitor.start();
    }

    public void end() {
        monitor.interrupt();
    }
}