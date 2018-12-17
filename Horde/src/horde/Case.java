package horde;

public class Case {
	
	// contient des objets et des zombies
	private String abscisse;
	private int ordonne;
	private int nbZombies;
	private int nbPlanche; 
	private int nbMetal;
	private boolean boisson;
	private boolean affCase;
	
	public Case(String abscisse, int ordonne) {
		this.setAbscisse(abscisse);
		this.setOrdonne(ordonne);
	}
	
	public Case(String abscisse, int ordonne, int nbZombies, int nbPlanche, int nbMetal, boolean boisson, boolean affCase) {
		this.setAbscisse(abscisse);
		this.setOrdonne(ordonne);
		this.setNbZombies(nbZombies);
		this.setNbPlanche(nbPlanche);
		this.setNbMetal(nbMetal);
		this.setBoisson(boisson);
		this.setAffCase(affCase);
	}
	
	public int getNbZombies() {
		return nbZombies;
	}
	
	public void setNbZombies(int nbZombies) {
		this.nbZombies = nbZombies;
	}

	public int getNbPlanche() {
		return nbPlanche;
	}

	public void setNbPlanche(int nbPlanches) {
		this.nbPlanche = nbPlanches;
	}

	public int getNbMetal() {
		return nbMetal;
	}

	public void setNbMetal(int nbMetal) {
		this.nbMetal = nbMetal;
	}

	
	public String getAbscisse() {
		return abscisse;
	}
	

	public void setAbscisse(String abscisse) {
		this.abscisse = abscisse;
	}

	public int getOrdonne() {
		return ordonne;
	}

	public void setOrdonne(int ordonnée) {
		this.ordonne = ordonnée;
	}

	public boolean hasBoisson() {
		return boisson;
	}

	public void setBoisson(boolean boisson) {
		this.boisson = boisson;
	}

	public boolean isAffCase() {
		return affCase;
	}

	public void setAffCase(boolean affCase) {
		this.affCase = affCase;
	}
}
