package parallel.multytreading_course.i_reentrantLock;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        Resource resource = new Resource();
        resource.i = 5;
        MyThread thread1 = new MyThread();
        MyThread thread2 = new MyThread();
        thread1.resource = resource;
        thread2.resource = resource;
        thread1.start();
        thread2.start();
        thread1.join();
        thread2.join();
        System.out.println(resource.i);
    }

    static class MyThread extends Thread{
        Resource resource;
        @Override
        public void run(){
            resource.changeI();
        }
    }
}

class Resource{
    int i;

    // аналог синхронизации:
    Lock lock = new ReentrantLock();

    void changeI(){
        // начало лока (как блока синхронизации)
        lock.lock();
            int i = this.i;
            if(Thread.currentThread().getName().equals("one")) {
                Thread.yield();
            }
            i++;
            this.i = i;
        // конец лока (как блока синхронизации)
        lock.unlock();
    }
}