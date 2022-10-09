public class Dogs {
    int speed;
    String breed;
    String nickname;

    public void run() {
        String run = "";
        for (int i = 0; i <= speed; i++) {
            if (i == 0) {
                run += "Бегу,";
            } else if (i == speed) {
                run += "бегу.";
            } else {
                run += "бегу, ";
            }
        }
        System.out.println(run);
    }

    public String info() {
        return "Кличка: " + nickname + ", порода:" + breed + ", скорость:" + speed;
    }
}
