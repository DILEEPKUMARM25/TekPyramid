package DSA.Assiagnment.Monotonic;

import java.util.*;

public class MonotonicStack {

    // Next Greater Element: return array of same length with next greater or -1
    public static int[] nextGreaterElement(int[] arr) {
        int n = arr.length;
        int[] res = new int[n];
        Arrays.fill(res, -1);
        Deque<Integer> st = new ArrayDeque<>(); // store indices

        for (int i = 0; i < n; i++) {
            while (!st.isEmpty() && arr[st.peek()] < arr[i]) {
                res[st.pop()] = arr[i];
            }
            st.push(i);
        }
        return res;
    }

    // quick demo
    public static void main(String[] args) {
        int[] a = {4, 5, 2, 10, 8};
        System.out.println(Arrays.toString(nextGreaterElement(a))); // [5,10,10,-1,-1]
    }
}

