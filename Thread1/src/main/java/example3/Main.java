package example3;

public class Main {
  public static void main(String[] args) {
    Performance.SIZE = 1_00_000_000;
    Performance.startTimer();
    Performance.withConcurrency();
    Performance.withoutConcurrency();
  }
}
