package horde;

import java.util.*;

public class HotelDeVille extends Case{
	// Toutes les interactions qu'il sont possibles de faire dans l'hdv
	// modification des setters avec les collections pour ajouter des objects dans ces collections
	
	private LinkedList<Integer> puits = new LinkedList<>();
	private ArrayList<ArrayList<ObjetJeu>> banque = new ArrayList<>();
	private static boolean grandePorte;
	private int defense = 20;
	
	public HotelDeVille(String abscisse, int ordonne) {
		super(abscisse, ordonne);
		this.setGrandePorte(false);
	}

	public static boolean isGrandePorte() {
		return grandePorte;
	}

	public void setGrandePorte(boolean grandePorte) {
		this.grandePorte = grandePorte;
	}

	public int getDefense() {
		return defense;
	}

	public void setDefense(int defense) {
		this.defense = defense;
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
		ArrayList<ObjetJeu> stockeRation = new ArrayList<>(); // ID 2
		
		for (int i = 0; i < 50; i++) {
			stockeRation.add(new Ration());
		}
		
		getBanque().add(stockePlanche);
		getBanque().add(stockeMetal);
		getBanque().add(stockeRation);
	}
	
	public void actionDansLaVille(Player p, LinkedList<Case> grilleDeJeu) {
		int code = -1;
		Scanner sc = new Scanner(System.in);
		System.out.println("\nQue Voulez vous faire?\n"
				+ "Sortir de la ville (se déplacer) : 1\n"
				+ "Aller à la banque : 2\n"
				+ "Aller au puit : 3\n"
				+ "Utiliser un objet : 4\n"
				+ "Aller au chantier : 5\n"
				+ "Passer son tour : 9");

		code = sc.nextInt();	
		
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
				if (id == 0 && p.getPa()>0) {
					setGrandePorte(true);
					p.setPa(p.getPa()-1);
					System.out.println("Vous avez ouvert la porte!");
				} else if (id == 1) {
					actionDansLaVille(p, grilleDeJeu);
				} else
					System.out.println("Vous ne possédez pas assez de PA!");
				// Une fois la porte ouverte alors le joueur peut exécuter des actions dehors
				actionDehors(p, grilleDeJeu);
			}
			break;
			/* ---------------------------------------------------------------------------------------------->*/
		case 2 : // BANQUE
			sc = new Scanner(System.in);
			System.out.println("Que voulez-vous faire à la banque?\n"
					+ "Stocker les items : 0\n"
					+ "Afficher les items : 1\n"
					+ "Récupérer une ration : 2\n"
					+ "Ne rien faire : 9");
			int id = sc.nextInt();
			
				switch (id)
				{
				case 0 :
					if (!p.getSac().isEmpty()) {
						p.getSac().forEach((temp) -> {
							// ObjetJeu objet = temp;
							// getId obtient le numéro (0 pl, 1 met, 2 gourde) du "tableau"  en fonction de l'objet
							// j'ajoute donc l'objet dans le tableau correspondant
							if (ObjetJeu.getId(temp) != 3) // si ce n'est pas une gourde alors
								getBanque().get(ObjetJeu.getId(temp)).add(temp);
					//tb de la banque     num du tb				ajout de l'objet
						});
						p.getSac().clear();
					} else 
						System.out.println("Votre sac est vide!");
					break;
				case 1 :
					System.out.println(getBanque().get(0).size() + " planche(s)");
					System.out.println(getBanque().get(1).size() + " métal(s)");
					System.out.println(getBanque().get(2).size() + " ration(s)");
					break;
				case 2 :
					if (getBanque().get(2).size()>0) {  
						if (p.getSac().size() < 10) {
							p.getSac().add(new Ration());
							getBanque().get(2).remove(new Ration());
							System.out.println("Ration obtenue!");
						} else 
							System.out.println("Vous n'avez pas de place dans votre sac pour une ration!");
					} else
						System.out.println("Il n'y a plus de rations!");
					break;
				case 9 :
					break;
				
				}
				actionDansLaVille(p, grilleDeJeu);
			break;
			//****************************************************************************************************
		case 3 : // PUITS
			if (getPuits().size()>0) {
				System.out.println(p.getSac().size());
				if (!p.isRecupGourde()) {
					if (p.getSac().size() < 10) {
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
			break;
			
		case 4 : // UTILISER UN OBJET
			System.out.println("TEST");
			p.utiliserUnObjet(p);
			break;
			
		case 5 : // CHANTIER
			GestionChantier gestion = new GestionChantier();
			gestion.gestionChantier(grilleDeJeu);
			break;
			
		case 9 :
			System.out.println("Tour passé!");
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
					+ "Utiliser un objet : 4\n"
					+ "Passer son tour : 9");
			code = sc.nextInt();
			
			switch (code)
			{
			case 0 :
				Player.avancerHaut(p);
				p.actionPossibleDuJoeur(p, grilleDeJeu);
				break;
			case 1 :
				Player.avancerDroite(p);
				p.actionPossibleDuJoeur(p, grilleDeJeu);
				break;
			case 2 :
				Player.avancerBas(p);
				p.actionPossibleDuJoeur(p, grilleDeJeu);
				break;
			case 3 :
				Player.avancerGauche(p);
				p.actionPossibleDuJoeur(p, grilleDeJeu);
				break;
			case 4 :
				p.utiliserUnObjet(p);
				break;
			case 9 :
				System.out.println("Tour passé!");
				break;
			}
			
			
		}
	}
	
}
