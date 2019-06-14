package org.peip.salesman.AlgorithmOpimization;

import org.peip.salesman.Chemin;
import org.peip.salesman.GestionMatrice;

import java.util.Random;

/**
 * Algorithme simple qui intervertit deux villes
 */
public class SimpleSwap {
    /**
     * @param g
     * @param ancien_ch
     * @return
     */
    public static Chemin simpleSwapAlgorithm(GestionMatrice g, Chemin ancien_ch) {
        if (ancien_ch.size() < 4) {
            return ancien_ch;
        }
        float oldCheminSize = ancien_ch.getdistancetotale();
        for (int i = 0; i < Math.ceil(factorielle((ancien_ch.size() - 1) / 2)); i++) {
            Random monRandom = new Random();
            int pointAIntervertir = 1 + monRandom.nextInt(ancien_ch.size() - 2); // générere un nombre entre 1 et l'indice de fin du chemin ancien_ch -1
            int ville = ancien_ch.get(pointAIntervertir);

            int villeAGauche;
            int villeAGauchex2;
            int villeADroite;
            if ((Math.random() < 0.5 && pointAIntervertir > 1) || pointAIntervertir == ancien_ch.size() - 2) { // swap vers la droite
                villeAGauche = ancien_ch.get(pointAIntervertir - 1);
                villeAGauchex2 = ancien_ch.get(pointAIntervertir - 2);
                villeADroite = ancien_ch.get(pointAIntervertir + 1);

            } else {
                villeAGauche = ancien_ch.get(pointAIntervertir + 1);
                villeAGauchex2 = ancien_ch.get(pointAIntervertir + 2);
                villeADroite = ancien_ch.get(pointAIntervertir - 1);

            }

            float valeurSegmentGauche = g.getMatriceA()[villeAGauchex2][villeAGauche];
            float valeurSegmentDroit = g.getMatriceA()[ville][villeADroite];
            float newValeurSegmentGauche = g.getMatriceA()[villeAGauchex2][ville];
            float newValeurSegmentDroit = g.getMatriceA()[villeAGauche][villeADroite];
            float newValueIfSwapped = (oldCheminSize - valeurSegmentDroit - valeurSegmentGauche) + newValeurSegmentGauche + newValeurSegmentDroit;
            if (newValueIfSwapped < oldCheminSize) {
                ancien_ch.setdistancetotale(newValueIfSwapped);
                oldCheminSize = newValueIfSwapped;
                ancien_ch.remove(pointAIntervertir - 1);
                ancien_ch.add(pointAIntervertir + 1, villeAGauche); // intervertion

            }
        }
        return ancien_ch;
    }

    public static int factorielle(int n) {
        int tmp = 1;
        for (int i = 1; i <= n; i++) {
            tmp *= i;
        }
        return tmp;
    }

}
