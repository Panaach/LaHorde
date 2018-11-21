package horde;

import java.util.*;

public class Grille {
	// 25*25
	// hdv au mileu
	// 1000 planches 500 plaques de métal, 100 boissons énergisantes
	
	public enum absAlphabet {
		  A,B,C,D,E,F,G,H,I,J,K,L,M,N,O,P,Q,R,S,T,U,V,W,X,Y;
	}
	
	LinkedList<Case> grille = new LinkedList<>();
	
	public ArrayList<Integer> tabZombies() {
		ArrayList<Integer> nbZombies = new ArrayList<>();
		
		for (int i = 0; i < 3; i++) {
			nbZombies.add(0);
		}
		
		for (int j = 1; j < 8; j++) {
			nbZombies.add(j);
		}
		
		return nbZombies;
	}
	
	public LinkedList<Case> createGrille() {
		int nbPlanches = 1000;
		int nbMetals = 500;		
		ArrayList<Integer> tabZombies = tabZombies();
		
		for (int i = 0; i < 25; i++) { // Abscisse LETTRE
			for (int j = 1; j < 26; j++) { // Ordonnée CHIFFRE
				int nbRandomZombies = (int) (Math.random() * tabZombies.size());
				
				if (i == 12 && j == 13)
					grille.add(new HotelDeVille(String.valueOf(absAlphabet.values()[i]), j));
				else				
					grille.add(new Case(String.valueOf(absAlphabet.values()[i]), j, tabZombies.get(nbRandomZombies), 0, 0));
			}
		}
		
		while (nbPlanches > 0) {

			//int nbRandomPlanches = (int) (Math.random() * 20);
			int nbPlanchesCase = 20;
			
			int nbRandomCase = (int) (Math.random() * grille.size());
			
			while(nbRandomCase == grille.size()/2) {
				nbRandomCase = (int) (Math.random() * grille.size());
			}
			
			grille.get(nbRandomCase).setNbPlanches(nbPlanchesCase);
			
			nbPlanches = nbPlanches - nbPlanchesCase;
			
			//System.out.println("pl " + nbPlanches);
		}
		
		while (nbMetals > 0) {

			//int nbRandomMetals = (int) (Math.random() * 10);
			int nbMetalsCase= 10;
			
			int nbRandomCase = (int) (Math.random() * grille.size());
			
			while(nbRandomCase == grille.size()/2) {
				nbRandomCase = (int) (Math.random() * grille.size());
			}

			grille.get(nbRandomCase).setNbMetals(nbMetalsCase);

			nbMetals = nbMetals - nbMetalsCase;
			
			//System.out.println("met "+ nbMetals);
		}
		
		return grille;
	}

	public void affiche(LinkedList<Case> grille) {
		for(int i=0; i<grille.size();i++) {		
			System.out.println(" met "+grille.get(i).getNbMetals() + " pl "+grille.get(i).getNbPlanches() + " zomb "+grille.get(i).getNbZombies());
		}
	}
}
