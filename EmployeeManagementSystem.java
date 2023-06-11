import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


abstract class Employee {
    private String name;
    private int age;
    private double salary;

    public Employee(String name, int age, double salary) {
        this.name = name;
        this.age = age;
        this.salary = salary;
    }

    public abstract void displayDetails();

    public abstract double calculateBonus();

    

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public double getSalary() {
        return salary;
    }
}


class Manager extends Employee {
    private String department;

    public Manager(String name, int age, double salary, String department) {
        super(name, age, salary);
        this.department = department;
    }

    @Override
    public void displayDetails() {
        System.out.println("Manager Name: " + getName());
        System.out.println("Age: " + getAge());
        System.out.println("Salary: " + getSalary());
        System.out.println("Department: " + department);
    }

    @Override
    public double calculateBonus() {
        return getSalary() * 0.2; 
    }
}


class Developer extends Employee {
    private String programmingLanguage;

    public Developer(String name, int age, double salary, String programmingLanguage) {
        super(name, age, salary);
        this.programmingLanguage = programmingLanguage;
    }

    @Override
    public void displayDetails() {
        System.out.println("Developer Name: " + getName());
        System.out.println("Age: " + getAge());
        System.out.println("Salary: " + getSalary());
        System.out.println("Programming Language: " + programmingLanguage);
    }

    @Override
    public double calculateBonus() {
        return getSalary() * 0.1; 
    }
}

// Main class to run the program
public class EmployeeManagementSystem {
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            List<Employee> employees = new ArrayList<>();

            
            employees.add(new Manager("Shivam", 35, 5000, "Sales and Marketing"));
            employees.add(new Developer("Shivansh", 28, 4000, "Java"));

           

            System.out.print("Enter employee name: ");
            String name = scanner.nextLine();
            System.out.print("Enter employee age: ");
            int age = scanner.nextInt();
            System.out.print("Enter employee salary: ");
            double salary = scanner.nextDouble();
            scanner.nextLine(); // Clearing the input buffer
            System.out.print("Enter employee type (Manager/Developer): ");
            String employeeType = scanner.nextLine();

            if (employeeType.equalsIgnoreCase("Manager")) {
                System.out.print("Enter manager department: ");
                String department = scanner.nextLine();
                employees.add(new Manager(name, age, salary, department));
            } else if (employeeType.equalsIgnoreCase("Developer")) {
                System.out.print("Enter programming language: ");
                String programmingLanguage = scanner.nextLine();
                employees.add(new Developer(name, age, salary, programmingLanguage));
            } else {
                System.out.println("Invalid employee type!");
            }

            
            System.out.println("\nEmployee Details:");
            for (Employee employee : employees) {
                employee.displayDetails();
                System.out.println("Bonus: " + employee.calculateBonus());
                System.out.println();
            }
        }
    }
}
