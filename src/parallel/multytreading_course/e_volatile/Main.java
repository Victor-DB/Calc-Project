package parallel.multytreading_course.e_volatile;

public class Main {

    // переменная не кэшируется потоками, ее изменения сразу пишутся в память (это легче синхронизации)
   volatile static int i = 0;

    public static void main(String[] args) {
        new ThreadWrite().start();
        new ThreadRead().start();
    }

    static class ThreadWrite extends Thread{
        @Override
        public void run(){
            while (i < 5) {
                System.out.println("increment i to " + (++i));
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) { e.printStackTrace(); }
            }
        }
    }

    static class ThreadRead extends Thread{
        @Override
        public void run(){
            int varLocal = i;
            while (varLocal < 5){
                if (varLocal != i){
                    System.out.println("new value i is: " + i);
                    varLocal = i;
                }
            }
        }
    }
}

