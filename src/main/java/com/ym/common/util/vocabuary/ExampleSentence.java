package com.ym.common.util.vocabuary;

public class ExampleSentence {
    private String english;
    private String chinese;
    private String provenance;      //  出处

    public ExampleSentence(String english, String chinese, String provenance) {
        this.english = english;
        this.chinese = chinese;
        this.provenance = provenance;
    }

    public ExampleSentence() {
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

    public String getProvenance() {
        return provenance;
    }

    public void setProvenance(String provenance) {
        this.provenance = provenance;
    }

    @Override
    public String toString() {
        return "ExampleSentence{" +
                "english='" + english + '\'' +
                ", chinese='" + chinese + '\'' +
                ", provenance='" + provenance + '\'' +
                '}';
    }
}
