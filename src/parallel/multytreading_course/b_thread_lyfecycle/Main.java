package parallel.multytreading_course.b_thread_lyfecycle;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        MyThread thread = new MyThread();
        thread.start();
        thread.join(); // сначала полностью выполняется код выше, а потом только начинает выполнстся код ниже
//        Thread.yield(); // подсказка планировщику что текущий поток готов уступить своё место для процессора
        System.out.println("main thread...");
    }
}

class MyThread extends Thread{
    @Override
    public void run(){
        for (int i = 0; i < 50; i++){
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) { e.printStackTrace(); }
            System.out.println(i);
        }
    }
}