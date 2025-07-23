import java.util.*;

public class LinearVsBinarySearch {
    public static void main(String[] args) {
        int[] sizes = {1000, 10_000, 1_000_000};
        int target = -1;

        for (int size : sizes) {
            int[] data = new int[size];
            for (int i = 0; i < size; i++) {
                data[i] = i * 2;
            }

            // Linear search
            long startLinear = System.nanoTime();
            int linearResult = linearSearch(data, target);
            long endLinear = System.nanoTime();

            // Binary search
            Arrays.sort(data);
            long startBinary = System.nanoTime();
            int binaryResult = binarySearch(data, target);
            long endBinary = System.nanoTime();

            System.out.println("Dataset Size: " + size);
            System.out.println("Linear Search Time (ms): " + (endLinear - startLinear) / 1_000_000.0);
            System.out.println("Binary Search Time (ms): " + (endBinary - startBinary) / 1_000_000.0);
            System.out.println("-----------------------------");
        }
    }

    public static int linearSearch(int[] arr, int target) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == target) return i;
        }
        return -1;
    }

    public static int binarySearch(int[] arr, int target) {
        int left = 0, right = arr.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (arr[mid] == target) return mid;
            else if (arr[mid] < target) left = mid + 1;
            else right = mid - 1;
        }
        return -1;
    }
}

