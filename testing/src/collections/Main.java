package collections;

public class Main {
    public static void main(String[] args) {
        MyCollections employees =  new MyCollections();
        employees.add("Ivan");
        employees.add("Ilya");
        employees.add("Ira");
        employees.add("Iva");
        employees.remove("Ira");
        employees.remove("Iva");
        for (int i = 0; i < employees.getSize(); i++) {
            System.out.println(employees.get(i));
        }
        System.out.println(employees.getSize());
    }
}
