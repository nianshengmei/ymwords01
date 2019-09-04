package com.ym.common.test;

import com.ym.common.code.StringOperation;

/*
 *   @autor ym
 *   test StringOperation    toUnicode  && fromUnicode
 * */
public class Test02demo {

    public static  void main(String[] args){
        String s = "吕诗文";
        String s1 = new StringOperation().toUnicode(s);
        System.out.println(s1);

        System.out.println(new StringOperation().fromUnicode(s1));

    }
}
