package org.peip.salesman.AlgorithmCreation;

import org.peip.salesman.Chemin;
import org.peip.salesman.GestionMatrice;
import org.peip.salesman.Ville;

import java.util.ArrayList;

public class PlusProcheVoisin {
	/*
	 * 
	 * @param matriceDistance la matrice des distances entre villes
	 * @param indexDepart la ville de départ du chemin
	 */
	public static Chemin creerChemin(GestionMatrice matriceVille, int indexDepart) {

		ArrayList<Ville> villes = matriceVille.getListe();
		float[][] matrice = matriceVille.getMatriceA();

		Chemin chemin = new Chemin();

		float distanceAB;
		int villeCourante = indexDepart;
		chemin.add(indexDepart);
		int destination = -1;
		float distanceTotale = -1;

		for (int i=0; i < villes.size() - 1; i++) {

			distanceAB = 10000000;

			for (int j=0; j < villes.size(); j++) {
				if (!chemin.contains(j) && matrice[villeCourante][j] < distanceAB) {
					distanceAB = matrice[villeCourante][j] ;
					destination = j;
				}
			}

			distanceTotale += distanceAB;

			chemin.add(destination);

			villeCourante = destination;
		}

		distanceTotale += matrice[villeCourante][indexDepart];

		chemin.setdistancetotale(distanceTotale);

		chemin.add(indexDepart);

		return chemin;
	}

}
