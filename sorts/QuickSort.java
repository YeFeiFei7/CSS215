package sorts;

import java.util.Arrays;

public class QuickSort {
    public static void main(String[] args) {
        int[] nums = {4, 2, 1, 5, 6, 3, 7};
        quickSortUltra(nums);
        System.out.println(Arrays.toString(nums));  //Verify correctness
        System.out.println("==============");

        //test
        int testTimes = 10000;
        long s = System.currentTimeMillis();
        for (int i = 0; i < testTimes; i++) {
            int[] arr = Test.generateRandomArray(10000, 100);
            quickSortUltra(arr);
        }
        long e = System.currentTimeMillis();

        System.out.println((e - s) * 0.001 + "s");   //average : 3s
    }

    public static void quickSortUltra(int[] arr) {
        if (arr == null || arr.length < 2) {
            return;
        }

        processUltra(arr, 0, arr.length - 1);
    }


    //O(N * logN)
    public static void processUltra(int[] arr, int l, int r) {
        if (l >= r) { ////base case : the array is already sorted.
            return;
        }

        //Randomly select a number to exchange with pivot before sorting
        swap(arr, ((int) (l + Math.random() * (r - l + 1))), r);

        //Partition the array using the "Dutch National Flag"
        int[] equalsArea = partitionUltra(arr, l, r);

        //repeat
        processUltra(arr, l, equalsArea[0] - 1);
        processUltra(arr, equalsArea[1] + 1, r);
    }


    public static int[] partitionUltra(int[] arr, int l, int r) {
        //pointers
        int smallArea = l - 1;
        int bigArea = r + 1;
        int index = l;

        int pivot = arr[r];

        /*
        Loop through the array until the index crosses the bigArea pointer.
        1. If the current element is equal to the pivot, move to the next element.

        2. If the current element is less than the pivot,
           swap it with the element at the smallArea next pointer

        3. If the current element is greater than the pivot,
           swap it with the element at the bigArea previous pointer
        */
        while (index < bigArea) {
            if (arr[index] == pivot) {
                index++;
            } else if (arr[index] < pivot) {
                swap(arr, index++, ++smallArea);
            } else {
                swap(arr, index, --bigArea);
            }
        }

        //Returns the indices of the smallArea next and bigArea previous parts for further sorting.
        return new int[] {smallArea + 1, bigArea - 1};
    }

    public static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}