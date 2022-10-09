package example1;

import java.util.Arrays;
import java.util.Random;

public class Main {
    public static void main(String[] args) {

        Human[] humans = new Human[1000];
        int[] ageHumans = new int[65];


        for (int i = 0; i < humans.length; i++) {

            int random = new Random().nextInt(65);

            humans[i] = new Human("User " + i, random);
        }

        for (int i = 0; i < humans.length; i++) {
            ageHumans[humans[i].getAge()]++;
        }


        for (int i = 0; i < ageHumans.length; i++) {
            System.out.println("Age:" + i + " встречается" + ageHumans[i]);
        }

    }
}
