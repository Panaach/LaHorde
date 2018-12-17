package horde;

import java.util.LinkedList;

public class Talkie {
	
	// méthode pour mettre a jour la grille et la créer
	public Case[][] createGrille(LinkedList<Case> grille) {
		Case[][] grilleDeJeu = new Case[25][25];
		LinkedList<Case> temp = grille;
		
		int compt = 0;
		for (int i = 0; i < 25; i++) {
			for (int j = 0; j < 25; j++) {
				grilleDeJeu[i][j] = temp.get(compt);
				compt += 1;
			}
		}
		
		return grilleDeJeu;
	}
	
	// méthode qui va afficher la map en fonction de la grille mis en paramètre
	public Case[][] afficheMap(Case[][] grille) {
		// LETTRE DES ABSCISSES
		System.out.print("            ");
		for (int i = 0; i < 25; i++) {
			System.out.print(Grille.absAlphabet.values()[i] + "          ");
		}
		System.out.print("\n");
		
		for (int k = 0; k < 25; k++) {
			// NOMBRE DES ORDONNEES
			if (k > 8) 
				System.out.print(k+1 + "    ");
			else 
				System.out.print(k+1 + "     ");
			
			for (int j = 0; j < 25; j++) {
				if (k == 12 && j == 11) {
					System.out.print("|   VILLE  ");
				} else if (!grille[k][j].isAffCase()) {
					int test;
					if (grille[k][j].hasBoisson())
						test = 1;
					else 
						test = 0;
					System.out.print("| " + Grille.absAlphabet.values()[j] + " P" + grille[k][j].getNbPlanche() + "M" + grille[k][j].getNbMetal() + "B" + test + " ");
				} else {
					System.out.print("| " + Grille.absAlphabet.values()[j] + " ****** ");
				}
			}
			System.out.println("|");
		}
		
		return grille;
	}
	
	/*public void afficherMap(LinkedList<Case> grille) {
		System.out.print("          ");
		for (int i = 0; i < 25; i++) {
			System.out.print(Grille.absAlphabet.values()[i] + "         ");
			if (i == 24)
				System.out.print("\n");
				
		}
		
		
		int test;
		int compteur = 0;
		
		for (int j = 0; j < 25; j++) {
			if (j > 9) 
				System.out.print(j + "    ");
			else 
				System.out.print(j + "     ");
				
			for (int k = 0; k < 25 ; k++) {
				
				if (grille.get(k).getAbscisse().equals("L") && grille.get(k).getOrdonne() == 13) {
					grille.get(Grille.numeroCaseDansLaListe("L", 13)).setAffCase(true);
					System.out.println("| *VILLE* |");
				} else {
					
					if (grille.get(compteur).isAffCase()) {
						if (grille.get(compteur).hasBoisson())
							test = 1;
						else 
							test = 0;
						
						System.out.print("| P"+grille.get(compteur).getNbPlanche()+"M"+grille.get(compteur).getNbMetal()+"B"+test+" |");
					} else {
						System.out.print("| ******* |");
					}
					
				}
				
				compteur += 1;
			}
			System.out.print("\n");
		}
		System.out.print("\n");
	}*/

}
