package horde;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Scanner;

public class Player {
	
	private String abscisse;
	private int ordonne;
	private String pseudo;
	private int nbTourRecupGourde;
	private boolean recupGourde;
	private int nbTourConsommeGourde;
	private boolean consommeGourde;
	private int nbTourMangerRation;
	private boolean mangerRation;
	private int pa;
	private int pv;
	private ArrayList<ObjetJeu> sac = new ArrayList<>();
	
	// sac du joueur
	HotelDeVille hdv = new HotelDeVille("L", 13);
	
	// Constructeur
	public Player(String pseudo) {
		this.setPseudo(pseudo);
		this.setNbTourRecupGourde(0);
		this.setMangerRation(false);
		this.setNbTourConsommeGourde(0);
		this.setConsommeGourde(false);
		this.setNbTourMangerRation(0);
		this.setMangerRation(false);
		this.setPa(6);
		this.setPv(100);
		this.setAbscisse("L");
		this.setOrdonne(13);
	}
	/*********************************** Getters and Setters ***********************************/
	public String getPseudo() {
		return pseudo;
	}
	
	public void setPseudo(String pseudo) {
		this.pseudo = pseudo;
	}
	
	public int getNbTourRecupGourde() {
		return nbTourRecupGourde;
	}
	
	public void setNbTourRecupGourde(int nbTourRecupGourde) {
		this.nbTourRecupGourde = nbTourRecupGourde;
	}
	
	public boolean isRecupGourde() {
		return recupGourde;
	}
	public void setRecupGourde(boolean recupGourde) {
		this.recupGourde = recupGourde;
	}
	public int getNbTourConsommeGourde() {
		return nbTourConsommeGourde;
	}
	public void setNbTourConsommeGourde(int nbTourConsommeGourde) {
		this.nbTourConsommeGourde = nbTourConsommeGourde;
	}
	public boolean isConsommeGourde() {
		return consommeGourde;
	}
	public void setConsommeGourde(boolean consommeGourde) {
		this.consommeGourde = consommeGourde;
	}
	public boolean isMangerRation() {
		return mangerRation;
	}
	public void setMangerRation(boolean mangerRation) {
		this.mangerRation = mangerRation;
	}
	public int getNbTourMangerRation() {
		return nbTourMangerRation;
	}
	
