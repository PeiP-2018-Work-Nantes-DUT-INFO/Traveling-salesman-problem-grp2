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
		int origine = indexDepart;
		chemin.add(indexDepart);
		int destination = -1;
		float distanceTotale = -1;
		for (int i=0; i < villes.size()-1; i++) {
			// DEBUG
			// System.out.printf("\nRecherche depuis la ville ID°%d :\n", origine.getId());
			distanceAB = 10000;

			for (int j=0; i < villes.size()-1; j++) {
				if (!chemin.contains(j)) {
					// Si le trajet ne contientndexDepart pas déjà cette ville
					if (matrice[origine][j] < distanceAB) {
						distanceAB = matrice[origine][j] ;
						destination = j;
						// DEBUG
						// System.out.printf("Un trajet de %d km a été trouvé !\n", matricePoids[origine.getId()][ville.getId()]);
					}
				}
			}
			// DBEUG
			// System.out.printf("Segment %d%d ajouté !\n", origine.getId(), destination.getId());
			distanceTotale = distanceTotale + distanceAB;
			chemin.add(destination);
			origine = destination;
		}	return null;
	}

}
