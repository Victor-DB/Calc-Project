package parallel.multytreading_course.r_phaser;

import java.util.concurrent.Phaser;

/**
 * Есть работа состоящая из фаз выполнения.
 * Phaser позволяет всем потокам закончить начатую фазу до конца,
 * а потом переходить на следующую фазу.
 */
public class Main {
    public static void main(String[] args) {
        Phaser phaser = new Phaser(2);
        new Washer(phaser);
        new Washer(phaser);
    }

    /** поток "мойщик машины" */
    static class Washer extends Thread{
        Phaser phaser;

        /** конструктор с запуском потока  */
        public Washer(Phaser phaser) {
            this.phaser = phaser;
            start();
        }

        @Override
        public void run(){

            /** моем три машины */
            for (int i = 0; i < 3; i++){
                System.out.println(getName() +  " моет машину");

                /** пока оба мойщика не домоют машину, к следующей не переходить
                 * т.е. потоки 0 и 1 в любой последовательности исполнения
                 * моют машины вместе пофазно (сначала первую, потом вторую, потом третью)
                 * */
                phaser.arriveAndAwaitAdvance();
            }
        }
    }
}
