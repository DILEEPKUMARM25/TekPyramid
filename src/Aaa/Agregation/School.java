package Aaa.Agregation;

import java.util.Arrays;



class Sample{
    String name;
    int age;
    Sample(String name, int age){
        this.name = name;
        this.age = age;
    }
}


public class School {

    public static void main(String[] args) {
        ///  String Builder
        StringBuilder str=new StringBuilder("hello");
        rev(str);
        System.out.println(str); //hello

        // StringBuffer
        StringBuffer buf=new StringBuffer("hel");
        need(buf);
        System.out.println(buf);//len

// String arr
        String[] arr={"gdsu","kbhdsg","hbsdu","jkhdfs"};
        revString(arr);
        System.out.println(Arrays.toString(arr));

    //   class DataType
    Sample s=new Sample("gdsu",18);
    change(s);
        System.out.println(s.name + " " + s.age);

        //primitive datatype
        int x=10;
        aaa(x);
        System.out.println(x);

    }

    private static void aaa(int x) {
        x=30;
    }

    private static void change(Sample s) {
        s.name="aa";
        s.age=20;
    }


    static void rev(StringBuilder str1){
        str1= str1.reverse();
        str1=str1.append("hello");
        str1=str1.append(" huuu");

    }




    private static void need(StringBuffer buf) {
        buf=buf.reverse();
    }

    private static void revString(String[] a) {
        String res="";
        int i=0;
        int len=a.length-1;
       while(i<len){
          String temp=a[i];
          a[i]=a[len];
          a[len]=temp;
          i++;
          len--;
       }
    }
}
