public class Box {
    int width;
    int length;
    int height;

    Box(int width, int length, int height) {
        this.height = height;
        this.width = width;
        this.length = length;
    }

    Box(Box box1, Box box2) {
        this.height = box2.height + box1.height;
        this.width = box2.width + box1.width;
        this.length = box1.length + box2.length;
    }

    Box createBox(Box box) {
        return new Box(width + box.width, length + box.length, height + box.height);
    }

    int volume() {
        return width * height * length;
    }

    public String showInfo() {

        return "width" + width + ", " + "height" + height + ", " + "length" + length;
    }



}
