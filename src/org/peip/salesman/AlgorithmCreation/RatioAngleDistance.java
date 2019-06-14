package org.peip.salesman.AlgorithmCreation;

import org.peip.salesman.Chemin;
import org.peip.salesman.GestionMatrice;
import org.peip.salesman.Ville;

import java.util.ArrayList;

public class RatioAngleDistance {
	/*
	 * 
	 * @param matriceDistance la matrice des distances entre villes
	 * @param indexDepart la première ville de départ du chemin
	 * @param indexBis la seconde ville de départ du chemin
	 */
	public static Chemin creerChemin(GestionMatrice matriceVille, int indexDepart, int indexBis) {

		ArrayList<Ville> villes = matriceVille.getListe();
		float[][] matrice = matriceVille.getMatriceA();

		double angleRef;
		double angle = 0;


		Chemin chemin = new Chemin();

		chemin.add(indexDepart);
		chemin.add(indexBis);
		
		float distanceAB;

		float distanceTotale = matrice[indexDepart][indexBis];
		
		int VillePrecedente = indexDepart;
		int VilleOrigine = indexBis;
		int VilleDestination = 0;

		for (int i=0; i < villes.size()-2; i++) {

			distanceAB = 10000;
			angleRef = 0;

			for (int j=0; j < villes.size(); j++) {

				if (!chemin.contains(j)) {

					double dAB = matrice[VillePrecedente][VilleOrigine];
					double dAC = matrice[VillePrecedente][j];
					double dBC = matrice[VilleOrigine][j];

					angle = Math.toDegrees(Math.acos(((dAB*dAB)+(dBC*dBC)-(dAC*dAC))/(2*dAB*dBC)));

					if (angle/dBC > angleRef) {
						angleRef = angle/dBC;
						distanceAB = matrice[VilleOrigine][j];
						VilleDestination = j;
					}
				}

			}
			// DEBUG
			// System.out.printf("Segment %d%d ajouté !\n", origine.getId(), destination.getId());
			distanceTotale = distanceTotale + distanceAB;
			chemin.add(VilleDestination);
			VillePrecedente = VilleOrigine;
			VilleOrigine = VilleDestination;
		}
		chemin.add(indexDepart);
		distanceTotale = distanceTotale + matrice[VilleOrigine][indexDepart];

		chemin.setdistancetotale(distanceTotale);

		return chemin;
	}
}
