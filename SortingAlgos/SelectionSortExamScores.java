package DSA.Sorting_Algorithms;

public class SelectionSortExamScores {
    public static void selectionSort(int[] scores) {
        int n = scores.length;
        for (int i = 0; i < n - 1; i++) {
            int minIdx = i;
            for (int j = i + 1; j < n; j++) {
                if (scores[j] < scores[minIdx]) {
                    minIdx = j;
                }
            }
            int temp = scores[minIdx];
            scores[minIdx] = scores[i];
            scores[i] = temp;
        }
    }

    public static void main(String[] args) {
        int[] scores = {72, 88, 45, 93, 60};
        selectionSort(scores);
        for (int score : scores) {
            System.out.print(score + " ");
        }
    }
}

