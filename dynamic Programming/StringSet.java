import java.util.*;
public class StringSet{


    public static void print1D(int[] arr){
        for (int ele : arr){
            System.out.print(ele+" ");
        }
       }
   
       public static void print2D(int[][] arr){
         for (int[] a : arr){
             print1D(a);
         }
       }

    public static void main(String[] args) {
        
    }


    public static void palindromicSubstring(String str, boolean[][] dp){
        int n = str.length();
        for (int gap = 0; gap < n; gap++){
            for (int i = 0, j = gap; j < n; i++, j++){
                  if (gap == 0){
                    dp[i][j] = true;
                  }
                  
                  else if (gap == 1  ){
                      dp[i][j] = str.charAt(i) == str.charAt(j);
                  }
                  else{
                      dp[i][j] = (str.charAt(i) == str.charAt(j)) && dp[i+1][j-1];
                  }
            }
        }
    }

    //Date : 28-10-2020
    //leectcode 5


    
    //leetcode 647

    
}