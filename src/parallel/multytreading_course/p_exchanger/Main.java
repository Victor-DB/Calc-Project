package parallel.multytreading_course.p_exchanger;

import java.util.concurrent.Exchanger;

/**
 * Exchanger передаёт данные между потоками
 */
public class Main {
    public static void main(String[] args) {

        /** Создаётся объект Exchanger со строковым типом передаваемых данных */
        Exchanger<String> exchanger = new Exchanger<>();

        /** запускаются потоки с объектом exchanger в конструкторе */
        new Mike(exchanger);
        new Alex(exchanger);
    }

    /**
     * Создаётся 1й поток
     */
    static class Mike extends Thread{

        /** Создаётся объект Exchanger */
        Exchanger<String> exchanger;

        /** Поток запускается из конструктора */
        public Mike(Exchanger<String> exchanger) {
            this.exchanger = exchanger;
            start();
        }

        @Override
        public void run(){
            try {

                /** Внутри метода exchange() передаются данные другому потоку
                 * Когда зупаскается иксченджер, то он ждёт запуска иксченджера в другом потоке
                 * */
                exchanger.exchange("Alex! Its 1st message from Mike.");

                sleep(1000);
                /** внутри метода exchange() передаются данные другому потоку */
                exchanger.exchange("Alex! Its 2nd message from Mike.");
            } catch (InterruptedException e) { e.printStackTrace(); }
        }
    }

    /**
     * Создаётся 2й поток
     */
    static class Alex extends Thread{
        /** Создаётся объект Exchanger */
        Exchanger<String> exchanger;

        /** Поток запускается из конструктора */
        public Alex(Exchanger<String> exchanger) {
            this.exchanger = exchanger;
            start();
        }

        @Override
        public void run(){
            try {
                /**  Здесь иксченджер принимает информацию и выводит*/
                System.out.println(exchanger.exchange(null));
                System.out.println(exchanger.exchange(null));
            } catch (InterruptedException e) { e.printStackTrace(); }
        }
    }
}
