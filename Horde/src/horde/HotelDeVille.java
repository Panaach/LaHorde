package horde;

import java.util.*;

public class HotelDeVille extends Case{
	// Toutes les interactions qu'il sont possibles de faire dans l'hdv
	// modification des setters avec les collections pour ajouter des objects dans ces collections
	
	private ArrayList<ArrayList<ObjetJeu>> banque = new ArrayList<>();
	private static boolean grandePorte;
	private int defense;
	GestionChantier gestion = new GestionChantier();
	
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
	
	// ********************************************************* //

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
	
	public void actionDansLaVille(Player p, LinkedList<Case> grilleDeJeu, Case[][] grilleCase) {
		int code = -1;
		Scanner sc = new Scanner(System.in);
		System.out.println("\nQue Voulez vous faire?\n"
				+ "Sortir de la ville (se d�placer) : 1\n"
				+ "Aller � la banque : 2\n"
				+ "Aller au puit : 3\n"
				+ "Utiliser un objet : 4\n"
				+ "Aller au chantier : 5\n"
				+ "Passer son tour : 9");

		code = sc.nextInt();	
		
		switch (code)
		{
		case 1 : // sortir de la ville
			if (isGrandePorte() == true) {
				// Le joueur va ex�cuter des actions dehors
				actionDehors(p, grilleDeJeu, grilleCase);
			} else {
				int id = -1;
				while (id != 0 && id != 1) {
					sc = new Scanner(System.in);
					System.out.println("Voulez-vous ouvrir la porte?\n"
							+ "Oui = 0\n"
							+ "Non = 1");
					id = sc.nextInt();
				}
				// Si l'on veut ouvrir la porte alors on perd 1 PA et on met la varaible � vraie
				if (id == 0 && p.getPa()>0) {
					setGrandePorte(true);
					p.setPa(p.getPa()-1);
					System.out.println("Vous avez ouvert la porte!");
				} else if (id == 1) {
					actionDansLaVille(p, grilleDeJeu, grilleCase);
				} else
					System.out.println("Vous ne poss�dez pas assez de PA!");
				// Une fois la porte ouverte alors le joueur peut ex�cuter des actions dehors
				actionDehors(p, grilleDeJeu, grilleCase);
			}
			break;
			/* ---------------------------------------------------------------------------------------------->*/
		case 2 : // BANQUE

			System.out.println("\nPSEUDO DU SAC " + p.getSac().size());
			sc = new Scanner(System.in);
			System.out.println("Que voulez-vous faire � la banque?\n"
					+ "Stocker les items : 0\n"
					+ "Afficher les items : 1\n"
					+ "R�cup�rer une ration : 2\n"
					+ "Ne rien faire : 9");
			int id = sc.nextInt();
			
				switch (id)
				{
				case 0 :
					System.out.println("\nSac du joeuur" + p.getSac().size());
					if (!p.getSac().isEmpty()) {
						
						for (int i = 0; i < p.getSac().size(); i++) {
							ObjetJeu temp = p.getSac().get(i);
							
							if (ObjetJeu.getId(temp) != 3 && ObjetJeu.getId(temp) != 4) {// si ce n'est pas une boisson / une gourde alors
								getBanque().get(ObjetJeu.getId(temp)).add(temp);
							}
							
							p.getSac().remove(i);
						}

						System.out.println("\nSac du joeuur" + p.getSac().size());
						/*p.getSac().forEach((temp) -> {
							
							// ObjetJeu objet = temp;
							// getId obtient le num�ro (0 pl, 1 met, 2 ration, 3 gourde) du "tableau"  en fonction de l'objet
							// j'ajoute donc l'objet dans le tableau correspondant
							if (ObjetJeu.getId(temp) != 3 && ObjetJeu.getId(temp) != 4) {// si ce n'est pas une boisson / une gourde alors
								getBanque().get(ObjetJeu.getId(temp)).add(temp);
					 //tb de la banque          num du tb		      ajout de l'objet
								p.getSac().remove(temp);
								
							} else if (ObjetJeu.getId(temp) == 2) {
								Scanner ok = new Scanner(System.in);
								System.out.println("Voulez-vous stocker la ration?\n"
										+ "Oui : 1\n"
										+ "Non : 2");
								int reponse = ok.nextInt();
								
								if (reponse == 1) {
									getBanque().get(ObjetJeu.getId(temp)).add(temp);
									p.getSac().remove(temp);									
								}
							}
							 
						});*/
						
					} else 
						System.out.println("Votre sac est vide!");
					break;
				case 1 :
					System.out.println(getBanque().get(0).size() + " planche(s)");
					System.out.println(getBanque().get(1).size() + " m�tal(s)");
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
				actionDansLaVille(p, grilleDeJeu, grilleCase);
			break;
			//****************************************************************************************************
		case 3 : // PUITS
			//System.out.println(getPuits().size());

			boolean hasGourde = false;
			for (int i = 0; i < p.getSac().size(); i++) {
				if (ObjetJeu.getId(p.getSac().get(i)) == 3)
					hasGourde = true;
					
			}
			
			if (!hasGourde) {
				p.getSac().add(new Gourde());
				System.out.println("Gourde obtenue!");				
			} else {
				System.out.println("Vous avez d�j� une gourde dans votre sac!");
			}			
			
			/*if (getPuits() != 0) {
				//System.out.println(p.getSac().size());
				if (!p.isRecupGourde()) {
					if (p.getSac().size() < 10) {
						p.setRecupGourde(true);
						p.getSac().add(new Gourde());
						setPuits(getPuits()-1);
						System.out.println("Gourde obtenue!");
					} else 
						System.out.println("Vous n'avez pas de place dans votre sac pour de l'eau!");
				} else {
					System.out.println("Vous devez attendre 12 tours avant de pouvoir r�cup�rer une autre gourde!");
				}
			} else {
				System.out.println("Le puits est vide!");
			}*/
			// retour dans la ville pour effectuer de nouvelle action
			actionDansLaVille(p, grilleDeJeu, grilleCase);
			break;
			
		case 4 : // UTILISER UN OBJET
			//System.out.println("TEST");
			p.utiliserUnObjet(p);
			actionDansLaVille(p, grilleDeJeu, grilleCase);
			break;
			
		case 5 : // CHANTIER
			setBanque(gestion.gestionChantier(getBanque(), p, grilleDeJeu, defense));
			actionDansLaVille(p, grilleDeJeu, grilleCase);
			
			break;
			
		case 9 :
			System.out.println("Tour pass�!");
			break;			
		}
	}
	
	public void actionDehors(Player p, LinkedList<Case> grilleDeJeu, Case[][] grilleCase) {
		int code = -1;
		

		System.out.println("\nPSEUDO DU SAC " + p.getSac().size());
		
		// Case dans laquelle se trouve le joueur
		//Case caseAct = grilleDeJeu.get(Grille.numeroCaseDansLaListe(p.getAbscisse(), p.getOrdonne()));
		
		boolean action = true;
		
		while (action) {
			
			if (p.getPv() <= 0) {
				System.out.println("Vous avez succomb� � vos blessures! (Vous �tes mort)");
				break;
			}

			System.out.println("\nVotre sac contient : " + p.getSac().size() + " objets!");
			
			//System.out.println("SIZE" + grilleDeJeu.size());
			System.out.println("\nVous �tes actuellement en " + p.getAbscisse() + " " + p.getOrdonne());
			Scanner sc = new Scanner(System.in);
			System.out.println("\nO� souhaitez-vous vous d�placer?\n"
					+ "Nord : 0\n"
					+ "Est : 1\n"
					+ "Sud : 2\n"
					+ "Ouest : 3\n"
					+ "Utiliser un objet : 4\n"
					+ "Afficher le talkie-walkie : 5\n"
					+ "Mettre � jour le talkie-walkie : 6\n"
					+ "Passer son tour : 9");
			code = sc.nextInt();
			
			switch (code)
			{
			case 0 :
				Player.avancerHaut(p);
				p.actionPossibleDuJoeur(p, grilleDeJeu, grilleCase);
				break;
			case 1 :
				Player.avancerDroite(p);
				p.actionPossibleDuJoeur(p, grilleDeJeu, grilleCase);
				break;
			case 2 :
				Player.avancerBas(p);
				p.actionPossibleDuJoeur(p, grilleDeJeu, grilleCase);
				break;
			case 3 :
				Player.avancerGauche(p);
				p.actionPossibleDuJoeur(p, grilleDeJeu, grilleCase);
				break;
			case 4 :
				p.utiliserUnObjet(p);
				break;
			case 5 :
				System.out.println("\nVoici la map � ce tour :");
				Talkie t = new Talkie();
				t.afficheMap(grilleCase);
				break;
			case 6 :				
				Case c = grilleDeJeu.get(Grille.numeroCaseDansLaListe(p.getAbscisse(), p.getOrdonne()));
				
				p.majTalkie(p, grilleCase, c.hasBoisson(), c.getNbPlanche(), c.getNbMetal());
				System.out.println("\nTalkie-walkie mis-�-jour!");
				actionDehors(p, grilleDeJeu, grilleCase);
			case 9 :
				System.out.println("Tour pass�!");
				action = false;
				break;
			}			
		}
	}
	
}
