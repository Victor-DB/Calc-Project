package parallel.multytreading_course.f_sinc_collections;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

// Потокобезопасные коллекции не гарантируют безопасность.
// Нужны также с ними применять synchronized там где надо
public class Main {
    public static void main(String[] args) {
        NameList list = new NameList();
        list.add("first");

        class MyThread extends Thread{
            @Override
            public void run(){
                System.out.println(list.removeFirst());
            }
        }

        MyThread thread = new MyThread();
        thread.setName("one");
        thread.start();
        new MyThread().start();
    }

    static class NameList{
        // потокобезопасная коллекция
        private List list = Collections.synchronizedList(new ArrayList<>());

        public void add(String name){
            list.add(name);
        }

        public synchronized String removeFirst(){
            if (list.size() > 0){
                // если имя потока "one"
                if (Thread.currentThread().getName().equals("one")) {
                    // то попросить его уступить место другому потоку
                    Thread.yield();
                }
              return (String) list.remove(0);
            }
            return null;
        }
    }
}
