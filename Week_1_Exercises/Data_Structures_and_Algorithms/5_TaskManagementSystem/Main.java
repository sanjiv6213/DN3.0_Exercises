// Main.java
public class Main {
    public static void main(String[] args) {
        TaskLinkedList taskList = new TaskLinkedList();

        // Adding tasks
        taskList.addTask(new Task(1, "Task 1", "Incomplete"));
        taskList.addTask(new Task(2, "Task 2", "Complete"));
        taskList.addTask(new Task(3, "Task 3", "Incomplete"));

        // Traversing tasks
        System.out.println("Tasks in the list:");
        taskList.traverseTasks();

        // Searching for a task
        System.out.println("\nSearching for Task with ID 2:");
        Task task = taskList.searchTask(2);
        if (task != null) {
            System.out.println("Found: " + task);
        } else {
            System.out.println("Task not found.");
        }

        // Deleting a task
        System.out.println("\nDeleting Task with ID 2:");
        boolean deleted = taskList.deleteTask(2);
        if (deleted) {
            System.out.println("Task deleted successfully.");
        } else {
            System.out.println("Task not found.");
        }

        // Traversing tasks after deletion
        System.out.println("\nTasks in the list after deletion:");
        taskList.traverseTasks();
    }
}
