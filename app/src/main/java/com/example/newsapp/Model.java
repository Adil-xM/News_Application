package com.example.newsapp;

public class Model {
    private String author,title,description,url,urlToimage,publishedAT;

    public Model(String author, String title, String description, String url, String urlToimage, String publishedAT) {

        this.author = author;
        this.title = title;
        this.description = description;
        this.url = url;
        this.urlToimage = urlToimage;
        this.publishedAT = publishedAT;
    }


    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
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

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getUrlToimage() {
        return urlToimage;
    }

    public void setUrlToimage(String urlToimage) {
        this.urlToimage = urlToimage;
    }

    public String getPublishedAT() {
        return publishedAT;
    }

    public void setPublishedAT(String publishedAT) {
        this.publishedAT = publishedAT;
    }
}
