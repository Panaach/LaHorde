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

			while (code != 1 || code > 2 || code > 3 || code > 9) {
				@SuppressWarnings("resource")
				Scanner sc = new Scanner(System.in);
				System.out.println("\nQue Voulez vous faire?\n"
						+ "Sortir de la ville : 1\n"
						+ "Aller à la banque : 2\n"
						+ "Aller au puit : 3\n"
						+ "Passer son tour : 9");

				code = sc.nextInt();	
			}	
				
			hdv.actionDansLaVille(p, code, grilleDeJeu);
						
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
