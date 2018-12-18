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
		
		// instance de la classe 
		VagueZombie vague = new VagueZombie();

		// Récupération de l'hotel de ville depuis la grille
		//hdv = (HotelDeVille) grilleDeJeu.get(Grille.numeroCaseDansLaListe("L", 13));
		
		// création de la banque dans la ville
		hdv.createBanque();
		
		hdv.setDefense(20);
		
		int code = -1;
		
		// nombre de tour dans le jeu
		int nbTour = 1;
		
		// MENU
		/*System.out.println("Bienvenue dans horde!");
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.print("Lancement de la partie");
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.print(".");
		
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.print(".");
		
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.print(".\n\n");
		
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}*/
		// FIN MENU
		
		// Création des joueurs
		for (int i = 0; i < nbPlayer; i++) {
			Scanner sc = new Scanner(System.in);
			System.out.println("Pseudo du joueur " + i + " :");
			String str = sc.nextLine();

			Player p = new Player(str/*, i*/);
			listPlayer.add(p);
		}
		
		// Cheat
		int numCase = Grille.numeroCaseDansLaListe("M", 13);
		for (int j = 0; j<540; j++) {
			hdv.getBanque().get(0).add(new Planche());
			hdv.getBanque().get(1).add(new Metal());					
		}
		//listPlayer.get(0).setPa(6150);
		grilleDeJeu.get(numCase).setNbPlanche(5);
		grilleDeJeu.get(numCase).setNbMetal(5);
		grilleDeJeu.get(numCase).setNbZombies(0);
		grilleDeJeu.get(Grille.numeroCaseDansLaListe("M", 13)).setNbPlanche(25);;

		listPlayer.get(0).setPv(10);
		listPlayer.get(0).getSac().add(new Planche());
		listPlayer.get(0).getSac().add(new Metal());
		listPlayer.get(0).getSac().add(new Boisson());
		//****************************************************
		
		Talkie t = new Talkie();
		Case[][] grilleCase = t.createGrille(grilleDeJeu);
		
		while (listPlayer.size() > 1) {
			System.out.println("\n***Les joueurs sont actuellement au tour " + nbTour + "!***\n");	
			
			for (int i = 0 ; i < listPlayer.size(); i++) {
				

				//System.out.println("\nPSEUDO DU SAC " + listPlayer.get(i).getSac().size());
				
				if (listPlayer.get(i).hasBuBoisson())
					listPlayer.get(i).setTourBoisson(listPlayer.get(i).getTourBoisson() + 1);
				
				if (listPlayer.get(i).hasBuBoisson() && listPlayer.get(i).getTourBoisson() >= 3) {
					listPlayer.get(i).setPv(listPlayer.get(i).getPv() - 5);
					System.out.println("Vous venez de perdre 5 PV à cause de la boisson énergisante!\n"
							+ "Il vous reste " + listPlayer.get(i).getPv() + " PV!");
				}
				
				if (listPlayer.get(i).getPv() > 0) {
					// TOUTE LES INFOS QUE JE VEUX SAVOIR
					/*System.out.println("NB planches " + hdv.getBanque().get(0).size() +
							" NB metals " + hdv.getBanque().get(1).size());	*/				
					
					
					Player p = listPlayer.get(i);
					System.out.println("**********************");
					System.out.println("C'est à " + listPlayer.get(i).getPseudo() + " de jouer!");
					System.out.println("**********************");
					
					//System.out.println(p.getAbscisse() + " " + p.getOrdonne());
			
					//System.out.println("Sac du joueur "+ listPlayer.get(i).getPseudo() + " " +listPlayer.get(i).getSac());

					if (hdv.enVille(p))
						hdv.actionDansLaVille(p, grilleDeJeu, grilleCase);			
					else
						hdv.actionDehors(p, grilleDeJeu, grilleCase);
					
					// méthode de test pour savoir s'il a consommer une ration/gourde ou récupérer une gourde
					p.testConsommationItem(p);
					
					if (p.getPv() <= 0) {
						System.out.println("Le joueur " + p.getPseudo() + " est mort!");
						listPlayer.remove(i);
					}
					
					System.out.println("\n\n");
				} else {
					System.out.println("Le joueur " + listPlayer.get(i).getPseudo() + " est mort de blessure!");
					listPlayer.remove(i);
				}
			}
			
			// ATTAQUE DES ZOMBIES
			// condition : s'il doit y avoir une attaque de zombies
			if (vague.attaqueZombie(nbTour)) {
					
				System.out.println("L'attaque des zombies est en cour!");
				
				vague.setMaxZombie(vague.getMaxZombie() + 10);
				vague.setMinZombie(vague.getMinZombie() + 10);
				
				
				if(HotelDeVille.isGrandePorte()) { // si la porte est ouverte alors la moiti" des joueurs est mort
					
					System.out.println("La porte est ouverte!");
					
					vague.tueJoueur(listPlayer);
					
				} else { // la porte est fermé donc je regarde le nombre de zombie qui attaque
					
					int nbZombie = vague.getMinZombie() + (int) (Math.random() * ((vague.getMaxZombie() - vague.getMinZombie()) + 1));
					
					if (nbZombie >= hdv.getDefense()) {
						vague.tueJoueur(listPlayer);
					} else {
						System.out.println("Les zombies n'ont pas réussi à passer les défenses!");
					}
				}
			}
			
			nbTour += 1;
		}
		
		System.out.println("Bravo " + listPlayer.get(0).getPseudo() + "! Vous êtes le dernier survivant et donc le gagnant!");
		
		//grille.affiche(ok);
	}

}
