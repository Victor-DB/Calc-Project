package parallel.multytreading_course.o_count_down_latch;

import java.util.concurrent.CountDownLatch;

/**
 * Применяется, когда нужно чтобы потоки выполнили всю работу,
 * а потом c результатом их работы можно было что-то делать
 */
public class Main {
    public static void main(String[] args) throws InterruptedException {
        CountDownLatch countDownLatch = new CountDownLatch(3);

        /* обёртка над методом start() для потока */
        new Work(countDownLatch);
        new Work(countDownLatch);
        new Work(countDownLatch);

        /** после выполнения всех потоков (когда счётчик дойдёт до нуля)
        * главный поток завершится
        * */
        countDownLatch.await();
        System.out.println("All jobs is done");
    }
}

class Work extends Thread{
    CountDownLatch countDownLatch;

    public Work(CountDownLatch countDownLatch) {
        this.countDownLatch = countDownLatch;
        start();
    }

    @Override
    public void run(){
        try {
            sleep(3000);
        } catch (InterruptedException e) { e.printStackTrace(); }
        System.out.println("work is done");
        // освобождает поток по закону декремента
        countDownLatch.countDown();
    }
}