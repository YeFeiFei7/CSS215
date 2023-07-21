package sorts;

import java.util.Arrays;

public class MergeSort {
    public static void main(String[] args) {
        int[] nums = {4, 2, 1, 5, 6, 3, 7};
        mergeSort(nums);
        System.out.println(Arrays.toString(nums));  //Verify correctness
        System.out.println("==============");

        //test
        int testTimes = 10000;
        long s = System.currentTimeMillis();
        for (int i = 0; i < testTimes; i++) {
            int[] arr = Test.generateRandomArray(10000, 100);
            mergeSort(arr);
        }
        long e = System.currentTimeMillis();

        System.out.println((e - s) * 0.001 + "s");  //average : 5.6s
    }

    //O(N*logN)
    public static void mergeSort(int[] arr) {
        if (arr == null || arr.length < 2) {
            return;
        }

        process(arr, 0, arr.length - 1);
    }

    public static void process(int[] arr, int l, int r) {
        if (l == r) { //base case : only one value left
            return;
        }

        int mid = (l + r) / 2;
        process(arr, l, mid);        // Sort the left half of the array
        process(arr, mid + 1, r);  // Sort the right half of the array
        merge(arr, l, mid, r);       // Merge the sorted left and right halves
    }

    public static void merge(int[] arr, int l, int mid, int r) {
        int[] help = new int[r - l + 1];
        int p1 = l;       // Pointer for the left subarray
        int p2 = mid + 1; // Pointer for the right subarray
        int i = 0;        // Pointer for the help array

        //Copy the smaller value from the left and right arrays into the help array first
        while (p1 <= mid && p2 <= r) {
            help[i++] = arr[p1] <= arr[p2] ? arr[p1++] : arr[p2++];
        }

        //Copy the remaining values (Only one of the while loop will terminate)
        while (p1 <= mid) {
            help[i++] = arr[p1++];
        }
        while (p2 <= r) {
            help[i++] = arr[p2++];
        }

        //Copy all the sorted values to the array
        for (i = 0; i < help.length; i++) {
            arr[l + i] = help[i];
        }
    }
}