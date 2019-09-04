package com.ym.common.vocabuary;

import com.ym.common.util.translation.youdao.CollinsDictionary;
import com.ym.common.util.vocabuary.Conjugate;
import com.ym.common.util.vocabuary.ExampleSentence;
import com.ym.common.util.vocabuary.SimpleVocabuary;
import com.ym.common.util.vocabuary.Synonym;

import java.util.List;

public class Word {
    private int id;
    private String word;                                //单词
    private String englishPhoneticSymbol;               //英式音标
    private String AmericanPhoneticSymbol;              //美式音标
    private List<String> interpretation;                //解释
    private List<SimpleVocabuary> webInterpretation;    //网络释义
    private CollinsDictionary collins;                  //柯斯林英汉大词典
    private List<Synonym> synonyms;                     //同义词
    private Conjugate conjugate;                        //同根词
    private List<ExampleSentence> bilingualExample;     //双语例句


    public static String makePhoneticSymbol(String orPhoneticSymbol){
        return "/"+orPhoneticSymbol+"/";
    }

    public Word(){}

    public Word(String word) {
        this.word = word;
    }

    public Word(int id, String word, String englishPhoneticSymbol, String americanPhoneticSymbol, List<String> interpretation, List<SimpleVocabuary> webInterpretation, CollinsDictionary collins, List<Synonym> synonyms, Conjugate conjugate, List<ExampleSentence> bilingualExample) {
        this.id = id;
        this.word = word;
        this.englishPhoneticSymbol = englishPhoneticSymbol;
        AmericanPhoneticSymbol = americanPhoneticSymbol;
        this.interpretation = interpretation;
        this.webInterpretation = webInterpretation;
        this.collins = collins;
        this.synonyms = synonyms;
        this.conjugate = conjugate;
        this.bilingualExample = bilingualExample;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getWord() {
        return word;
    }

    public void setWord(String word) {
        this.word = word;
    }

    public String getEnglishPhoneticSymbol() {
        return englishPhoneticSymbol;
    }

    public void setEnglishPhoneticSymbol(String englishPhoneticSymbol) {
        this.englishPhoneticSymbol = englishPhoneticSymbol;
    }

    public String getAmericanPhoneticSymbol() {
        return AmericanPhoneticSymbol;
    }

    public void setAmericanPhoneticSymbol(String americanPhoneticSymbol) {
        AmericanPhoneticSymbol = americanPhoneticSymbol;
    }

    public List<String> getInterpretation() {
        return interpretation;
    }

    public void setInterpretation(List<String> interpretation) {
        this.interpretation = interpretation;
    }

    public List<SimpleVocabuary> getWebInterpretation() {
        return webInterpretation;
    }

    public void setWebInterpretation(List<SimpleVocabuary> webInterpretation) {
        this.webInterpretation = webInterpretation;
    }

    public CollinsDictionary getCollins() {
        return collins;
    }

    public void setCollins(CollinsDictionary collins) {
        this.collins = collins;
    }

    public List<Synonym> getSynonyms() {
        return synonyms;
    }

    public void setSynonyms(List<Synonym> synonyms) {
        this.synonyms = synonyms;
    }

    public Conjugate getConjugate() {
        return conjugate;
    }

    public void setConjugate(Conjugate conjugate) {
        this.conjugate = conjugate;
    }

    public List<ExampleSentence> getBilingualExample() {
        return bilingualExample;
    }

    public void setBilingualExample(List<ExampleSentence> bilingualExample) {
        this.bilingualExample = bilingualExample;
    }

    @Override
    public String toString() {
        return "Word{" +
                "id=" + id +
                ", \n\n\nword='" + word + '\'' +
                ", \n\n\nenglishPhoneticSymbol='" + englishPhoneticSymbol + '\'' +
                ", \n\n\nAmericanPhoneticSymbol='" + AmericanPhoneticSymbol + '\'' +
                ", \n\n\ninterpretation=" + interpretation +
                ", \n\n\nwebInterpretation=" + webInterpretation +
                ", \n\n\ncollins=" + collins +
                ", \n\n\nsynonyms=" + synonyms +
                ", \n\n\nconjugate=" + conjugate +
                ", \n\n\nbilingualExample=" + bilingualExample +
                '}';
    }

    public com.ym.bean.Word toWordBean(){
        return WordUtils.toWordBean(this);
    }
}
