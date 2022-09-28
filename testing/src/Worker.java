public class Worker {
    String name;
    String position;
    int wage;

    public Worker(String name, String position, int wage) {
        this.name = name;
        this.position = position;
        this.wage = wage;
    }

    public String getInfo(int month) {
        int allSum = month * this.wage;

        return "Сотрудник: " + name + ", должность: " + position + ", за " + month + " месяцев получил " + allSum + " рублей.";
    }
}
