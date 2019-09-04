package com.ym.common.util.translation.youdao;

import com.ym.common.code.StringOperation;
import com.ym.common.reptile.Reptile;
import com.ym.common.util.vocabuary.*;
import com.ym.common.vocabuary.Word;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;

public class YouDaoTrans {
    private static Reptile reptile = new Reptile();

    //字符串操作
    private static StringOperation so = new StringOperation();

    //获取英文音标
    private static String getEnglishPhoneticSymbol(Document document) {
        String sEnglish = "";
        try {
            Elements elements = document.getElementsByClass("phonetic");
            sEnglish = so.deleteLeftAndRight(elements.get(0).text());
        } catch (ArrayIndexOutOfBoundsException ex) {
            ex.printStackTrace();
        }finally {
            return Word.makePhoneticSymbol(sEnglish);
        }

    }

    //获取美式音标
    private static String getAmericanPhoneticSymbol(Document document){
        String sAmerican = "";
        try{
            Elements elements = document.getElementsByClass("phonetic");
            sAmerican = so.deleteLeftAndRight(elements.get(1).text());
        }catch (ArrayIndexOutOfBoundsException ex){
            ex.printStackTrace();
        }finally {
            return Word.makePhoneticSymbol(sAmerican);
        }

    }

    //获取解释
    private static List<String> getInterpretation(Document document){
        List<String> interpretations = new ArrayList<String>();
        try {
            Elements trans = document.select("div#results-contents #phrsListTab .trans-container ul li");
            for (int i = 0; i < trans.size(); i++) {
                interpretations.add(trans.get(i).text());
            }
        }catch (ArrayIndexOutOfBoundsException ex){
            ex.printStackTrace();
        }
        return interpretations;
    }

    //获取网络释义
    private static List<SimpleVocabuary> getWebInterpretation(Document document){
        List<SimpleVocabuary> webInterpretation = new ArrayList<SimpleVocabuary>();
        try{
        Elements  webInterpretations = document.select("div#webPhrase .wordGroup");
        Elements  englishWebInterpretations = document.select("div#webPhrase .wordGroup .contentTitle");
        for(int i = 0;i<englishWebInterpretations.size();i++){
            SimpleVocabuary sv = new SimpleVocabuary();
            String templeEnglish = englishWebInterpretations.get(i).text();
            sv.setEnglish(templeEnglish);
            String templeChinese = webInterpretations.get(i).text().replace(templeEnglish,"");
            sv.setChinese(templeChinese);
            webInterpretation.add(sv);
        } }catch (ArrayIndexOutOfBoundsException ex){
            ex.printStackTrace();
        }
        return webInterpretation;
    }

    //获取柯斯林英汉大词典解析
    private static CollinsDictionary getCollins(Document document){
        CollinsDictionary newCollins = new CollinsDictionary();
        try{
            Elements collins = document.select("div#collinsResult .trans-container .trans-content .collinsToggle .wt-container");
            newCollins.setKeyWord(collins.select("span.title").text());//单词
            String[] css0 = collins.select("span.star").toString().split("class=\"");
            String[] css1 = css0[1].split("\"");
            String className = css1[0];
            newCollins.setPhoneticSymbol(collins.select("em.additional").text()); //音标
            newCollins.setFrequency(className);             //使用频率
            newCollins.setRank(collins.select("span.via").text());  //等级
            newCollins.setAdditionalPattern(collins.select("span.additional").text());      //额外部分
            List<String> exampleSentences = new ArrayList<String>();
            for(int i = 0;i<collins.select("p").size();i++) {
                exampleSentences.add(collins.select("p").get(i).text().replace(collins.select("p .additional").text(),""));
            }
            newCollins.setExampleSentence(exampleSentences);
        }catch (ArrayIndexOutOfBoundsException ex){
            ex.printStackTrace();
        }finally {
            return newCollins;
        }
    }

    //同义词
    private static List<Synonym> getSynonyms(Document document){
        List<Synonym> newSynonyms = new ArrayList<Synonym>();
        try{
            Elements synonyms = document.select("div#transformToggle #synonyms");
            for(int i = 0;i<synonyms.select("li").size();i++){
                Synonym synonym = new Synonym();
                String tempExplains = synonyms.select("li").get(i).text();
                String[] ss = tempExplains.split("\\.");
                String type = ss[0]+".";
                String explains = ss[1];
                ExplainWithType ewt = new ExplainWithType(type,explains);
                ArrayList<String> allWords = new ArrayList<String>();
                for(int j =0;j<synonyms.select("ul p").get(i).select(".contentTitle").size();j++){
                    String w = synonyms.select("ul p").get(i).select(".contentTitle").get(j).text().replace(",","");
                    allWords.add(w);
                }
                synonym.setExplains(ewt);
                synonym.setWords(allWords);
                newSynonyms.add(synonym);
            }
        }catch (ArrayIndexOutOfBoundsException ex){
            ex.printStackTrace();
        }finally {
            return newSynonyms;
        }

    }

