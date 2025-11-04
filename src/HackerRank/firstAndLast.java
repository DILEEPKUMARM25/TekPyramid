package HackerRank;

import java.util.Scanner;

public class firstAndLast {

    public static void main(String[] args)
    {
        Scanner scan = new Scanner(System.in);
        System.out.println("Enter a string:");
        String s = scan.nextLine();
        System.out.println("Enter a number:");
        int k = scan.nextInt();
        System.out.println(getSmallestAndLargest(s, k));
    }

    public static String getSmallestAndLargest(String s, int k) {
        String smallest = s.substring(0, k);
        String largest = s.substring(0, k);
        for (int i = 1; i <= s.length() - k; i++) {
            String str = s.substring(i, i + k);
            if (smallest.compareTo(str) > 0) {
                smallest = str;
            }
            if (largest.compareTo(str) < 0) {
                largest = str;
            }
        }
        return smallest + "\n" + largest;
    }
}
