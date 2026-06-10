import java.util.ArrayList;
import java.util.Scanner;

class Employee {
    int id;
    String name;
    double salary;

    Employee(int id, String name, double salary) {
        this.id = id;
        this.name = name;
        this.salary = salary;
    }

    void display() {
        System.out.println("ID: " + id +
                           ", Name: " + name +
                           ", Salary: " + salary);
    }
}

public class EmployeeManagementSystem {
    public static void main(String[] args) {

        ArrayList<Employee> employees = new ArrayList<>();
        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.println("\n--- Employee Management System ---");
            System.out.println("1. Add Employee");
            System.out.println("2. View Employees");
            System.out.println("3. Update Employee");
            System.out.println("4. Delete Employee");
            System.out.println("5. Exit");
            System.out.print("Enter choice: ");

            int choice = sc.nextInt();

            switch (choice) {

                case 1:
                    System.out.print("Enter Employee ID: ");
                    int id = sc.nextInt();
                    sc.nextLine();

                    System.out.print("Enter Employee Name: ");
                    String name = sc.nextLine();

                    System.out.print("Enter Salary: ");
                    double salary = sc.nextDouble();

                    employees.add(new Employee(id, name, salary));
                    System.out.println("Employee Added Successfully!");
                    break;

                case 2:
                    if (employees.isEmpty()) {
                        System.out.println("No Employees Found.");
                    } else {
                        for (Employee emp : employees) {
                            emp.display();
                        }
                    }
                    break;

                case 3:
                    System.out.print("Enter Employee ID to Update: ");
                    int updateId = sc.nextInt();

                    boolean updated = false;

                    for (Employee emp : employees) {
                        if (emp.id == updateId) {

                            sc.nextLine();
                            System.out.print("Enter New Name: ");
                            emp.name = sc.nextLine();

                            System.out.print("Enter New Salary: ");
                            emp.salary = sc.nextDouble();

                            updated = true;
                            System.out.println("Employee Updated Successfully!");
                            break;
                        }
                    }

                    if (!updated) {
                        System.out.println("Employee Not Found.");
                    }
                    break;

                case 4:
                    System.out.print("Enter Employee ID to Delete: ");
                    int deleteId = sc.nextInt();

                    boolean deleted = false;

                    for (int i = 0; i < employees.size(); i++) {
                        if (employees.get(i).id == deleteId) {
                            employees.remove(i);
                            deleted = true;
                            System.out.println("Employee Deleted Successfully!");
                            break;
                        }
                    }

                    if (!deleted) {
                        System.out.println("Employee Not Found.");
                    }
                    break;

                case 5:
                    System.out.println("Exiting Program...");
                    sc.close();
                    System.exit(0);

                default:
                    System.out.println("Invalid Choice!");
            }
        }
    }
}