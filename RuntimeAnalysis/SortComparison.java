import java.util.*;

public class SortComparison {
    public static void main(String[] args) {
        int[] sizes = {1000, 10_000, 1_000_000};

        for (int size : sizes) {
            int[] arr = generateRandomArray(size);

            // Bubble Sort
            if (size <= 10_000) {
                int[] copyBubble = Arrays.copyOf(arr, arr.length);
                long startBubble = System.nanoTime();
                bubbleSort(copyBubble);
                long endBubble = System.nanoTime();
                System.out.println("Bubble Sort time for " + size + " elements: " +
                        (endBubble - startBubble) / 1_000_000.0 + " ms");
            } else {
                System.out.println("Bubble Sort for " + size + " elements: Skipped (Unfeasible)");
            }

            // Merge Sort
            int[] copyMerge = Arrays.copyOf(arr, arr.length);
            long startMerge = System.nanoTime();
            Arrays.sort(copyMerge);
            long endMerge = System.nanoTime();
            System.out.println("Merge Sort time for " + size + " elements: " +
                    (endMerge - startMerge) / 1_000_000.0 + " ms");

            // Quick Sort
            int[] copyQuick = Arrays.copyOf(arr, arr.length);
            long startQuick = System.nanoTime();
            quickSort(copyQuick, 0, copyQuick.length - 1);
            long endQuick = System.nanoTime();
            System.out.println("Quick Sort time for " + size + " elements: " +
                    (endQuick - startQuick) / 1_000_000.0 + " ms");

            System.out.println("-----------------------------");
        }
    }

    private static int[] generateRandomArray(int size) {
        Random rand = new Random();
        int[] arr = new int[size];
        for (int i = 0; i < size; i++) {
            arr[i] = rand.nextInt();
        }
        return arr;
    }

    public static void bubbleSort(int[] arr) {
        int n = arr.length;
        for (int i = 0; i < n-1; i++) {
            for (int j = 0; j < n-i-1; j++) {
                if (arr[j] > arr[j+1]) {
                    int temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;
                }
            }
        }
    }

    public static void quickSort(int[] arr, int low, int high) {
        if (low < high) {
            int pi = partition(arr, low, high);
            quickSort(arr, low, pi - 1);
            quickSort(arr, pi + 1, high);
        }
    }

    public static int partition(int[] arr, int low, int high) {
        int pivot = arr[high];
        int i = low - 1;
        for (int j = low; j < high; j++) {
            if (arr[j] < pivot) {
                i++;
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }
        int temp = arr[i+1];
        arr[i+1] = arr[high];
        arr[high] = temp;
        return i+1;
    }
}

