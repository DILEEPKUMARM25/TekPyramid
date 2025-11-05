package Sample;

public class Sample {
    public static void main(String[] args) {
        new bbb(10);

     ;
        boolean s=true;
        boolean s1=false;
        System.out.println(s1);
    }
}
class aaa{
    aaa(){
        System.out.println("aaa");
    }
    {
        System.out.println("instance aa");
    }
}
class bbb extends   aaa{
    bbb(){
        System.out.println("bbb");
    }
    {
        System.out.println("instance bb");
    }
    bbb(int i){
        System.out.println("bI");
    }
}
