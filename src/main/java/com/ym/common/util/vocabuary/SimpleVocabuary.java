package com.ym.common.util.vocabuary;

public class SimpleVocabuary {
    private String english;
    private String chinese;

    public SimpleVocabuary(String english, String chinese) {
        this.english = english;
        this.chinese = chinese;
    }

    public SimpleVocabuary(String english) {
        this.english = english;
    }

    public SimpleVocabuary() {
    }

    public String getEnglish() {
        return english;
    }

    public void setEnglish(String english) {
        this.english = english;
    }

    public String getChinese() {
        return chinese;
    }

    public void setChinese(String chinese) {
        this.chinese = chinese;
    }

    @Override
    public String toString() {
        return "SimpleVocabuary{" +
                "english='" + english + '\'' +
                ", chinese='" + chinese + '\'' +
                '}';
    }
}
