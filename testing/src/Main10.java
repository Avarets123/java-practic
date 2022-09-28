public class Main10 {
    public static void main(String[] args) {
        Box box = new Box(5, 12, 11);
        Box box1 = new Box(5, 6, 7);

        Box box2 = box1.createBox(box);
        Box box3 = new Box(box1, box2);
    }
}
