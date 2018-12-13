package horde;

import java.util.*;

public class TableDeJeu {

	public static void main(String[] args) {
		
		Grille grille = new Grille();
		HotelDeVille hdv = new HotelDeVille("L", 13);
		int nbPlayer = 2;
		LinkedList<Player> listPlayer = new LinkedList<>();

		//Création de la grille de jeu
		LinkedList<Case> grilleDeJeu = grille.createGrille();

		// Récupération de l'hotel de ville depuis la grille
		//hdv = (HotelDeVille) grilleDeJeu.get(Grille.numeroCaseDansLaListe("L", 13));
		
		// création de la banque dans la ville
		hdv.createBanque();
		
		// création du puits
		hdv.createPuits();
		
		int code = -1;
		
		// Création des joueurs
		for (int i = 0; i < nbPlayer; i++) {
			Scanner sc = new Scanner(System.in);
			System.out.println("Pseudo du joueur " + i + " :");
			String str = sc.nextLine();

			Player p = new Player(str/*, i*/);
			listPlayer.add(p);
		}
		
		while (listPlayer.size() != 1) {
			for (int i = 0 ; i < listPlayer.size(); i++) {
				Player p = listPlayer.get(i);
				System.out.println("**********************");
				System.out.println("C'est à " + listPlayer.get(i).getPseudo() + " de jouer!");
				System.out.println("**********************");
				
				//System.out.println(p.getAbscisse() + " " + p.getOrdonne());
		
				System.out.println(listPlayer.get(i).getSac() + "");
				// Cheat
				int numCase = Grille.numeroCaseDansLaListe("M", 13);
				grilleDeJeu.get(numCase).setNbPlanche(5);
				grilleDeJeu.get(numCase).setNbMetal(5);
				grilleDeJeu.get(numCase).setNbZombies(0);
				//****************************************************
				
				if (hdv.enVille(p))
					hdv.actionDansLaVille(p, grilleDeJeu);			
				else
					hdv.actionDehors(p, grilleDeJeu);
				
				// méthode de test pour savoir s'il a consommer une ration/gourde ou récupérer une gourde
				p.testConsommationItem(p);
				
				//System.out.println("Taille du sac "+p.getSac().size());
							
				//*************************//
				/*Player.avancerDroite(listPlayer.get(i));
				//System.out.println(listPlayer.get(i).getPa()+"/6 PA "+ listPlayer.get(i).getAbscisse());
				
				int numCase = Grille.numeroCaseDansLaListe(p.getAbscisse(), p.getOrdonne());
		
				grilleDeJeu.get(numCase).setNbPlanche(11);
				p.fouiller(p, grilleDeJeu);
				//p.getSac().forEach((temp) -> {System.out.println(temp.getClass());});
				Player.avancerGauche(listPlayer.get(i));*/
			}
		}
		
		//grille.affiche(ok);
	}

}
