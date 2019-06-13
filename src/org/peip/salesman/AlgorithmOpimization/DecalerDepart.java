package org.peip.salesman.AlgorithmOpimization;

import org.peip.salesman.Chemin;

public class DecalerDepart {
	
	public static Chemin decalerPtDepart(Chemin ancien_ch, int indexNouveauDepart) {
		
		indexNouveauDepart = Math.abs(indexNouveauDepart);
		
		int indexDepart = indexNouveauDepart%(ancien_ch.size()-1);
		if (indexDepart==0) {
			return ancien_ch;
		}
		
		Chemin nouveau_ch = new Chemin();
		nouveau_ch.setdistancetotale(ancien_ch.getdistancetotale());
		
		int villeDepart = ancien_ch.get(indexDepart);
		nouveau_ch.add(villeDepart);
		for (int j = indexDepart+1; j < ancien_ch.size()-1+indexDepart; j++) {
			int ville = ancien_ch.get(j%(ancien_ch.size()-1));
			nouveau_ch.add(ville);
		}
		nouveau_ch.add(villeDepart);
		nouveau_ch.setdistancetotale(ancien_ch.getdistancetotale());
		
		return nouveau_ch;
	}
}
