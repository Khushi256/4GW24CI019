import java.util.Scanner;

class Employee{
    private String name;
    private int id;
    private double salary;

    public Employee(int id, String name, double salary){
        this.id = id;
        this.name= name;
        this.salary = salary;
    }

    public void display(){
        System.out.print("\n------------------------\n");
        System.out.print("\n Employe id:" + id);
        System.out.print("Employe name: \n" + name);
        System.out.print("Employe salary:\n " + salary);
        System.out.print("\n------------------------\n");
        
    }

    public void raiseSalary(double percent){
        if(percent > 0){
            double inc = salary * percent/100;
            salary += inc;
            System.out.print("Salary raised by " + percent + "is now " + salary);
        
        }
        else{
            System.out.print("invalid ");
        }
    }

}

public class EmployeeDemo{
    public static void main(String args[]){

        Scanner sc = new Scanner(System.in);

        System.out.print(" Enter Employe id: ");
        int id = sc.nextInt();
        sc.nextLine();
        System.out.print(" Enter Employe name: ");
        String name = sc.nextLine();
        System.out.print(" Enter Employe salary: ");
        double salary = sc.nextDouble();

        Employee emp = new Employee(id,name,salary);

        double percent = sc.nextDouble();

        System.out.print(" Before the increment the actual salary is : ");
        emp.display();

        emp.raiseSalary(percent);
        System.out.print(" After the increment the actual salary is : ");
        emp.display();

        sc.close();

    }
}
