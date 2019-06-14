package org.peip.salesman.Main_Test;

import org.peip.salesman.GestionMatrice;
import org.peip.salesman.AlgorithmCreation.*;
import org.peip.salesman.AlgorithmOpimization.*;

public class MainRatioXYDistance {
	public static long TestRatioXYDistance(GestionMatrice m) {
		long t1 = System.nanoTime();
		RatioXYDistance.creerChemin(m, 0);
		long t2 = System.nanoTime();
		return t2-t1;
	}
	
	public static void main(String [] args) {
		GestionMatrice g = new GestionMatrice();
		System.out.println("Le temps d'execution de création RatioXYDistance a été de " + TestRatioXYDistance(g)/1000 + " µs.\n");
	}
}
