package org.peip.salesman;

import org.peip.salesman.AlgorithmCreation.AnglePlusOuvert;
import org.peip.salesman.AlgorithmCreation.PlusProcheVoisin;
import org.peip.salesman.AlgorithmCreation.RatioAngleDistance;

import java.util.Random;

public class Main {

	public static void main(String[] args) {
		GestionMatrice g = new GestionMatrice();
		System.out.println(g.toString());
		Chemin chemin = RatioAngleDistance.creerChemin(g, 0, 1);

		System.out.println("LE FAMEUX CHEMIN");
		System.out.println(chemin);
	}

}