package com.bzz.Serienliste.model;

import java.util.Collection;
import java.util.Map;

//TestKommentar
public class Liste {
    private String name;
    private int listID;
    private boolean isPublic;
    private int cntr;
    private Map serien;

    public Liste(String name, boolean isPublic) {
        this.name = name;
        this.isPublic = isPublic;
    }

    public String getName() { return name; }

    public void setName(String name) { this.name = name; }

    public boolean isPublic() {
        return isPublic;
    }

    public int getListID() {
        return listID;
    }

    public void setListID(int listID) {
        this.listID = listID;
    }

    public void setPublic(boolean aPublic) {
        isPublic = aPublic;
    }

    public int getCntr() {
        return cntr;
    }

    public void setCntr(int cntr) {
        this.cntr = cntr;
    }

    public Map getSerien() {
        return serien;
    }

    public void setSerien(Map serien) {
        this.serien = serien;
    }

}
