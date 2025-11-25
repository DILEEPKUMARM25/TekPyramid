package JAVA8FEATURE.Assiagnment.set;

import java.util.*;
import java.util.stream.Collectors;
import java.util.Objects;
import java.util.stream.Stream;

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
        studentSet.add(new Student("Meera", "Biology", 45, 8, 4.8, 1));
        studentSet.add(new Student("Kiran", "Engineering", 40, 4, 4.6, 0));
        studentSet.add(new Student("Rahul", "Chemistry", 23, 5, 2.9, 2));
        studentSet.add(new Student("Sara", "Mathematics", 35, 1, 4.7, 3));
        studentSet.add(new Student("Nisha", "Mathematics", 24, 4, 3.2, 0));
        studentSet.add(new Student("David", "Computer Science", 25, 5, 3.9, 0));
        studentSet.add(new Student("Elena", "Engineering", 28, 7, 4.7, 0));
        studentSet.add(new Student("Zara", "Biology", 50, 8, 3.1, 0));
        studentSet.add(new Student("John", "Mathematics", 38, 3, 4.8, 3));
        studentSet.add(new Student("Mark", "Mathematics", 26, 6, 2.5, 5));
        studentSet.add(new Student("Lara", "Mathematics", 22, 2, 2.9, 2));
        studentSet.add(new Student("Anil", "Mathematics", 21, 3, 3.6, 0));
        studentSet.add(new Student("Rekha", "Mathematics", 24, 4, 3.7, 0));
        studentSet.add(new Student("Rohan", "Mathematics", 22, 2, 3.5, 1));


        /*Filter out all students who have a GPA greater than 3.8 and are majoring in Biology, but have joined in the last 4 years and have a performance rating below 7.
        Calculate the square root of the sum of the GPAs of the remaining students, but only for those who have an age above 30 and a GPA above 3.9.
                Find the student with the closest age to the square root, but only if their major is Computer Science and they have a GPA above 4.2.*/


        List<Student> biology = studentSet.stream().filter(emp -> !(emp.getGpa() > 8 && emp.getMajor().equalsIgnoreCase("Biology")) && emp.getYearsOfEnrollment() > 4).toList();
        double sum = biology.stream().filter(emp -> emp.getAge() > 30 && emp.getGpa() > 3.9).mapToDouble(Student::getGpa).sum();
        System.out.println("the avarage is "+ Math.sqrt(sum));
        System.out.println(biology);

        List<Student> computerScience = biology.stream().filter(std -> (std.getGpa() >= sum + 5 || std.getGpa() <= sum - 5) && std.getMajor().equalsIgnoreCase("Computer Science") && std.getGpa() > 4.2).toList();
        System.out.println(computerScience);
    }
}
