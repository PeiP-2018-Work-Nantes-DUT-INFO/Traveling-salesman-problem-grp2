package org.peip.salesman.Main_Test;

import org.peip.salesman.GestionMatrice;
import org.peip.salesman.AlgorithmCreation.AnglePlusOuvert;

public class MainAnglePlusOuvert {
	public static long TestAnglePlusOuvert(GestionMatrice m) {
		long t1 = System.nanoTime();
		AnglePlusOuvert.creerChemin(m, 0, 1);
		long t2 = System.nanoTime();
		return t2-t1;
	}
	
	public static void main(String [] args)
	{
		GestionMatrice g = new GestionMatrice();
		System.out.println("Le temps d'execution de création AnglePlusOuvert a été de " + TestAnglePlusOuvert(g)/1000 + " µs.\n");
	}
}
