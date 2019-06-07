package org.peip.salesman;

import org.peip.salesman.AlgorithmCreation.AlgorithmCreation;
import org.peip.salesman.GestionMatrice;

public class Main {

	public static void main(String[] args) {
		GestionMatrice g = new GestionMatrice();
		System.out.println(g.toString());
		System.out.println("Fin du programme..");
		AlgorithmCreation ac = new AlgorithmCreation(g.getMatriceA());
	}

}