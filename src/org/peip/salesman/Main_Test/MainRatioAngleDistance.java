package org.peip.salesman.Main_Test;

import org.peip.salesman.GestionMatrice;
import org.peip.salesman.AlgorithmCreation.RatioAngleDistance;

public class MainRatioAngleDistance {
	public static long TestRatioAngleDistance(GestionMatrice m) {
		long t1 = System.nanoTime();
		RatioAngleDistance.creerChemin(m, 0, 1);
		long t2 = System.nanoTime();
		return t2-t1;
	}
	
	public static void main(String [] args) {
		GestionMatrice g = new GestionMatrice();
		System.out.println("Le temps d'execution de cr�ation RatioAngleDistance a �t� de " + TestRatioAngleDistance(g)/1000 + " �s.\n");
	}
}
