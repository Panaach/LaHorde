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
		ArrayList<ObjetJeu> stockePlanche = new ArrayList<>();
		ArrayList<ObjetJeu> stockeMetal = new ArrayList<>();
		
		getBanque().add(stockePlanche);
		getBanque().add(stockeMetal);
	}
	
	/*System.out.println("Que Voulez vous faire?\n"
			+ "Sortir de la ville : 1\n"
			+ "Aller à la banque : 2\n"
			+ "Aller au puit : 3");*/
	
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
				} else 
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
						+ "Ne rien faire = 2");
				int id = sc.nextInt();
				
				if (id == 0) {
					p.getSac().forEach((temp) -> {
						// ObjetJeu objet = temp;
						getBanque().get(temp.getId(temp)).add(temp);
						p.getSac().remove(temp);
					});
				} else if (id == 1) {
					for (int i = 0; i < getBanque().size(); i++) {
						System.out.println(getBanque().get(i).size() + " Planches");
					}
				}
			}
			actionDansLaVille(p, grilleDeJeu);
		case 9 :
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
			

			System.out.println("-------------->"+p.getAbscisse()+p.getOrdonne());
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
			
			// position du joueur apres s'être déplacer
			System.out.println("-------------->"+p.getAbscisse()+p.getOrdonne());
			// si le joueur n'est pas en ville il peut fouiller la case
			System.out.println(enVille(p));
			
			if (!enVille(p)) {
				caseAct = grilleDeJeu.get(Grille.numeroCaseDansLaListe(p.getAbscisse(), p.getOrdonne()));
				System.out.println("\n" + caseAct.getNbZombies() + " zombies dans cette case!");
				
				if (caseAct.getNbZombies()>0) {
					System.out.println("Que voulez-vous faire dans cette case?\n"
							+ "Fouiller la case : 0\n"
							+ "Tuer un zombie : 1\n"
							+ "Ne rien faire : 2");
				} else {
					System.out.println("\nQue voulez-vous faire dans cette case?\n"
							+ "Fouiller la case : 0\n"
							+ "Ne rien faire : 2");
				}
				code = sc.nextInt();
				
				if (code == 0) {
					p.fouiller(p, grilleDeJeu);
				} else if (code == 1) {
					p.tuerUnZombie(p, grilleDeJeu);
					System.out.println("\n" + caseAct.getNbZombies() + " zombies dans cette case!");
				}
	/************************ICI JE PEUX TUER DES ZOMBIES A CHANGER***********************************/
				
				if (caseAct.getNbZombies()>p.getPa()) {
					System.out.println("\nTrop de zombies vous ne pouvez plus vous déplacer!");
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
