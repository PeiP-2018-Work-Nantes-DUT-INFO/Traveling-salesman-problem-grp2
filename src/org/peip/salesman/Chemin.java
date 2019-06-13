package org.peip.salesman;

import java.util.ArrayList;
import java.util.List;

public class Chemin extends ArrayList<Integer> {
    private int distancetotale;

    public Chemin(int distancetotale) {
        super();
        this.distancetotale = distancetotale;
    }

    public Chemin() {
        this(0);
    }

    public int getdistancetotale() {
        return distancetotale;
    }

    public void setdistancetotale(int distancetotale) {
        this.distancetotale = distancetotale;
    }

    public List<Ville> toVille (List<Ville> villes) {
        ArrayList<Ville>  villeTmp = new ArrayList<Ville>();
        for(int indexVille: this) {
            villeTmp.add(villes.get(indexVille));
        }
        return villeTmp;
    }
}
