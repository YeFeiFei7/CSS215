package heap;

public class Test {
    public static void main(String[] args) {
        MyHeap heap = new MyHeap();
        heap.add(3);
        heap.add(5);
        heap.add(1);
        heap.add(4);
        heap.add(2);
        System.out.println("size: " + heap.getSize());
        while (!heap.isEmpty()) {
            System.out.print(heap.poll() + " ");
        }
        System.out.println();
        System.out.println("size: " + heap.getSize());
    }
}
