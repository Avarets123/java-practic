package example1;

public class Main {
    public static void main(String[] args) {

        Thread currentThread = Thread.currentThread();
        Thread enThread = new EnThread();
        Thread eggThread = new EggThread();


        enThread.start();
        eggThread.start();
        System.out.println(currentThread.getName() + ": MainThread");

    }
}