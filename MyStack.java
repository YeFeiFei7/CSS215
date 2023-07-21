package stack_queue;

public class MyStack {
    private final int[] arr;
    private final int limit; //size limit
    private int top;   //Top of the stack, used to control the pointer of the entire stack

    //Constructor with default limit of 10
    public MyStack() {
        limit = 10;
        arr = new int[limit];
        top = -1;
    }

    //Constructor with a specified limit
    public MyStack(int limit) {
        this.limit = limit;
        arr = new int[limit];
        top = -1;
    }

    //Push an element onto the stack
    public void push(int val) {
        if (top == limit - 1) {
            throw new RuntimeException("Stack is full");
        }

        arr[++top] = val;
    }

    //Pop and return the top element from the stack
    public int pop() {
        if (isEmpty()) {
            throw new RuntimeException("Stack is empty");
        }

        return arr[top--];
    }

    //Get the current size of the stack
    public int getSize() {
        return top + 1;
    }

    //Check if the stack is empty
    public boolean isEmpty() {
        return top == -1;
    }
}