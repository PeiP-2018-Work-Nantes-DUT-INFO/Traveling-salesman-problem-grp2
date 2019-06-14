package org.peip.salesman;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class GestionMatrice {
	private File file;
	private ArrayList<Ville> liste;
	private float[][] matriceA;

	@SuppressWarnings("unused")
	private int nombreVille;
	
	public GestionMatrice()
	{
		this.liste = new ArrayList<Ville>();
		this.initListe();
		this.nombreVille = liste.size();
		
		this.matriceA = new float[nombreVille][nombreVille];
		this.initMatrice();
	}

	public File getFile() {
		return file;
	}

	public void setFile(File file) {
		this.file = file;
	}

	public ArrayList<Ville> getListe() {
		return liste;
	}

	public float[][] getMatriceA() {
		return matriceA;
	}
	
	private void initListe()
	{
		Scanner sc = null;
		String line = null;
		String[] champs = null;
		this.file = new File("data/villes_Fit_A_1000.csv");

		try {
			
			sc = new Scanner(this.file);

			while (sc.hasNextLine()) {
				line = sc.nextLine();
				line = line.replace(',', '.');
				champs = line.split(";");
				System.out.println(champs[0] + " " + champs[1] + " " + champs[2]);
				liste.add(new Ville(champs[0], Float.parseFloat(champs[1]), Float.parseFloat(champs[2])));
			}
		} catch (FileNotFoundException e) {
			System.out.println("Fichier pas trouvé !");
		}
		
	}
	
	private void initMatrice()
	{
		for (int i = 0; i < this.liste.size()/2; i++)
		{
			for (int j = 0; j < this.liste.size()/2; j++)
			{
				this.matriceA[i][j] = -1;
			}
		}
		
		for (int i = 0; i < this.liste.size(); i++)
		{
			for (int j = 0; j < this.liste.size(); j++)
			{
				if(i==j) this.matriceA[i][j] = 0;
				else this.matriceA[i][j] = (float) this.liste.get(i).calcDist(this.liste.get(j));
			}
		}
	}
	
	
	public String toString()
	{
		String s = "";
		for (int i = 0; i < this.liste.size(); i++)
		{
			s += "| ";
			for (int j = 0; j < this.liste.size(); j++)
			{
				if(this.matriceA[i][j] == 0.0) s += "0.0000000    |    ";
				else s += this.matriceA[i][j] + "    |    ";
			}
			s += "\n";
		}
		
		return s;
	}
}
