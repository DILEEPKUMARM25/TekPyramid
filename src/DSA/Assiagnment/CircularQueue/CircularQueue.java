package DSA.Assiagnment.CircularQueue;
public class CircularQueue {
    private int[] data;
    private int head;   // index of current front
    private int tail;   // index for next insertion
    private int size;
    private final int capacity;

    public CircularQueue(int capacity) {
        if (capacity <= 0) throw new IllegalArgumentException("Capacity must be > 0");
        this.capacity = capacity;
        data = new int[capacity];
        head = 0;
        tail = 0;
        size = 0;
    }

    public boolean enqueue(int x) {
        if (isFull()) return false;
        data[tail] = x;
        tail = (tail + 1) % capacity;
        size++;
        return true;
    }

    public Integer dequeue() {
        if (isEmpty()) return null;
        int val = data[head];
        head = (head + 1) % capacity;
        size--;
        return val;
    }

    public Integer peek() {
        if (isEmpty()) return null;
        return data[head];
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public boolean isFull() {
        return size == capacity;
    }


    public static void main(String[] args) {
        CircularQueue cq = new CircularQueue(3);
        System.out.println("Enqueue 1: " + cq.enqueue(1));
        System.out.println("Enqueue 2: " + cq.enqueue(2));
        System.out.println("Enqueue 3: " + cq.enqueue(3));
        System.out.println("Enqueue 4 (should be false): " + cq.enqueue(4));
        System.out.println("Dequeue: " + cq.dequeue());
        System.out.println("Enqueue 4 now: " + cq.enqueue(4));
        System.out.println("Peek: " + cq.peek());
    }
}
