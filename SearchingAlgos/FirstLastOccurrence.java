public class FirstLastOccurrence {
    public static int[] findFirstLast(int[] nums, int target) {
        return new int[] {
            findOccurrence(nums, target, true),
            findOccurrence(nums, target, false)
        };
    }

    private static int findOccurrence(int[] nums, int target, boolean first) {
        int left = 0, right = nums.length - 1, res = -1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] == target) {
                res = mid;
                if (first) right = mid - 1;
                else left = mid + 1;
            } else if (nums[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 2, 2, 3, 4};
        int[] res = findFirstLast(arr, 2);
        System.out.println("First: " + res[0] + ", Last: " + res[1]);
    }
}
