package JAVA8FEATURE.Assiagnment.list;


import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

class Employee {
    private int id;
    private String name;
    private String department;
    private String jobTitle;
    private String jobType;
    private int age;
    private int yearsOfExperience;
    private double salary;
    private int performanceRating;

    public Employee(int id,String name, String department, String jobTitle,String jobType,
                    int age, int yearsOfExperience,
                    double salary, int performanceRating) {
        this.id = id;
        this.name = name;
        this.department = department;
        this.jobTitle = jobTitle;
        this.jobType = jobType;
        this.age = age;
        this.yearsOfExperience = yearsOfExperience;
        this.salary = salary;
        this.performanceRating = performanceRating;
    }

    // Getters
    public int getId() { return id; }
    public String getName() { return name; }
    public String getDepartment() { return department; }
    public String getJobTitle() { return jobTitle; }
    public String getJobType() { return jobType; }
    public int getAge() { return age; }
    public int getYearsOfExperience() { return yearsOfExperience; }
    public double getSalary() { return salary; }
    public int getPerformanceRating() { return performanceRating; }
}



public class EmloyeeAssiagnmet {

    public static void main(String[] args) {


        List<Employee> employees = List.of(
                new Employee(1,"Alice Johnson", "IT", "Manager", "part-time",38, 4, 120000, 4),
                new Employee(2,"Bob Smith", "IT", "Developer", "full-time",29, 5, 125000, 5),
                new Employee(3,"Charlie Davis", "HR", "Manager", "part-time",45, 18, 150000, 3),
                new Employee(4,"Diana Patel", "Finance", "Analyst", "full-time",32, 7, 78000, 4 ),
                new Employee(5,"Ethan Brown", "Sales", "Manager", "full-time",41, 2, 110000, 2),
                new Employee(6,"Fiona Wilson", "Marketing", "Executive", "part-time",27, 3, 62000, 5),
                new Employee(7,"George Miller", "IT", "Developer", "part-time",36, 10, 98000, 3),
                new Employee(8,"Hannah Garcia", "HR", "Manager", "full-time",30, 6, 95000, 4),
                new Employee(9,"Ian Thompson", "Finance", "Manager", "part-time",50, 3, 175000, 5),
                new Employee(10,"Julia Roberts", "Sales", "Executive", "full-time",28, 4, 70000, 3)
        );




        //Implement a program that reads a list of Employee objects from the user and performs the following operations:
        //Filter out all employees who are managers and have a salary greater than 100,000, but have joined in the last 3 years.
        //Sort the remaining employees in descending order of their years of experience, and then by their performance ratings in ascending order.
        //Return a new list containing the names of the remaining employees, but with each name reversed and in uppercase.


        List<StringBuilder> builderList = employees.stream().filter(employee -> !(employee.getJobTitle().equals("Manager")
                        && employee.getSalary() > 100000 && employee.getYearsOfExperience() > 3))
                .sorted(Comparator.comparing(Employee::getYearsOfExperience).reversed()
                        .thenComparing(Employee::getPerformanceRating))
                .map(employee -> new StringBuilder(employee.getName()
                        .toUpperCase()).reverse()).toList();
        System.out.println(builderList);



        /*Create a program that takes a list of Employee objects as input and performs the following operations:
        Filter out all employees who have joined in the last 5 years and have a performance rating of less than 8, but have a salary between 60,000 and 120,000.
        Sort the remaining employees in ascending order of their salaries, and then by their years of experience in descending order.
                Return a new list containing the IDs of the remaining employees, but with each ID multiplied by 10.*/

        List<Integer> list = employees.stream().filter(employee -> !(employee.getYearsOfExperience() <= 5 && employee.getPerformanceRating() < 8 && employee.getSalary() >= 60000 && employee.getSalary() <= 120000))
                .sorted(Comparator.comparing(Employee::getSalary).thenComparing(Employee::getYearsOfExperience).reversed()).map(emp -> emp.getId() * 10).toList();
        System.out.println(list);

        /*Write a program that reads a list of Employee objects from the user and performs the following operations:
        Remove all employees who are part-time and have a salary less than 50,000, but are in the Sales or Marketing department.
                Calculate the sum of the salaries of the remaining employees, but only for those who have more than 3 years of experience.
                Find the average age of the remaining employees, but only for those who have a performance rating of at least 7.*/

        List<Employee> collect = employees.stream().filter(employee -> !(employee.getJobType().equals("Part-Time")
                && employee.getSalary() < 50000
                && employee.getDepartment().equals("Sales") || employee.getDepartment().equals("Marketing"))).collect(Collectors.toList());
        double sum = collect.stream().filter(employee -> employee.getYearsOfExperience() > 3).mapToDouble(Employee::getSalary).sum();
        double average = collect.stream().filter(employee -> employee.getPerformanceRating() >= 7).mapToDouble(Employee::getAge).average().orElse(0);
        System.out.println(collect+"\n");
        System.out.println("the sum of the salaries: "+sum+"\n");
        System.out.println("average age of the remaining employees: "+ average);

    }

}