package parallel.multytreading_course.u_fork_join_framework;

import java.util.Date;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveTask;

public class Main {

    static long numOfOperations = 10_000_000_000l;

    /** количество ядер процессора, у меня оно равно 12 */
    static int numOfThreads = Runtime.getRuntime().availableProcessors();

    public static void main(String[] args) {
        /** время до */
        System.out.println(new Date());

        /** ForkJoinPool разбивает задачу на несколько частей и выполняет многопоточно
         * количество потоков равно количеству ядер процессора
         */
        ForkJoinPool pool = new ForkJoinPool(numOfThreads);
        System.out.println(pool.invoke(new MyFork(0, numOfOperations)));
        System.out.println(numOfThreads);

        /** время после */
        System.out.println(new Date());
    }

    static class MyFork extends RecursiveTask<Long>{

        long from, to;

        public MyFork(long from, long to) {
            this.from = from;
            this.to = to;
        }

        @Override
        protected Long compute() {

            /** если операция разбита на достаточное количество частей, то выполняем опреацию */
            if (to - from <= numOfOperations/numOfThreads) {
                long j = 0;
                for (long i = from; i < to; i++){
                    j += i;
                }
                return j;
            }
            /** разбиваем на части поменьше */
            else {
                /* 5 000 000 */
                long middle = (to + from) / 2;
                /*  от 0 до 5 000 000 */
                MyFork firstHalf = new MyFork(from, middle);
                /* для разбиения */
                firstHalf.fork();

                /*  от 5 000 001 до 10 000 000 000 */
                MyFork secondHalf = new MyFork(middle + 1, to);
                long secondValue = secondHalf.compute();
                /*  ждём выполнения потока firstHalf и возвращаем  */
                return firstHalf.join() + secondValue;
            }

        }
    }

}
