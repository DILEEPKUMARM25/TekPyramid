package JAVA8FEATURE.StreamAPI.Sample1;

import java.util.ArrayList;
import java.util.List;

public class EmpData {

    public static List<Employee> getData() {

        List<Employee> list = new ArrayList<>();

        // Creating 10 Employee objects
        list.add(new Employee("Emp1", 1, 10000));
        list.add(new Employee("Emp2", 2, 12000));
        list.add(new Employee("Emp3", 3, 15000));
        list.add(new Employee("Emp4", 4, 18000));
        list.add(new Employee("Emp5", 5, 20000));
        list.add(new Employee("Emp6", 6, 22000));
        list.add(new Employee("Emp7", 7, 25000));
        list.add(new Employee("Emp8", 8, 28000));
        list.add(new Employee("Emp9", 9, 30000));
        list.add(new Employee("Emp10", 10, 35000));

        return list;
    }
}

