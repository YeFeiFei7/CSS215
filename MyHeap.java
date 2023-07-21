package heap;

//Max-Heap
public class MyHeap {
    private final int[] heap;
    private final int limit;
    private int heapSize; //pointer

    //Constructor with default limit of 10
    public MyHeap() {
        limit = 10;
        heap = new int[limit];
        heapSize = 0;
    }

    //Constructor with a specified limit
    public MyHeap(int limit) {
        this.limit = limit;
        heap = new int[limit];
        heapSize = 0;
    }

    // Add an element to the max-heap
    public void add(int val) {
        if (heapSize == limit) {
            System.out.println("Heap is Full");
            return;
        }

        //Add the values to the array, and then proceed to adjust the max-heap
        heap[heapSize] = val;
        heapInsert(heapSize++);
    }

    //Helper method to maintain the max-heap property during the insertion process
    private void heapInsert(int index) {
        int parentIndex = (index - 1) / 2; //find the index of the parent

        //While the current element is greater than its parent
        while (heap[index] > heap[parentIndex]) {
            //swap them
            swap(heap, index, parentIndex);
            index = parentIndex;
            parentIndex = (index - 1) / 2;
        }
    }

    //Remove and return the maximum element from the max-heap
    public int poll() {
        if (isEmpty()) {
            throw new RuntimeException("Heap is Empty");
        }

        /*
        Save the maximum value of the heap
        then swap it with the last value in the heap
        and then proceed to adjust the Heap
        */
        int val = heap[0];
        swap(heap, 0, --heapSize);
        heapify(0, heapSize);

        return val;
    }

    // Helper method to maintain the max-heap property during the deletion process
    private void heapify(int index, int heapSize) {
        int left = index * 2 + 1;

        //While the current element has at least one child
        while (left < heapSize) {
            //Find the larger child between the left and right children
            int largestIndex = left + 1 < heapSize && heap[left + 1] > heap[left] ? left + 1 : left;

            //Compare with the largest child, and find the ultimately largest one
            int finalLargestIndex = heap[index] > heap[largestIndex] ? index : largestIndex;

            //If the current element is already larger than its largest child, no need to swap, break out of the loop
            if (finalLargestIndex == index) {
                break;
            }

            //Swap the current element with its largest child and continue heapify
            swap(heap, index, finalLargestIndex);
            index = finalLargestIndex;
            left = index * 2 + 1;
        }
    }

    private void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    //Check if the max-heap is empty
    public boolean isEmpty() {
        return heapSize == 0;
    }

    //Get the current size of the max-heap
    public int getSize() {
        return heapSize;
    }
}