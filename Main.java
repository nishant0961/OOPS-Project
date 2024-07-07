import java.util.*;

abstract class Employee{    //abstract class

    private String name;    //access modifier

    private int id;  

    //constructur
    public Employee(String name, int id)
    {
        this.name = name;
        this.id = id;
    }

    //getter or setter
    public  String getName()
    {
        return name;
    }

    public int getId()
    {
        return id;
    }

    public abstract double calculateSalary();  //abstract method

    @Override
    public String toString()
    {
        return "Employee [name = "+name+", id = "+id+", salary = "+calculateSalary()+"]";
    }
}

class FullTimeEmployee extends Employee{

    private double monthlySalary;

    public FullTimeEmployee(String name, int id, double monthlySalary)
    {
        //super keyword :->  if we want to run the constructor of parent class as we are in child class
        super(name, id);
        this.monthlySalary = monthlySalary;
    }

    @Override
    public double calculateSalary()
    {
        return monthlySalary;
    }
}

class PartTimeEmployee extends Employee{

    private int hoursWorked;

    private double hourlyRate;

    public PartTimeEmployee(String name, int id, int hoursWorked, double hourlyRate)
    {
        super(name, id);
        this.hoursWorked = hoursWorked;
        this.hourlyRate  = hourlyRate;
    }

    @Override
    public double calculateSalary()
    {
        return hoursWorked * hourlyRate;
    }
}

class PayRollSystem{

    private ArrayList<Employee>employeeList;

    public PayRollSystem() {
        employeeList = new ArrayList<>();
    }

    public void addEmployee(Employee employee)
    {
        employeeList.add(employee);
    }

    public void removeEmployee(int id)
    {
        Employee employeeToRemove = null;
        for(Employee employee : employeeList)
        {
            if(employee.getId() == id)
            {
                employeeToRemove = employee;
                break;
            }
        }
        if(employeeToRemove != null)
        {
            employeeList.remove(employeeToRemove);
        }
    }

    public void displayEmployee()
    {
        for(Employee employee : employeeList)
        {
            System.out.println(employee);
        }
    }
}

public class Main {
    public static void main(String[] args)
    {
        PayRollSystem payRollSystem = new PayRollSystem();
        FullTimeEmployee emp1 = new FullTimeEmployee("Vikas", 1, 70000.0);
        PartTimeEmployee emp2  = new PartTimeEmployee("Alex", 2, 40, 100);


        payRollSystem.addEmployee(emp1);
        payRollSystem.addEmployee(emp2);
        System.out.println("Intial Employee Details: ");
        payRollSystem.displayEmployee();

        System.out.println("Removing Employees");
        payRollSystem.removeEmployee(2);

        System.out.println("Remaining Employee Details: ");
        payRollSystem.displayEmployee();

    }
}