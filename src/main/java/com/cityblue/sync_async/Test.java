package com.cityblue.sync_async;

import com.cityblue.common.Constants;
import com.cityblue.common.util.FileReader;
import lombok.extern.slf4j.Slf4j;


@Slf4j(topic = "cityblue.test")
public class Test {
    public static void main(String[] args) {
        syncRead();
        asyncRead();
    }

    public static void syncRead() {
        FileReader.read(Constants.MP4_FULL_PATH);
        log.debug("同步执行");
    }


    public static void asyncRead() {
        new Thread(() -> FileReader.read(Constants.MP4_FULL_PATH)).start();
        log.debug("异步执行");
    }


}
