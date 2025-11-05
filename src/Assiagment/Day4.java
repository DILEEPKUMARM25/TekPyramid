package Assiagment;
/*
16. Java Program to Find the Maximum and Minimum Occurring Characters in a String

*17. Java Program to Replace the Spaces in a String with a Specific Character

*18. Java Program to Replace Lower-Case Characters with Upper-Case and Vice-Versa

*19. Java Program to Determine Whether a Given String is a Palindrome

*20. Java Program to Determine Whether One String is a Rotation of Another

*21. Java Program to Reverse a String Character by Character

*22. Java Program to Reverse a String Word by Word (Example: "I Love Programming" -> "Programming Love I")

*23. Java Program to Print the Duplicate Words in a String


 */

import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.Map;

public class Day4 {


    public static void main(String[] args) {
        maxAndMin();
        maxAndMinCollection();
        rePlace();
        upperLower();
        palindrom();
        rotation();
        charactorTocharactor();
        wordRev();
        duplicateWord();

    }

    private static void maxAndMinCollection() {
        String word="aabzbcfjssjdskbk";
        LinkedHashMap<Character, Integer> map=new LinkedHashMap<>();
        for (char c:word.toCharArray()){
            map.put(c,map.getOrDefault(c,0)+1);
        }

        char max=' ';
        char min=' ';
        int maxvalue=Integer.MIN_VALUE;
        int minvalue=Integer.MAX_VALUE;
        for(Map.Entry<Character, Integer> entry:map.entrySet()){
        int value=entry.getValue();
        if(value>maxvalue){
            maxvalue=value;
            max=entry.getKey();
        }
        if(value<minvalue){
            minvalue=value;
            min=entry.getKey();
        }
        }
        System.out.println("max is - "+ max +" "+maxvalue);
        System.out.println("min is - "+ min +" "+minvalue);
    }

    private static void duplicateWord() {
        String word="aabbcdhjksjsaaa";
        LinkedHashSet set=new LinkedHashSet();
        for (int i = 0; i < word.length(); i++) {
            set.add(word.charAt(i));
        }
        System.out.println(set);
    }

    private static void wordRev() {
        String str="i love programming";
        String[] words = str.split(" ");
        int i=0;
        int j=words.length-1;
        while(i<j){
            String temp=words[i];
            words[i]=words[j];
            words[j]=temp;
            i++;
            j--;
        }
        System.out.println(Arrays.toString(words));
    }

    private static void charactorTocharactor() {
        String str="hello";
        String res="";
        for(int i=0;i<str.length();i++){
            res=str.charAt(i)+res;
        }
        System.out.println(res);
    }

    private static void rotation() {
        String str="ABCD";
        String str1="BCDA";
        String str2=str+str;

        for(int i=0;i<str2.length()-4;i++){
            String temp=str2.substring(i,i+4);

            if(temp.equals(str1)) {
                System.out.println("its part of rotation");
                return;
            }

        }
        System.out.println("its not part of rotation");
    }

    private static void palindrom() {
        String str="mom";
        String res="";
        for(int i=0;i<str.length();i++){
            res=str.charAt(i)+res;
        }
        if(str.equals(res)){
            System.out.println("Palindrom");
        }else {
            System.out.println("Not palindrom");
        }
    }

    private static void upperLower() {
        String str="HelLOii";
        char[] arr=str.toCharArray();
       for (int i=0;i<arr.length;i++) {
           if(arr[i]>='A'&&arr[i]<='Z') {
               arr[i]=(char)(arr[i]+32);
           }
           else if(arr[i]>='a'&&arr[i]<='z') {
               arr[i]=(char)(arr[i]-32);
           }
       }
        System.out.println(Arrays.toString(arr));
    }

    private static void rePlace() {
        String str="hgas kbsaj nghsac  sdvsa";
        String Str1=str.replaceAll(" ","@");
        System.out.println(Str1);
    }


    static void maxAndMin(){
        String str="aabcccd";
        int[] arr=new int[26];
        for (int i = 0; i < str.length(); i++) {
            arr[str.charAt(i)-'a']++;
        }
        int maxIndex=0;
        int minindex=0;
        int max=Integer.MIN_VALUE;//arr[0]
        int min=Integer.MAX_VALUE;//arr[0]

  for (int i=0;i<26;i++){
      if(arr[i]>max && arr[i]!=0){
        maxIndex=i;
        max=arr[i];

      }
      if(arr[i]<min && arr[i]!=0){
        minindex=i;
        min=arr[i];
      }
  }


        System.out.println("the max charactor is "+ (char)(maxIndex+'a')+"-> "+max);
        System.out.println("the min charactor is "+ (char)(minindex+'a')+"-> "+minindex);
    }
}
