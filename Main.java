import java.util.ArrayList;

abstract class Employee {
    private String name;
    private int id;

    Employee(String name, int id)

    {
        this.name = name;
        this.id = id;
    }
    public String getName()
    {
        return name;
    }
    public int getId()
    {
        return id;
    }
    public abstract double getSalary();


    @Override
    //using concept of polymorphism
    public String toString()
    {
        return "Employee [name = " + name + " , id = " + id + ", salary = "+ getSalary() + "]";
    }
}

 class FullTimeEmployee extends Employee
{
    private double monthlySalary;
    public FullTimeEmployee(String name, int id, double monthlySalary)
    {
        super(name,id);
        this.monthlySalary = monthlySalary;
    }

    @Override
    public double getSalary()
    {
        return monthlySalary;
    }



}


class PartTimeEmployee extends Employee {

    private int hoursWorked;
    private double hourlyRate;

    public PartTimeEmployee(String name,int id, int hoursWorked, double hourlyRate)
    {
        super(name,id);
        this.hourlyRate = hourlyRate;
        this.hoursWorked = hoursWorked;
    }
    @Override
    public double getSalary()
    {
        return hoursWorked * hourlyRate;
    }
}

class PayrollSystem {
    private ArrayList<Employee> employeeList;

    public PayrollSystem() {
        employeeList = new ArrayList<>();
    }

    public void addEmployee(Employee employee) {
        employeeList.add(employee);
    }

    public void removeEmployee(int id) {
        Employee employeeToRemove = null;
        for (Employee employee : employeeList) {
            if (employee.getId() == id) {
                employeeToRemove = employee;
                break;
            }
        }
        if (employeeToRemove != null) {
            employeeList.remove(employeeToRemove);
        }
    }

    public void displayEmployees() {
        for (Employee employee : employeeList) {
            System.out.println(employee);
        }
    }
}







public class Main {
    public static void main(String[] args) {
        PayrollSystem payrollSystem = new PayrollSystem();
        FullTimeEmployee emp1 = new FullTimeEmployee("Ram", 1, 10000);
        PartTimeEmployee emp2 = new PartTimeEmployee("Shyam", 2, 10, 1000);


        payrollSystem.addEmployee(emp1);
        payrollSystem.addEmployee(emp2);

        System.out.println("Initial Employees ");
        payrollSystem.displayEmployees();

        System.out.println(" Employees removed ");
        payrollSystem.removeEmployee(2);


        System.out.println(" Employees after removing ");
        payrollSystem.displayEmployees();


    }
}