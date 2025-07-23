import java.io.*;

public class CountWordInFile {
    public static void main(String[] args) {
        String target = "hello";
        int count = 0;

        try (FileReader fr = new FileReader("input.txt");
            BufferedReader br = new BufferedReader(fr)) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] words = line.split("\\s+");
                for (String word : words) {
                    if (word.equals(target)) {
                        count++;
                    }
                }
            }
            System.out.println("Occurrences of \"" + target + "\": " + count);

        } 
        catch (IOException e) {
            e.printStackTrace();
        }
    }
}

