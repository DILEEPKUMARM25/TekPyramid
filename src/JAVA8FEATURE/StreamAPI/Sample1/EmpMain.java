package JAVA8FEATURE.StreamAPI.Sample1;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class EmpMain {

    static  List<Employee> getMax(String max){
//        if(max.equals("max")){
//            System.out.println("max reach");
//            //collect by using that we can collect elemet as list set map
//            // filter use to filtergenation
//            return EmpData.getData().stream().filter(t->t.getSalary()>19000).collect(Collectors.toList());
//        }
//        else{
//            System.out.println("no max reach");
//            return EmpData.getData().stream().filter(t->t.getSalary()<19000).collect(Collectors.toList());}


        //use ternary operator
        return (max.equals("max"))?EmpData.getData().stream().filter(t->t.getSalary()>19000).collect(Collectors.toList())
                :EmpData.getData().stream().filter(t->t.getSalary()>19000).collect(Collectors.toList());
    }


    static void sortEmp(){
        List<Employee> list = EmpData.getData();
        // sort based on the salary

        //normal
//        Collections.sort(list, (e1, e2) -> (int)(e2.getSalary()-e1.getSalary()));//Decending
//        System.out.println(list);


        //1 ways
        //list.stream().sorted((e1, e2) -> (int)(e2.getSalary()-e1.getSalary())).forEach(System.out::println);
        //2 way
        list.stream().sorted(Comparator.comparing(Employee::getSalary).reversed()).forEach(System.out::println);
        list.stream().sorted(Comparator.comparing(Employee::getName )).forEach(System.out::println);
    }

    public static void main(String[] args) {
       // System.out.println( getMax("max"));
        sortEmp();
    }
}
