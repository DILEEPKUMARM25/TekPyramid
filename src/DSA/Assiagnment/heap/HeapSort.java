package DSA.Assiagnment.heap;

public class HeapSort {

    public static void heapSort(int[] arr) {
        int n = arr.length;

        // Step 1: Build max heap
        for (int i = n / 2 - 1; i >= 0; i--) {
            heapify(arr, n, i);
        }

        // Step 2: One by one extract root (largest) and move to end
        for (int i = n - 1; i > 0; i--) {
            // Swap arr[0] with arr[i]
            int temp = arr[0];
            arr[0] = arr[i];
            arr[i] = temp;

            // Heapify on reduced heap
            heapify(arr, i, 0);
        }
    }

    // Heapify a subtree rooted at index i, heap size = n
    public static void heapify(int[] arr, int n, int i) {
        int largest = i;
        int left = 2 * i + 1;
        int right = 2 * i + 2;

        // If left child larger
        if (left < n && arr[left] > arr[largest]) {
            largest = left;
        }

        // If right child larger
        if (right < n && arr[right] > arr[largest]) {
            largest = right;
        }

        // If largest is not root
        if (largest != i) {
            int temp = arr[i];
            arr[i] = arr[largest];
            arr[largest] = temp;

            // Recursively heapify affected subtree
            heapify(arr, n, largest);
        }
    }

    public static void main(String[] args) {
        int[] arr = {12, 11, 13, 5, 6, 7};

        heapSort(arr);

        System.out.print("Sorted: ");
        for (int x : arr) {
            System.out.print(x + " ");
        }
    }
}
