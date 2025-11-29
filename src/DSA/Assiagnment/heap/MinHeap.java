package DSA.Assiagnment.heap;

import java.util.Arrays;

class MinHeap {
    int[] heap;
    int size;

    MinHeap(int capacity) {
        heap = new int[capacity];
        size = 0;
    }

    int parent(int i) { return (i - 1) / 2; }
    int left(int i) { return 2 * i + 1; }
    int right(int i) { return 2 * i + 2; }

    // Insert
    void add(int val) {
        heap[size] = val;
        int i = size;
        size++;

        // heapify up
        while (i > 0 && heap[parent(i)] > heap[i]) {
            swap(i, parent(i));
            i = parent(i);
        }
    }

    // Remove min
    int poll() {
        if (size == 0) return -1;

        int root = heap[0];
        heap[0] = heap[size - 1];
        size--;

        heapify(0);
        return root;
    }

    // Heapify Down
    void heapify(int i) {
        int smallest = i;
        int l = left(i);
        int r = right(i);

        if (l < size && heap[l] < heap[smallest]) smallest = l;
        if (r < size && heap[r] < heap[smallest]) smallest = r;

        if (smallest != i) {
            swap(i, smallest);
            heapify(smallest);
        }
    }

    void swap(int i, int j) {
        int t = heap[i];
        heap[i] = heap[j];
        heap[j] = t;
    }


    public static void main(String[] args) {
        MinHeap heap=new MinHeap(4);
        heap.add(12);
        heap.add(5);
        heap.add(17);
        heap.add(2);
        System.out.println(Arrays.toString(heap.heap));
        System.out.println( heap.poll());
        System.out.println( heap.poll());
        System.out.println( heap.poll());
        heap.add(1);
        heap.add(10);
        System.out.println(Arrays.toString(heap.heap));
    }
}

