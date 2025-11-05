package Assiagment;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedHashMap;



/*
 *1. Java Program to Find the Frequency of Elements in an Array

 *2. Java Program to Left Rotate the Elements in an Array by 2 Positions

 *3. Java Program to Right Rotate the Elements in an Array by 2 Positions

 *4. Java Program to Print the Duplicates from an Array

 *5. Java Program to Remove the Duplicates from an Array

 */


public class Day1 {
    public static void main(String[] args) {
        feq();
        duplicate();
        removeduplicate();
        left();
        right();
        leftc();
        rightc();
    }

    //------------------------------feq
    static void feq() {
        String str="hellohowareyou";

        LinkedHashMap<Character,Integer> map=new LinkedHashMap<Character,Integer>();
        for(char ch:str.toCharArray()) {
            map.put(ch, map.getOrDefault(ch, 0)+1);

        }

        map.forEach((key,value)->{
            if(value>0)
                System.out.print(key +"->"+value + "  ");

        });
        System.out.println();
    }




    static void duplicate() {
        String str="hellhowareyou";

        LinkedHashMap<Character,Integer> map=new LinkedHashMap<Character,Integer>();
        for(char ch:str.toCharArray()) {
            map.put(ch, map.getOrDefault(ch, 0)+1);

        }

        map.forEach((key,value)->{
            if(value==1)
                System.out.print(key +"->"+value + "  ");
        });
        System.out.println();
    }




    static void removeduplicate() {
        String str="hellhowareyou";

        LinkedHashMap<Character,Integer> map=new LinkedHashMap<Character,Integer>();
        for(char ch:str.toCharArray()) {
            map.put(ch, map.getOrDefault(ch, 0)+1);

        }

        map.forEach((key,value)->{
            if(value>1)
                System.out.print(key +"->"+value + "  ");
        });
        System.out.println();
    }


    static void left() {
        int[] arr= {1,2,3,4,5};
        for(int i=0;i<2;i++) {
            int a=arr[0];
            for(int j=0;j<arr.length-1;j++) {
                arr[j]=arr[j+1];
            }
            arr[arr.length-1]=a;

        }
        System.out.println(Arrays.toString(arr));
    }

    static void right() {
        int[] arr= {1,2,3,4,5};
        for(int i=0;i<2;i++) {
            int a=arr[arr.length-1];
            for(int j=arr.length-1;j>0;j--) {
                arr[j]=arr[j-1];
            }
            arr[0]=a;

        }
        System.out.println(Arrays.toString(arr));
    }

    ///collection
    static void leftc() {
        int[] arr= {1,2,3,4,5};
        ArrayList list=new ArrayList();
        for(int a:arr) {
            list.add(a);
        }
        for(int i=0;i<2;i++) {
            Object a1 = list.get(0);
            list.remove(0);
            list.add(a1);
        }
        System.out.println(list);

    }

    static void rightc() {
        int[] arr= {1,2,3,4,5};
        ArrayList list=new ArrayList();
        for(int a:arr) {
            list.add(a);
            //sdf
        }
        for(int i=0;i<2;i++) {
            Object a1 = list.get(list.size()-1);
            list.remove(list.size()-1);
            list.add(0,a1);
        }
        System.out.println(list);

    }

}