	public void setNbTourMangerRation(int nbTourMangerRation) {
		this.nbTourMangerRation = nbTourMangerRation;
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
			System.out.println("Nombre de PA du joueur : " + p.getPa());
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
			System.out.println("Nombre de PA du joueur : " + p.getPa());
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
			System.out.println("Nombre de PA du joueur : " + p.getPa());
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
	
	public void fouiller(Player p, LinkedList<Case> grilleDeJeu) {
		Case caseActuelle = grilleDeJeu.get(Grille.numeroCaseDansLaListe(p.getAbscisse(), p.getOrdonne()));
		
		System.out.println("Nombre de PA du joueur : " + p.getPa());

		if (!caseActuelle.getAbscisse().equals("L") || caseActuelle.getOrdonne() != 13) {
			// Si mon sac n'est pas vide alors j'évite le nullPointerexeption
			if (!p.getSac().isEmpty()) {
				if (caseActuelle.getNbPlanche() != 0 || caseActuelle.getNbMetal() != 0) {
					System.out.println("Vous avez trouvé : " + caseActuelle.getNbPlanche() + " planches\n"
							+ caseActuelle.getNbMetal() + " métals");
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
				// Si mon sac est vide alors (j'ai le nullPointerexeption) dans ma boucle for je peux commencer à 0
				if (caseActuelle.getNbPlanche() != 0 || caseActuelle.getNbMetal() != 0) {
					System.out.println("Vous avez trouvé " + caseActuelle.getNbPlanche() 
										+ " planches et " + caseActuelle.getNbMetal() + " métals!");
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
	
	public void actionPossibleDuJoeur(Player p, LinkedList<Case> grilleDeJeu) {
		Scanner sc = new Scanner(System.in);
		// si le joueur n'est pas en ville alors il peut tuer ou fouiller des cases
		int code = -1;
		if (!hdv.enVille(p)) {
			Case caseAct = grilleDeJeu.get(Grille.numeroCaseDansLaListe(p.getAbscisse(), p.getOrdonne()));
			//System.out.println("\n" + caseAct.getNbZombies() + " zombies dans cette case!");
			
			if (caseAct.getNbZombies()>0) {
				System.out.println("Que voulez-vous faire dans cette case?\n"
						+ "Fouiller la case : 0\n"
						+ "Utiliser un objet dans le sac : 1\n"
						+ "Tuer un zombie : 2\n"
						+ "Ne rien faire : 9");
			} else {
				System.out.println("\nQue voulez-vous faire dans cette case?\n"
						+ "Fouiller la case : 0\n"
						+ "Utiliser un objet dans le sac : 1\n"
						+ "Ne rien faire : 9");
			}
			code = sc.nextInt();

			switch (code)
			{
			case 0 : // FOUILLER UNE CASE
				p.fouiller(p, grilleDeJeu); 
				break;
			case 1 : // UTILISER UN OBJET DANS LE SAC
				utiliserUnObjet(p);
				break;
			case 2 :// TUER UN ZOMBIE
				p.tuerUnZombie(p, grilleDeJeu);
				System.out.println("\n" + caseAct.getNbZombies() + " zombies dans cette case!");	
				break;	
				
			case 9 : // NE RIEN FAIRE
				break;
			}

			// S'il y a trop de zombies dans la case le joueur ne peut plus se déplacer 
			// TODO IL PERDS DES PV OU UN TRUC DU GENRE A RAJOUTER !!!
			if (caseAct.getNbZombies()>p.getPa()) {
				code = 0;
				while (code == 0) {
					System.out.println("\nTrop de zombies vous ne pouvez plus vous déplacer!\n"
							+ "Voulez-vous tuer un zombie?\n"
							+ "Tuer un zombie : 0 \n"
							+ "Ne rien faire : 1");
					code = sc.nextInt();
					
					if (code == 0)
						p.tuerUnZombie(p, grilleDeJeu);
					else
						break;
				}
			}

		} else { // sinon je suis en ville (je regarde si la porte est ouverte) si oui alors je peut effectuer des actions en ville
			if (HotelDeVille.isGrandePorte() == true) {
				hdv.actionDansLaVille(p, grilleDeJeu);
			} else {
				System.out.println("La porte est fermée, shit happens!");
			}
		}
	}
	
	public void utiliserUnObjet(Player p) {
		if (!p.getSac().isEmpty()) { // sac non vide
			Scanner sc = new Scanner(System.in);
			p.getSac().forEach((temp) -> {
				// ObjetJeu objet = temp;					
				if (ObjetJeu.getId(temp) == 3) { // POUR UTILISER UNE GOURDE
					System.out.println("Voulez-vous utiliser votre gourde?\n"
							+ "Utiliser : 0\n"
							+ "Ne rien faire : 1");
					int utiliser = sc.nextInt();
					
					if (utiliser == 0) { 
						if (!p.isConsommeGourde()) {
							if (p.getNbTourConsommeGourde() == 0) { // GOURDE UTILISER : + 6PA
								p.getSac().remove(new Gourde());
								p.setPa(6);
								p.setConsommeGourde(true);
								System.out.println("Gourde utilisé!");
							} else {
								p.setConsommeGourde(false);
							}
						} else
							System.out.println("Vous avez déjà utiliser une gourde aujourd'hui!");
					} 
					return;
				} 
				
				if (ObjetJeu.getId(temp) == 2) { // POUR UTILISER UNE RATION
					System.out.println("Voulez-vous utiliser votre ration?\n"
							+ "Utiliser : 0\n"
							+ "Ne rien faire : 1");
					int utiliser = sc.nextInt();
					/*---------------------------------------------------------------------------------------------------------------------------*/
					if (utiliser == 0) { // UTILISER RATION
						if (!p.isMangerRation() && p.getNbTourMangerRation() == 0) {
							p.setMangerRation(true);
							p.getSac().remove(new Ration());
							p.setPa(6);
							System.out.println("Ration utilisé!");
						} else
							System.out.println("Vous avez déjà utiliser une ration aujourd'hui!");
					} 
				} else
					System.out.println("Aucun objet à utiliser!");
				return; // sinon je vais tout le temps demander s'il veut utiliser un objet dans son sac
			});
		} else 
			System.out.println("Votre sac est vide!");
	}
	
	public void testConsommationItem(Player p) {
		// s'il a récupérer la gourde au puit alors il doit attendre 12 tours avant de pouvoir en récupérer une
		if (p.isRecupGourde() && p.getNbTourRecupGourde() < 12) {
			p.setNbTourRecupGourde(p.getNbTourRecupGourde()+1);
		} else {
			p.setRecupGourde(false);
			p.setNbTourRecupGourde(0);
		}
		
		// s'il a consommé une gourde il doit attendre 12 tours avant de pouvoir en reconsommer une
		if (p.isConsommeGourde() && p.getNbTourConsommeGourde() < 12) {
			p.setNbTourConsommeGourde(p.getNbTourConsommeGourde()+1);
		} else {
			p.setConsommeGourde(false);
			p.setNbTourConsommeGourde(0);
		}
		
		// s'il a mangé une ration il doit attendre 12 tours avant de pouvoir en remanger une
		if (p.isMangerRation() && p.getNbTourMangerRation() < 12) {
			p.setNbTourMangerRation(p.getNbTourMangerRation()+1);
		} else {
			p.setMangerRation(false);
			p.setNbTourMangerRation(0);
		}
	}
}
