package org.peip.salesman;

import org.peip.salesman.AlgorithmCreation.PlusProcheVoisin;

import java.util.Random;

public class Main {

	public static void main(String[] args) {
		GestionMatrice g = new GestionMatrice();
		System.out.println(g.toString());
		System.out.println("Fin du programme..");
		PlusProcheVoisin.creerChemin(g, (new Random()).nextInt(10));
	}

}