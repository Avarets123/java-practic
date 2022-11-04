package example1;

public class EnThread extends Thread{

    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName() + ": example1.EnThread");
    }
}
