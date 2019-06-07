package org.peip.salesman;

public class Ville {
	private String nom;
	private float x;
	private float y;
	private int id;
	
	private static int compteurID = 0;
	
	public Ville(String nom, float x, float y){
		this.nom = nom;
		this.x = x;
		this.y = y;
		this.id = compteurID;
		compteurID++;
	}

	public double calcDist(Ville v) {
		return Math.sqrt(Math.pow(v.getX()-this.x, 2)+Math.pow(v.getY()-this.y, 2));
	}
	
	public String getNom() { return nom; }
	public float getX() { return x; }
	public float getY() { return y; }
	public int getId() { return id; }
	
	public void setNom(String nom) { this.nom = nom; }
	public void setX(float x) { this.x = x; }
	public void setY(float y) { this.y = y; }
	public void setId(int id) { this.id = id; }
	
	
}
