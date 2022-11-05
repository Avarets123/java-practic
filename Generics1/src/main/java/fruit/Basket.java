package fruit;

import java.util.ArrayList;
import java.util.List;

public class Basket<T extends Fruit> {

  private List<T> fruits;

  public Basket() {
    this.fruits = new ArrayList<>();
  }

  public void add(T elem) {
    fruits.add(elem);
  }


  public double getWeight() {
    double result = 0;

    for (T element : fruits) {
      result += element.getWeight();
    }
    return result;
  }


  public int compare(Basket<?> basket) {
    return Double.compare(getWeight(), basket.getWeight());
  }

  public static <U extends Fruit> void  transfer(Basket<? extends U> src, Basket<? super U> dst) {
    dst.fruits.addAll(src.fruits);
    src.fruits.clear();
  }


}
