import java.io.*;
import java.util.*;

public class ChallengeProblem {
    public static void main(String[] args) throws IOException {
        int N = 1_000_000;
        String word = "hello";

        // StringBuilder test
        long startBuilder = System.nanoTime();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < N; i++) {
            sb.append(word);
        }
        long endBuilder = System.nanoTime();

        // StringBuffer test
        long startBuffer = System.nanoTime();
        StringBuffer sbf = new StringBuffer();
        for (int i = 0; i < N; i++) {
            sbf.append(word);
        }
        long endBuffer = System.nanoTime();

        System.out.println("StringBuilder time (ms): " + (endBuilder - startBuilder) / 1_000_000);
        System.out.println("StringBuffer time (ms): " + (endBuffer - startBuffer) / 1_000_000);

        // FileReader word count
        long startFR = System.nanoTime();
        int wordCountFR = countWordsUsingFileReader("bigfile.txt");
        long endFR = System.nanoTime();

        long startISR = System.nanoTime();
        int wordCountISR = countWordsUsingInputStreamReader("bigfile.txt");
        long endISR = System.nanoTime();

        System.out.println("FileReader word count: " + wordCountFR + ", time (ms): " + (endFR - startFR) / 1_000_000);
        System.out.println("InputStreamReader word count: " + wordCountISR + ", time (ms): " + (endISR - startISR) / 1_000_000);
    }

    public static int countWordsUsingFileReader(String fileName) throws IOException {
        int count = 0;
        try (FileReader fr = new FileReader(fileName);
            BufferedReader br = new BufferedReader(fr)) {
            String line;
            while ((line = br.readLine()) != null) {
                count += line.split("\\s+").length;
            }
        }
        return count;
    }

    public static int countWordsUsingInputStreamReader(String fileName) throws IOException {
        int count = 0;
        try (FileInputStream fis = new FileInputStream(fileName);
            InputStreamReader isr = new InputStreamReader(fis, "UTF-8");
            BufferedReader br = new BufferedReader(isr)) {
            String line;
            while ((line = br.readLine()) != null) {
                count += line.split("\\s+").length;
            }
        }
        return count;
    }
}

