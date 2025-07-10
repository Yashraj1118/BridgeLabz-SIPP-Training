package circularlinkedlist.taskscheduler;

public class TaskScheduler {
    public Task head = null;
    public Task tail = null;
    public Task current = null;

    public void addAtBeginning(int id, String name, int priority, String date) {
        Task t = new Task(id, name, priority, date);
        if (head == null) {
            head = tail = t;
            t.next = t;
        } else {
            t.next = head;
            tail.next = t;
            head = t;
        }
    }

    public void addAtEnd(int id, String name, int priority, String date) {
        Task t = new Task(id, name, priority, date);
        if (head == null) {
            head = tail = t;
            t.next = t;
        } else {
            tail.next = t;
            t.next = head;
            tail = t;
        }
    }

    public void addAtPosition(int id, String name, int priority, String date, int pos) {
        if (pos <= 0 || head == null) {
            addAtBeginning(id, name, priority, date);
            return;
        }

        Task temp = head;
        for (int i = 0; i < pos - 1 && temp.next != head; i++) {
            temp = temp.next;
        }

        if (temp.next == head) {
            addAtEnd(id, name, priority, date);
        } else {
            Task t = new Task(id, name, priority, date);
            t.next = temp.next;
            temp.next = t;
        }
    }

    public void removeById(int id) {
        if (head == null) return;

        Task temp = head;
        Task prev = tail;

        do {
            if (temp.taskId == id) {
                if (temp == head && temp == tail) {
                    head = tail = null;
                } else if (temp == head) {
                    head = head.next;
                    tail.next = head;
                } else if (temp == tail) {
                    tail = prev;
                    tail.next = head;
                } else {
                    prev.next = temp.next;
                }

                System.out.println("Task removed: " + id);
                return;
            }
            prev = temp;
            temp = temp.next;
        } while (temp != head);

        System.out.println("Task not found");
    }

    public void viewCurrentTask() {
        if (current == null) {
            current = head;
        }

        if (current != null) {
            System.out.println(current.taskId + " | " + current.taskName + " | Priority: " + current.priority + " | Due: " + current.dueDate);
        } else {
            System.out.println("No tasks in scheduler");
        }
    }

    public void moveToNextTask() {
        if (current != null) {
            current = current.next;
            viewCurrentTask();
        } else {
            System.out.println("No tasks in scheduler");
        }
    }

    public void displayAllTasks() {
        if (head == null) {
            System.out.println("No tasks to display");
            return;
        }

        Task temp = head;
        do {
            System.out.println(temp.taskId + " | " + temp.taskName + " | Priority: " + temp.priority + " | Due: " + temp.dueDate);
            temp = temp.next;
        } while (temp != head);
    }

    public void searchByPriority(int priority) {
        if (head == null) {
            System.out.println("No tasks available");
            return;
        }

        Task temp = head;
        boolean found = false;
        do {
            if (temp.priority == priority) {
                System.out.println(temp.taskId + " | " + temp.taskName + " | Due: " + temp.dueDate);
                found = true;
            }
            temp = temp.next;
        } while (temp != head);

        if (!found) System.out.println("No tasks with priority: " + priority);
    }
}
