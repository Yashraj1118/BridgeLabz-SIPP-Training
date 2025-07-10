package doublylinkedlist.texteditor;

public class EditorHistory {
    public TextState head;
    public TextState tail;
    public TextState current;
    public int size = 0;
    public final int MAX_HISTORY = 10;

    public void addState(String content) {
        TextState newState = new TextState(content);

        if (current != null && current.next != null) {
            current.next.prev = null;
            current.next = null;
        }

        if (head == null) {
            head = tail = current = newState;
        } else {
            current.next = newState;
            newState.prev = current;
            current = newState;
            tail = current;
        }

        size++;
        if (size > MAX_HISTORY) {
            head = head.next;
            head.prev = null;
            size--;
        }
    }

    public void undo() {
        if (current != null && current.prev != null) {
            current = current.prev;
            System.out.println("Undo performed");
        } else {
            System.out.println("Nothing to undo");
        }
    }

    public void redo() {
        if (current != null && current.next != null) {
            current = current.next;
            System.out.println("Redo performed");
        } else {
            System.out.println("Nothing to redo");
        }
    }

    public void showCurrent() {
        if (current != null) {
            System.out.println("Current text: " + current.content);
        } else {
            System.out.println("Editor is empty");
        }
    }
}
