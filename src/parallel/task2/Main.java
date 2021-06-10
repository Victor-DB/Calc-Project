package parallel.task2;


public class Main {

    static class Thread1 extends Thread{
        public final Obj obj;
        Thread1(Obj obj) { this.obj = obj; }

        @Override
        public void run(){
            for (int i = 0; i < 500; i++) {
                obj.decrease(1);
            }
        }
    }


    static class Thread2 extends Thread{
        public final Obj obj;
        Thread2(Obj obj) { this.obj = obj; }

        @Override
        public void run(){
            for (int i = 0; i < 500; i++) {
                obj.increase(1);
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
        System.out.println("all count: " + obj.count);
    }
}

