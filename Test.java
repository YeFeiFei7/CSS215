package stack_queue;


public class Test {
    public static void main(String[] args) {
        System.out.println("===Test for Stack===");
        MyStack stack = new MyStack();
        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.push(4);

        System.out.println("size: " + stack.getSize());
        while (!stack.isEmpty()) {
            System.out.print(stack.pop() + " ");
        }
        System.out.println("\nsize: " + stack.getSize());


        System.out.println("\n===Test for Queue===");
        MyQueue queue = new MyQueue();
        queue.add(1);
        queue.add(2);
        queue.add(3);
        queue.add(4);

        System.out.println("size: " + queue.getSize());
        while(!queue.isEmpty()) {
            System.out.print(queue.poll() + " ");
        }
        System.out.println("\nsize: " + queue.getSize());
    }
}