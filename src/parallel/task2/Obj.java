package parallel.task2;

public class Obj {
    public int count = 1000;
    public int getCount() { return count; }
    public void setCount(int count) { this.count = count; }

    public synchronized void increase(int amount){
        count += amount;
    }
    public synchronized void decrease(int amount){
        count -= amount;
    }
}

