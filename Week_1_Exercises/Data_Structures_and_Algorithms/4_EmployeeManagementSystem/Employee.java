// Employee.java
public class Employee {
    private int employeeId;
    private String name;
    private String position;
    private double salary;

    // Constructor
    public Employee(int employeeId, String name, String position, double salary) {
        this.employeeId = employeeId;
        this.name = name;
        this.position = position;
        this.salary = salary;
    }

    // Getters and Setters
   
    public void setEmployeeId(int employeeId) {
        this.employeeId = employeeId;
    }
    public void setSalary(double salary) {
        this.salary = salary;
    }
    public void setName(String name) {
        this.name = name;
    }
    public void setPosition(String position) {
        this.position = position;
    }

    public String getName() {
        return name;
    }
    public int getEmployeeId() {
        return employeeId;
    }
    public String getPosition() {
        return position;
    }
    public double getSalary() {
        return salary;
    }

   
    @Override
    public String toString() {
        return "EmployeeId: " + employeeId + ", Name: " + name + ", Position: " + position + ", Salary: " + salary;
    }
}
