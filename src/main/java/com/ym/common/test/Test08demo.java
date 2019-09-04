package com.ym.common.test;

import com.ym.common.reptile.Reptile;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

import java.io.IOException;

public class Test08demo {

    public static  void main(String[] args) {
        Reptile reptile = new Reptile();
        String s ="";
        try {
            s = reptile.fromEnglishGetDetail("reptile");
        }catch (Exception ex){
            ex.printStackTrace();
        }

        try
        {
            Document document = Jsoup.connect(s).get();
            Element element =  document.getElementById("webPhrase");
            System.out.println(element.toString());
        }
        catch (IOException e) {
            e.printStackTrace();
        }

    }
}
