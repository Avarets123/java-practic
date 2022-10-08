public class Main7 {

    public static void main(String[] args) {
        Rect rect = new Rect();

        rect.setParam(6, 10);

        int rectArea = rect.getArea();
        int rectPerimeter = rect.getPerimeter();
        System.out.println(rectArea);
        System.out.println(rectPerimeter);
    }
}
