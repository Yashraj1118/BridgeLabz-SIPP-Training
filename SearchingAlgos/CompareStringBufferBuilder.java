public class CompareStringBufferBuilder {
    public static void main(String[] args) {
        int N = 1_000_000;
        String word = "hello";

        // Test StringBuffer
        long startBuffer = System.nanoTime();
        StringBuffer sbf = new StringBuffer();
        for (int i = 0; i < N; i++) {
            sbf.append(word);
        }
        long endBuffer = System.nanoTime();

        // Test StringBuilder
        long startBuilder = System.nanoTime();
        StringBuilder sbd = new StringBuilder();
        for (int i = 0; i < N; i++) {
            sbd.append(word);
        }
        long endBuilder = System.nanoTime();

        System.out.println("StringBuffer time (ms): " + (endBuffer - startBuffer) / 1_000_000);
        System.out.println("StringBuilder time (ms): " + (endBuilder - startBuilder) / 1_000_000);
    }
}

