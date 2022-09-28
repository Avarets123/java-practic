public class Main5 {
    public static void main(String[] args) {
        Human human1 = new Human();
        human1.age = 27;
        human1.name = "Oleg";
        human1.weight = 100;

        Human human2 = new Human();
        human2.weight = 90;
        human2.name = "Andrey";
        human2.age = 30;

        Human human3 = new Human();
        human3.age = 44;
        human3.name = "Sasha";
        human3.weight = 77;

        int middleAge = (human3.age + human2.age + human1.age) / 3;
        int middleWeight = (human3.weight + human2.weight + human1.weight) / 3;

        System.out.println("Средний возраст: " + middleAge);
        System.out.println("Средний вес: " + middleWeight);
    }
}
