package circularlinkedlist.roundrobin;

public class Process {
    public int processId;
    public int burstTime;
    public int remainingTime;
    public int priority;
    public int waitingTime = 0;
    public int turnaroundTime = 0;

    public Process next;

    public Process(int processId, int burstTime, int priority) {
        this.processId = processId;
        this.burstTime = burstTime;
        this.remainingTime = burstTime;
        this.priority = priority;
    }
}

