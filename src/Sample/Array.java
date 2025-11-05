package Sample;

import java.util.Arrays;

public class Array {


        public static void main(String[] args) {
            String s="hello";
            String[] sArr={"hello", "dear"};
            fxn(s);
            System.out.println("s->"+s);
            mthd(sArr);
            System.out.println("sArr->"+ Arrays.toString(sArr));
        }

        public static void fxn(String x){
            x=x+"NEW";
        }

        public static void mthd(String[] xx){
            xx[1]="jalib";//the memory address pointing to the array sArr is copied to xx
        }


    }



