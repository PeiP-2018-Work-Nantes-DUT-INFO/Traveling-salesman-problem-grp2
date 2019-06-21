package org.peip.salesman.Main_Test;

import org.peip.salesman.GestionMatrice;
import org.peip.salesman.AlgorithmCreation.PlusProcheVoisin;

public class MainPlusProcheVoisinSingle {
	public static long TestPlusProcheVoisin(GestionMatrice m) {
		long t1 = System.nanoTime();
		PlusProcheVoisin.algo(m, 0, 1000000);
		long t2 = System.nanoTime();
		return t2-t1;
	}
	
	public static void main(String [] args) {
		GestionMatrice g = new GestionMatrice();
		System.out.println("Le temps d'execution de création PlusProcheVoisin a été de " + TestPlusProcheVoisin(g)/1000 + " µs.\n");
	}
}
