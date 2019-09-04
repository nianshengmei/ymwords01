package com.ym.test;

import com.ym.common.io.OpXlsx;

import java.util.ArrayList;
import java.util.List;

public class ReadXLSX {


    public static List<String> ReadXlsx(String fileName){
        List<String> ret = new ArrayList<String>();
        OpXlsx ox = new OpXlsx();
        try {
            ret = ox.fileReader(fileName);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return ret;
    }
}
