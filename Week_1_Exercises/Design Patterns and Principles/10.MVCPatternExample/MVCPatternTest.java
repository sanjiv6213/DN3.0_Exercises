package MVCPatternExample;

public class MVCPatternTest {
    public static void main(String[] args) {
        // Fetch student record based on his/her ID from the database
        Student model = retrieveStudentFromDatabase();

        // Create a view to write student details on console
        StudentView view = new StudentView();

        // Create a controller
        StudentController controller = new StudentController(model, view);

        // Display initial details
        controller.updateView();

        // Update model data
        controller.setStudentName("John Doe");
        controller.setStudentGrade("A");

        // Display updated details
        controller.updateView();
    }

    private static Student retrieveStudentFromDatabase() {
        return new Student("1", "Jane Smith", "B");
    }
}