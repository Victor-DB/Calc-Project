package parallel.multytreading_course.g_deadlock;

// Deadlock - ситуация когда два потока дёргают два взаимосвязанных ресурса и зависают
// Эта программа должна иногда зависать при запусках
public class Main {
    public static void main(String[] args) {
        ResourceA a = new ResourceA();
        ResourceB b = new ResourceB();
        // проинициализировали поля внутри объектов:
        a.b = b;
        b.a = a;
        MyThread1 t1 = new MyThread1();
        MyThread2 t2 = new MyThread2();
        // проинициализировали ссылки внутри потоков:
        t1.a = a;
        t2.b = b;
        // запускаем потоки:
        t1.start();
        t2.start();
    }
}


class MyThread1 extends Thread{
    ResourceA a;
    @Override
    public void run() {
        System.out.println(a.getI());
    }
}


class MyThread2 extends Thread{
    ResourceB b;
    @Override
    public void run() {
        System.out.println(b.getI());
    }
}


// Класс с объектами, ссфлающимися друг на друга
class ResourceA{
    ResourceB b;
    public synchronized int getI(){
        return b.returnI();
    }

    public synchronized int returnI(){
        return 1;
    }
}


// Класс с объектами, ссфлающимися друг на друга
class ResourceB{
    ResourceA a;
    public synchronized int getI(){
        return a.returnI();
    }

    public synchronized int returnI(){
        return 2;
    }
}
