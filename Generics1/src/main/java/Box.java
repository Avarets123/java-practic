import java.io.Serializable;
import java.util.List;

public class Box<T extends Number & Comparable<T> & Serializable> {
  private T[] array;

  public Box(T... array) {
    this.array = array;
  }

  public double avg() {
    double result = 0;

    for (T element : array) {
      result += ((Number) element).doubleValue();
    }


    return result / array.length;
  }

  public T[] getArray() {
    return array;
  }

  public void setArray(T[] array) {
    this.array = array;
  }


  public int compareTo(Box<? extends Number> another) {
    if (avg() > another.avg()) {
      return 1;
    } else if (avg() == another.avg()) {
      return 0;
    } else {
      return -1;
    }

  }

  public static <E> void transfer(List<? extends E> src, List<? super E> dst) {
    dst.addAll(src);
    src.clear();
  }

  public static <U> U getFirstElement(List<U> elements) {
    return elements.get(0);
  }

  public static void method(List<? extends Number> numbers) {

  }
}
