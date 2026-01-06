import java.io.*;
import java.util.Scanner;

public class EmployeeManagementSystem {

    static final int MAX = 100;
    static int count = 0;

    // Arrays (DSA)
    static String[] empId = new String[MAX];
    static String[] empName = new String[MAX];
    static double[] empSalary = new double[MAX];
    static String[] empDept = new String[MAX];

    static Scanner sc = new Scanner(System.in);
    static final String FILE_NAME = "employees.txt";

    public static void main(String[] args) {

        // OS: Process Management
        System.out.println("Process ID: " + ProcessHandle.current().pid());

        // OS: File System
        loadFromFile();

        int choice;

        while (true) {
            System.out.println("\n===== EMPLOYEE MANAGEMENT SYSTEM =====");
            System.out.println("1. Add Employee");
            System.out.println("2. View Employees");
            System.out.println("3. Search Employee");
            System.out.println("4. Delete Employee");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");

            if (!sc.hasNextInt()) {
                System.out.println("Please enter numbers only!");
                sc.next();
                continue;
            }

            choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {
                case 1: addEmployee(); break;
                case 2: viewEmployees(); break;
                case 3: searchEmployee(); break;
                case 4: deleteEmployee(); break;
                case 5:
                    saveToFile();
                    System.out.println("Program terminated.");
                    System.exit(0); // OS: System Call
                default:
                    System.out.println("Invalid choice!");
            }
        }
    }

    // Add Employee
    static void addEmployee() {
        if (count == MAX) {
            System.out.println("Employee limit reached!");
            return;
        }

        System.out.print("Enter Employee ID: ");
        empId[count] = sc.nextLine();

        System.out.print("Enter Employee Name: ");
        empName[count] = sc.nextLine();

        System.out.print("Enter Salary: ");
        while (!sc.hasNextDouble()) {
            System.out.println("Enter valid salary!");
            sc.next();
        }
        empSalary[count] = sc.nextDouble();
        sc.nextLine();

        System.out.print("Enter Department: ");
        empDept[count] = sc.nextLine();

        count++;
        System.out.println("Employee added successfully!");
    }

    // View Employees
    static void viewEmployees() {
        if (count == 0) {
            System.out.println("No employees available.");
            return;
        }

        System.out.println("\nID\tName\tSalary\tDepartment");
        System.out.println("-----------------------------------");

        for (int i = 0; i < count; i++) {
            System.out.println(empId[i] + "\t" + empName[i] + "\t" +
                               empSalary[i] + "\t" + empDept[i]);
        }
    }

    // Search Employee (Linear Search)
    static void searchEmployee() {
        System.out.print("Enter Employee ID to search: ");
        String id = sc.nextLine();

        for (int i = 0; i < count; i++) {
            if (empId[i].equals(id)) {
                System.out.println("Employee Found:");
                System.out.println("Name: " + empName[i]);
                System.out.println("Salary: " + empSalary[i]);
                System.out.println("Department: " + empDept[i]);
                return;
            }
        }
        System.out.println("Employee not found!");
    }

    // Delete Employee (Array Shifting)
    static void deleteEmployee() {
        System.out.print("Enter Employee ID to delete: ");
        String id = sc.nextLine();

        for (int i = 0; i < count; i++) {
            if (empId[i].equals(id)) {
                for (int j = i; j < count - 1; j++) {
                    empId[j] = empId[j + 1];
                    empName[j] = empName[j + 1];
                    empSalary[j] = empSalary[j + 1];
                    empDept[j] = empDept[j + 1];
                }
                count--;
                System.out.println("Employee deleted successfully!");
                return;
            }
        }
        System.out.println("Employee not found!");
    }

    // OS: File Write
    static void saveToFile() {
        try (PrintWriter pw = new PrintWriter(new FileWriter(FILE_NAME))) {
            for (int i = 0; i < count; i++) {
                pw.println(empId[i] + "," + empName[i] + "," +
                           empSalary[i] + "," + empDept[i]);
            }
        } catch (IOException e) {
            System.out.println("Error saving file!");
        }
    }

    // OS: File Read
    static void loadFromFile() {
        File file = new File(FILE_NAME);
        if (!file.exists()) return;

        try (Scanner fs = new Scanner(file)) {
            while (fs.hasNextLine() && count < MAX) {
                String[] data = fs.nextLine().split(",");
                empId[count] = data[0];
                empName[count] = data[1];
                empSalary[count] = Double.parseDouble(data[2]);
                empDept[count] = data[3];
                count++;
            }
        } catch (Exception e) {
            System.out.println("Error reading file!");
        }
    }
}
