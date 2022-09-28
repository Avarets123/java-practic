public class Rect {
    int length;
    int width;


    public void  setParam(int length, int width) {
        this.length = length;
        this.width = width;
    }

    public int getArea() {
        return this.length * this.width;
    }

    public int getPerimeter() {
        return  (this.length + this.width) * 2;
    }
}
