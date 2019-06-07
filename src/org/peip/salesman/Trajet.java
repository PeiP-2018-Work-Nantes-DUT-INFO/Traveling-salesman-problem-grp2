package org.peip.salesman;
import java.util.ArrayList;

@SuppressWarnings("serial")
public class Trajet extends ArrayList<Ville>{
	private Matrice matrice;
	private int distanceTotale;
	
	/**
	 * Créer une ArrayList de villes, initialisée vide
	 */
	public Trajet(Matrice matrice) {
		super();
		this.matrice = matrice;
		this.distanceTotale = 0;
	}

	/**
	 * Détermine un trajet grâce à l'algorithme du plus proche voisin
	 * @param indexDepart l'index du point de départ dans la liste
	 */
	public void plusProcheVoisin(int indexDepart) {
		int distanceAB;

		this.add(matrice.listeVilles.get(indexDepart));
		Ville origine = matrice.listeVilles.get(indexDepart);
		Ville destination = matrice.listeVilles.get(0);
		
		for (int i=0; i<matrice.nbVilles-1; i++) {
			// DEBUG
			// System.out.printf("\nRecherche depuis la ville ID°%d :\n", origine.getId());
			distanceAB = 10000;
			for (Ville ville : matrice.listeVilles) {
				if (!this.contains(ville)) {
					// Si le trajet ne contient pas déjà cette ville
					if (matrice.tableau[origine.getId()][ville.getId()] < distanceAB) {
						distanceAB = matrice.tableau[origine.getId()][ville.getId()];
						destination = ville;
						// DEBUG
						// System.out.printf("Un trajet de %d km a été trouvé !\n", matricePoids[origine.getId()][ville.getId()]);
					}
				}
			}
			// DBEUG
			// System.out.printf("Segment %d%d ajouté !\n", origine.getId(), destination.getId());
			distanceTotale = distanceTotale + distanceAB;
			this.add(destination);
			origine = destination;
		}
		
		this.add(matrice.listeVilles.get(indexDepart));
		distanceTotale = distanceTotale + matrice.tableau[origine.getId()][indexDepart];
	}
	
	
	/**
	 * Détermine un trajet grâce à l'algorithme de l'angle le plus ouvert
	 * @param indexDepart l'index du point de départ dans la liste
	 * @param indexDepartBis l'index du deuxième point du premier segment dans la liste
	 */
	public void anglePlusOuvert(int indexDepart, int indexDepartBis) {
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
					
					if (angle > angleRef) {
						angleRef = angle;
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
	}
	
	
	/**
	 * Détermine un trajet grâce à l'algorithme de l'angle par la distance
	 * @param indexDepart l'index du point de départ dans la liste
	 * @param indexDepartBis l'index du deuxième point du premier segment dans la liste
	 */
	public void angleParDistance(int indexDepart, int indexDepartBis) {
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
	}
		
	public void xyParDistance(int indexDepart) {
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
	}
	
	/**
	 * Améliore un trajet en vérifiant si un point est présent autour d'un segment
	 */
	public void ameliorationGeometrique() throws Exception {
		
		if (matrice.nbVilles > 3) {
			
		} else {
			throw new Exception("Ce trajet ne comporte pas assez de villes.");
		}
		
	}
	
	@Override
	public String toString() {
		String str = new String();
		for (Ville ville : this) {
			str = str + " -> " + ville.getNom();
		}
		str = str + "\t\t = " + this.distanceTotale + "km";
		return str;
	}
}
