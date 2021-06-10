package parallel.task1;

public class Account {

    public long amount;
    public long balance;

    public Account(long balance) { this.balance = balance; }
    public long getBalance() { return balance; }

    // помечая метод модификатором synchronized мы блокируем поток доступа к переменной amount до полного выполнениы операции
    public synchronized void withdraw(long amount) {
        checkAmount(amount);
        balance -= amount;
    }

    // или можно пометить блок кода (объект this указывает на текущий монитор - объект, который блокируется внутри блока synchronized)
    public void deposit(long amount) {
        synchronized (this) {
            checkAmount(amount);
            balance += amount;
        };

    }

    public void checkAmount(long amount) {
        if (balance < amount)  {
            throw new IllegalArgumentException("not enough money");
        }
    }

}
