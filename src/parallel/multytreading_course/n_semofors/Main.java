package parallel.multytreading_course.n_semofors;

import java.util.concurrent.Semaphore;

/**
 * Семафор позволяет многим потокам работать с несколькими ресурсами
 */
public class Main {
    public static void main(String[] args) {
        Semaphore table = new Semaphore(2);

        Person person1 = new Person();
        Person person2 = new Person();
        Person person3 = new Person();
        Person person4 = new Person();
        Person person5 = new Person();
        person1.table = table;
        person2.table = table;
        person3.table = table;
        person4.table = table;
        person5.table = table;
        person1.start();
        person2.start();
        person3.start();
        person4.start();
        person5.start();
    }

    static class Person extends Thread{
        Semaphore table;
        @Override
        public void run(){
            System.out.printf("Клиент %s ждёт свободный столик\n", this.getName());
            try {

                /** Получает разрешение от семафора table */
                table.acquire();

                System.out.printf("Клиент %s кушает сейчас\n", this.getName());
                this.sleep(5000);
                System.out.printf("Клиент %s освобождает столик\n", this.getName());

                /** Освобождает разрешение, возвращая его на семафор */
                table.release();

            } catch (InterruptedException e) { e.printStackTrace(); }
        }
    }
}
