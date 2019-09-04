package com.ym.common.io;

public class Pic {
    private int index;
    private String name;

    public Pic(int index, String name) {
        this.index = index;
        this.name = name;
    }

    public Pic() {
    }

    public int getIndex() {
        return index;
    }

    public void setIndex(int index) {
        this.index = index;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Pic{" +
                "index=" + index +
                ", name='" + name + '\'' +
                '}';
    }
}
