package com.example.elitereader.Models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

public class Novel {
    @SerializedName("id")
    @Expose
    private Integer id;
    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("chapter")
    @Expose
    private String chapter;
    @SerializedName("lastUpdate")
    @Expose
    private String lastUpdate;
    @SerializedName("description")
    @Expose
    private String description;
    @SerializedName("imgLink")
    @Expose
    private String imgLink;

    public Novel() {
    }

    public Novel(Integer id, String name, String lastUpdate, String description, String imgLink, String chapter) {
        this.id = id;
        this.name = name;
        this.lastUpdate = lastUpdate;
        this.description = description;
        this.imgLink = imgLink;
        this.chapter = chapter;
    }

    public String getChapter() {
        return chapter;
    }

    public void setChapter(String chapter) {
        this.chapter = chapter;
    }

    public static int getLastId() {
        return lastId;
    }

    public static void setLastId(int lastId) {
        Novel.lastId = lastId;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastUpdate() {
        return lastUpdate;
    }

    public void setLastUpdate(String lastUpdate) {
        this.lastUpdate = lastUpdate;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getImgLink() {
        return imgLink;
    }

    public void setImgLink(String imgLink) {
        this.imgLink = imgLink;
    }

    //
    private static int lastId = 0;

    public static ArrayList<Novel> createNovelList(int number) {
        ArrayList<Novel> novels = new ArrayList<Novel>();

        for (int i = 1; i <= number; i++) {
            novels.add(new Novel(++lastId, "Book " + i, "22/12/2012", "Book Description", "https://www.w3schools.com/w3css/img_lights.jpg", "1"));
        }
        return novels;
    }
}
