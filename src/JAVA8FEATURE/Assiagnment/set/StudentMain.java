package JAVA8FEATURE.Assiagnment.set;

import java.util.*;
import java.util.stream.Collectors;
import java.util.Objects;

class Student {
    private String name;
    private String major;
    private int age;
    private int yearsOfEnrollment;
    private double gpa;
    private int numberOfIncompleteCourses;

    public Student(String name, String major, int age, int yearsOfEnrollment, double gpa, int numberOfIncompleteCourses) {
        this.name = name;
        this.major = major;
        this.age = age;
        this.yearsOfEnrollment = yearsOfEnrollment;
        this.gpa = gpa;
        this.numberOfIncompleteCourses = numberOfIncompleteCourses;
    }

    public String getName() { return name; }
    public String getMajor() { return major; }
    public int getAge() { return age; }
    public int getYearsOfEnrollment() { return yearsOfEnrollment; }
    public double getGpa() { return gpa; }
    public int getNumberOfIncompleteCourses() { return numberOfIncompleteCourses; }

    @Override
    public String toString() {
        return name + " (" + major + ", GPA: " + gpa + ", Age: " + age +
                ", Enrollment: " + yearsOfEnrollment + " yrs)";
    }

    @Override
    public int hashCode() { return Objects.hash(name, major); }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof Student)) return false;
        Student s = (Student) obj;
        return this.name.equals(s.name) && this.major.equals(s.major);
    }
}

public class StudentMain {

