package threader;

public class RunnableInterface implements Runnable {
    @Override
    public void run() {
        try {
            for (int i = 0; i < 1000000; i++) {

                System.out.println("Tick");
                Thread.sleep(500);
            }
        } catch (Exception e) {

        }
    }
}
