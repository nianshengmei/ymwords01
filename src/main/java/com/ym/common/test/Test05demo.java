package com.ym.common.test;

import com.ym.common.io.OpTxt;
import com.ym.common.reptile.Reptile;

import java.io.IOException;

public class Test05demo {

    public static void main(String[] args) throws IOException {
        Reptile reptile = new Reptile();
        String url = "https://fanyi.baidu.com/v2transapi";
        StringBuilder s = reptile.fromURLGetHtml(url);
        OpTxt txt = new OpTxt();
        txt.write("E://picture/test/123.txt",s.toString());
    }
}
