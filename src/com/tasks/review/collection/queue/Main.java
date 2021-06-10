package com.tasks.review.collection.queue;

import java.util.*;

public class Main {
    public static void main(String[] args) {

        Deque queue = new ArrayDeque();
        for(int i = 0; i< 10000; i++){
            queue.push(i);

        }
        //System.out.println(queue.peek());
        System.out.println(queue.poll());

        Set set = Collections.synchronizedSet(new TreeSet<>());
    }
}
