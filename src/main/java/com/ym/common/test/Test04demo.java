package com.ym.common.test;

/*
 *      @autor ym
 *      test StringOperation  Encode  && Decode
 * */

import com.ym.common.code.StringOperation;

public class Test04demo {

    public static  void main(String[] args)throws Exception {
        StringOperation so = new StringOperation();
        String s = "吕诗文";
        String s1 = so.Encode(s,"Unicode");
        System.out.println(s1);
        System.out.println(so.Decode(s1,"Unicode"));


        System.out.println(s.hashCode());
    }
}
