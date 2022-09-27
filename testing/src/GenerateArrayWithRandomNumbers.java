import java.util.Arrays;
import java.util.Random;

public class GenerateArrayWithRandomNumbers {
    public static void main(String[] args) {
        int[] arr = generateRandomArray(30, 99);

        System.out.println(Arrays.toString(arr));

    }

    public static int[] generateRandomArray(int count, int range) {

        Random random = new Random();

        int[] newArr = new int[count];

        for (int i = 0; i <= count - 1; i++) {
            newArr[i] = random.nextInt(range);
        }


        return newArr;
    }

}
