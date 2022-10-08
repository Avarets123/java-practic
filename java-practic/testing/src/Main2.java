import java.util.Arrays;

public class Main2 {
    public static void main(String[] args) {
//        int[] arr = new int[11];

        int[] numbers = {43, 55, 1, -3, 4, 43, -54, 0, 432, 3};
        int min, indexMin, save;



        for (int i = 0; i < numbers.length; i++) {
            min = numbers[i];
            indexMin = i;


            for (int j = i; j < numbers.length; j++) {
                if (min > numbers[j]) {
                    min = numbers[j];
                    indexMin = j;
                }

            }

            save = numbers[i];
            numbers[i] = min;
            numbers[indexMin] = save;

        }
        System.out.print(Arrays.toString(numbers));

    }
}
