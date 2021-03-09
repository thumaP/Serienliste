package com.bzz.Serienliste.model;

public class Serie {
    private int seriesID;
    private String kategorie;
    private String title;
    private String desc;
    private int anzFolgen;
    private int imgURL;

    public String getKategorie() {
        return kategorie;
    }

    public int getSeriesID() {
        return seriesID;
    }

    public void setSeriesID(int seriesID) {
        this.seriesID = seriesID;
    }

    public void setKategorie(String kategorie) {
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
