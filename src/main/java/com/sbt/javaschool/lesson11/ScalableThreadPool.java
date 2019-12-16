package com.sbt.javaschool.lesson11;

import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;

public class ScalableThreadPool implements ThreadPool {
    private final Queue<Runnable> taskQueue = new ConcurrentLinkedQueue<>();
    private final List<Thread> threadList = new ArrayList<>();

    private volatile boolean isRunning = true;

    public ScalableThreadPool(int threadsCountMin, int threadsCountMax) {
        for (int i = 0; i < threadsCountMin; i++) {
            threadList.add(new Thread(new Task(), "#" + i));
        }
        if (taskQueue.size() > threadsCountMin && taskQueue.size() <= threadsCountMax){
            for (int i = 0; i < (taskQueue.size() - threadsCountMin); i++) {
                threadList.add(new Thread(new Task(), "#" + i));
            }
        }
    }

    @Override
    public void start() {
        for (Thread t: threadList) {
            t.start();
        }
    }

    @Override
    public void execute(Runnable runnable) {
        if (isRunning) {
            taskQueue.offer(runnable);
        }
    }

    private void shutdown() {
        isRunning = false;
    }

    private final class Task implements Runnable {

        @Override
        public void run() {
            if (threadList.size() > taskQueue.size()){
                shutdown();
            }
            while (isRunning) {
                Runnable nextTask = taskQueue.poll();
                if (nextTask != null) {
                    nextTask.run();
                }
            }
        }
    }
}
