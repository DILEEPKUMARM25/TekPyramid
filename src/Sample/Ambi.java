package Sample;


import java.util.*;

public class Ambi   {


        public static void main(String[] args) {
            ArrayList<Integer> list = new ArrayList<>();
            ArrayList<Integer> list1 = new ArrayList<>();
            list.add(1);
            list.add(2);
            list.add(3);
            list.add(4);
            list1.add(1);
            list1.add(5);
            list1.add(8);
            list1.add(4);
            list.add(6);
         list.removeAll(list1);
            System.out.println(list);
            System.out.println(list1);
//            list.remove(2);
//            System.out.println(list);
//            Iterator a=list.iterator();
//            for(Integer i : list){
//                a.next();
//                a.remove();
//            }
//            for(Integer x : list){
//                if (x==40){
//                    list.remove(x);
//                }
//            }

//        // Remove all "Banana" using for loop
//        for (int i = 0; i<=list.size()-1; i++) {
//            if (list.get(i)==40 ){
//                list.remove(i);
//            }
//        }

//            Iterator<Integer> itr = list.iterator();

//            System.out.println("Final List: " + a.next());
//            a.forEachRemaining(System.out::println);
            Iterator<Integer> itr = list.iterator();

//            while (itr.hasNext()) {
//                int x = itr.next();
//                if (x > 50) {
//                    itr.forEachRemaining(System.out::println);
//                    break;
//                }
//                Collection
//            }


        }
    }



