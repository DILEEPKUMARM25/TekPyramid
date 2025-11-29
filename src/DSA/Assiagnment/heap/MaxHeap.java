package DSA.Assiagnment.heap;

import java.util.Arrays;

class MaxHeap {
    int[] heap;
    int size;

    MaxHeap(int capacity) {
        heap = new int[capacity];
        size = 0;
    }

    int parent(int i) { return (i - 1) / 2; }
    int left(int i) { return 2 * i + 1; }
    int right(int i) { return 2 * i + 2; }

    void add(int val) {
        heap[size] = val;
        int i = size;
        size++;

        while (i > 0 && heap[parent(i)] < heap[i]) {
            swap(i, parent(i));
            i = parent(i);
        }
    }

    int poll() {
        if (size == 0) return -1;

        int root = heap[0];
        heap[0] = heap[size - 1];
        size--;

        heapify(0);
        return root;
    }

    void heapify(int i) {
        int largest = i;
        int l = left(i);
        int r = right(i);

        if (l < size && heap[l] > heap[largest]) largest = l;
        if (r < size && heap[r] > heap[largest]) largest = r;

        if (largest != i) {
            swap(i, largest);
            heapify(largest);
        }
    }

    void swap(int i, int j) {
        int t = heap[i];
        heap[i] = heap[j];
        heap[j] = t;
    }


    public static void main(String[] args) {
        MaxHeap a=new MaxHeap(5);
        a.add(10);
        a.add(5);
        System.out.println(a.poll() );
        System.out.println(Arrays.toString(a.heap));
    }
}
