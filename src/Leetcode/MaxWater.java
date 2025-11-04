package Leetcode;


public class MaxWater {
    public static void main(String[] args) {
        int[] arr= {1,8,6,2,5,4,8,3,7};
        System.out.println(area(arr));
    }

    private static int area(int[] arr) {
        // TODO Auto-generated method stub
        int	max=0;
        int i=0,j=arr.length-1;
        while(i<j) {
            int h=Math.min(arr[i], arr[j]);
            int w=j-i;
            int area=w*h;
            max=Math.max(max, area);
            if(arr[i]>arr[j]) {
                j--;
            }
            else
                i++;
        }

        return max;
    }

}
