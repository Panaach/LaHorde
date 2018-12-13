package horde;

import java.util.LinkedList;
import java.util.Scanner;

//@SuppressWarnings("unused")
public class GestionChantier {
	// Constructeur
	public GestionChantier() {}
	
	// Mur d'enceinte
	private int murPlanche = 20;
	private int murMetal = 5;
	private int murPA = 10;
	
	// Fil barbelés
	private int filPlanche = 20;
	private int filMetal = 30;
	private int filPA = 20;
	
	// Fosses à zombies 
	private int fossePlanche = 50;
	private int fosseMetal = 25;
	private int fossePA = 30;
	
	// Mine autour de la ville
	private int minePlanche = 10;
	private int mineMetal = 50;
	private int minePA = 30;
	
	// Porte blindées
	private int portePlanche = 50;
	private int porteMetal = 50;
	private int portePA = 40;
	
	// Miradors avec mitrailleuse auto
	private int miradorPlanche = 75;
	private int miradorMetal = 75;
	private int miradorPA = 50;
	
	// Abris anti-atomique
	private int abrisPlanche = 100;
	private int abrisMetal = 200;
	private int abrisPA = 60;
	
	public void gestionChantier(LinkedList<Case> grilleDeJeu) {
		
		//HotelDeVille hdv = (HotelDeVille) grilleDeJeu.get(Grille.numeroCaseDansLaListe("L", 13));
		HotelDeVille hdv = new HotelDeVille("L", 13);
		
		
		Scanner sc = new Scanner(System.in);
		System.out.println("Que voulez-vous contruire?" + "					Les resourses actuelles sont de " + hdv.getBanque().get(0).size() + " planches et " + hdv.getBanque().get(1).size() + "métals.\n"
				+ "Mur d'enceinte (20P et 5M et 10 PA) : 1\n"
				+ "Fil barbelés (20P et 30M et 20 PA) : 2\n"
				+ "Fosse à zombies (50P et 25M et 30 PA) : 3\n"
				+ "Mine autour de la ville (10P et 50M et 30 PA) : 4\n"
				+ "Porte blindées (50P et 50M et 40 PA) : 5\n"
				+ "Miradors avec mitrailleuse automatique (75P et 75M et 50 PA) : 6\n"
				+ "Abris anti-atomique (100P et 200M et 60 PA) : 7\n"
				+ "Ne rien faire : 9");
		int code = sc.nextInt();
		// s'il y a 10 Pa de donné alors je vais checké a la banque s'il y a assez et je mets les variables à 0 pour dire que j'ai construit
		switch (code)
		{
		case 1 :			
			
			break;
		case 2 :
					
			break;
		case 3 :
			
			break;
		case 4 :
			
			break;
		case 5 :
			
			break;
		case 6 :
			
			break;
		case 7 :
			
			break;
		case 9 :
			
			break;
		}
		
	}
}
