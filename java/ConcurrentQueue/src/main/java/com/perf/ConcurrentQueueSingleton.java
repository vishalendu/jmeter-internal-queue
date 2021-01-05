package com.perf;

import java.util.concurrent.ConcurrentLinkedDeque;

public class ConcurrentQueueSingleton {

    private ConcurrentLinkedDeque<String> queue  = null;
    private static ConcurrentQueueSingleton singleton = null;

    private ConcurrentQueueSingleton(){
        queue = new ConcurrentLinkedDeque<String>();
    }

    public static ConcurrentQueueSingleton getInstance(){
        if(singleton==null){
            singleton = new ConcurrentQueueSingleton();
        }
        return singleton;
    }

    public  void put(String data){
            queue.add(data);
    }

    public  String get() throws InterruptedException {
        if(queue.size()==0)
            return null;
        else
            return queue.poll();
    }

    public  int size(){
        return queue.size();
    }

    public void clear(){
        queue.clear();
    }


}
