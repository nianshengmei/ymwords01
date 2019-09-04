package com.ym.common.test;

import java.util.ArrayList;
import java.util.List;

public class Test06demo {

    private static int a;
    private static int ans;
    private static void test(){

       int[][] nums = new int[a][a];
       int key = 1;
       for(int i = 0; i<a;i++){
           List<int[]> is = getArray(i);
           for (int[] s:is
           ) {
               nums[s[1]][s[0]] = key;
               if(key == a){
                   ans = s[1]+s[0]+1;
               }
               key++;
           }

       }

       for(int i = 0;i<a;i++){
           for(int j=0;j<a-i;j++){
               System.out.print(nums[i][j]+"  ");
           }
           System.out.println();
       }

    }

    private static List<int[]> getArray(int sum){
        ArrayList<int[]> ret = new ArrayList<int[]>();
        for(int i = 0;i<a;i++){
            for (int j =0;j<a;j++){
                if(i+j == sum){
                    ret.add(new int[]{i,j});
                }
            }
        }
        return ret;
    }




    public static  void main(String[] args){
        a=171;
       test();
       System.out.println(ans+"行---"+ans+"列");
    }
}
