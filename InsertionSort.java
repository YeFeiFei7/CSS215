package sorts;

import java.util.Arrays;

public class InsertionSort {
    public static void main(String[] args) {
        int[] nums = {4, 2, 1, 5, 6, 3, 7};
        insertionSort(nums);
        System.out.println(Arrays.toString(nums)); //Verify correctness
        System.out.println("==============");

        //test
        int testTimes = 10000;
        long s = System.currentTimeMillis();
        for (int i = 0; i < testTimes; i++) {
            int[] arr = Test.generateRandomArray(10000, 100);
            insertionSort(arr);
        }
        long e = System.currentTimeMillis();

        System.out.println((e - s) * 0.001 + "s");  //average : 29s
    }

    //O(N^2)
    public static void insertionSort(int[] arr) {
        for (int i = 1; i < arr.length; i++) {
            int index = i;  //new value that need to insert

            //If the previous number is larger than the latter
            while (index > 0 && arr[index] < arr[index - 1]) {
                //swap them...
                int temp = arr[index];
                arr[index] = arr[index - 1];
                arr[index - 1] = temp;
                index--;
            }

        }
    }
}