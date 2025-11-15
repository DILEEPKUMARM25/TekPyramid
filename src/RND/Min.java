package RND;

class Max{

    public static void main(String[] args){
        String str="abbcccd";
        int min=0,max=0;
        int[] arr=new int[26];
        for(int i=0;i<str.length();i++){
            char ch=str.charAt(i);
            arr[ch-'a']++;
        }

        for(int i=0;i<arr.length;i++){
            if(arr[i]< min){
                min=i;

            }
            if(arr[i]>max){
                max=i;
            }
        }


        System.out.println("the mac value " +(char)(max+'a'));
        System.out.println("the min value " +(char)(min+'a'));

    }

}