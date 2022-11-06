package example3;

public class Main {
  public static void main(String[] args) {
    Performance.SIZE = 100_000_000;
    Performance.withConcurrency();
    Performance.withoutConcurrency();
  }
}
