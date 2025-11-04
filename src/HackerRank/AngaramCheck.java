package HackerRank;

public class AngaramCheck {

    public static void main(String[] args) {
        String str="Dbc";
        String str1="dbc";
        System.out.println(check(str,str1));;
    }

    private static Boolean check(String str, String str1) {

        str=str.toLowerCase();
        str1=str1.toLowerCase();
        int[] arr=new int[26];
        for(char ch:str.toCharArray())
            arr[ch-'a']++;
        for(char ch:str1.toCharArray())
            arr[ch-'a']--;
        for(int i=0;i<arr.length;i++) {
            if(arr[i]!=0) {
                return false;
            }

        }
        return true;
    }


}

