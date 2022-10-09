package threader;

public class Main {

    public static boolean isFive = false;


    public static void main(String[] args) {
//        Thread timer = new Thread(new Runnable() {
//            @Override
//            public void run() {
//                try {
//                    for (int i = 0; i < 1000000; i++) {
//                        System.out.println(i);
//                        Thread.sleep(1000);
//                    }
//                } catch (Exception e) {
//                }
//            }
//        });
//        RunnableInterface rrr = new RunnableInterface();
//        Thread timer2 = new Thread(rrr);
//        timer2.start();
//        timer.start();

        Thread whileThread = new Thread(new Runnable() {
            @Override
            public void run() {
                int i = 0;
                try {
                    while (true) {
                        if (i == 5) {
                            isFive = true;
                        }
                        System.out.println(i);
                        i++;
                        Thread.sleep(1000);
                    }
                } catch (Exception e) {
                }
            }
        });

        Thread whileThread2 = new Thread(new Runnable() {
            @Override
            public void run() {
                int i = 0;
                try {
                    while (!isFive) {
                        System.out.println(i);
                        i++;
                        Thread.sleep(1000);
                    }
                } catch (Exception e) {
                }
            }
        });
        whileThread2.start();
        whileThread.start();
    }
}
