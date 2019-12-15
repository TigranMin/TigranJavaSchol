package com.sbt.javaschool.lesson11;

import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;

public class FixedThreadPool implements ThreadPool {
    private final Queue<Runnable> taskQueue = new ConcurrentLinkedQueue<>();
    private volatile boolean isRunning = true;

    public FixedThreadPool(int threadsCount) {
        for (int i = 0; i < threadsCount; i++) {
            new Thread(new Task(), "#" + i).start();
        }
    }

    @Override
    public void start() {

    }

    @Override
    public void execute(Runnable runnable) {
        if (isRunning) {
            taskQueue.offer(runnable);
        }
    }

    public void shutdown() {
        isRunning = false;
    }

    private final class Task implements Runnable {

        @Override
        public void run() {
            while (isRunning) {
                Runnable nextTask = taskQueue.poll();
                if (nextTask != null) {
                    nextTask.run();
                }
            }
        }
    }
}