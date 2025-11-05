package Sample;


interface A{
    void eat();
    void code();
}
interface B extends A
{
    @Override
    default void code() {
        System.out.println("Code");
    }
    @Override
    default  void eat()
    {
        System.out.println("Eat");
    }
}






public class IterfacesClass  implements B{


    public static void main(String[] args) {
        B b=new B() {};
        b.code();
        b.eat();

    }
}
