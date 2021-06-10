package parallel.task4;

import java.util.concurrent.atomic.AtomicInteger;

// 1. class must implements Runnable:
public class HowToDoThread implements Runnable{

    static void makeThread(int num, String string) {
        // 2. create Runnable instance:
        Runnable r = () -> {
            try {
                for (int i = 0; i < 50; i++) {
                    System.out.println(string + " " + i);
                    Thread.sleep(2000);
                }
            } catch (InterruptedException e) { e.printStackTrace(); }
        };

        // 3. create instance Thread using r:
        Thread thread = new Thread(r);

        // 4. run method start():
        thread.start();

    }


    @Override
    public void run() {}

    public static void main(String[] args) {
        makeThread(50, "one");
        makeThread(50, "two");
        makeThread(50, "three");
    }
}
