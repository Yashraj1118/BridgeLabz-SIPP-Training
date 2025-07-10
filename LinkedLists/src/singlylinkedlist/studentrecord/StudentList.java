package singlylinkedlist.studentrecord;

public class StudentList {
    Student head;

    public void addFirst(Student s) {
        s.next = head;
        head = s;
    }

    public void addLast(Student s) {
        if (head == null) {
            head = s;
            return;
        }
        Student temp = head;
        while (temp.next != null) {
            temp = temp.next;
        }
        temp.next = s;
    }

    public void addAtPos(Student s, int pos) {
        if (pos <= 1 || head == null) {
            addFirst(s);
            return;
        }
        Student temp = head;
        for (int i = 1; i < pos - 1 && temp.next != null; i++) {
            temp = temp.next;
        }
        s.next = temp.next;
        temp.next = s;
    }

    public void deleteByRoll(int roll) {
        if (head == null) return;

        if (head.roll == roll) {
            head = head.next;
            return;
        }

        Student temp = head;
        while (temp.next != null && temp.next.roll != roll) {
            temp = temp.next;
        }

        if (temp.next != null) {
            temp.next = temp.next.next;
        } else {
            System.out.println("Roll not found");
        }
    }

    public void searchByRoll(int roll) {
        Student temp = head;
        while (temp != null) {
            if (temp.roll == roll) {
                System.out.println("Found: " + temp.roll + " " + temp.Name + " " + temp.age + " " + temp.Grade);
                return;
            }
            temp = temp.next;
        }
        System.out.println("Not found");
    }

    public void updateGrade(int roll, String grade) {
        Student temp = head;
        while (temp != null) {
            if (temp.roll == roll) {
                temp.Grade = grade;
                System.out.println("Grade updated");
                return;
            }
            temp = temp.next;
        }
        System.out.println("Not found");
    }

    public void display() {
        if (head == null) {
            System.out.println("List is empty");
            return;
        }
        Student temp = head;
        while (temp != null) {
            System.out.println(temp.roll + " " + temp.Name + " " + temp.age + " " + temp.Grade);
            temp = temp.next;
        }
    }
}
