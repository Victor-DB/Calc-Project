package parallel.task5.await_signal;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * ТО ЖЕ САМОЕ КАК С wait-notify, только с Condition!
 * Объект, поля которого синхронно растут.
 * Если одно поле обгоняет другое поле больше чем на 35,
 * то оно ждёт пока другое подрастёт
 */
public class Main {

    static Obj obj = new Obj();

    public static void main(String[] args) {
        new Thread1(obj).start();
        new Thread2(obj).start();
    }
}

class Thread1 extends Thread{
    Obj obj;
    public Thread1(Obj obj) {
        this.obj = obj;
    }
    @Override
    public void run(){
        for (int i = 0; i < 250; i ++){
            try {
                sleep(2000);
                obj.increase0(obj);
            } catch (InterruptedException e) { e.printStackTrace(); }
            System.out.println(getName() + " : " + obj.num0);
        }
    }
}

class Thread2 extends Thread{
    Obj obj;
    public Thread2(Obj obj) {
        this.obj = obj;
    }
    @Override
    public void run(){
        for (int i = 0; i < 350; i ++){
            try {
                sleep(2000);
                obj.increase1(obj);
            } catch (InterruptedException e) { e.printStackTrace(); }
            System.out.println(getName() + " : " + obj.num1);
        }
    }
}

class Obj{
    int num0 = 0;
    int num1 = 0;
    Lock lock = new ReentrantLock();
    Condition condition = lock.newCondition();


    public void increase0(Obj obj) throws InterruptedException {
        lock.lock();
            obj.num0 += 15;
            while (obj.num0 - obj.num1 > 35){
                condition.await();
            }
        lock.unlock();
    }

    public void increase1(Obj obj) throws InterruptedException {
        lock.lock();
            obj.num1 += 1;
            condition.signalAll();
        lock.unlock();
    }

}