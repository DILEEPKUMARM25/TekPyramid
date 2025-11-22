package JAVA8FEATURE.Assiagnment.map;


import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;



 class  Customer {
    private String id;
    private String name;
    private String country;
    private int age;
    private int yearsOfMembership;
    private double balance;
    private int loyaltyScore;
    private int numberOfTransactions;

    public Customer(String id, String name, String country, int age, int yearsOfMembership,
                    double balance, int loyaltyScore, int numberOfTransactions) {
        this.id = id;
        this.name = name;
        this.country = country;
        this.age = age;
        this.yearsOfMembership = yearsOfMembership;
        this.balance = balance;
        this.loyaltyScore = loyaltyScore;
        this.numberOfTransactions = numberOfTransactions;
    }

    // ---- Getters ----
    public String getId() { return id; }
    public String getName() { return name; }
    public String getCountry() { return country; }
    public int getAge() { return age; }
    public int getYearsOfMembership() { return yearsOfMembership; }
    public double getBalance() { return balance; }
    public int getLoyaltyScore() { return loyaltyScore; }
    public int getNumberOfTransactions() { return numberOfTransactions; }

    // toString for printing details
    @Override
    public String toString() {
        return id + " - " + name + " | Country: " + country +
                " | Age: " + age +
                " | Years: " + yearsOfMembership +
                " | Balance: " + balance +
                " | Loyalty: " + loyaltyScore;
    }
}


public class CustomerMain {
    public static void main(String[] args) {

        Map<String, Customer> customerMap = new HashMap<>();
        customerMap.put("C1", new Customer("C1", "Alice", "India", 25, 5, 15000, 7, 20));
        customerMap.put("C2", new Customer("C2", "Bob", "USA", 30, 3, 10000, 4, 15));
        customerMap.put("C3", new Customer("C3", "David", "UK", 45, 10, 20000, 8, 30));
        customerMap.put("C4", new Customer("C4", "John", "India", 28, 2, 3000, 3, 22));
        customerMap.put("C5", new Customer("C5", "Emma", "India", 34, 4, 4000, 2, 18));
        customerMap.put("C6", new Customer("C6", "Sophia", "India", 26, 1, 2500, 3, 10));
        customerMap.put("C7", new Customer("C7", "Lily", "India", 32, 8, 7000, 6, 50));
        customerMap.put("C8", new Customer("C8", "Mark", "India", 29, 7, 9000, 7, 40));
        customerMap.put("C9", new Customer("C9", "Chris", "India", 27, 6, 11000, 9, 35));
        customerMap.put("C10", new Customer("C10", "Jenny", "India", 33, 9, 13000, 4, 60));
        customerMap.put("C11", new Customer("C11", "Zara", "India", 31, 5, 12500, 9, 70));

       /* Write a program that reads a map of Customer objects from the user and performs the following operations:
        Filter out all customers who have a balance greater than 10000 and are from the United States, but have joined in the last 5 years.
                Calculate the square root of the sum of the balances of the remaining customers, but only for those who have a loyalty score greater than 8.
        Find the customer with the closest age to the square root, but only if their age is less than 40.*/



    }
}