package parallel.multytreading_course.s_blocking_queue;

import java.util.PriorityQueue;
import java.util.Queue;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.PriorityBlockingQueue;

public class Main {
    public static void main(String[] args) {

        /** при запуске в таком виде вылетает эксепшн, так как поток может
         * попытаться вытащить элемент из очереди раньше, чем элемент будет положен в неё
         */
       // Queue<String> queue = new PriorityQueue<>();

        /**
         * BlockingQueue блокирует удаление элементов из очереди
         * пока не будет добавлен элемент в очередь
         */
        BlockingQueue queue = new PriorityBlockingQueue();

        /** поток удаления элемента из очереди */
        new Thread() {
            @Override
            public void run(){
               // System.out.println(queue.remove());
                try {
                    System.out.println(queue.take());
                } catch (InterruptedException e) { e.printStackTrace(); }
            }
        }.start();

        /** поток добавления элемента в очередь */
        new Thread() {
            @Override
            public void run(){
                System.out.println(queue.add("Поместим сюда эту строку"));
            }
        }.start();

    }
}
