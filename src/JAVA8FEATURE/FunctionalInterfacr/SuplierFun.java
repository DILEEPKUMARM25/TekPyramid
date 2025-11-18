package JAVA8FEATURE.FunctionalInterfacr;

import java.util.List;
import java.util.Objects;
import java.util.function.Supplier;

public class SuplierFun {
    public static void main(String[] args) {
//        Supplier s=()->"no ";
//        System.out.println(  s.get());
        List<String> li= List.of("hbsj","jhbasj");
        System.out.println(li.stream().findAny().orElseGet(()->"no"));;//2
    }
}
