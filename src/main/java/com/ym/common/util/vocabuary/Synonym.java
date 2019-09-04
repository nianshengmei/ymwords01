package com.ym.common.util.vocabuary;

import java.util.List;

public class Synonym {

    private ExplainWithType explains;
    private List<String> words;

    public Synonym(ExplainWithType explains, List<String> words) {
        this.explains = explains;
        this.words = words;
    }

    public Synonym() {
    }

    public ExplainWithType getExplains() {
        return explains;
    }

    public void setExplains(ExplainWithType explains) {
        this.explains = explains;
    }

    public List<String> getWords() {
        return words;
    }

    public void setWords(List<String> words) {
        this.words = words;
    }

    @Override
    public String toString() {
        return "Synonyms{" +
                "explains='" + explains + '\'' +
                ", words=" + words +
                '}';
    }
}
