public class Main11 {

    public static void main(String[] args) {
        Box box = new Box(5, 6, 7);
        String infoBox = box.showInfo();

        BoxWeigth boxWeigth = new BoxWeigth(1, 2, 3, 4);
        String infoBoxWeigth = boxWeigth.showInfo();

        System.out.println(infoBox);
        System.out.println(infoBoxWeigth);

    }

}
