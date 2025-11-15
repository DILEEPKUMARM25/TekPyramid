package project.Array;

public class Main {
Employee[] arr=new Employee[20];
int index=0;
    public static void main(String[] args) {

        String s="hello";

        Main m=new Main();

        Employee e1=new Employee(1,"dileep",24,100.00);
        Employee e2=new Employee(2,"Akshay",25,120.00);
        Employee e3=new Employee(3,"deepak",20,130.00);

        m.addEmployee(e1);
        m.addEmployee(e2);
        m.addEmployee(e3);

        m.displayEmployees();

        try {
            m.updateEmployee(2,"Akshay", 26, 200.00);  // update age & salary
        } catch(EmployeeNotFoundException e) {
            System.out.println(e.getMessage());
        }

        try {
            m.fetchEmployee(1);  // fetching info
        } catch(EmployeeNotFoundException e) {
            System.out.println(e.getMessage());
        }


        try {
            m. deleteEmployee(3);;  // delete
        } catch(EmployeeNotFoundException e) {
            System.out.println(e.getMessage());
        }
    }

    public void addEmployee(Employee e) {
        if(index < arr.length) {
            arr[index] = e;
            index++;
            System.out.println("Employee added successfully ");
        } else {
            System.out.println("Array is full");
        }
    }

    public void displayEmployees() {
        System.out.println("\n--- Employee List ---");
        for(int i = 0; i < index; i++) {
            System.out.println("Name: " + arr[i].getName() +
                    ", Age: " + arr[i].getAge() +
                    ", Salary: " + arr[i].getSalary());
        }
    }

    public void deleteEmployee(int no) throws EmployeeNotFoundException {
        for (int i = 0; i < index; i++) {
            if (arr[i].getNo() == no) {

                // Shift elements left
                for (int j = i; j < index - 1; j++) {
                    arr[j] = arr[j + 1];
                }
                arr[index - 1] = null;
                index--;

                System.out.println("Employee with No " + no + " deleted successfully.");
                return;
            }
        }
        throw new EmployeeNotFoundException("Employee with No '" + no + "' not found.");
    }


    public void updateEmployee(int no,String name, int newAge, double newSalary) throws EmployeeNotFoundException {
        for(int i = 0; i < index; i++) {
            if(arr[i].getNo() == no) {
                arr[i].setName(name);
                arr[i].setAge(newAge);
                arr[i].setSalary(newSalary);
                System.out.println(" Updated employee: " + name);
                return;
            }
        }
        throw new EmployeeNotFoundException(" Employee '" + no + "' not found");
    }

    public void fetchEmployee(int no) throws EmployeeNotFoundException {
        for(int i = 0; i < index; i++) {
            if(arr[i].getNo() == no) {
                System.out.println(" Employee Found:");
                System.out.println("Name: " + arr[i].getName());
                System.out.println("Age: " + arr[i].getAge());
                System.out.println("Salary: " + arr[i].getSalary());
                return;
            }
        }
        throw new EmployeeNotFoundException("Employee '" + no + "' not found");
    }

}

// inheritence and encapsulation

  class Employee extends Employee1 {
    private int no;
      private  double salary;
    public Employee(int no,String name, int age, double salary) {
        this.name = name;
        this.age = age;
        this.salary = salary;
        this.no = no;
    }
public int getNo() {
        return no;
}
public void setNo(int no) {
        this.no = no;
}
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public int getAge() {
        return age;
    }
    public void setAge(int age) {
        this.age = age;
    }
    public double getSalary() {
        return salary;
    }
    public void setSalary(double salary) {
        this.salary = salary;
    }
}


///  Abstraction
abstract class Employee1 {
     String name;
     int age;

}


///  Exception Handled

class EmployeeNotFoundException extends Exception {
    public EmployeeNotFoundException(String msg) {
        super(msg);
    }
}