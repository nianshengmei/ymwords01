package com.ym.common.code;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;

public class StringOperation {


    public String toUpperString(String string){
       return string.toUpperCase();
    }

    public String toLowerString(String string){
        String s = string.toLowerCase();
        return s;
    }


    public boolean isLowercaseCharacter(char c){
     boolean ret = false;
     if(c>='a' && c<='z'){
         ret = true;
     }
     return ret;
    }

    public boolean isUppercaseCharacter(char c){
        boolean ret = false;
        if(c>='A' && c<='Z'){
            ret = true;
        }
        return ret;
    }

    public boolean isCharacter(char c){
        boolean ret = false;
        if((c>='A' && c<='Z') ||(c>='a' && c<='z')){
            ret = true;
        }
        return ret;
    }

    public String toUnicode(String s){
        char[] chars = s.toCharArray();
        StringBuilder builder = new StringBuilder();
        for(char c:chars){
            builder.append("\\u"+ Integer.toHexString((int)c)+"");
        }
        return builder.toString();
    }

    public String fromUnicode(String unicode){
        String[] ss = unicode.split("\\\\u");
        String ret = "";
        for(int i=1;i<ss.length;i++){
            ret += (char) Integer.valueOf(ss[i], 16).intValue();
        }
        return ret;
    }

    public String toURLCode(String s) throws UnsupportedEncodingException {
        return URLEncoder.encode(s,"UTF-8");
    }

    public String fromURLCode(String s) throws UnsupportedEncodingException {
        return URLDecoder.decode(s,"UTF-8");
    }

    public String Encode(String content, String code) throws UnsupportedEncodingException {
        return URLEncoder.encode(content,code);
    }

    public String Decode(String content, String code) throws UnsupportedEncodingException {
        return URLDecoder.decode(content,code);
    }

    public String deleteLeftAndRight(String s){
        return s.substring(1,s.length()-1);
    }

    public String deleteRedundantSpace(String initialString){
        return initialString.replaceAll("\\s+"," ");
    }

    private String deleteNumber(String s ){         //删除数字
        return s.replaceAll("\\d+", "").trim();
    }

    private int getNumber(String s){    //获得字符串中的数字
        String ret = "";
        for(int i =0;i<s.length();i++){
            if(s.charAt(i)>='0' &&s.charAt(i)<='9'){
                ret+=s.charAt(i);
            }
        }
        return Integer.parseInt(ret);
    }

}
