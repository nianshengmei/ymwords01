package com.ym.common.io;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class ReadFiles {
    private String deleteNumberAndPoint(String s ){
        return s.replaceAll("\\d+", "").replace(".","").trim();
    }

    private int getNumber(String s){
        String ret = "";
        for(int i =0;i<s.length();i++){
            if(s.charAt(i)>='0' &&s.charAt(i)<='9'){
                ret+=s.charAt(i);
            }
        }
        return Integer.parseInt(ret);
    }

    public List<Pic> readFiles(String path){
        List<Pic> ret = new ArrayList<Pic>();
        File file= new File(path);
        String[] ss = file.list();
        for(String s:ss){
            String temp = s;
            s= s.replace(".jpg","").replace(".JPG","");
            s= deleteNumberAndPoint(s);
            int id = getNumber(temp);
            Pic pic = new Pic(id,s);
            ret.add(pic);
        }

        return ret;
    }


    public static  void main(String[] args){
        List<Pic> ps = new ReadFiles().readFiles("E:\\picture\\公民科学家鸟\\公民科学家鸟");
        for(Pic p:ps){
            System.out.println("INSERT INTO `xuanxiang_bank` VALUES ('" +
                    p.getIndex()+"', '001', '"+
                    p.getName()+
                    "', null, null, null, null, null, null, null, null);");
        }
    }
}
