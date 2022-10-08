public class Monstr {
    int eye;
    int leg;
    int hand;

    Monstr(int eye, int leg, int hand) {
        this.eye = eye;
        this.hand = hand;
        this.leg = leg;
    }

    Monstr() {
        eye = 2;
        hand = 2;
        leg = 2;
    }

    Monstr(int eye) {
        this.eye = eye;
        this.hand = 2;
        this.leg = 2;
    }
    Monstr(int eye, int hand) {
        this.eye = eye;
        this.hand = hand;
        this.leg = 2;
    }

    public  void  voice() {
        System.out.println("Голос");
    }
    public  void  voice(int i) {
        for (int j = 0; j <= i; j++) {
            System.out.print("Голос ! ");
        }
    }
    public  void  voice(int i, String world) {
        for (int j = 0; j <= i; j++) {
            System.out.println(world + "! ");
        }
    }
}
