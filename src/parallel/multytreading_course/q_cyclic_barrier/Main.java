package parallel.multytreading_course.q_cyclic_barrier;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

/** CyclicBarrier используется чтобы дождаться всех бегунов
 * у стартовой дорожки чтобы одновременно стартануть */
public class Main {
    public static void main(String[] args) {

        /** Ждём у барьера 3х спортсменов
         * как только они собрались
         * запускается поток Run */
        CyclicBarrier cyclicBarrier = new CyclicBarrier(3, new Run());
        /* если будет меньше 3х, то поток new Run() не запустится */
        new Sportsmen(cyclicBarrier);
        new Sportsmen(cyclicBarrier);
        new Sportsmen(cyclicBarrier);
    }

    /**  поток объявления забега */
    static class Run extends Thread{
        @Override
        public void run(){
            System.out.println("Гонка началась!");
        }
    }

    /**  потоки бегуны */
    static class Sportsmen extends Thread{
        CyclicBarrier barrier;

        /**  старт потока внутри конструктора */
        public Sportsmen(CyclicBarrier barrier) {
            this.barrier = barrier;
            start();
        }

        @Override
        public void run(){
            try {
                /** Как только спорстмены собрались,
                 * они 3 раза вызывают метод await
                 * после этого вызывается new Run() в конструкторе
                 */
                barrier.await();
            } catch (InterruptedException e) { e.printStackTrace();
            } catch (BrokenBarrierException e) { e.printStackTrace(); }
        }
    }
}
