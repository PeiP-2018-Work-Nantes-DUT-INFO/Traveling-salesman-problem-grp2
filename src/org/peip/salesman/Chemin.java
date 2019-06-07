package org.peip.salesman;

import java.util.ArrayList;

public class Chemin extends ArrayList<Integer> {
    private int distancetotale;

    public chemin(int distancetotale) {
        super();
        this.distancetotale = distancetotale;
    }

    public chemin() {
        this(0);
    }

    public int getdistancetotale() {
        return distancetotale;
    }

    public void setdistancetotale(int distancetotale) {
        this.distancetotale = distancetotale;
    }
}
