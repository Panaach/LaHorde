package horde;

import java.util.ArrayList;
import java.util.HashSet;

public class HotelDeVille extends Case{
	// Toutes les interactions qu'il sont possibles de faire dans l'hdv
	// modification des setters avec les collections pour ajouter des objects dans ces collections
	
	private HashSet maison = new HashSet();
	private ArrayList<Integer> puits = new ArrayList<Integer>();
	private HashSet banque = new HashSet();
	private HashSet chantiers = new HashSet();
	private boolean grandePorte;
	
	public HotelDeVille(String abscisse, int ordonne) {
		super(abscisse, ordonne);
		this.setGrandePorte(false);
		this.setPuits(170);
	}

	public HashSet getMaison() {
		return maison;
	}

	public void addMaison(Object e) {
		this.maison.add(e);
	}

	public ArrayList<Integer> getPuits() {
		return puits;
	}

	public void setPuits(int puits) {
		this.puits.add(puits);
	}

	public HashSet getBanque() {
		return banque;
	}

	public void addBanque(Object e) {
		this.banque.add(e);
	}

	public HashSet getChantiers() {
		return chantiers;
	}

	public void addChantiers(Object e) {
		this.chantiers.add(e);
	}

	public boolean isGrandePorte() {
		return grandePorte;
	}

	public void setGrandePorte(boolean grandePorte) {
		this.grandePorte = grandePorte;
	}
	
	public void ouvrirPorte(Player p) {
		p.setPa(p.getPa()-1);
		this.setGrandePorte(true);
	}
	
}
