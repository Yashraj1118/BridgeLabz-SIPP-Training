import java.io.*;

public class FileReadLineByLine {
    public static void main(String[] args) {
        try (FileReader fr = new FileReader("input.txt");
            BufferedReader br = new BufferedReader(fr)) {
            
            String line;
            while ((line = br.readLine()) != null) {
                System.out.println(line);
            }
            
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

