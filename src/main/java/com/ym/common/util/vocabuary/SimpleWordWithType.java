package com.ym.common.util.vocabuary;

public class SimpleWordWithType {
    private String english;
    private String chinese;
    private String type;

    public SimpleWordWithType(String english, String chinese, String type) {
        this.english = english;
        this.chinese = chinese;
        this.type = type;
    }

    public SimpleWordWithType() {
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

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return "SimpleWordWithType{" +
                "english='" + english + '\'' +
                ", chinese='" + chinese + '\'' +
                ", type='" + type + '\'' +
                '}';
    }
}
