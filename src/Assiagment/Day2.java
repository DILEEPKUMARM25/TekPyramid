package Assiagment;

import java.util.Arrays;

/*
*6. Java Program to Print the Largest Element in an Integer Array without Using a Sorting Algorithm
*7. Java Program to Print the 2nd Largest Element in an Integer Array without Using a Sorting Algorithm
*8. Java Program to Print the 3rd Largest Element in an Integer Array without Using a Sorting Algorithm
*9. Java Program to Sort Elements in an Array Using Bubble Sort
10. Java Program to Find the Total Number of Punctuations Present in a String
 */


public class Day2 {
    public static void main(String[] args) {
        int[] arr= {5,3,1,4,8,2,6};
        maxFirst(arr);
        maxsecond(arr);
        maxthird(arr);
        bubble(arr);
        punctuation();
    }

    private static void punctuation() {
        String str="Hello, world! How are you doing today?";
//		int count=0;
//		for(int i=0;i<str.length();i++) {
//			char ch=str.charAt(i);
//			 if (ch == '!' || ch == ',' || ch == ';' || ch == '.' || ch == '?' || ch == '-' || ch == '\'' || ch == '\"' || ch == ':')
//	                count++;
//		}
//		System.out.println(count);

        String pun=str.replaceAll("[^//p{punct}]", "");
        System.out.println(pun.length());
    }

    private static void bubble(int[] arr) {
        for(int i=0;i<arr.length;i++) {
            for(int j=0;j<arr.length-i-1;j++)
            {
                if(arr[j]>arr[j+1]) {
                    int temp=arr[j];
                    arr[j]=arr[j+1];
                    arr[j+1]=temp;
                }
            }
        }
        System.out.println(Arrays.toString(arr));
    }

    private static void maxthird(int[] arr) {

        int first=0,secound=0,third=0;
        for(int i=0;i<arr.length;i++) {
            if(arr[i]>first) {
                third=secound;
                secound=first;
                first=arr[i];
            }
            else if(arr[i]>secound && arr[i]!=first) {
                third=secound;
                secound=arr[i];
            }
            else if(arr[i]>third && arr[i]!=first&&arr[i]!=secound) {
                third=arr[i];
            }
        }
        System.out.println("the first Lorgest element - " + first);
        System.out.println("the secound Lorgest element - " + secound);
        System.out.println("the third Lorgest element - "  + third);

    }
    private static void maxsecond(int[] arr) {

        int first=0,secound=0;
        for(int i=0;i<arr.length;i++) {
            if(arr[i]>first) {
                secound=first;
                first=arr[i];
            }
            else if(arr[i]>secound && arr[i]!=first) {
                secound=arr[i];
            }
        }
        System.out.println("the first Lorgest element - "+ first);
        System.out.println("the secound Lorgest element - "+ secound);

    }

    private static void maxFirst(int[ ] arr) {

        int first=arr[0];
        for(int i=0;i<arr.length;i++) {
            if(arr[i]>first)
                first=arr[i];
        }
        System.out.println("the first Lorgest element - "+ first);

    }
}
