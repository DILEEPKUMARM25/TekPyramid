package DSA.Assiagnment.heap;

import java.util.*;

public class MedianFinder {

    private PriorityQueue<Integer> maxHeap; // lower half
    private PriorityQueue<Integer> minHeap; // higher half

    public MedianFinder() {
        maxHeap = new PriorityQueue<>(Collections.reverseOrder());
        minHeap = new PriorityQueue<>();
    }

    // Add number
    public void addNum(int num) {

        // Step 1: Push to maxHeap first
        maxHeap.add(num);

        // Step 2: Balance by moving largest of left to right
        minHeap.add(maxHeap.poll());

        // Step 3: Ensure maxHeap is always larger or equal
        if (minHeap.size() > maxHeap.size()) {
            maxHeap.add(minHeap.poll());
        }
    }

    // Get Median
    public double findMedian() {
        if (maxHeap.size() == minHeap.size()) {
            return (maxHeap.peek() + minHeap.peek()) / 2.0;
        } else {
            return maxHeap.peek();
        }
    }

    public static void main(String[] args) {
        MedianFinder mf = new MedianFinder();

        mf.addNum(5);
        mf.addNum(15);
        mf.addNum(1);
        mf.addNum(3);

        System.out.println(mf.findMedian());  // Output: 4.0
    }
}
