package parallel.multytreading_course.k_callable_and_futures;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

/**
 * Интерфейс Callable нужен когда нам нужно вернуть какой-то результат
 * В конструктор FutureTask передаётся экземпляр callable
 * В конструктор Thread передаётся экземпляр futureTask
 */
public class Main {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        Callable<Integer> callable = new MyCallable();
        FutureTask futureTask = new FutureTask(callable);
        new Thread(futureTask).start();
        System.out.println(futureTask.get());
    }

    static class MyCallable implements Callable<Integer>{
        @Override
        public Integer call() throws Exception {
            int j = 0;
            for (int i = 0; i < 7; i++, j++) {
                Thread.sleep(200);
            }
            return j;
        }
    }


}
