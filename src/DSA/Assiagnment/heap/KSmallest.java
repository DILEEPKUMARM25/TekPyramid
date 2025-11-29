package DSA.Assiagnment.heap;

import java.util.*;

public class KSmallest {
    public static List<Integer> kSmallest(int[] arr, int k) {
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());

        for (int num : arr) {
            maxHeap.add(num);

            if (maxHeap.size() > k)
                maxHeap.poll(); // remove largest
        }

        return new ArrayList<>(maxHeap);
    }

    public static void main(String[] args) {
        int[] arr = {10, 3, 5, 2, 8, 15};
        int k = 3;
        System.out.println(kSmallest(arr, k));  // output: [5, 3, 2]
    }
}
