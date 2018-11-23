package horde;

public class Case {
	
	// contient des objets et des zombies
	private String abscisse;
	private int ordonne;
	private int nbZombies;
	private int nbPlanche; 
	private int nbMetal;
	//private int nbBoissons;
	
	public Case(String abscisse, int ordonne) {
		this.setAbscisse(abscisse);
		this.setOrdonne(ordonne);
		//this.setNbBoissons(nbBoissons);
	}
	
	public Case(String abscisse, int ordonne, int nbZombies, int nbPlanche, int nbMetal/*, int nbBoissons*/) {
		this.setAbscisse(abscisse);
		this.setOrdonne(ordonne);
		this.setNbZombies(nbZombies);
		this.setNbPlanche(nbPlanche);
		this.setNbMetal(nbMetal);
		//this.setNbBoissons(nbBoissons);
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
}
