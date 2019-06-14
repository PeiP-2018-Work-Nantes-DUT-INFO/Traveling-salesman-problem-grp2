package org.peip.salesman.AlgorithmCreation;

import org.peip.salesman.Chemin;
import org.peip.salesman.GestionMatrice;
import org.peip.salesman.Ville;

import java.util.ArrayList;

public class RatioXYDistance {
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
		float distanceTotale = 0;
		double ratio;

		chemin.add(indexDepart);
		int origine = indexDepart;
		int destination = 0;

		for (int i=0; i < villes.size() - 1; i++) {
			// DEBUG
			// System.out.printf("\nRecherche depuis la ville ID°%d :\n", origine.getId());
			distanceAB = 0;
			ratio = 0;
			for (int j=0; j < villes.size(); j++) {
				// System.out.print("ok |");
				if (!chemin.contains(j)) {
					// Si le trajet ne contient pas déjà cette ville

					if ((villes.get(j).getX()*villes.get(j).getY())/matrice[origine][j] > ratio) {
						ratio = (villes.get(j).getX()*villes.get(j).getY())/matrice[origine][j];
						distanceAB = matrice[origine][j];
						destination = j;
						// DEBUG
						// System.out.printf("Un angle de %3.1f° a été trouvé !\n", angleRef);
					}
				}

			}
			// DEBUG
			// System.out.printf("Segment %d%d ajouté !\n", origine.getId(), destination.getId());
			distanceTotale += distanceAB;
			chemin.add(destination);
			origine = destination;
		}

		chemin.add(indexDepart);
		distanceTotale += matrice[origine][indexDepart];

		chemin.setdistancetotale(distanceTotale);

		return chemin;
	}
}
