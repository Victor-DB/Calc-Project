package parallel.multytreading_course.i_reentrantLock;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Main2 {
    public static void main(String[] args) throws InterruptedException {
        Resource2 resource = new Resource2();
        resource.i = 5;
        resource.j = 5;
        MyThread thread1 = new MyThread();
        MyThread thread2 = new MyThread();
        thread1.resource = resource;
        thread2.resource = resource;
        thread1.start();
        thread2.start();
        thread1.join();
        thread2.join();
        System.out.println(resource.i);
        System.out.println(resource.j);
    }

    static class MyThread extends Thread{
        Resource2 resource;
        @Override
        public void run(){
            resource.changeI();
            resource.changeJ();
        }
    }
}

class Resource2{
    int i;
    int j;

    // аналог синхронизации, но гибче:
    // в одном методе открыли лок, в другом закрыли - весь код в этих методах выполниться только одним потоком
    Lock lock = new ReentrantLock();

    void changeI(){
        lock.lock();  // начало лока (как блока синхронизации)
        int i = this.i;
        if(Thread.currentThread().getName().equals("one")) {
            Thread.yield();
        }
        i++;
        this.i = i;
        // можно даже здесь вызвать метод changeJ()
        // вместо resource.changeJ() из 28 строки и всё будет работать
    }

    void changeJ(){
        int j = this.j;
        if(Thread.currentThread().getName().equals("one")) {
            Thread.yield();
        }
        j++;
        this.j = j;
        lock.unlock(); // конец лока (как блока синхронизации)
    }

}
