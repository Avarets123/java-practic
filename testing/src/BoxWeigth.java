public class BoxWeigth extends Box {
    int weight;

    public BoxWeigth(int height, int width, int length, int weight) {
        super(width, length, height);
        this.weight = weight;
    }

    @Override
    public String showInfo() {
        String str = super.showInfo();
        return str + ", " + "weight" + weight;
    }

}
