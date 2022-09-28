public class Main9 {

    public static void main(String[] args) {
        Monstr first = new Monstr(4, 5, 3);
        Monstr second = new Monstr();
        Monstr third = new Monstr(4);
        Monstr four = new Monstr(4, 5);

        first.voice();
        first.voice(34);
        first.voice(11, "Hi");
    }

}
