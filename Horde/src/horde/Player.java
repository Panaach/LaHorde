package horde;

import java.util.HashSet;

public class Player {
	
	private String abscisse;
	private int ordonne;
	private String pseudo;
	private int indice;
	private int pa;
	private int pv;
	private HashSet sac;
	
	// Constructeur
	public Player(String pseudo, int indice) {
		this.setPseudo(pseudo);
		this.setPa(6);
		this.setPv(100);
		this.setIndice(indice);
		this.setAbscisse("L");
		this.setOrdonne(13);
	}
	// Getters and Setters
	public String getPseudo() {
		return pseudo;
	}
	
	public void setPseudo(String pseudo) {
		this.pseudo = pseudo;
	}
	
	public int getPa() {
		return pa;
	}
	
	public void setPa(int pa) {
		this.pa = pa;
	}
	
	public int getPv() {
		return pv;
	}
	
	public void setPv(int pv) {
		this.pv = pv;
	}
	
	public int getIndice() {
		return indice;
	}
	
	public void setIndice(int indice) {
		this.indice = indice;
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

	public void setOrdonne(int ordonne) {
		this.ordonne = ordonne;
	}
	
	public static void avancerDroite(Player p) {
		if (p.getPa()>0) {
			if (!p.getAbscisse().equals("y")) {
				// parcours l'énumération afin de trouver la lettre correspondante et on la remplace par la suivante
				// perds 1 PA
				int i = 0;
				while(!p.getAbscisse().equals(String.valueOf(Grille.absAlphabet.values()[i]))) {
					i+=1;
				}
				p.setAbscisse(String.valueOf(Grille.absAlphabet.values()[i+1]));
				p.setPa(p.getPa()-1);
			} else
				System.out.println("Vous ne pouvez pas vous déplacer à droite!");
		} else
			System.out.println("Vous ne possédez plus de PA!");
	}

	public static void avancerGauche(Player p) {
		if (p.getPa()>0) {
			if (!p.getAbscisse().equals("A")) {
				// parcours l'énumération afin de trouver la lettre correspondante et on la remplace par la précédente
				// perds 1 PA
				int i = 0;
				while(!p.getAbscisse().equals(String.valueOf(Grille.absAlphabet.values()[i]))) {
					i+=1;
				}
				p.setAbscisse(String.valueOf(Grille.absAlphabet.values()[i-1]));
				p.setPa(p.getPa()-1);
			} else
				System.out.println("Vous ne pouvez pas vous déplacer à gauche!");
		} else
			System.out.println("Vous ne possédez plus de PA!");
	}
	
	public static void avancerHaut(Player p) {
		if (p.getPa()>0) {
			if (p.getOrdonne() != 1) {
				// réduit de 1 l'ordonnée	
				// perds 1 PA
				p.setOrdonne(p.getOrdonne()-1);
				p.setPa(p.getPa()-1);
			} else
				System.out.println("Vous ne pouvez pas vous déplacer vers le haut!");
		} else
			System.out.println("Vous ne possédez plus de PA!");
	}
	
	public static void avancerBas(Player p) {
		if (p.getPa()>0) {
			if (p.getOrdonne() != 25) {
				// augmente de 1 l'ordonnée	
				// perds 1 PA
				p.setOrdonne(p.getOrdonne()+1);
				p.setPa(p.getPa()-1);
			} else
				System.out.println("Vous ne pouvez pas vous déplacer vers le bas!");
		} else
			System.out.println("Vous ne possédez plus de PA!");
	}
}
