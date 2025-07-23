import java.io.*;

public class UserInputToFile {
    public static void main(String[] args) {
        try (InputStreamReader isr = new InputStreamReader(System.in);
            BufferedReader br = new BufferedReader(isr);
            FileWriter fw = new FileWriter("output.txt")) {

            String input;
            while (true) {
                System.out.print("Enter text (type 'exit' to quit): ");
                input = br.readLine();
                if ("exit".equalsIgnoreCase(input)) {
                    break;
                }
                fw.write(input + System.lineSeparator());
            }

            System.out.println("User input written to file.");

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

