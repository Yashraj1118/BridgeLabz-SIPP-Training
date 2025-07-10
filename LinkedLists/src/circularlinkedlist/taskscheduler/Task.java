package circularlinkedlist.taskscheduler;

public class Task {
    public int taskId;
    public String taskName;
    public int priority;
    public String dueDate;

    public Task next;

    public Task(int taskId, String taskName, int priority, String dueDate) {
        this.taskId = taskId;
        this.taskName = taskName;
        this.priority = priority;
        this.dueDate = dueDate;
        this.next = null;
    }
}
