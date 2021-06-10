package parallel.multytreading_course.a_create_thread;

public class Main {

    public static void main(String[] args) {
        MyThread thread1 = new MyThread();
        thread1.start();
        System.out.println(Thread.currentThread().getName() + ": in main method...");

        MyRunnable runnable = new MyRunnable();
        Thread thread2 = new Thread(runnable);
        thread2.start();
    }
}


//......   1й способ создания потока
class MyThread extends Thread {
    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName() + ": one thread...");
        doSometh();
    }
    private void doSometh(){
        System.out.println(Thread.currentThread().getName() + ": do something...");
    }
}


//.....  2й способ создания потока
class MyRunnable implements Runnable{
    @Override
    public void run(){
        System.out.println(Thread.currentThread().getName() + ": second thread...");
    }
}

