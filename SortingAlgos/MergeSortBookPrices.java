package DSA.Sorting_Algorithms;

public class MergeSortBookPrices {
    public static void mergeSort(int[] prices, int left, int right) {
        if (left < right) {
            int mid = left + (right - left) / 2;
            mergeSort(prices, left, mid);
            mergeSort(prices, mid + 1, right);
            merge(prices, left, mid, right);
        }
    }

    private static void merge(int[] prices, int left, int mid, int right) {
        int n1 = mid - left + 1;
        int n2 = right - mid;

        int[] L = new int[n1];
        int[] R = new int[n2];

        System.arraycopy(prices, left, L, 0, n1);
        System.arraycopy(prices, mid + 1, R, 0, n2);

        int i = 0, j = 0, k = left;

        while (i < n1 && j < n2) {
            if (L[i] <= R[j]) {
                prices[k] = L[i];
                i++;
            } else {
                prices[k] = R[j];
                j++;
            }
            k++;
        }

        while (i < n1) {
            prices[k] = L[i];
            i++;
            k++;
        }

        while (j < n2) {
            prices[k] = R[j];
            j++;
            k++;
        }
    }

    public static void main(String[] args) {
        int[] prices = {450, 200, 300, 150, 500};
        mergeSort(prices, 0, prices.length - 1);
        for (int price : prices) {
            System.out.print(price + " ");
        }
    }
}

