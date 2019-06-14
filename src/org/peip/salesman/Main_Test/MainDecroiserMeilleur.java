package org.peip.salesman.Main_Test;

import org.peip.salesman.Chemin;
import org.peip.salesman.GestionMatrice;
import org.peip.salesman.AlgorithmCreation.PlusProcheVoisin;
import org.peip.salesman.AlgorithmOpimization.Decroiser;

public class MainDecroiserMeilleur {
	public static long TestDecroiserMeilleur(GestionMatrice m, Chemin c) {
		long t1 = System.nanoTime();
		Decroiser.meilleurPtDepart(m, c);
		long t2 = System.nanoTime();
		return t2-t1;
	}
	
	public static void main(String [] args) {
		GestionMatrice g = new GestionMatrice();
		System.out.println("Le temps d'execution de cr�ation DecroiserMeilleur a �t� de " + TestDecroiserMeilleur(g, PlusProcheVoisin.creerChemin(g))/1000 + " �s.\n");
	}
}
