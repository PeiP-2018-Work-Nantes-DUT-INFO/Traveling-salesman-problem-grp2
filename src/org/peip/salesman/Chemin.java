package org.peip.salesman;

import java.util.ArrayList;
import java.util.List;

public class Chemin extends ArrayList<Integer> {
    private float distancetotale;

    public Chemin(int distancetotale) {
        super();
        this.distancetotale = distancetotale;
    }

    public Chemin() {
        this(0);
    }

    public float getdistancetotale() {
        return distancetotale;
    }

    public void setdistancetotale(float distancetotale) {
        this.distancetotale = distancetotale;
    }

    public List<Ville> toVille (List<Ville> villes) {
        ArrayList<Ville>  villeTmp = new ArrayList<Ville>();
        for(int indexVille: this) {
            villeTmp.add(villes.get(indexVille));
        }
        return villeTmp;
    }
    
    public float calcDist(float[][] matrice) {
    	float distance = 0;
    	for(int i = 0 ; i < this.size()-1; i++) {
    		distance += matrice[this.get(i)][this.get(i+1)];
    	}
    	return distance;
    }
}
