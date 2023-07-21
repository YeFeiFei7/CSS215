package sorts;

import java.util.Arrays;

public class SelectionSort {
    public static void main(String[] args) {
        int[] nums = {4, 2, 1, 5, 6, 3, 7};
        selectionSort(nums);
        System.out.println(Arrays.toString(nums)); //Verify correctness
        System.out.println("==============");

        //test
        int testTimes = 10000;
        long s = System.currentTimeMillis();
        for (int i = 0; i < testTimes; i++) {
            int[] arr = Test.generateRandomArray(10000, 100);
            selectionSort(arr);
        }
        long e = System.currentTimeMillis();

        System.out.println((e - s) * 0.001 + "s");  //average : 75s
    }

    //O(N^2)
    public static void selectionSort(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            int midIndex = i; //Assume `i` position is the minimum value in array

            //find minimum value in array (i ~ N)
            for (int j = i + 1; j < arr.length; j++) {
                midIndex = arr[j] < arr[midIndex] ? j : midIndex;
            }

            //swap them
            int temp = arr[i];
            arr[i] = arr[midIndex];
            arr[midIndex] = temp;
        }
    }
}