package com.example.bankSoftware.customThreadPool;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;
import java.util.concurrent.FutureTask;

public class ThreadPool {
    BlockingQueue<Runnable> queue;
    public ThreadPool(int queueSize, int nThread) {
        queue = new BlockingQueue<>(queueSize);
        String threadName;
        TaskExecutor task;
        for (int count = 0; count < nThread; count++) {
            threadName = "Thread - " + count;
            task = new TaskExecutor(queue);
            Thread thread = new Thread(task, threadName);
            thread.start();
            System.out.println(thread.getName());
        }
    }

    public <T> Future<T> submitTask(Callable<T> task) throws InterruptedException {
        FutureTask<T> task1 = new FutureTask<T>(task);
        queue.enqueue(task1);
        return task1;
    }
}
