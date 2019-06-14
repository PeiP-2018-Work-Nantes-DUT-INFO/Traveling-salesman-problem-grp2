package org.peip.salesman;

import org.peip.salesman.AlgorithmCreation.AnglePlusOuvert;
import org.peip.salesman.AlgorithmCreation.PlusProcheVoisin;
import org.peip.salesman.AlgorithmCreation.RatioAngleDistance;

import java.util.Random;

public class Main {

	public static void main(String[] args) {
		GestionMatrice g = new GestionMatrice();

		Chemin chemin = PlusProcheVoisin.creerChemin(g);

		System.out.println("Chemin : " + chemin);
		System.out.println("Distance du chemin : " + chemin.getdistancetotale());
	}

}