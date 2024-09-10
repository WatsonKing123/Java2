import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
class Employee {
    private String name;
    private int age;

    public Employee(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}

class EmployeeManager {
    private List<Employee> employeeList = new ArrayList<>();

    public void addEmployee(String name, int age) {
        // Check if the employee with the same name already exists
        for (Employee employee : employeeList) {
            if (employee.getName().equalsIgnoreCase(name)) {
                System.out.println("Employee with name '" + name + "' already exists. Cannot add duplicate.");
                return;
            }
        }
        Employee employee = new Employee(name, age);
        employeeList.add(employee);
        System.out.println("Employee " + name + " added successfully.");
    }

    public void deleteEmployee(String name) {
        employeeList.removeIf(employee -> employee.getName().equalsIgnoreCase(name));
    }

    public void printEmployees() {
        Collections.sort(employeeList, Comparator.comparing(Employee::getName));
        List<String> employeeList_temp = new ArrayList<>();
        for (Employee employee : employeeList) {
            employeeList_temp.add(employee.getName());
        }
        System.out.println(employeeList_temp);
    }
}

public class Management_system {
    public static void main(String[] args) {
        EmployeeManager manager = new EmployeeManager();

        // Step 1: Add 3 employees A, B, C
        manager.addEmployee("A", 25);
        manager.addEmployee("B", 30);
        manager.addEmployee("C", 28);

        // Step 2: Delete B
        manager.deleteEmployee("B");

        // Step 3: Add 2 employees A, D
        manager.addEmployee("A", 26);
        manager.addEmployee("D", 32);

        // Step 4: Print all employees, should print A, C, D
        System.out.println("Employees after all operations:");
        manager.printEmployees();
    }
}