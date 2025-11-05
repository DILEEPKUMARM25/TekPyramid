package Assiagment;

import java.util.Arrays;

/*
.
25. Java Program to Add Two Matrices
26. Java Program to Multiply Two Matrices
27. Java Program to Find the Transpose of a Matrix
 */

public class Day5 {
    public static void main(String[] args) {
addMatrix();
multipleMatrix();
tracepose();

    }

    private static void tracepose() {
        int[][] arr={{1,2,3},
                     {4,5,6},
                     {7,8,9}
                    };

        for(int i=0;i<arr.length;i++){
            for(int j=arr.length-1;j>=0;j--){
                System.out.print(arr[j][i]+" ");
            }
            System.out.println();
        }


    }

    private static void multipleMatrix() {
        int[][] arr={{1,2,3},{4,5,6},{7,8,9}};
        int[][] arr2={{1,2,3},{4,5,6},{7,8,9}};
        int[][] arr3=new int[3][3];
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                for (int  k = 0; k < 3; k++) {
                    arr3[i][j]=arr[i][k]+arr2[k][j];
                }

            }
        }
        System.out.println(  Arrays.deepToString(arr3));
    }

    private static void addMatrix() {

        int[][] arr={{1,2,3},{4,5,6},{7,8,9}};
        int[][] arr2={{1,2,3},{4,5,6},{7,8,9}};
        int[][] arr3=new int[3][3];
        for (int i = 0; i < 3; i++) {
                for (int j = 0; j < 3; j++) {
                    arr3[i][j]=arr[i][j]+arr2[i][j];
                }
        }

        System.out.println(Arrays.deepToString(arr3));
    }


}
