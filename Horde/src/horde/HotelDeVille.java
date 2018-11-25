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
	
	public void createPuits() {
		for (int i = 0; i < 150; i++) {
			this.getPuits().add(1);
		}
	}
	
	/*System.out.println("Que Voulez vous faire?\n"
			+ "Sortir de la ville : 1\n"
			+ "Aller à la banque : 2\n"
			+ "Aller au puit : 3");*/
	
	public void actionDansLaVille(Player p, int id, LinkedList<Case> grilleDeJeu) {
		int code = -1;
		switch (id)
		{
			case 1 : // sortir de la ville
				if (isGrandePorte() == true) {
					// Le joueur va exécuter des actions dehors
					actionDehors(p, grilleDeJeu);
				} else {
					while (code != 0 && code != 1) {
						Scanner sc = new Scanner(System.in);
						System.out.println("Voulez-vous ouvrir la porte?\n"
								+ "Oui = 0\n"
								+ "Non = 1");
						code = sc.nextInt();
					}
					// Si l'on veut ouvrir la porte alors on perd 1 PA et on met la varaible à vraie
					if (code == 0 && p.getPa()>0) {
						setGrandePorte(true);
						p.setPa(p.getPa()-1);
						System.out.println("Vous avez ouvert la porte!");
					} else 
						System.out.println("Vousne possédez pas assez de PA!");
					// Une fois la porte ouverte alors le joueur peut exécuter des actions dehors
					actionDehors(p, grilleDeJeu);
				}
				break;
			case 9 :
				break;
			
		}
	}
	
	public void actionDehors(Player p, LinkedList<Case> grilleDeJeu) {
		int code = -1;
		Case caseAct = grilleDeJeu.get(Grille.numeroCaseDansLaListe(p.getAbscisse(), p.getOrdonne()));;
		while (true) {
				Scanner sc = new Scanner(System.in);
				System.out.println("Où souhaitez-vous vous déplacer?\n"
						+ "Nord : 0\n"
						+ "Est : 1\n"
						+ "Sud : 2\n"
						+ "Ouest : 3\n"
						+ "Passer son tour : 9");
				code = sc.nextInt();

				if (code == 9)
					break;
				
				switch (code)
				{
				case 0 :
					Player.avancerHaut(p);
					break;
				case 1 :
					Player.avancerDroite(p);
					break;
				case 2 :
					Player.avancerBas(p);
					break;
				case 3 :
					Player.avancerGauche(p);
					break;
				}
				caseAct = grilleDeJeu.get(Grille.numeroCaseDansLaListe(p.getAbscisse(), p.getOrdonne()));
				System.out.println("\n" + caseAct.getNbZombies() + " zombies dans cette case!");
				if (caseAct.getNbZombies()>0) 
					System.out.println("Que voulez-vous faire dans cette case?\n"
							+ "Fouiller la case : 0\n"
							+ "Tuer un zombie : 1\n"
							+ "Ne rien faire : 2");
				else 
					System.out.println("\nQue voulez-vous faire dans cette case?\n"
							+ "Fouiller la case : 0\n"
							+ "Ne rien faire : 2");
				code = sc.nextInt();
				if (code == 0) {
					p.fouiller(p, grilleDeJeu);
				} else if (code == 1) {
					p.tuerUnZombie(p, grilleDeJeu);
					System.out.println("\n" + caseAct.getNbZombies() + " zombies dans cette case!");
				}

			if (caseAct.getNbZombies()>p.getPa()) {
				System.out.println("\nTrop de zombies vous ne pouvez plus vous déplacer!");
				break;
			}
		}
	}
	
}
