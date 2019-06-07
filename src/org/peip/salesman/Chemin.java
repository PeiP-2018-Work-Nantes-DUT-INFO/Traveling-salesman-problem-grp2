package org.peip.salesman;

import java.util.ArrayList;

public class Chemin extends ArrayList {
    private int distanceTotale;

    public Chemin(int distanceTotale) {
        super();
        this.distanceTotale = distanceTotale;
    }

    public Chemin() {
        this(0);
    }

    public int getDistanceTotale() {
        return distanceTotale;
    }

    public void setDistanceTotale(int distanceTotale) {
        this.distanceTotale = distanceTotale;
    }
}
