package interfaceExample2;

public class Main {

    public static void main(String[] args) {
        Counter counter = new Counter();
        Director director = new Director();

        director.force(counter, 5);

        director.force(new Counter(), 7);
    }
}
