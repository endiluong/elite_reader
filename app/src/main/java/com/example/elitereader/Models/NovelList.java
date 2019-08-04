package com.example.elitereader.Models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

public class NovelList {
    @SerializedName("novels")
    @Expose
    private ArrayList<Novel> novels = new ArrayList<>();
    public ArrayList<Novel> getNovels() {
        return novels;
    }
    public void setNovels(ArrayList<Novel> novels) {
        this.novels = novels;
    }
}