    //获取同根词
    private static Conjugate getConjugate(Document document){
        Conjugate conjugates = new Conjugate();
        try{
            Elements conjugate = document.select("div#transformToggle #relWordTab");
            List<SimpleWordWithType> allSimpleWordWithTypes = new ArrayList<SimpleWordWithType>();
            if(conjugate.select("p").size()>0) {
                String root = conjugate.select("p").get(0).text();
                String vc = conjugate.select("#relWordTab").text();
                String s = vc.replace(root,"");
                for (int i = 1;i<conjugate.select("p").size();i++){
                    String w = conjugate.select("p").get(i).select(".contentTitle").text();
                    String ex = conjugate.select("p").get(i).text();
                    String explain = ex.replace(w,"").replace(" ","");
                    s=s.replace(ex," ");
                }
                s= so.deleteRedundantSpace(s).trim();
                String[] ss = s.split(" ");
                for (int i = 1;i<conjugate.select("p").size();i++){
                    String word = conjugate.select("p").get(i).select(".contentTitle").text();
                    String explain = conjugate.select("p").get(i).text();
                    if(i<=ss.length) {
                        String type = ss[i - 1];
                        SimpleWordWithType simpleWordWithType = new SimpleWordWithType(word, explain, type);
                        allSimpleWordWithTypes.add(simpleWordWithType);
                    }
                }
                conjugates.setRoot(root);
            }
            conjugates.setAllWords(allSimpleWordWithTypes);
        }catch (ArrayIndexOutOfBoundsException ex){

        }finally {
            return conjugates;
        }


    }

    //双语例句
    private static List<ExampleSentence> getBilingualExample(Document document, String query){
        List<ExampleSentence> bilingualExample = new ArrayList<ExampleSentence>();
        try{
            String moreExamplesUrl = "http://dict.youdao.com/example/blng/eng/"+query+"/#keyfrom=dict.main.moreblng";
            Document newDocument = Jsoup.connect(moreExamplesUrl).get();
            Elements bilingualExamples = newDocument.select("div#bilingual .ol li");
            for(int i = 0;i<bilingualExamples.size();i++){
                String english = bilingualExamples.get(i).select("p").get(0).text();
                String chinese = bilingualExamples.get(i).select("p").get(1).text();
                String provenance = "http://"+bilingualExamples.get(i).select("p").get(2).text();
                ExampleSentence exs = new ExampleSentence(english,chinese,provenance);
                bilingualExample.add(exs);
            }
        }catch (ArrayIndexOutOfBoundsException ex){
            ex.printStackTrace();
        }catch (IOException ex){
            ex.printStackTrace();
        }finally {
            return bilingualExample;
        }

    }


    public static Word queryWord(String query){
        Word ret = new Word();
        String url = "";
        try {
            url = reptile.fromEnglishGetDetail(query);
            Document document = Jsoup.connect(url).get();
            String englishPhoneticSymbol = YouDaoTrans.getEnglishPhoneticSymbol(document);
            String americanPhoneticSymbol = YouDaoTrans.getAmericanPhoneticSymbol(document);
            List<String> interpretation = YouDaoTrans.getInterpretation(document);
            List<SimpleVocabuary> webInterpretation = YouDaoTrans.getWebInterpretation(document);
            CollinsDictionary collins = YouDaoTrans.getCollins(document);
            List<Synonym> synonyms = YouDaoTrans.getSynonyms(document);
            Conjugate conjugate = YouDaoTrans.getConjugate(document);
            List<ExampleSentence> bilingualExample = YouDaoTrans.getBilingualExample(document,query);
            ret.setAmericanPhoneticSymbol(americanPhoneticSymbol);
            ret.setBilingualExample(bilingualExample);
            ret.setCollins(collins);
            ret.setConjugate(conjugate);
            ret.setEnglishPhoneticSymbol(englishPhoneticSymbol);
            ret.setInterpretation(interpretation);
            ret.setSynonyms(synonyms);
            ret.setWebInterpretation(webInterpretation);
            ret.setWord(query);
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }catch (IOException e) {
            e.printStackTrace();
        }finally{
            return ret;
        }

    }
}
