package com.sbt.javaschool.lesson11.part2;

public interface ThreadPool {

    void start();
    void execute(Runnable runnable);


}
