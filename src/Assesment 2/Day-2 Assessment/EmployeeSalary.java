class Employee {
    double salary = 30000;

    double getSalary() {
        return salary;
    }
}

class Manager extends Employee {
    double getSalary() {
        return salary + 20000;
    }
}

public class EmployeeSalary {
    public static void main(String[] args) {
        Employee emp = new Employee();
        Manager mgr = new Manager();

        System.out.println("Employee Salary: " + emp.getSalary());
        System.out.println("Manager Salary: " + mgr.getSalary());
    }
}
