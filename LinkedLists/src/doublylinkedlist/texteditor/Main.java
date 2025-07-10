package doublylinkedlist.texteditor;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        EditorHistory editor = new EditorHistory();
        Scanner sc = new Scanner(System.in);
        int ch;

        while (true) {
            System.out.println("1 Type Text");
            System.out.println("2 Undo");
            System.out.println("3 Redo");
            System.out.println("4 Show Current State");
            System.out.println("0 Exit");
            ch = sc.nextInt();
            sc.nextLine();

            if (ch == 0) break;

            if (ch == 1) {
                System.out.print("Enter text: ");
                String newText = sc.nextLine();
                editor.addState(newText);
            } else if (ch == 2) {
                editor.undo();
            } else if (ch == 3) {
                editor.redo();
            } else if (ch == 4) {
                editor.showCurrent();
            }
        }
    }
}

