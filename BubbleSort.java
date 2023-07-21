package sorts;

import java.util.Arrays;

public class BubbleSort {
    public static void main(String[] args) {
        int[] nums = {4, 2, 1, 5, 6, 3, 7};
        bubbleSort(nums);
        System.out.println(Arrays.toString(nums));  //Verify correctness
        System.out.println("==============");

        //test
        int testTimes = 10000;
        long s = System.currentTimeMillis();
        for (int i = 0; i < testTimes; i++) {
            int[] arr = Test.generateRandomArray(10000, 100);
            bubbleSort(arr);
        }
        long e = System.currentTimeMillis();

        System.out.println((e - s) * 0.001 + "s");   //average : 5min
    }

    //O(N^2)
    public static void bubbleSort(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = 0; j < arr.length - 1 - i; j++) { //0~N-1; 0~N-2; 0~N-3...
                //If the first number is greater than the second, swap them
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }

            }
        }
    }
}