package horde;

import java.util.*;

public class TableDeJeu {

	public static void main(String[] args) {
		int nbPlayer = 2;
		LinkedList<Player> listPlayer = new LinkedList<>();
		
		// Création des joueurs
		for (int i = 0; i < nbPlayer; i++) {
			Scanner sc = new Scanner(System.in);
			System.out.println("Pseudo du joueur " + i + " :");
			System.out.println("Pseudo du joueur " + i + " :");
			System.out.println("Pseudo du joueur " + i + " :");
			String str = sc.nextLine();

			Player p = new Player(str, i);
			listPlayer.add(p);
		}

	}

}
