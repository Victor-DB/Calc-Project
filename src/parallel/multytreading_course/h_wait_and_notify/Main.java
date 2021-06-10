package parallel.multytreading_course.h_wait_and_notify;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        MyThread thread = new MyThread();
        thread.start();
        // synchronized должен быть вызван тут и там на одном и том же объекте
        synchronized (thread){
            thread.wait();
        }
        // когда программа полностью выполниться, то выведется total
        System.out.println(thread.total);
    }

    static class MyThread extends Thread{
        int total;
        @Override
        public void run(){
            // вызываем synchronized на текущем объекте класса MyThread
            synchronized (this){
                for (int i = 0; i < 5; i++) {
                    total += i;
                    try {
                        sleep(500);
                    } catch (InterruptedException e) { e.printStackTrace(); }
                }
                // после выполнения работы (до 5) сообщим что закончили:
                notify();
            }
        }
    }
}
