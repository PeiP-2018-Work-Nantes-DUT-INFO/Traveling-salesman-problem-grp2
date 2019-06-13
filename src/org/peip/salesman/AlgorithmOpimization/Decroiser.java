package org.peip.salesman.AlgorithmOpimization;

import org.peip.salesman.Chemin;
import org.peip.salesman.GestionMatrice;
import org.peip.salesman.Ville;

public class Decroiser {
	
	public static Chemin meilleurPtDepart(GestionMatrice g, Chemin ancien_ch) {
		Chemin nouveau_ch = new Chemin();
		Chemin meilleur_ch = ancien_ch;
		
		for (int i = 0; i < ancien_ch.size()-1; i++) {
			nouveau_ch = DecalerDepart.decalerPtDepart(ancien_ch, i);
			nouveau_ch = decroiserChemin(g, nouveau_ch);
			
			if (nouveau_ch.getdistancetotale() < meilleur_ch.getdistancetotale()) {
				meilleur_ch = nouveau_ch;
				meilleur_ch.setdistancetotale(nouveau_ch.getdistancetotale());
				// System.out.println("Meilleur dt "+meilleur_ch.getdistancetotale());
			}
		}
		return meilleur_ch;
	}
	
	/**
	 * 
	 * @param chemin le chemin à optimiser
	 */
	public static Chemin decroiserChemin(GestionMatrice g, Chemin ancien_ch) {
		
		Chemin nouveau_ch = ancien_ch;
		Chemin meilleur_ch = ancien_ch;
		boolean changement = true;
		float dt = ancien_ch.getdistancetotale();
		float[][] m = g.getMatriceA();
		
		while (changement) {
			changement = false;
			for (int i = 0; i < nouveau_ch.size()-3; i++) {
				for (int j=i+2; j < nouveau_ch.size()-1; j++) {
					int numeroVille1 = nouveau_ch.get(i);
					int numeroVille2 = nouveau_ch.get(i+1);
					int numeroVille3 = nouveau_ch.get(j);
					int numeroVille4 = nouveau_ch.get(j+1);
					
					Ville p1 = g.getListe().get(numeroVille1);
					Ville p2 = g.getListe().get(numeroVille2);
					Ville p3 = g.getListe().get(numeroVille3);
					Ville p4 = g.getListe().get(numeroVille4);
					
					//System.out.print(numeroVille1);
					//System.out.print(numeroVille2+" ");
					//System.out.print(numeroVille3);
					//System.out.println(numeroVille4);
					
					if (checkCroisement(p1, p2, p3, p4)) {
						nouveau_ch = swap2opt(nouveau_ch, i+1, j);
						dt = dt - m[numeroVille1][numeroVille2] - m[numeroVille3][numeroVille4] + m[numeroVille1][numeroVille3] + m[numeroVille2][numeroVille4];
						if (dt < ancien_ch.getdistancetotale()) {
							meilleur_ch = nouveau_ch;
							meilleur_ch.setdistancetotale(dt);
							changement = true;
						}
					}
				}
			}
			ancien_ch = meilleur_ch;
		}
		return meilleur_ch;
	}
	
	public static Chemin swap2opt(Chemin ancien_ch, int indexDepart, int indexFin) {
		Chemin nouveau_ch = new Chemin();
		
		for (int i = 0; i < indexDepart; i++) {
			nouveau_ch.add(ancien_ch.get(i));
		}
		for (int i = indexFin; i >= indexDepart; i--) {
			nouveau_ch.add(ancien_ch.get(i));
		}
		for (int i = indexFin+1; i < ancien_ch.size(); i++) {
			nouveau_ch.add(ancien_ch.get(i));
		}
		
		return nouveau_ch;
	}
	
	public static boolean checkCroisement(Ville p1, Ville p2, Ville p3, Ville p4) {
		// Pos x y des points p1, p2, p3 et p4
		float x1 = p1.getX();
		float x2 = p2.getX();
		float x3 = p3.getX();
		float x4 = p4.getX();
		float y1 = p1.getY();
		float y2 = p2.getY();
		float y3 = p3.getY();
		float y4 = p4.getY();
		
		// Parametres des équations des droites (p1,p2) et (p3,p4)
		float a1 = (y2-y1)/(x2-x1);
		float a2 = (y4-y3)/(x4-x3);
		float b1 = y1 - (a1*x1);
		float b2 = y3 - (a2*x3);
		
		// Croisement ?
		if (a1 != a2) {
			float xcommun = (b2-b1)/(a1-a2);
			if (((xcommun<x1 && xcommun>x2)||(xcommun>x1 && xcommun<x2))&&((xcommun<x3 && xcommun>x4)||(xcommun>x3 && xcommun<x4))) {
				return true;
			}
		}
		return false;
	}
	
}
