package circularlinkedlist.roundrobin;

public class Scheduler {
    public Process head = null;
    public Process tail = null;
    public int timeQuantum = 2;

    public void addProcess(int id, int burst, int priority) {
        Process p = new Process(id, burst, priority);
        if (head == null) {
            head = tail = p;
            p.next = p;
        } else {
            tail.next = p;
            p.next = head;
            tail = p;
        }
    }

    public void removeProcess(Process target) {
        if (head == null || target == null) return;

        if (head == target && head.next == head) {
            head = tail = null;
            return;
        }

        Process prev = tail;
        Process curr = head;

        do {
            if (curr == target) {
                prev.next = curr.next;
                if (curr == head) head = curr.next;
                if (curr == tail) tail = prev;
                return;
            }
            prev = curr;
            curr = curr.next;
        } while (curr != head);
    }

    public void displayProcesses() {
        if (head == null) {
            System.out.println("No processes in queue");
            return;
        }

        Process temp = head;
        do {
            System.out.println("PID: " + temp.processId + " | BT: " + temp.burstTime + " | RT: " + temp.remainingTime + " | Priority: " + temp.priority);
            temp = temp.next;
        } while (temp != head);
    }

    public void simulateScheduling() {
        if (head == null) return;

        int time = 0;
        Process current = head;

        while (head != null) {
            if (current.remainingTime <= timeQuantum) {
                time += current.remainingTime;
                current.remainingTime = 0;
                current.turnaroundTime = time;
                current.waitingTime = current.turnaroundTime - current.burstTime;

                System.out.println("Process " + current.processId + " completed at time " + time);
                Process next = current.next;
                removeProcess(current);
                if (head == null) break;
                current = next;
            } else {
                current.remainingTime -= timeQuantum;
                time += timeQuantum;
                System.out.println("Process " + current.processId + " ran for " + timeQuantum + " units");
                current = current.next;
            }

            displayProcesses();
        }
    }

    public void calculateAndPrintAvgTimes() {
        int totalWaiting = 0, totalTurnaround = 0, count = 0;
        Process temp = head;

        if (temp == null) {
            System.out.println("No processes to calculate times.");
            return;
        }

        do {
            totalWaiting += temp.waitingTime;
            totalTurnaround += temp.turnaroundTime;
            count++;
            temp = temp.next;
        } while (temp != head);

        System.out.println("Average Waiting Time: " + (totalWaiting * 1.0 / count));
        System.out.println("Average Turnaround Time: " + (totalTurnaround * 1.0 / count));
    }
}
