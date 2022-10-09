package threeCollections;

import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {
        ArrayList<Integer> counts = new ArrayList<>(10);
        ArrayList<String> strings = new ArrayList<>(10);
        ArrayList<String> all = new ArrayList<>(10);

        for (int i = 0; i < 10; i++) {
            counts.add(i);
            strings.add("Person " + i);
        }


        for (int i = 0; i < 10; i++) {
            int count = counts.get(i);
            String string = strings.get(i);
            all.add(string + " " + count);
        }

        for (String person : all) {

            System.out.println(person);
        }


    }
}




