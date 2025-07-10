package singlylinkedlist.studentrecord;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StudentList list = new StudentList();

        while (true) {
            System.out.println("\n1. Add First\n2. Add Last\n3. Add At Pos");
            System.out.println("4. Delete by Roll\n5. Search by Roll\n6. Update Grade");
            System.out.println("7. Display\n8. Exit");
            int ch = sc.nextInt();

            if (ch == 8) break;

            int roll, age, pos;
            String name, grade;

            switch (ch) {
                case 1:
                    System.out.print("Enter Roll, Name, Age, Grade: ");
                    roll = sc.nextInt(); name = sc.next(); age = sc.nextInt(); grade = sc.next();
                    Student s1 = new Student(roll, age, name, grade);
                    list.addFirst(s1);
                    break;
                case 2:
                    System.out.print("Enter Roll, Name, Age, Grade: ");
                    roll = sc.nextInt(); name = sc.next(); age = sc.nextInt(); grade = sc.next();
                    Student s2 = new Student(roll, age, name, grade);
                    list.addLast(s2);
                    break;
                case 3:
                    System.out.print("Enter Roll, Name, Age, Grade: ");
                    roll = sc.nextInt(); name = sc.next(); age = sc.nextInt(); grade = sc.next();
                    Student s3 = new Student(roll, age, name, grade);
                    System.out.print("Enter Position: ");
                    pos = sc.nextInt();
                    list.addAtPos(s3, pos);
                    break;
                case 4:
                    System.out.print("Enter Roll to delete: ");
                    roll = sc.nextInt();
                    list.deleteByRoll(roll);
                    break;
                case 5:
                    System.out.print("Enter Roll to search: ");
                    roll = sc.nextInt();
                    list.searchByRoll(roll);
                    break;
                case 6:
                    System.out.print("Enter Roll and New Grade: ");
                    roll = sc.nextInt(); grade = sc.next();
                    list.updateGrade(roll, grade);
                    break;
                case 7:
                    list.display();
                    break;
                default:
                    System.out.println("Invalid");
            }
        }

    }
}
