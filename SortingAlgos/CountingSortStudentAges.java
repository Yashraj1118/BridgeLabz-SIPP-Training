package DSA.Sorting_Algorithms;

public class CountingSortStudentAges {
    public static void countingSort(int[] ages) {
        int max = 18;
        int min = 10;
        int range = max - min + 1;

        int[] count = new int[range];
        int[] output = new int[ages.length];

        for (int age : ages) {
            count[age - min]++;
        }

        for (int i = 1; i < range; i++) {
            count[i] += count[i - 1];
        }

        for (int i = ages.length - 1; i >= 0; i--) {
            output[count[ages[i] - min] - 1] = ages[i];
            count[ages[i] - min]--;
        }

        System.arraycopy(output, 0, ages, 0, ages.length);
    }

    public static void main(String[] args) {
        int[] ages = {12, 16, 14, 10, 18, 12, 15};
        countingSort(ages);
        for (int age : ages) {
            System.out.print(age + " ");
        }
    }
}

