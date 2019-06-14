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
	public static Chemin creerChemin(GestionMatrice matriceVille) {

		int o = matriceVille.getListe().size();

		Chemin chemin = algo(matriceVille, 0);

		System.out.println("Le chemin de base : " + chemin);
		System.out.println("Distance du chemin de base : " + chemin.getdistancetotale());

		for(int i = 1; i < o; i++){


			Chemin cheminTMP = algo(matriceVille, i);

			if(chemin.getdistancetotale() > cheminTMP.getdistancetotale()) {
				chemin = cheminTMP;
			}

		}

		return chemin;
	}


	public static Chemin algo(GestionMatrice matriceVille, int indexDepart){

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

		chemin.add(indexDepart);

		chemin.setdistancetotale(distanceTotale);


		return chemin;
	}
}
