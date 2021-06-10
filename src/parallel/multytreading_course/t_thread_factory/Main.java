package parallel.multytreading_course.t_thread_factory;

import java.util.concurrent.ThreadFactory;

public class Main {
    public static void main(String[] args) {

        /** настройка для однообразных потоков */
        ThreadFactory threadFactory = new ThreadFactory() {
            @Override
            public Thread newThread(Runnable r) {
                Thread thread = new Thread(r);
                thread.setPriority(Thread.MAX_PRIORITY);
                return thread;
            }
        };

        /** запуск потока через фабрику threadFactory
         * Все потоки будут иметь максимальный приоритет
         * согласно настройке thread.setPriority(Thread.MAX_PRIORITY)
         * */
        threadFactory.newThread(new MyRun()).start();

    }

    /** создадим произвольный поток */
    static class MyRun implements Runnable{
        @Override
        public void run() {
            System.out.println(1);
        }
    }

}
