package com.ym.test;

public class GetNumList {

    private static int pageMax = 20;
    public static int[] getNumListBYPageNumber(int i ){
        int[] ret = new int[pageMax];
       if(i<=0){
           throw new ArrayIndexOutOfBoundsException();
       }else{
           for(int j = i*pageMax+1; j<=pageMax*(i+1);j++){
               ret[j-i*pageMax-1] = j;
           }
           return ret;
       }
    }
    public static void setPageMax(int pageMaxl) {
        pageMax = pageMaxl;
    }
}
