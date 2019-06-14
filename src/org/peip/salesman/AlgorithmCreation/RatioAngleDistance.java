package org.peip.salesman.AlgorithmCreation;

import org.peip.salesman.Chemin;

public class RatioAngleDistance {
	/*
	 * 
	 * @param matriceDistance la matrice des distances entre villes
	 * @param indexDepart la première ville de départ du chemin
	 * @param indexBis la seconde ville de départ du chemin
	 */
	public static Chemin creerChemin(float[][] matriceDistance, int indexDepart, int indexBis) {
		// TODO Algorithme du plus proche voisin

		/*

		double angleRef;
		double angle = 0;

		int distanceAB;

		this.add(matrice.listeVilles.get(indexDepart));
		this.add(matrice.listeVilles.get(indexDepartBis));
		distanceTotale = distanceTotale + matrice.tableau[indexDepart][indexDepartBis];
		Ville precedente = matrice.listeVilles.get(indexDepart);
		Ville origine = matrice.listeVilles.get(indexDepartBis);
		Ville destination = matrice.listeVilles.get(0);

		for (int i=0; i<matrice.nbVilles-2; i++) {
			// DEBUG
			// System.out.printf("\nRecherche depuis la ville ID°%d :\n", origine.getId());
			distanceAB = 10000;
			angleRef = 0;
			for (Ville ville : matrice.listeVilles) {
				// System.out.print("ok |");
				if (!this.contains(ville)) {
					// Si le trajet ne contient pas déjà cette ville
					double dAB = matrice.tableau[precedente.getId()][origine.getId()];
					double dAC = matrice.tableau[precedente.getId()][ville.getId()];
					double dBC = matrice.tableau[origine.getId()][ville.getId()];

					angle = Math.toDegrees(Math.acos(((dAB*dAB)+(dBC*dBC)-(dAC*dAC))/(2*dAB*dBC)));

					if (angle/dBC > angleRef) {
						angleRef = angle/dBC;
						distanceAB = matrice.tableau[origine.getId()][ville.getId()];
						destination = ville;
						// DEBUG
						// System.out.printf("Un angle de %3.1f° a été trouvé !\n", angleRef);
					}
				}

			}
			// DEBUG
			// System.out.printf("Segment %d%d ajouté !\n", origine.getId(), destination.getId());
			distanceTotale = distanceTotale + distanceAB;
			this.add(destination);
			precedente = origine;
			origine = destination;
		}
		this.add(matrice.listeVilles.get(indexDepart));
		distanceTotale = distanceTotale + matrice.tableau[origine.getId()][indexDepart];


		 */

		return null;
	}
}
