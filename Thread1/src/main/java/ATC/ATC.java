package ATC;

public class ATC {
  private int amount = 100_000;

  private final Object monitor = new Object();

  public int getAmount() {
    return amount;
  }

//  public void synchronized getMoney(String name, int sum) {

    public void getMoney(String name, int sum) {
    synchronized (monitor) {

      System.out.println(name + " подошел к банкомату");
      try {
        Thread.sleep(2000);
      } catch (InterruptedException e) {
        throw new RuntimeException(e);
      }

      if (!(sum < amount && sum >= 0)) {
        System.out.println("В банкомате недостаточно денег для " + name);
        return;
      }

      amount -= sum;
      System.out.println(name + " вывел " + sum + " рублей. В банкомате осталось " + amount + " рублей.");
    }
  }
}
