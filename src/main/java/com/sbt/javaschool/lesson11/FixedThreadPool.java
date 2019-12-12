package com.sbt.javaschool.lesson11;

import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;

public class FixedThreadPool implements ThreadPool {

    private final Queue<Runnable> taskQueue = new ConcurrentLinkedQueue<>();
    private volatile boolean isClosed = false;


    public FixedThreadPool(int threadCount) {
        for (int i = 0; i < threadCount; i++) {
            new Thread(new Task(), "#" + i).start();
        }
    }

    public void close(){
        isClosed = true;
    }

    @Override
    public void start() {

    }

    @Override
    public void execute(Runnable runnable) {
        if (!isClosed) {
            taskQueue.offer(runnable);
        }
    }

    private final class Task implements Runnable {

        @Override
        public void run() {
            while (!isClosed) {
                Runnable nextTask = taskQueue.poll();
                if (nextTask != null) {
                    nextTask.run();
                }
            }
        }
    }

}
