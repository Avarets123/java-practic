package example1;

public class EggThread extends Thread{

    @Override
    public void run() {
        Thread eggThread = Thread.currentThread();
        System.out.println(eggThread.getName() + ": example1.EggThread");
    }
}
