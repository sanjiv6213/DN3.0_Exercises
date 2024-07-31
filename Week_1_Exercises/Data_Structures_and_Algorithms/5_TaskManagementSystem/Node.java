// Node.java
public class Node {
    private Task task;
    private Node next;

    // Constructor
    public Node(Task task) {
        this.task = task;
        this.next = null;
    }

    // Getters and Setters
    public Task getTask() {
        return task;
    }

    public void setTask(Task task) {
        this.task = task;
    }

    public Node getNext() {
        return next;
    }

    public void setNext(Node next) {
        this.next = next;
    }
}
