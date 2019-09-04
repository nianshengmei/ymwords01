package com.ym.common.test;

/*
*   @autor ym
*   test StringOperation    toUpperString
* */

import com.ym.common.code.StringOperation;

public class Test01demo {

    public static  void main(String[] args){


        String s = "abc345ASDa##ERTaaxcEasE33";
        String s1 = new StringOperation().toUpperString(s);
        System.out.println(s+"\n"+s1);
    }
}
