public class Main4 {
    public static void main(String[] args) {

        int[] array = {12, 43, 65, 2344, 64, 12, -4, -1111};
        int[] array2 = {453, 32, 4, 11, 66, 22, 12};

        int sum = calcSumArray(array, 4, 7);
        int sum2 = calcSumArray(array2, 1, 6);


    }

    public static int calcSumArray(int[] array, int from, int to) {
        int sum = 0;

        for (int i = from; i <= to; i++) {
            sum += array[i];
        }

        return sum;
    }
}
