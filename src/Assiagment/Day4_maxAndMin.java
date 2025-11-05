package Assiagment;


import java.util.*;

public class Day4_maxAndMin {
    public static void main(String[] args) {
        System.out.println("*16. Java Program to Find the Maximum and Minimum Occurring Characters in a String");

        //collecting the String input from user
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the String");
        String str=sc.nextLine();

        //converting the string into char Array
        char[] charArr = str.toCharArray();
        Map<Character, Integer> charMap = new LinkedHashMap<>();
        for(char x:charArr){
            charMap.put(x, charMap.getOrDefault(x,0)+1);
        }


        //print the key value pair
//        for(Map.Entry<Character,Integer> entry:charMap.entrySet()) {
//            System.out.println(entry.getKey() + "->" + entry.getValue());
//        }

        //max and min using collections
        Map.Entry<Character,Integer> minEntry = Collections.min(charMap.entrySet(),Map.Entry.comparingByValue());
        Map.Entry<Character,Integer> maxEntry = Collections.max(charMap.entrySet(),Map.Entry.comparingByValue());

        //getting min and max frequency values
//        System.out.println(" Minimum and Maximum Occurring Characters in a String");
//        System.out.println("Min->"+minEntry.getValue());
//        System.out.println("Max->"+maxEntry.getValue());



        //fetching all characters of min and max values and printing them
        for(Map.Entry<Character,Integer> entry:charMap.entrySet()) {
            if(entry.getValue().equals(minEntry.getValue())){
                System.out.println("Min:"+entry.getKey()+" appears "+minEntry.getValue()+" times.");
            }
            else if(entry.getValue().equals(maxEntry.getValue())){
                System.out.println("Max:"+entry.getKey()+" appears "+maxEntry.getValue()+" times.");
            }
        }

    }
}

