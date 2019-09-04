package com.ym.common.util.vocabuary;

import java.util.List;

//同根词
public class Conjugate {
    private String root;                        //词根
    private List<SimpleWordWithType> allWords;     //所有同根词

    public Conjugate(String root, List<SimpleWordWithType> allWords) {
        this.root = root;
        this.allWords = allWords;
    }

    public Conjugate(String root) {
        this.root = root;
    }

    public Conjugate() {
    }

    public String getRoot() {
        return root;
    }

    public void setRoot(String root) {
        this.root = root;
    }

    public List<SimpleWordWithType> getAllWords() {
        return allWords;
    }

    public void setAllWords(List<SimpleWordWithType> allWords) {
        this.allWords = allWords;
    }

    @Override
    public String toString() {
        return "Conjugate{" +
                "root='" + root + '\'' +
                ", allWords=" + allWords +
                '}';
    }
}
