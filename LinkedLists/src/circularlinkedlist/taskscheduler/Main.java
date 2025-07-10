package circularlinkedlist.taskscheduler;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        TaskScheduler scheduler = new TaskScheduler();
        Scanner sc = new Scanner(System.in);
        int ch;

        while (true) {
            System.out.println("1 Add Task at Beginning");
            System.out.println("2 Add Task at End");
            System.out.println("3 Add Task at Position");
            System.out.println("4 Remove Task by ID");
            System.out.println("5 View Current Task");
            System.out.println("6 Move to Next Task");
            System.out.println("7 Display All Tasks");
            System.out.println("8 Search by Priority");
            System.out.println("0 Exit");
            ch = sc.nextInt();

            if (ch == 0) break;

            if (ch == 1) {
                System.out.print("Enter ID, Name, Priority, DueDate: ");
                scheduler.addAtBeginning(sc.nextInt(), sc.next(), sc.nextInt(), sc.next());
            } else if (ch == 2) {
                System.out.print("Enter ID, Name, Priority, DueDate: ");
                scheduler.addAtEnd(sc.nextInt(), sc.next(), sc.nextInt(), sc.next());
            } else if (ch == 3) {
                System.out.print("Enter ID, Name, Priority, DueDate, Position: ");
                scheduler.addAtPosition(sc.nextInt(), sc.next(), sc.nextInt(), sc.next(), sc.nextInt());
            } else if (ch == 4) {
                System.out.print("Enter Task ID to remove: ");
                scheduler.removeById(sc.nextInt());
            } else if (ch == 5) {
                scheduler.viewCurrentTask();
            } else if (ch == 6) {
                scheduler.moveToNextTask();
            } else if (ch == 7) {
                scheduler.displayAllTasks();
            } else if (ch == 8) {
                System.out.print("Enter Priority: ");
                scheduler.searchByPriority(sc.nextInt());
            }
        }
    }
}

