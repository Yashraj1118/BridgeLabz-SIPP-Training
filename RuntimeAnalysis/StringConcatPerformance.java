public class StringConcatPerformance {
    public static void main(String[] args) {
        int N = 1_000_000;
        String word = "hello";

        // String concatenation
        long startString = System.nanoTime();
        String str = "";
        for (int i = 0; i < N; i++) {
            str += word;
        }
        long endString = System.nanoTime();
        System.out.println("String time (ms): " + (endString - startString) / 1_000_000.0);

        // StringBuilder
        long startSB = System.nanoTime();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < N; i++) {
            sb.append(word);
        }
        long endSB = System.nanoTime();
        System.out.println("StringBuilder time (ms): " + (endSB - startSB) / 1_000_000.0);

        // StringBuffer
        long startSBuf = System.nanoTime();
        StringBuffer sbuf = new StringBuffer();
        for (int i = 0; i < N; i++) {
            sbuf.append(word);
        }
        long endSBuf = System.nanoTime();
        System.out.println("StringBuffer time (ms): " + (endSBuf - startSBuf) / 1_000_000.0);
    }
}

