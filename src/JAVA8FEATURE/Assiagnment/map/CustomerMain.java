package JAVA8FEATURE.Assiagnment.map;


import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

 class Customer {
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

//        Implement a program that reads a map of Customer objects from the user and performs the following operations:
//        Filter out all customers who have a balance less than the average balance of all customers.
//        Calculate the total years of membership of the remaining customers.
//        Find the customer with the highest years of membership and return their details.
        System.out.println("=========== TASK 1 ===========");
        OptionalDouble average = customerMap.values().stream()
                .mapToDouble(Customer::getBalance).average();

//// Extract the actual value
        double avg = average.orElse(0);
//
//// Filter customers with balance >= average
        List<Customer> filtered = customerMap.values().stream()
                .filter(c -> c.getBalance() >= avg)
                .toList();
//
//// Calculate total years of membership
        int totalYears = filtered.stream()
                .mapToInt(Customer::getYearsOfMembership)
                .sum();
//
//// Find customer with highest years of membership
        Customer highestMembership = filtered.stream()
                .max(Comparator.comparingInt(Customer::getYearsOfMembership))
                .orElse(null);
        System.out.println("The Average balance of all customers: "+avg);
        System.out.println("The filtered:" +filtered);
        System.out.println("total years of membership : "+totalYears);
        System.out.println("customer with highest years of membership: "+highestMembership);

//        Create a program that takes a map of Customer objects as input and performs the following operations:
//        Filter out all customers who have joined in the last 3 years and have a loyalty score less than 4, but have a balance between 2000 and 5000.
//        Calculate the sum of the balances of the remaining customers, but only for those who have an even age.
//        Find the average age of the remaining customers, but only if their country has more than 10 customers.
        System.out.println("=========== TASK 2 ===========");
        List<Customer> filteredList = customerMap.values().stream()
                .filter(customer -> !(customer.getYearsOfMembership() > 3
                        && customer.getLoyaltyScore() < 4
                        && customer.getBalance() >= 2000
                        && customer.getBalance() <= 5000))
                .toList();

        System.out.println("\nFiltered Customers (After Removing those with <4 Loyalty & Balance 2000-5000 & <3 yrs):");
        filteredList.forEach(c -> System.out.println(c.getName() + " - " + c.getCountry()));

        // Step 2: Sum balances of customers with even age
        double sumBalances = filteredList.stream()
                .filter(c -> c.getAge() % 2 == 0)
                .mapToDouble(Customer::getBalance)
                .sum();

        System.out.println("\nSum of balances of customers with even age: " + sumBalances);

        // Step 3: Count customers by country
        Map<String, Long> countryCount = filteredList.stream()
                .collect(Collectors.groupingBy(Customer::getCountry, Collectors.counting()));

        System.out.println("\nCustomer count by country:");
        countryCount.forEach((country, count) ->
                System.out.println(country + " → " + count));

        // Step 4: Find average age for countries having more than 10 customers
        System.out.println("\nAverage Age for Countries with > 10 Customers:");
        countryCount.entrySet().stream()
                .filter(entry -> entry.getValue() > 10)
                .forEach(entry -> {
                    String country = entry.getKey();
                    double avgAge = filteredList.stream()
                            .filter(c -> c.getCountry().equals(country))
                            .mapToInt(Customer::getAge)
                            .average()
                            .orElse(0);
                    System.out.println(country + " → Average Age: " + avgAge);
                });


    }
}