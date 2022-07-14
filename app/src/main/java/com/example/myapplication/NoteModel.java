package com.example.myapplication;

import java.io.Serializable;

public class NoteModel implements Serializable {

    private String title;
    private String description;
    private String imgUrl;
    private long createdAt;

    public NoteModel(String title, String description, String imgUrl, long createdAt) {
        this.title = title;
        this.description = description;
        this.imgUrl = imgUrl;
        this.createdAt = createdAt;
    }


    public NoteModel(String title, String description, long createdAt) {
        this.title = title;
        this.description = description;
        this.createdAt = createdAt;
    }

    public NoteModel() {
    }

    public NoteModel(String title, String description) {
        this.title = title;
        this.description = description;
    }



    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public long getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(long createdAt) {
        this.createdAt = createdAt;
    }

    public String getImgUrl() {
        return imgUrl;
    }

    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl;
    }
}
