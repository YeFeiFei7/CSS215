package stack_queue;

public class MyQueue {
    private final int[] arr;
    private final int limit; // size limit
    private int curSize; // current size

    //pointers
    private int addIndex = 0;
    private int pollIndex = 0;

    //Constructor with default limit of 10
    public MyQueue() {
        limit = 10;
        arr = new int[limit];
        curSize = 0;
    }

    //Constructor with a specified limit
    public MyQueue(int limit) {
        this.limit = limit;
        arr = new int[limit];
        curSize = 0;
    }

    //Add an element to the queue
    public void add(int val) {
        if (curSize == limit) {
            throw new RuntimeException("Queue is Full");
        }

        arr[addIndex] = val;
        addIndex = getNextIndex(addIndex); // Update the addIndex in a circular manner
        curSize++;
    }

    //Remove and return the front element from the queue
    public int poll() {
        if (isEmpty()) {
            throw new RuntimeException("Queue is Empty");
        }

        int val = arr[pollIndex];
        pollIndex = getNextIndex(pollIndex); // Update the pollIndex in a circular manner
        curSize--;
        return val;
    }

    //Helper method to get the next circular index based on the current index
    private int getNextIndex(int index) {
        return index < limit - 1 ? index + 1 : 0;
    }

    //Check if the queue is empty
    public boolean isEmpty() {
        return curSize == 0;
    }

    //Get the current size of the queue
    public int getSize() {
        return curSize;
    }
}