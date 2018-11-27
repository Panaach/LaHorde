package horde;

import java.util.*;

public class HotelDeVille extends Case{
	// Toutes les interactions qu'il sont possibles de faire dans l'hdv
	// modification des setters avec les collections pour ajouter des objects dans ces collections
	
	private HashSet maison = new HashSet();
	private LinkedList<Integer> puits = new LinkedList<>();
	private ArrayList<ArrayList<ObjetJeu>> banque = new ArrayList<>();
	private HashSet chantiers = new HashSet();
	private boolean grandePorte;
	
	public HotelDeVille(String abscisse, int ordonne) {
		super(abscisse, ordonne);
		this.setGrandePorte(false);
	}

	public boolean isGrandePorte() {
		return grandePorte;
	}

	public void setGrandePorte(boolean grandePorte) {
		this.grandePorte = grandePorte;
	}

	public ArrayList<ArrayList<ObjetJeu>> getBanque() {
		return banque;
	}

	public void setBanque(ArrayList<ArrayList<ObjetJeu>> banque) {
		this.banque = banque;
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
	
	public boolean enVille(Player p) {
		if (p.getAbscisse().equals("L") && p.getOrdonne() == 13) 
			return true;
		else 
			return false;
	}
	
	public void createBanque() {
		ArrayList<ObjetJeu> stockePlanche = new ArrayList<>(); // ID 0
		ArrayList<ObjetJeu> stockeMetal = new ArrayList<>(); // ID 1
		ArrayList<ObjetJeu> stockeGourde = new ArrayList<>(); // ID 2
		
		getBanque().add(stockePlanche);
		getBanque().add(stockeMetal);
		getBanque().add(stockeGourde);
	}
	
	public void actionDansLaVille(Player p, LinkedList<Case> grilleDeJeu) {
		int code = -1;
		Scanner sc = new Scanner(System.in);
		while (code != 1 && code != 2 && code != 3 && code != 9) {
			System.out.println("\nQue Voulez vous faire?\n"
					+ "Sortir de la ville (se déplacer) : 1\n"
					+ "Aller à la banque : 2\n"
					+ "Aller au puit : 3\n"
					+ "Passer son tour : 9");

			code = sc.nextInt();	
		}
		
		switch (code)
		{
		case 1 : // sortir de la ville
			if (isGrandePorte() == true) {
				// Le joueur va exécuter des actions dehors
				actionDehors(p, grilleDeJeu);
			} else {
				int id = -1;
				while (id != 0 && id != 1) {
					sc = new Scanner(System.in);
					System.out.println("Voulez-vous ouvrir la porte?\n"
							+ "Oui = 0\n"
							+ "Non = 1");
					id = sc.nextInt();
				}
				// Si l'on veut ouvrir la porte alors on perd 1 PA et on met la varaible à vraie
				if (id == 0 || p.getPa()>0) {
					setGrandePorte(true);
					p.setPa(p.getPa()-1);
					System.out.println("Vous avez ouvert la porte!");
				} else if (id == 1)
					actionDansLaVille(p, grilleDeJeu);
				else
					System.out.println("Vous ne possédez pas assez de PA!");
				// Une fois la porte ouverte alors le joueur peut exécuter des actions dehors
				actionDehors(p, grilleDeJeu);
			}
			break;
			/* ---------------------------------------------------------------------------------------------->*/
		case 2 :
			if (p.getSac().size() != 0) {
				sc = new Scanner(System.in);
				System.out.println("Voulez-vous stocker vos items dans la banque?\n"
						+ "Stocker les items = 0\n"
						+ "Afficher les items = 1\n"
						+ "Ne rien faire = 9");
				int id = sc.nextInt();
				
				switch (id)
				{
				case 0 :
					p.getSac().forEach((temp) -> {
						// ObjetJeu objet = temp;
						// getId obtient le numéro (0 pl, 1 met, 2 gourde) du "tableau"  en fonction de l'objet
						// j'ajoute donc l'objet dans le tableau correspondant
						getBanque().get(ObjetJeu.getId(temp)).add(temp);
				//tb de la banque     num du tb				ajout de l'objet
					});
					p.getSac().clear();
					break;
				case 1 :
					System.out.println(getBanque().get(0).size() + " planche(s)");
					System.out.println(getBanque().get(1).size() + " métal(s)");
					System.out.println(getBanque().get(2).size() + " gourde(s)");
					break;
				case 9 :
					break;
				
				} 
			} else {
				System.out.println(getBanque().get(0).size() + " planche(s)");
				System.out.println(getBanque().get(1).size() + " métal(s)");
				System.out.println(getBanque().get(2).size() + " gourde(s)");
			}
			actionDansLaVille(p, grilleDeJeu);
			
		case 3 :
			if (getPuits().size()>0) {
				if (!p.isRecupGourde()) {
					if (p.getSac().size() != 10) {
						p.setRecupGourde(true);
						p.getSac().add(new Gourde());
						getPuits().remove(0);
						System.out.println("Gourde obtenue!");
					} else 
						System.out.println("Vous n'avez pas de place dans votre sac pour de l'eau!");
				} else {
					System.out.println("Vous devez attendre 12 tours avant de pouvoir récupérer une autre gourde!");
				}
			} else {
				System.out.println("Le puits est vide!");
			}
			// retour dans la ville pour effectuer de nouvelle action
			actionDansLaVille(p, grilleDeJeu);
			
		case 9 :
			p.setNbTour(p.getNbTour() + 1);
			break;			
		}
	}
	
	public void actionDehors(Player p, LinkedList<Case> grilleDeJeu) {
		int code = -1;
		
		// Case dans laquelle se trouve le joueur
		Case caseAct = grilleDeJeu.get(Grille.numeroCaseDansLaListe(p.getAbscisse(), p.getOrdonne()));
		while (true) { // TODO a changer
			//System.out.println(p.getAbscisse() + " " + p.getOrdonne());
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
			case 9 :
				p.setNbTour(p.getNbTour() + 1);
				break;
			}
			
			// si le joueur n'est pas en ville alors il peut tuer ou fouiller des cases
			if (!enVille(p)) {
				caseAct = grilleDeJeu.get(Grille.numeroCaseDansLaListe(p.getAbscisse(), p.getOrdonne()));
				System.out.println("\n" + caseAct.getNbZombies() + " zombies dans cette case!");
				
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
				case 0 :
					p.fouiller(p, grilleDeJeu); // FOUILLER UNE CASE
					break;
				case 1 : // UTILISER UN OBJET DANS LE SAC

					p.getSac().forEach((temp) -> {
						// ObjetJeu objet = temp;
						if (ObjetJeu.getId(temp) == 2) {
							System.out.println("Voulez-vous utiliser votre gourde?\n"
									+ "Utiliser : 0\n"
									+ "Ne rien faire : 1");
							int utiliser = sc.nextInt();
							
							if (utiliser == 0) { // GOURDE UTILISER : + 6PA
								p.getSac().remove(temp);
								p.setPa(6);
							}
							return;
						}				
					});
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

			} else { // sinon je suis en ville (je regarde si la porte est ouverte) si oui alors je peut effectuer des actions en ville
				if (isGrandePorte() == true) {
					actionDansLaVille(p, grilleDeJeu);
				} else {
					System.out.println("La porte est fermée, shit happens!");
				}
			}
		}
	}
	
}
