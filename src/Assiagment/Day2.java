package Assiagment;

import java.util.Arrays;

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
        System.out.println("the first Lorgest element - "+ first);
        System.out.println("the secound Lorgest element - "+ secound);
        System.out.println("the third Lorgest element - "+ third);

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
