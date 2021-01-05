package com.perf;

import java.util.Random;

public class ConcurrentQueueTest {

    public static void main(String[] args) throws InterruptedException {
        ConcurrentQueueSingleton singleton = ConcurrentQueueSingleton.getInstance();
        for (int i=0;i<10;i++)
            singleton.put(String.valueOf(new Random().nextInt()));

        System.out.println(singleton.size());

        for (int i=0;i<10;i++)
            System.out.println(singleton.get());

    }

}
