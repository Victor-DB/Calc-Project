package parallel.task3;

public class MyThread implements Runnable {
    Thread thread;

    MyThread(String name) {
        thread = new Thread(this, name);
        thread.start();
    }

    @Override
    public void run() {
        System.out.println(thread.getName() + " - запуск");
        try {
            for(int count = 0; count < 10; count++) {
                Thread.sleep(400);
                System.out.println("B " + thread.getName() + ", счетчик: " + count);
            }
        } catch(InterruptedException ехс) {
            System.out.println(thread.getName() + " - прерван");
        }
        System.out.println(thread.getName() + " - завершение");
    }
}

class MoreThreads {
    public static void main(String[] args) {
        System.out.println("Зaпycк основного потока");
        MyThread mt1 = new MyThread("Child #1");
        MyThread mt2 = new MyThread("Child #2");
        MyThread mt3 = new MyThread("Child #3");

        for(int i = 0; i < 50; i++) {
            System.out.print(".");
            try {
                Thread.sleep(100);
            } catch(InterruptedException ехс) { System.out.println("Пpepывaниe основного потока"); }
            System.out.println("Зaвepmeниe основного потока");
        }
    }
}
