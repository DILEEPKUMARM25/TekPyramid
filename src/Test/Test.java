package Test;



import java.util.Objects;

public class Test {

}

class Student{
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