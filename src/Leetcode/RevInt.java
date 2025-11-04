package Leetcode;

public class RevInt {

        public static void main(String[] args) {
            long no=123;
            System.out.println(aa(no));
        }

        private static int aa(long no) {

            long res=0;
            while(no!=0) {
                long rem=no%10;
                res=res*10+rem;
                no/=10.0;

            }
//		System.out.println(res);
//		System.out.println(Integer.MAX_VALUE);
//		System.out.println(Integer.MIN_VALUE);
//
            if(res >Integer.MAX_VALUE || res<Integer.MIN_VALUE ) {
                return 0;
            }
            return (int)res;

        }

    }
