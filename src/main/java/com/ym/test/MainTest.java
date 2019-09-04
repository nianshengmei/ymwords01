package com.ym.test;

import com.ym.common.code.Number;
import com.ym.common.vocabuary.Word;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class MainTest {

    public static void main(String[] args){
        List<String> allString = ReadXLSX.ReadXlsx("E:\\eng\\bnc15000.xlsx");

        int pages = allString.size()/20;
        for(int i = 31;i<=pages;i++){
            int n = i;
            int[] numList = GetNumList.getNumListBYPageNumber(n);

            List<Word> allWords =RepiteYoudaoByStringWord.getAllWordsByPageNum(allString,numList);
            WriteTxt wt = new WriteTxt();
            Number number = new Number();
            String dateString = "第"+number.numberToString(i)+"天";

            File file = new File("E:\\eng\\英语词汇默写集\\"+dateString);
            if(!file.exists()){
                file.mkdir();
            }
            wt.WriteTxtEnglish("E:\\eng\\英语词汇默写集\\"+dateString+"\\看英文默写中文.doc",allWords);
            wt.WriteTxtChinese("E:\\eng\\英语词汇默写集\\"+dateString+"\\看英文写中文.doc",allWords);
            wt.WriteTxtAll("E:\\eng\\英语词汇默写集\\"+dateString+"\\答案.doc",allWords);
        }



    }
}
