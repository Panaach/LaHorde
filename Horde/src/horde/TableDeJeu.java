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
		
		int code = -1;
		
		// Création des joueurs
		for (int i = 0; i < nbPlayer; i++) {
			@SuppressWarnings("resource")
			Scanner sc = new Scanner(System.in);
			System.out.println("Pseudo du joueur " + i + " :");
			String str = sc.nextLine();

			Player p = new Player(str, i);
			listPlayer.add(p);
		}
		
		for (int i = 0 ; i < listPlayer.size(); i++) {
			Player p = listPlayer.get(i);
			System.out.println("C'est à " + listPlayer.get(i).getPseudo() + " de jouer!");
			
			//System.out.println(p.getAbscisse() + " " + p.getOrdonne());

			// Cheat pour mettre 11 planches dans la case d'à côté
			int numCase = Grille.numeroCaseDansLaListe("M", 13);
			grilleDeJeu.get(numCase).setNbPlanche(11);
			//****************************************************
			
			if (hdv.enVille(p))
				hdv.actionDansLaVille(p, grilleDeJeu);			
			else
				hdv.actionDehors(p, grilleDeJeu);
						
			//*************************//
			/*Player.avancerDroite(listPlayer.get(i));
			//System.out.println(listPlayer.get(i).getPa()+"/6 PA "+ listPlayer.get(i).getAbscisse());
			
			int numCase = Grille.numeroCaseDansLaListe(p.getAbscisse(), p.getOrdonne());

			grilleDeJeu.get(numCase).setNbPlanche(11);
			p.fouiller(p, grilleDeJeu);
			//p.getSac().forEach((temp) -> {System.out.println(temp.getClass());});
			Player.avancerGauche(listPlayer.get(i));*/
		}
		
		//grille.affiche(ok);
	}

}
