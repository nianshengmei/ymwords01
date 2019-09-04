package com.ym.common.util.vocabuary;

public class ExplainWithType {

    private String type;
    private String explains;

    public ExplainWithType(String type, String explains) {
        this.type = type;
        this.explains = explains;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getExplains() {
        return explains;
    }

    public void setExplains(String explains) {
        this.explains = explains;
    }

    public ExplainWithType() {
    }

    @Override
    public String toString() {
        return "ExplainWithType{" +
                "type='" + type + '\'' +
                ", explains='" + explains + '\'' +
                '}';
    }
}
