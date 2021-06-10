package parallel.multytreading_course.v_thread_local_random;

import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.TimeUnit;

public class Main {
    public static void main(String[] args) {
        /**
         * В многопоточных приложениях для рандома лучше использовать класс ThreadLocalRandom
         */
        System.out.println(ThreadLocalRandom.current().nextInt());

        /**
         * Для удобства лучше использовать класс TimeUnit вместо обычных секунд в методе sleep например
         */
        System.out.println(TimeUnit.DAYS.toMillis(14));
    }
}
