public class FibonacciComparison {
    public static void main(String[] args) {
        int N = 30;

        long startRec = System.nanoTime();
        int resultRec = fibonacciRecursive(N);
        long endRec = System.nanoTime();
        System.out.println("Recursive Fibonacci (" + N + "): " + resultRec +
                " in ms: " + (endRec - startRec) / 1_000_000.0);

        long startItr = System.nanoTime();
        int resultItr = fibonacciIterative(N);
        long endItr = System.nanoTime();
        System.out.println("Iterative Fibonacci (" + N + "): " + resultItr +
                " in ms: " + (endItr - startItr) / 1_000_000.0);
    }

    public static int fibonacciRecursive(int n) {
        if (n <= 1) return n;
        return fibonacciRecursive(n - 1) + fibonacciRecursive(n - 2);
    }

    public static int fibonacciIterative(int n) {
        if (n <= 1) return n;
        int a = 0, b = 1;
        for (int i = 2; i <= n; i++) {
            int sum = a + b;
            a = b;
            b = sum;
        }
        return b;
    }
}

