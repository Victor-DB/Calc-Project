package parallel.multytreading_course.m_ScheduledExcecuterService;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/**
 * Выполнение потоков по расписанию с помощью ScheduledExecutorService
 */
public class Main {
    public static void main(String[] args) {

        /** Создание объекта класса ScheduledExecutorService */
        ScheduledExecutorService service = Executors.newSingleThreadScheduledExecutor();
        /** Выполнить поток MyThread через 3 секунды */
        service.schedule(new MyThread(), 3, TimeUnit.SECONDS);
        /** Завершить работу сервиса */
        service.shutdown();
    }

    /** Создаем поток */
    static class MyThread extends Thread{
        @Override
        public void run(){
            System.out.println(1);
        }
    }

}
