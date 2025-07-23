import java.io.*;

public class FileReaderVsInputStreamReader {
    public static void main(String[] args) throws IOException {
        String filename = "largefile.txt";

        // FileReader test
        long startFR = System.nanoTime();
        int countFR = readUsingFileReader(filename);
        long endFR = System.nanoTime();

        System.out.println("FileReader read " + countFR + " chars in ms: " + (endFR - startFR) / 1_000_000.0);

        // InputStreamReader test
        long startISR = System.nanoTime();
        int countISR = readUsingInputStreamReader(filename);
        long endISR = System.nanoTime();

        System.out.println("InputStreamReader read " + countISR + " chars in ms: " + (endISR - startISR) / 1_000_000.0);
    }

    private static int readUsingFileReader(String fileName) throws IOException {
        int count = 0;
        try (FileReader fr = new FileReader(fileName);
            BufferedReader br = new BufferedReader(fr)) {
            while (br.readLine() != null) {
                count++;
            }
        }
        return count;
    }

    private static int readUsingInputStreamReader(String fileName) throws IOException {
        int count = 0;
        try (FileInputStream fis = new FileInputStream(fileName);
            InputStreamReader isr = new InputStreamReader(fis, "UTF-8");
            BufferedReader br = new BufferedReader(isr)) {
            while (br.readLine() != null) {
                count++;
            }
        }
        return count;
    }
}

