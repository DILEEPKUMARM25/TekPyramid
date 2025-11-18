package JAVA8FEATURE.FunctionalInterfacr;

import java.util.List;
import java.util.function.Predicate;

/// interface give true oe false as output use filler java
public class PredicateFu {
    public static void main(String[] args) {
//        Predicate<Integer> p= t->t%2==0;
//        System.out.println(p.test(5)); // give true or false with method using test()
        List<Integer> li= List.of(2, 5, 2, 5, 8, 7, 2, 85);//if generic speciefy or else its not work % at filter
//        li.stream().filter(p).forEach(System.out::println);//filtermwthod internally use predicate interface //fo
        // for each use consumer fun interface
        li.stream().filter(l-> l % 2==0).forEach(l-> System.out.println("the no "+l));
    }
}
