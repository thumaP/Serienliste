package com.bzz.Serienliste.model;

import com.bzz.Serienliste.data.DataHandler;

import java.util.ArrayList;

public class Serie {
    private int seriesID;
    private Kategorie kategorie;
    private String title;
    private String desc;
    private int anzFolgen;
    private int imgURL;

    public Serie(Kategorie kategorie, String title, String desc, int anzFolgen, int rating, boolean watched) {
        this.kategorie = kategorie;
        this.title = title;
        this.desc = desc;
        this.anzFolgen = anzFolgen;
        this.rating = rating;
        this.watched = watched;
    }

    public void saveSerie(ArrayList arrayList, Serie serie) {
        arrayList.add(serie);
    }

    public Kategorie getKategorie() {
        return kategorie;
    }

    public int getSeriesID() {
        return seriesID;
    }

    public void setSeriesID(int seriesID) {
        this.seriesID = seriesID;
    }

    public void setKategorie(Kategorie kategorie) {
        this.kategorie = kategorie;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public int getAnzFolgen() {
        return anzFolgen;
    }

    public void setAnzFolgen(int anzFolgen) {
        this.anzFolgen = anzFolgen;
    }

    public int getImgURL() {
        return imgURL;
    }

    public void setImgURL(int imgURL) {
        this.imgURL = imgURL;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        if(rating >= 10) {
            rating = 10;
        }
        if(rating <= 1) {
            rating = 1;
        }
        this.rating = rating;
    }

    public boolean isWatched() {
        return watched;
    }

    public void setWatched(boolean watched) {
        this.watched = watched;
    }

    private int rating;
    private boolean watched;
}
