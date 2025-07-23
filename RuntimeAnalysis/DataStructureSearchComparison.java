import java.util.*;

public class DataStructureSearchComparison {
    public static void main(String[] args) {
        int[] sizes = {1000, 100_000, 1_000_000};
        int target = -1;

        for (int size : sizes) {
            int[] arr = new int[size];
            Set<Integer> hashSet = new HashSet<>();
            Set<Integer> treeSet = new TreeSet<>();

            for (int i = 0; i < size; i++) {
                arr[i] = i * 2;
                hashSet.add(arr[i]);
                treeSet.add(arr[i]);
            }

            // Array search
            long startArray = System.nanoTime();
            boolean foundArray = arraySearch(arr, target);
            long endArray = System.nanoTime();

            // HashSet search
            long startHashSet = System.nanoTime();
            boolean foundHashSet = hashSet.contains(target);
            long endHashSet = System.nanoTime();

            // TreeSet search
            long startTreeSet = System.nanoTime();
            boolean foundTreeSet = treeSet.contains(target);
            long endTreeSet = System.nanoTime();

            System.out.println("Size: " + size);
            System.out.println("Array search (ms): " + (endArray - startArray) / 1_000_000.0);
            System.out.println("HashSet search (ms): " + (endHashSet - startHashSet) / 1_000_000.0);
            System.out.println("TreeSet search (ms): " + (endTreeSet - startTreeSet) / 1_000_000.0);
            System.out.println("-----------------------------");
        }
    }

    public static boolean arraySearch(int[] arr, int target) {
        for (int num : arr) {
            if (num == target) return true;
        }
        return false;
    }
}

