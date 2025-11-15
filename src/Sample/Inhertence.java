package Sample;

public class Inhertence  {
int i;
    Inhertence(){
    try{
        i=1/0;
        add();
        System.out.println("hello");
    }
    catch(ArithmeticException e){
        System.out.println("Arithmetic Exception");
    }
        System.out.println("hiui");
    }

    public static void main(String[] args) {

        Inhertence i=new Inhertence();

    }
    static void add(){
        System.out.println("Inhertence added");
    }
}
