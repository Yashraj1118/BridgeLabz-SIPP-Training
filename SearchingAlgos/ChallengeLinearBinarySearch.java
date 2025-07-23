import java.util.*;

public class ChallengeLinearBinarySearch {
    public static int findFirstMissingPositive(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int num : nums) {
            if (num > 0) set.add(num);
        }

        int i = 1;
        while (true) {
            if (!set.contains(i)) return i;
            i++;
        }
    }

    public static int binarySearch(int[] arr, int target) {
        Arrays.sort(arr);
        int left = 0, right = arr.length - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (arr[mid] == target) {
                return mid;
            } else if (arr[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] arr = {3, 4, -1, 1};
        System.out.println("First missing positive: " + findFirstMissingPositive(arr));

        int target = 4;
        System.out.println("Index of " + target + ": " + binarySearch(arr, target));
    }
}

