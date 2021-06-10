package parallel.multytreading_course.l_executors;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Для работы с пулом потоков нужны экзекьюторы
 * Экзекьюторы (Executor или ExecutorServise) нужны чтобы вся
 * работа велась в ограниченном количестве потоков
 * дабы не перегружать приложение
 */
public class Main {
    public static void main(String[] args) throws ExecutionException, InterruptedException {

        /** Создается пул двух потоков.
         * У объекта executor вызывается метод submit, в который передается поток */
        ExecutorService executor = Executors.newFixedThreadPool(2);
        executor.submit(new MyRunnable());

        /** т.к. submit типа Future, то к нему применим метод get() из предыдущего урока */
        System.out.println(
            executor.submit(new MyCallable()).get()
        );

        /** Если executor не остановить после работы, то он не остановится */
        executor.shutdown();
    }

    /** Поток с помощью Runnable */
    static class MyRunnable implements Runnable{
        @Override
        public void run() {
            System.out.println(1);
        }
    }

    /** Поток с помощью Callable */
    static class MyCallable implements Callable<String>{
        @Override
        public String call() throws Exception {
            return "2";
        }
    }
}
