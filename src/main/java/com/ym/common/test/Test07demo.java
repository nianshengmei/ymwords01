package com.ym.common.test;

import com.ym.common.io.OpTxt;
import com.ym.common.reptile.Reptile;

import java.io.IOException;

public class Test07demo {

    public static void main(String[] args) throws IOException {

        String url = "http://dict.youdao.com/search?q=%E7%88%AC%E8%99%AB&keyfrom=new-fanyi.smartResult";
        StringBuilder s = new Reptile().getPage(url);
        String str = new String(s.toString().getBytes("ISO-8859-1"),"UTF-8");
        OpTxt txt = new OpTxt();
        txt.write("E://picture/test/1234.html",s.toString());

    }
}
