import java.util.Arrays;

public class SortArray {
    public static void main(String[] args) {

//        int[] gen = {12, 3, 56, 1, 435, 34, 1324, 213, -1, 4};

        int[] gen = GenerateArrayWithRandomNumbers.generateRandomArray(12, 150);

        sortArrayMutate(gen);

        System.out.println(Arrays.toString(gen));




    }

    public static void sortArrayMutate(int[] arrayNumbers) {
        int min;
        int minIndex ;
        int temp;
        for (int i = 0; i < arrayNumbers.length ; i++) {
            min = arrayNumbers[i];
            minIndex = i;
            for (int j = i; j < arrayNumbers.length ; j++) {
                if (arrayNumbers[j] < min) {
                    min = arrayNumbers[j];
                    minIndex = j;
                }
            }
            temp = arrayNumbers[i];
            arrayNumbers[i] = min;
            arrayNumbers[minIndex] = temp;
        }
    }

}
