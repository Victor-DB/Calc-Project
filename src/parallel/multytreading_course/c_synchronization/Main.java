package parallel.multytreading_course.c_synchronization;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        Resource resource = new Resource();
        resource.setI(5);
        MyThread thread1 = new MyThread(resource);
        MyThread thread2 = new MyThread(resource);
        thread1.start();
        thread2.start();
        thread1.join();
        thread2.join();
        System.out.println(resource.getI());
    }
}

class MyThread extends Thread{
    Resource resource;

    public MyThread(Resource resource) {
        this.resource = resource;
    }

    @Override
    public void run() {
        resource.changeI();
    }
}

//  Общий доступ к переменным класса будет реализован:
class Resource{
    private int i;

    public int getI() { return i; }
// желательно синхронизировать метод, меняющий значение
    public synchronized void setI(int i) { this.i = i; }

//   synchronized блокирует монитор (текущий объект recource). Монитор - это лок на объекте.
    public void changeI(){
        // нестатическая синх идёт на уровне объекта resource
        synchronized(this){
            int i = this.i;
            i++;
            this.i = i;
        }
    }
}
