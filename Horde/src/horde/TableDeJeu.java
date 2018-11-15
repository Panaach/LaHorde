package horde;

import java.util.*;

public class TableDeJeu {

	public static void main(String[] args) {
		
		Grille grille = new Grille();
		
		int nbPlayer = 1;
		LinkedList<Player> listPlayer = new LinkedList<>();
		
		// Création des joueurs
		for (int i = 0; i < nbPlayer; i++) {
			Scanner sc = new Scanner(System.in);
			System.out.println("Pseudo du joueur " + i + " :");
			String str = sc.nextLine();

			Player p = new Player(str, i);
			listPlayer.add(p);
		}

		LinkedList<Case> ok = grille.createGrille();
		for (int i = 0 ; i < listPlayer.size(); i++) {
			Player.avancerDroite(listPlayer.get(i));;
		}
		
		//grille.affiche(ok);
	}

}
