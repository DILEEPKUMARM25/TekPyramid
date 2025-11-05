package Sample;

class aa{
    static  int a=10;
    static  void a(){
        System.out.println("aaa");
    }

}

public class Inhertence extends aa {

    public static void main(String[] args) {
        System.out.println(a);
        a();
    }
}
