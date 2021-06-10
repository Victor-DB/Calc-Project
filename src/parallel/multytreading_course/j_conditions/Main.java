package parallel.multytreading_course.j_conditions;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Один поток приостанавливается и ждёт пока другой поток не выполнит нужное условие
 */
public class Main {

    /** С локами принято использовать кондишины **/
    static Lock lock = new ReentrantLock();
    static Condition condition = lock.newCondition();
    static int account = 0;

    public static void main(String[] args) {
        new AccountMinus().start();
        new AccountPlus().start();

    }

    /**
     * Поток увеличения счёта
     * После увеличения баланса (account += 10) пробуждаем поток для выполнения (condition.signal())
     * Основной код должен быть в блоке синхронизации lock.lock() - lock.unlock()
     */
    static class AccountPlus extends Thread{
        @Override
        public void run() {
            lock.lock();
                account += 10;
                condition.signal();
            lock.unlock();
        }
    }

    /**
     * Поток уменьшения счёта
     * Если account < 10 то ждём (condition.await();)
     * Основной код должен быть в блоке синхронизации lock.lock() - lock.unlock()
     */
    static class AccountMinus extends Thread{
        @Override
        public void run(){
            if (account < 10) {
                try {
                    lock.lock();
                        System.out.println("account before: " + account);
                        condition.await();
                        System.out.println("account after: " + account);
                    lock.unlock();
                } catch (InterruptedException e) { e.printStackTrace(); }
            }
            account -= 10;
        }
    }
}
