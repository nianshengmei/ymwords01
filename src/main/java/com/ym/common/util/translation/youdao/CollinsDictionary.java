package com.ym.common.util.translation.youdao;

import java.util.List;

//柯林斯英汉大词典
public class CollinsDictionary {
    private String keyWord;                 //单词
    private String phoneticSymbol;          //音标
    private String frequency;                  //使用频率
    private List<String> exampleSentence;   //例句
    private String rank;                    //等级
    private String additionalPattern;       //额外部分

    public CollinsDictionary(String keyWord, String phoneticSymbol, String frequency, List<String> exampleSentence, String rank, String additionalPattern) {
        this.keyWord = keyWord;
        this.phoneticSymbol = phoneticSymbol;
        this.frequency = frequency;
        this.exampleSentence = exampleSentence;
        this.rank = rank;
        this.additionalPattern = additionalPattern;
    }

    public CollinsDictionary(String keyWord) {
        this.keyWord = keyWord;
    }

    public CollinsDictionary() {
    }

    public String getKeyWord() {
        return keyWord;
    }

    public void setKeyWord(String keyWord) {
        this.keyWord = keyWord;
    }

    public String getPhoneticSymbol() {
        return phoneticSymbol;
    }

    public void setPhoneticSymbol(String phoneticSymbol) {
        this.phoneticSymbol = phoneticSymbol;
    }

    public String getFrequency() {
        return frequency;
    }

    public void setFrequency(String frequency) {
        this.frequency = frequency;
    }

    public List<String> getExampleSentence() {
        return exampleSentence;
    }

    public void setExampleSentence(List<String> exampleSentence) {
        this.exampleSentence = exampleSentence;
    }

    public String getRank() {
        return rank;
    }

    public void setRank(String rank) {
        this.rank = rank;
    }

    public String getAdditionalPattern() {
        return additionalPattern;
    }

    public void setAdditionalPattern(String additionalPattern) {
        this.additionalPattern = additionalPattern;
    }

    @Override
    public String toString() {
        return "CollinsDictionary{" +
                "keyWord='" + keyWord + '\'' +
                ", phoneticSymbol='" + phoneticSymbol + '\'' +
                ", frequency=" + frequency +
                ", exampleSentence=" + exampleSentence +
                ", rank='" + rank + '\'' +
                ", additionalPattern='" + additionalPattern + '\'' +
                '}';
    }
}
