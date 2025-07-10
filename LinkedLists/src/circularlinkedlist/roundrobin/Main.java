package circularlinkedlist.roundrobin;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scheduler scheduler = new Scheduler();
        Scanner sc = new Scanner(System.in);
        int ch;

        while (true) {
            System.out.println("1 Add Process");
            System.out.println("2 Show All Processes");
            System.out.println("3 Run Round Robin Scheduling");
            System.out.println("0 Exit");
            ch = sc.nextInt();

            if (ch == 0) break;

            if (ch == 1) {
                System.out.print("Enter Process ID, Burst Time, Priority: ");
                scheduler.addProcess(sc.nextInt(), sc.nextInt(), sc.nextInt());
            } else if (ch == 2) {
                scheduler.displayProcesses();
            } else if (ch == 3) {
                scheduler.simulateScheduling();
            }
        }
    }
}

