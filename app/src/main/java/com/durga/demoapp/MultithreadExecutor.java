package com.durga.demoapp;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;

public class MultithreadExecutor {
    ExecutorService executorService;

    public MultithreadExecutor(Runnable runnable) {
        try {
            this.executorService = Executors.newCachedThreadPool();
            this.executorService.submit(runnable);
        } finally {
            executorService.shutdown();
        }
    }
}
