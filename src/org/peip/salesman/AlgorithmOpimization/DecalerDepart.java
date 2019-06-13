package org.peip.salesman.AlgorithmOpimization;

import org.peip.salesman.Chemin;

public class DecalerDepart {
	
	public static Chemin decalerPtDepart(Chemin ancien_ch, int indexNouveauDepart) {
		Chemin nouveau_ch = new Chemin();
		nouveau_ch.setdistancetotale(ancien_ch.getdistancetotale());
		
		int villeDepart = ancien_ch.get(indexNouveauDepart);
		nouveau_ch.add(villeDepart);
		for (int j = indexNouveauDepart+1; j < ancien_ch.size()-1+indexNouveauDepart; j++) {
			int ville = ancien_ch.get(j%(ancien_ch.size()-1));
			nouveau_ch.add(ville);
		}
		nouveau_ch.add(villeDepart);
		return nouveau_ch;
	}
}
