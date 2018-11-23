package horde;

import java.util.*;

public class HotelDeVille extends Case{
	// Toutes les interactions qu'il sont possibles de faire dans l'hdv
	// modification des setters avec les collections pour ajouter des objects dans ces collections
	
	private HashSet maison = new HashSet();
	private LinkedList<Integer> puits = new LinkedList<>();
	private HashSet banque = new HashSet();
	private HashSet chantiers = new HashSet();
	private boolean grandePorte;
	
	public HotelDeVille(String abscisse, int ordonne) {
		super(abscisse, ordonne);
		this.setGrandePorte(false);
	}

	public HashSet getMaison() {
		return maison;
	}

	public HashSet getBanque() {
		return banque;
	}

	public boolean isGrandePorte() {
		return grandePorte;
	}

	public void setGrandePorte(boolean grandePorte) {
		this.grandePorte = grandePorte;
	}

	public LinkedList<Integer> getPuits() {
		return puits;
	}
	
	// ********************************************************* //

	public void ouvrirPorte(Player p) {
		p.setPa(p.getPa()-1);
		this.setGrandePorte(true);
	}
	
	public void createPuits() {
		for (int i = 0; i < 150; i++) {
			this.getPuits().add(1);
		}
	}
	
	/*System.out.println("Que Voulez vous faire?\n"
			+ "Sortir de la ville : 1\n"
			+ "Aller à la banque : 2\n"
			+ "Aller au puit : 3");*/
	
	public void actionDansLaVille(Player p) {
		//TODO ICI
	}
	
}
