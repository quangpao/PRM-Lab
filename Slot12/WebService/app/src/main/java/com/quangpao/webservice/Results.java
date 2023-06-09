package com.quangpao.webservice;

import com.google.gson.annotations.SerializedName;

public class Results {
    @SerializedName("name")
    private String superName;

    public Results(String name) {
        this.superName = name;
    }

    public String getName() {
        return superName;
    }

    private void setName(String name) { this.superName = name; }
}
