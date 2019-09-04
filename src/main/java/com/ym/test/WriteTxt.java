package com.ym.test;

import com.ym.common.io.OpTxt;
import com.ym.common.vocabuary.Word;
import com.ym.common.vocabuary.WordUtils;

import java.io.IOException;
import java.util.List;

public class WriteTxt {

    private OpTxt opTxt = new OpTxt();
    public void WriteTxtEnglish(String fileName, List<Word> words){
        int i = 1;
        String line="";
        for(Word w:words){
            line += i +"、"+w.getWord()+"\n\n";
            i++;
        }
        try {
            opTxt.write(fileName,line);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void WriteTxtChinese(String fileName, List<Word> words){
        int i = 1;
        String line="";
        for(Word w:words){
            line += i +"、"+new WordUtils().backInterpretation(w.getInterpretation())+"\n\n";
            i++;
        }
        try {
            opTxt.write(fileName,line);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    public void WriteTxtAll(String fileName, List<Word> words){
        int i = 1;
        String line="";
        for(Word w:words){
            line += i +"、"+w.getWord()+": "+new WordUtils().backInterpretation(w.getInterpretation())+"\n\n";
            i++;
        }
        try {
            opTxt.write(fileName,line);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
