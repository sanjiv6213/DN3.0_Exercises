public class Main {

    public static void main(String[] args) {
        EmployeeManagementSystem ems = new EmployeeManagementSystem(5);

        Employee emp1 = new Employee(1, "Alice", "Developer", 60000);
        Employee emp2 = new Employee(2, "Bob", "Manager", 80000);
        Employee emp3 = new Employee(3, "Charlie", "Analyst", 55000);

        // Adding employees
        ems.addEmployee(emp1);
        ems.addEmployee(emp2);
        ems.addEmployee(emp3);

        // Traversing employees
        System.out.println("All Employees:");
        ems.traverseEmployees();

        // Searching for an employee
        System.out.println("\nSearching for employee with ID 2:");
        Employee searchResult = ems.searchEmployeeById(2);
        if (searchResult != null) {
            System.out.println(searchResult);
        } else {
            System.out.println("Employee not found.");
        }

        // Deleting an employee
        System.out.println("\nDeleting employee with ID 1:");
        ems.deleteEmployeeById(1);
        ems.traverseEmployees();
    }
}
