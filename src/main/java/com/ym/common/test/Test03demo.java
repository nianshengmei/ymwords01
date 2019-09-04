package com.ym.common.test;

import com.ym.common.code.StringOperation;

/*
*      @autor ym
*      test StringOperation  toURLcode  && fromURLcode
* */
public class Test03demo {

    public static  void main(String[] args) throws Exception {
        StringOperation so = new StringOperation();
        String s = "吕诗文";
        String s1 = so.toURLCode(s);
        System.out.println(s1);

        System.out.println(so.fromURLCode(s1));


    }
}
