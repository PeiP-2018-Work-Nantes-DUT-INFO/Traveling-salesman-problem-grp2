package org.peip.salesman.Main_Test;

import org.peip.salesman.AlgorithmCreation.PlusProcheVoisin;
import org.peip.salesman.AlgorithmOpimization.Decroiser;
import org.peip.salesman.AlgorithmOpimization.SimpleSwap;
import org.peip.salesman.Chemin;
import org.peip.salesman.GestionMatrice;

public class MainOptiSimpleSwap {
	public static long testSimpleSwap(GestionMatrice m, Chemin c) {
		long t1 = System.nanoTime();
		Chemin cheminOptimisé= SimpleSwap.simpleSwapAlgorithm(m, c);
		long t2 = System.nanoTime();
		System.out.println(String.format("Longueur après:%f\nAprès opti: %s", cheminOptimisé.getdistancetotale(), cheminOptimisé.toString()));
		return t2-t1;
	}
	
	public static void main(String [] args) {
		GestionMatrice g = new GestionMatrice();
		System.out.println("Le temps d'execution de création testSimpleSwap a été de " + testSimpleSwap(g, PlusProcheVoisin.creerChemin(g))/1000 + " µs.\n");
	}
}
