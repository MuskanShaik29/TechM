import java.io.*;

class Employee implements Serializable {
    String name;
    int id;
    
    Employee(String name, int id) {
        this.name = name;
        this.id = id;
    }
}

public class EmployeeDatabase {
    public static void main(String[] args) {
        Employee emp = new Employee("Alice", 101);

        // Serialization
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("employee.dat"))) {
            oos.writeObject(emp);
            System.out.println("Employee Serialized!");
        } catch (IOException e) {
            e.printStackTrace();
        }

        // Deserialization
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream("employee.dat"))) {
            Employee deserializedEmp = (Employee) ois.readObject();
            System.out.println("Employee Name: " + deserializedEmp.name + ", ID: " + deserializedEmp.id);
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
