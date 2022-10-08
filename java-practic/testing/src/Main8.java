public class Main8 {
    public static void main(String[] args) {
        Worker worker1 = new Worker("Andrey", "developer", 60000);

        String infoWorker1 = worker1.getInfo(6);

        System.out.println(infoWorker1);
    }
}
