package RND;

class Div{

    public static void main(String[] args){
        String str="abcabcaaaa";
        int part=2;

        int len=str.length();
        if(len%part!=0){
            System.out.println("we can not divied equally");
            return;
        }

        for(int i=0;i<str.length();i=i+part){
            System.out.println(str.substring(i,i+part));
        }

    }

}