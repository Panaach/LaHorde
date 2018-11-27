package horde;

import java.util.ArrayList;
import java.util.LinkedList;

public class Player {
	
	private String abscisse;
	private int ordonne;
	private String pseudo;
	private boolean recupGourde;
	//private int indice;
	private int nbTour;
	private int pa;
	private int pv;
	private ArrayList<ObjetJeu> sac = new ArrayList<>();
	
	// Constructeur
	public Player(String pseudo/*, int indice*/) {
		this.setPseudo(pseudo);
		this.setNbTour(nbTour);	
		this.setRecupGourde(false);
		this.setPa(6);
		this.setPv(100);
		//this.setIndice(indice);
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
	
	public boolean isRecupGourde() {
		return recupGourde;
	}
	
	public void setRecupGourde(boolean recupGourde) {
		this.recupGourde = recupGourde;
	}
	
	public int getNbTour() {
		return nbTour;
	}
	
	public void setNbTour(int nbTour) {
		this.nbTour = nbTour;
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
	
	/*public int getIndice() {
		return indice;
	}
	
	public void setIndice(int indice) {
		this.indice = indice;
	}*/

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
	
	public ArrayList<ObjetJeu> getSac() {
		return sac;
	}
	
	public void setSac(ArrayList<ObjetJeu> sac) {
		this.sac = sac;
	}
	
	//************************************************************************************//
	
	public static void avancerDroite(Player p) {
		if (p.getPa()>0) {
			System.out.println("Nombre de PA du joueur : " + p.getPa());
			if (!p.getAbscisse().equals("Y")) {
				// parcours l'�num�ration afin de trouver la lettre correspondante et on la remplace par la suivante
				// perds 1 PA
				int i = 0;
				while(!p.getAbscisse().equals(String.valueOf(Grille.absAlphabet.values()[i]))) {
					i+=1;
				}
				p.setAbscisse(String.valueOf(Grille.absAlphabet.values()[i+1]));
				p.setPa(p.getPa()-1);
			} else
				System.out.println("Vous ne pouvez pas vous d�placer � droite!");
		} else
			System.out.println("Vous ne poss�dez plus de PA!");
	}

	public static void avancerGauche(Player p) {
		if (p.getPa()>0) {
			System.out.println("Nombre de PA du joueur : " + p.getPa());
			if (!p.getAbscisse().equals("A")) {
				// parcours l'�num�ration afin de trouver la lettre correspondante et on la remplace par la pr�c�dente
				// perds 1 PA
				int i = 0;
				while(!p.getAbscisse().equals(String.valueOf(Grille.absAlphabet.values()[i]))) {
					i+=1;
				}
				p.setAbscisse(String.valueOf(Grille.absAlphabet.values()[i-1]));
				p.setPa(p.getPa()-1);
			} else
				System.out.println("Vous ne pouvez pas vous d�placer � gauche!");
		} else
			System.out.println("Vous ne poss�dez plus de PA!");
	}
	
	public static void avancerHaut(Player p) {
		if (p.getPa()>0) {
			System.out.println("Nombre de PA du joueur : " + p.getPa());
			if (p.getOrdonne() != 1) {
				// r�duit de 1 l'ordonn�e	
				// perds 1 PA
				p.setOrdonne(p.getOrdonne()-1);
				p.setPa(p.getPa()-1);
			} else
				System.out.println("Vous ne pouvez pas vous d�placer vers le haut!");
		} else
			System.out.println("Vous ne poss�dez plus de PA!");
	}
	
	public static void avancerBas(Player p) {
		if (p.getPa()>0) {
			System.out.println("Nombre de PA du joueur : " + p.getPa());
			if (p.getOrdonne() != 25) {
				// augmente de 1 l'ordonn�e	
				// perds 1 PA
				p.setOrdonne(p.getOrdonne()+1);
				p.setPa(p.getPa()-1);
			} else
				System.out.println("Vous ne pouvez pas vous d�placer vers le bas!");
		} else
			System.out.println("Vous ne poss�dez plus de PA!");
	}
	
	public void fouiller(Player p, LinkedList<Case> grilleDeJeu) {
		Case caseActuelle = grilleDeJeu.get(Grille.numeroCaseDansLaListe(p.getAbscisse(), p.getOrdonne()));
		
		System.out.println("Nombre de PA du joueur : " + p.getPa());

		if (!caseActuelle.getAbscisse().equals("L") || caseActuelle.getOrdonne() != 13) {
			// Si mon sac n'est pas vide alors j'�vite le nullPointerexeption
			if (!p.getSac().isEmpty()) {
				if (caseActuelle.getNbPlanche() != 0 || caseActuelle.getNbMetal() != 0) {
					System.out.println(caseActuelle.getNbPlanche() + " planches\n"
							+ caseActuelle.getNbMetal() + " m�tals");
					for (int i = p.getSac().size(); i < 10; i++) {

						if (caseActuelle.getNbPlanche() != 0) {
							p.getSac().add(new Planche());
							caseActuelle.setNbPlanche(caseActuelle.getNbPlanche()-1);
						} else if (caseActuelle.getNbMetal() != 0 ) {
							p.getSac().add(new Metal());
							caseActuelle.setNbPlanche(caseActuelle.getNbPlanche()-1);
						}
						
					}
				} else 
					System.out.println("Il n'y a rien dans cette case!");				
			} else {
				// Si mon sac est vide alors (j'ai le nullPointerexeption) dans ma boucle for je peux commencer � 0
				if (caseActuelle.getNbPlanche() != 0 || caseActuelle.getNbMetal() != 0) {
					System.out.println("Vous avez trouv� " + caseActuelle.getNbPlanche() 
										+ " planches et " + caseActuelle.getNbMetal() + " m�tals!");
					for (int i = 0; i < 10; i++) {
						
						if (caseActuelle.getNbPlanche() != 0) {
							p.getSac().add(new Planche());
							caseActuelle.setNbPlanche(caseActuelle.getNbPlanche()-1);
						} else if (caseActuelle.getNbMetal() != 0 ) {
							p.getSac().add(new Metal());
							caseActuelle.setNbPlanche(caseActuelle.getNbPlanche()-1);
						}
						
					}
				} else 
					System.out.println("Il n'y a rien dans cette case!");
			}
		} else
			System.out.println("Vous ne pouvez pas fouiller la ville!");
	}
	
	public void tuerUnZombie (Player p, LinkedList<Case> grilleDeJeu) {
		p.setPa(p.getPa()-1);
		Case caseAct = grilleDeJeu.get(Grille.numeroCaseDansLaListe(p.getAbscisse(), p.getOrdonne()));
		caseAct.setNbZombies(caseAct.getNbZombies()-1);
	}
}
