package parallel.task2.twoThreads;

class Obj extends Object{
    public int count1 = 0;
    public int count2 = 0;

    public synchronized void changeObj1(int amount) {
        count1 = count1 + amount;
    }
    public synchronized void changeObj2(int amount) {
        count2 = count2 + amount;
    }
}

public class Main {

    public static class Thread1 extends Thread{
        public final Obj obj;
        public Thread1(Obj obj) { this.obj = obj; }
        @Override
        public void run(){
            for (int i = 0; i < 500; i++) {
                obj.changeObj1(1);
                System.out.println("count1: " + obj.count1);
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) { e.printStackTrace(); }
            }
        }
    }

    public static class Thread2 extends Thread{
        public final Obj obj;
        public Thread2(Obj obj) { this.obj = obj; }
        @Override
        public void run(){
            for (int i = 0; i < 500; i++) {
                obj.changeObj2(3); // если не передать параметр, то не меняется значение
                System.out.println("count2: " + obj.count2);
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) { e.printStackTrace(); }
                if (obj.count2 - obj.count1 > 20){
                    try {
                        synchronized (obj){
                            System.out.println("sleep...");
                            Thread.currentThread().join();
                            System.out.println("state: " + Thread.currentThread().getState());
                        }

                    } catch (InterruptedException e) { e.printStackTrace(); }
                }
                if(obj.count2 - obj.count1 < 20 && Thread.currentThread().getState() == State.WAITING) {
                    synchronized (obj){
                        System.out.println("notify...");
                        Thread.currentThread().notify();
                        System.out.println("state: " + Thread.currentThread().getState());
                    }

                }
            }
        }
    }

    public static void main(String[] args) throws InterruptedException {
        Obj obj = new Obj();
        Thread1 thread1 = new Thread1(obj);
        Thread2 thread2 = new Thread2(obj);
        thread1.start();
        thread2.start();
        thread1.join();
        thread2.join();
        System.out.println("count1: " + obj.count1);
        System.out.println("count2: " + obj.count2);



    }
}
