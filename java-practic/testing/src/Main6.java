public class Main6 {

    public static void main(String[] args) {
        Dogs first = new Dogs();
        first.nickname = "Tuzik";
        first.breed = "undefined";
        first.speed = 10;


        Dogs second = new Dogs();
        second.nickname = "Kruzik";
        second.breed = "undefined";
        second.speed = 10;

        String infoFirst = first.info();
        second.run();
        System.out.println(infoFirst);

    }
}
