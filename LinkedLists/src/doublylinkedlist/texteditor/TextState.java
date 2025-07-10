package doublylinkedlist.texteditor;

public class TextState {
    public String content;
    public TextState prev;
    public TextState next;

    public TextState(String content) {
        this.content = content;
    }
}
