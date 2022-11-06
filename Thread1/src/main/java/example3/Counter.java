package example3;

public class Counter {
  private int value;

  public int getValue() {
    return value;
  }

  public synchronized void inc() {
    value++;
  }

  public  void dec() {
    synchronized (this) {
      value--;
    }
  }
}
