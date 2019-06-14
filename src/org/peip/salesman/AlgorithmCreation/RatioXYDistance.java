package org.peip.salesman.AlgorithmCreation;

import org.peip.salesman.Chemin;

public class RatioXYDistance {
	/*
	 * 
	 * @param matriceDistance la matrice des distances entre villes
	 * @param indexDepart la ville de départ du chemin
	 */
	public static Chemin creerChemin(float[][] matriceDistance, int indexDepart, int indexBis) {
		/*

			int distanceAB;
		double ratio;

		this.add(matrice.listeVilles.get(indexDepart));
		Ville origine = matrice.listeVilles.get(indexDepart);
		Ville destination = matrice.listeVilles.get(0);

		for (int i=0; i<matrice.nbVilles-1; i++) {
			// DEBUG
			// System.out.printf("\nRecherche depuis la ville ID°%d :\n", origine.getId());
			distanceAB = 0;
			ratio = 0;
			for (Ville ville : matrice.listeVilles) {
				// System.out.print("ok |");
				if (!this.contains(ville)) {
					// Si le trajet ne contient pas déjà cette ville

					if ((ville.getX()*ville.getY())/matrice.tableau[origine.getId()][ville.getId()] > ratio) {
						ratio = (ville.getX()*ville.getY())/matrice.tableau[origine.getId()][ville.getId()];
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
			origine = destination;
		}

		this.add(matrice.listeVilles.get(indexDepart));
		distanceTotale = distanceTotale + matrice.tableau[origine.getId()][indexDepart];


		 */
		return null;
	}
}
