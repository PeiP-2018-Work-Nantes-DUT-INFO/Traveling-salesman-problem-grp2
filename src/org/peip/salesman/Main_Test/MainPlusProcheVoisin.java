package org.peip.salesman.Main_Test;

import org.peip.salesman.GestionMatrice;
import org.peip.salesman.AlgorithmCreation.PlusProcheVoisin;

public class MainPlusProcheVoisin {
	public static long TestPlusProcheVoisin(GestionMatrice m) {
		long t1 = System.nanoTime();
		PlusProcheVoisin.creerChemin(m);
		long t2 = System.nanoTime();
		return t2-t1;
	}
	
	public static void main(String [] args) {
		GestionMatrice g = new GestionMatrice();
		System.out.println("Le temps d'execution de cr�ation PlusProcheVoisin a �t� de " + TestPlusProcheVoisin(g)/1000 + " �s.\n");
	}
}
