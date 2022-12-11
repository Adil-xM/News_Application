package com.example.newsapp;

import java.util.ArrayList;

public class impoNews {
    private  String status;
    private String totalResu;
    private ArrayList<Model> articles;

    public impoNews(String status, String totalResu, ArrayList<Model> articles) {
        this.status = status;
        this.totalResu = totalResu;
        this.articles = articles;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getTotalResu() {
        return totalResu;
    }

    public void setTotalResu(String totalResu) {
        this.totalResu = totalResu;
    }

    public ArrayList<Model> getArticles() {
        return articles;
    }

    public void setArticles(ArrayList<Model> articles) {
        this.articles = articles;
    }
}
