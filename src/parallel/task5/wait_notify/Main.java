package parallel.task5.wait_notify;

/**
 * Объект, поля которого синхронно растут.
 * Если одно поле обгоняет другое поле больше чем на 35,
 * то оно ждёт пока другое подрастёт
 */
class Obj{
    int num0 = 0;
    int num1 = 0;

    /**
     * Метод увеличения поля num0 в первом потоке
     */
    public synchronized void increase0(Obj obj) throws InterruptedException {
        obj.num0 += 15;
        while (obj.num0 - obj.num1 > 35){
            wait();
        }
    }

    /**
     * Метод увеличения поля num1 во втором потоке
     */
    public synchronized void increase1(Obj obj) throws InterruptedException {
        obj.num1 += 1;
        notifyAll();
    }

}

/**
 * Первый поток
 */
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

/**
 * Второй поток
 */
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

/**
 * Первый поток
 */
public class Main {

    static Obj obj = new Obj();

    public static void main(String[] args) {
        new Thread1(obj).start();
        new Thread2(obj).start();
    }
}
