package DSA.Assiagnment.heap;

import java.util.*;

public class KLargest {
    public static List<Integer> kLargest(int[] arr, int k) {
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();

        for (int num : arr) {
            minHeap.add(num);

            if (minHeap.size() > k)
                minHeap.poll(); // remove smallest
        }

        return new ArrayList<>(minHeap);
    }

    public static void main(String[] args) {
        int[] arr = {10, 3, 5, 2, 8, 15};
        int k = 3;
        System.out.println(kLargest(arr, k));  // output: [8, 10, 15]
    }
}

