package horde;

public class Case {
	
	// contient des objets et des zombies
	private String abscisse;
	private int ordonne;
	private int nbZombies;
	private int nbPlanches; 
	private int nbMetals;
	//private int nbBoissons;
	
	public Case(String abscisse, int ordonne) {
		this.setAbscisse(abscisse);
		this.setOrdonne(ordonne);
		this.setNbZombies(nbZombies);
		this.setNbPlanches(nbPlanches);
		this.setNbMetals(nbMetals);
		//this.setNbBoissons(nbBoissons);
	}
	
	public Case(String abscisse, int ordonne, int nbZombies, int nbPlanches, int nbMetals/*, int nbBoissons*/) {
		this.setAbscisse(abscisse);
		this.setOrdonne(ordonne);
		this.setNbZombies(nbZombies);
		this.setNbPlanches(nbPlanches);
		this.setNbMetals(nbMetals);
		//this.setNbBoissons(nbBoissons);
	}
	
	public int getNbZombies() {
		return nbZombies;
	}
	
	public void setNbZombies(int nbZombies) {
		this.nbZombies = nbZombies;
	}

	public int getNbPlanches() {
		return nbPlanches;
	}

	public void setNbPlanches(int nbPlanches) {
		this.nbPlanches = nbPlanches;
	}

	public int getNbMetals() {
		return nbMetals;
	}

	public void setNbMetals(int nbMetals) {
		this.nbMetals = nbMetals;
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
