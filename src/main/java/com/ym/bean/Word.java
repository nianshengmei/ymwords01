package com.ym.bean;

import com.ym.common.vocabuary.WordUtils;

public class Word {

    private int id;
    private String word;                                //单词
    private String englishPhoneticSymbol;               //英式音标
    private String AmericanPhoneticSymbol;              //美式音标
    private String interpretation;                //解释
    private String webInterpretation;    //网络释义
    private String collins;                  //柯斯林英汉大词典
    private String synonyms;                     //同义词
    private String conjugate;                        //同根词
    private String bilingualExample;     //双语例句

    public int getId() {
        return id;
    }

    public Word() {
    }

    public Word(int id, String word, String englishPhoneticSymbol, String americanPhoneticSymbol, String interpretation, String webInterpretation, String collins, String synonyms, String conjugate, String bilingualExample) {
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

    public String getInterpretation() {
        return interpretation;
    }

    public void setInterpretation(String interpretation) {
        this.interpretation = interpretation;
    }

    public String getWebInterpretation() {
        return webInterpretation;
    }

    public void setWebInterpretation(String webInterpretation) {
        this.webInterpretation = webInterpretation;
    }

    public String getCollins() {
        return collins;
    }

    public void setCollins(String collins) {
        this.collins = collins;
    }

    public String getSynonyms() {
        return synonyms;
    }

    public void setSynonyms(String synonyms) {
        this.synonyms = synonyms;
    }

    public String getConjugate() {
        return conjugate;
    }

    public void setConjugate(String conjugate) {
        this.conjugate = conjugate;
    }

    public String getBilingualExample() {
        return bilingualExample;
    }

    public void setBilingualExample(String bilingualExample) {
        this.bilingualExample = bilingualExample;
    }

    @Override
    public String toString() {
        return "Word{" +
                "id=" + id +
                ", word='" + word + '\'' +
                ", englishPhoneticSymbol='" + englishPhoneticSymbol + '\'' +
                ", AmericanPhoneticSymbol='" + AmericanPhoneticSymbol + '\'' +
                ", interpretation='" + interpretation + '\'' +
                ", webInterpretation='" + webInterpretation + '\'' +
                ", collins='" + collins + '\'' +
                ", synonyms='" + synonyms + '\'' +
                ", conjugate='" + conjugate + '\'' +
                ", bilingualExample='" + bilingualExample + '\'' +
                '}';
    }

    public com.ym.common.vocabuary.Word toVoCcabularyWord(){
        return WordUtils.toVocabularyWord(this);
    }
}
