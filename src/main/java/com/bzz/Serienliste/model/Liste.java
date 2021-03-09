package com.bzz.Serienliste.model;

import java.util.Collection;


public class Liste {

    private int listID;
    private boolean isPublic;
    private int cntr;

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

    public Collection getSerien() {
        return serien;
    }

    public void setSerien(Collection serien) {
        this.serien = serien;
    }

    private Collection serien;
}
