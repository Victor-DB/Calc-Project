package parallel.multytreading_course.d_sync_static_methods;

// Статическая синхронизация
// Стат синхр и нестатит синхр не совмещать!
public class Main {
    public static void main(String[] args) throws InterruptedException {
        Resource.i = 5;
        MyThread thread1 = new MyThread();
        MyThread thread2 = new MyThread();
        thread1.start();
        thread2.start();
        thread1.join();
        thread2.join();
        System.out.println(Resource.i);
    }
}

class MyThread extends Thread{
    @Override
    public void run() {
        Resource.changeStaticI();
    }
}

class Resource{
    // static var
    static int i;

    public static void changeStaticI(){
        // статич синхр происходит на уровне класса, ее использовать только для стат перменных!
        synchronized(Resource.class){
            int i = Resource.i;
            i++;
            Resource.i = i;
        }
    }
}