    public static void main(String[] args) {

        Set<Student> studentSet = new HashSet<>();
        studentSet.add(new Student("Aarav", "Computer Science", 20, 2, 3.8, 0));
        studentSet.add(new Student("Meera", "Biology", 19, 3, 3.4, 1));
        studentSet.add(new Student("Kiran", "Engineering", 21, 4, 3.6, 0));
        studentSet.add(new Student("Rahul", "Chemistry", 23, 5, 2.9, 2));
        studentSet.add(new Student("Sara", "Mathematics", 22, 1, 2.7, 3));
        studentSet.add(new Student("Nisha", "Mathematics", 24, 4, 3.2, 0));
        studentSet.add(new Student("David", "Computer Science", 25, 5, 3.9, 0));
        studentSet.add(new Student("Elena", "Engineering", 28, 7, 3.7, 0));
        studentSet.add(new Student("Zara", "Biology", 20, 2, 3.1, 0));
        studentSet.add(new Student("John", "Mathematics", 23, 3, 2.8, 3));
        studentSet.add(new Student("Mark", "Mathematics", 26, 6, 2.5, 5));
        studentSet.add(new Student("Lara", "Mathematics", 22, 2, 2.9, 2));
        studentSet.add(new Student("Anil", "Mathematics", 21, 3, 3.6, 0));
        studentSet.add(new Student("Rekha", "Mathematics", 24, 4, 3.7, 0));
        studentSet.add(new Student("Rohan", "Mathematics", 22, 2, 3.5, 1));

        System.out.println("=========== TASK 1 ===========");
//        Write a program that takes a set of Student objects as input and performs the following operations:
//        Group the students by their major into a Map where the key is the major and the value is a set of students in that major, but only for majors with more than 5 students and an average GPA above 3.0.
//                Sort the students within each major in ascending order of their GPA, and then by their age in descending order.
//                Return the Map containing the grouped and sorted students.
        Map<String, Set<Student>> grouped = studentSet.stream()
                .collect(Collectors.groupingBy(
                        Student::getMajor,
                        Collectors.toSet()
                ));

        System.out.println(grouped);


        Map<String, List<Student>> finalTask1 = grouped.entrySet().stream()
                .filter(entry -> {
                    double avgGPA = entry.getValue().stream()
                            .mapToDouble(Student::getGpa).average().orElse(0);
                    return entry.getValue().size() > 5 && avgGPA > 3.0;
                })
                .collect(Collectors.toMap(
                        Map.Entry::getKey,
                        entry -> entry.getValue().stream()
                                .sorted(
                                        Comparator.comparingDouble(Student::getGpa)
                                                .thenComparing(Comparator.comparingInt(Student::getAge).reversed())
                                )
                                .collect(Collectors.toList())
                ));


        System.out.println("\nResult Task 1 Map: " + finalTask1);

        System.out.println("\n=========== TASK 2 ===========");
//        Implement a program that reads a set of Student objects from the user and performs the following operations:
//        Filter out all students who have a GPA less than the average GPA of all students, but have an age above 18 and a major in Biology or Chemistry.
//                Calculate the total years of enrollment of the remaining students, but only for those who have joined in the last 4 years and are majoring in Computer Science or Engineering.
//                Find the student with the highest years of enrollment and return their details, but only if they have an age below 30 and a GPA above 3.7.

        double avgGPAAll = studentSet.stream().mapToDouble(Student::getGpa).average().orElse(0);

        List<Student> filteredTask2 = studentSet.stream()
                .filter(s -> !(s.getGpa() < avgGPAAll &&
                        s.getAge() > 18 &&
                        (s.getMajor().equals("Biology") || s.getMajor().equals("Chemistry"))))
                .toList();

        int totalYears = filteredTask2.stream()
                .filter(s -> s.getYearsOfEnrollment() <= 4 &&
                        (s.getMajor().equals("Computer Science") || s.getMajor().equals("Engineering")))
                .mapToInt(Student::getYearsOfEnrollment)
                .sum();

        System.out.println("Total years of enrollment (CS & Engg only): " + totalYears);

        Optional<Student> highestYears = filteredTask2.stream()
                .filter(s -> s.getAge() < 30 && s.getGpa() > 3.7)
                .max(Comparator.comparingInt(Student::getYearsOfEnrollment));

        System.out.println("Student with highest enrollment: " +
                highestYears.orElse(null));


        System.out.println("\n=========== TASK 3 ===========");
//        Create a program that takes a set of Student objects as input and performs the following operations:
//        Filter out all students who have joined in the last 3 years and have a major in Mathematics, but have a GPA below 3.0 and are on academic probation.
//                Calculate the sum of the GPAs of the remaining students, but only for those who have an age above 22 and a GPA above the average GPA.
//                Find the average age of the remaining students, but only if their department has more than 10 students and an average GPA above 3.5.
//                Calculate the factor  ial of the average age, but only if the total years of enrollment of all students is greater than 30 and the average GPA is below 3.9.

        List<Student> filteredTask3 = studentSet.stream()
                .filter(s -> !(s.getYearsOfEnrollment() <= 3 &&
                        s.getMajor().equals("Mathematics") &&
                        s.getGpa() < 3.0 &&
                        s.getNumberOfIncompleteCourses() > 0))
                .toList();

        double avgGPAAfterFilter = filteredTask3.stream()
                .mapToDouble(Student::getGpa).average().orElse(0);

        double sumGPA = filteredTask3.stream()
                .filter(s -> s.getAge() > 22 && s.getGpa() > avgGPAAfterFilter)
                .mapToDouble(Student::getGpa).sum();

        System.out.println("Sum of GPAs (Filtered): " + sumGPA);

        Map<String, List<Student>> deptGroup = filteredTask3.stream()
                .collect(Collectors.groupingBy(Student::getMajor));
//        System.out.println("Task----------3-------"+deptGroup);

        deptGroup.forEach((dept, list) -> {
            double avg = list.stream().mapToDouble(Student::getGpa).average().orElse(0);
            if (list.size() > 10 && avg > 3.5) {
                double avgAge = list.stream().mapToInt(Student::getAge).average().orElse(0);
                System.out.println("Average age for " + dept + ": " + avgAge);

                int totalYearsAll = studentSet.stream()
                        .mapToInt(Student::getYearsOfEnrollment).sum();

                if (totalYearsAll > 30 && avg < 3.9) {
                    long factorial = 1;
                    for (int i = 1; i <= (int) avgAge; i++) factorial *= i;
                    System.out.println("Factorial of average age: " + factorial);
                }
            }
        });
   }
}
