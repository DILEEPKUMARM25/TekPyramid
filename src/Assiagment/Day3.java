package Assiagment;
/*
*11. Java Program to Find the Total Number of Vowels Present in a String
*12. Java Program to Find the Total Number of Consonants Present in a String
*13. Java Program to Determine if Two Strings are Anagrams
14. Java Program to Divide a String into N Parts
15. Java Program to Find All Subsets of a String (Example: Subsets of "FUN" -> F, FU, FUN, U, UN, N)
 */
import java.util.Arrays;
public class Day3 {
    public static void main(String[] args) {
        vowelAndConsonant("vassuvnassoisdbdfbwiiw");
        anagram();
       part();
        fun();
    }
    private static void part() {
        int a=8;
        String str="helloworldjava";
        int len=str.length();
        if(len%a!=0){
            int no=len%a;
            System.out.println("we can not make parts using that string - "+str);
            System.out.println("that remain charector is "+str.substring(str.length()-no));
            return;
        }

            int part = len / a;
            for (int j = 0; j < len; j += part) {
                System.out.println(str.substring(j, j + part));

        }
        }

    private static void fun() {
        String str="FUN";
     for(int i=0;i<str.length();i++){
         for (int j=i+0;j<str.length();j++){
             System.out.print(str.substring(i,j+1 )+" ");
         }
     }
    }

    private static void anagram() {
        String word="race";
        String word1="care";
        char[] arr=word.toCharArray();
        char[] arr1=word1.toCharArray();
        Arrays.sort(arr);
        Arrays.sort(arr1);
        if(arr.length!=arr1.length){
            System.out.println("not anagram");
        }
        else {
           if(Arrays.equals(arr,arr1)){
               System.out.println("anagram");
           }else  {
               System.out.println("not anagram");
           }
        }
    }

    private static void vowelAndConsonant(String s) {
        String vowel=s.replaceAll("[^aeiouAeiou]","");
        System.out.println("vowel length:"+ vowel.length());
        String Con=s.replaceAll("[aeiouAeiou]","");
        System.out.println("Consonants length:"+ Con.length());
    }
}
