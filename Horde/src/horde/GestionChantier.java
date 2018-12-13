package horde;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Scanner;

public class GestionChantier/* extends HotelDeVille*/{
	// Constructeur
	public GestionChantier() {
        this.setMurPlanche(20);
        this.setMurMetal(5);
        this.setMurPA(10);

        this.setFilPlanche(20);
        this.setFilMetal(30);
        this.setFilPA(20);

        this.setFossePlanche(50);
        this.setFosseMetal(25);
        this.setFossePA(30);

        this.setMinePlanche(10);
        this.setMineMetal(50);
        this.setMinePA(30);

        this.setPortePlanche(50);
        this.setPorteMetal(50);
        this.setPortePA(40);

        this.setMiradorPlanche(75);
        this.setMiradorMetal(75);
        this.setMiradorPA(50);

        this.setAbrisPlanche(100);
        this.setAbrisMetal(200);
        this.setAbrisPA(60);
    }

	// Mur d'enceinte
	private int murPlanche = 20;
	private int murMetal = 5;
	private int murPA = 10;
	
	// Fil barbel�sz
	private int filPlanche = 20;
	private int filMetal = 30;
	private int filPA = 20;
	
	// Fosses � zombies 
	private int fossePlanche = 50;
	private int fosseMetal = 25;
	private int fossePA = 30;
	
	// Mine autour de la ville
	private int minePlanche = 10;
	private int mineMetal = 50;
	private int minePA = 30;
	
	// Porte blind�es
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
	
	public int getMurPlanche() {
		return murPlanche;
	}

	public void setMurPlanche(int murPlanche) {
		this.murPlanche = murPlanche;
	}
	public int getMurMetal() {
		return murMetal;
	}

	public void setMurMetal(int murMetal) {
		this.murMetal = murMetal;
	}

	public int getMurPA() {
		return murPA;
	}

	public void setMurPA(int murPA) {
		this.murPA = murPA;
	}

	public int getFilPlanche() {
		return filPlanche;
	}

	public void setFilPlanche(int filPlanche) {
		this.filPlanche = filPlanche;
	}

	public int getFilMetal() {
		return filMetal;
	}

	public void setFilMetal(int filMetal) {
		this.filMetal = filMetal;
	}

	public int getFilPA() {
		return filPA;
	}

	public void setFilPA(int filPA) {
		this.filPA = filPA;
	}

	public int getFossePlanche() {
		return fossePlanche;
	}

	public void setFossePlanche(int fossePlanche) {
		this.fossePlanche = fossePlanche;
	}

	public int getFosseMetal() {
		return fosseMetal;
	}

	public void setFosseMetal(int fosseMetal) {
		this.fosseMetal = fosseMetal;
	}

	public int getFossePA() {
		return fossePA;
	}

	public void setFossePA(int fossePA) {
		this.fossePA = fossePA;
	}

	public int getMinePlanche() {
		return minePlanche;
	}

	public void setMinePlanche(int minePlanche) {
		this.minePlanche = minePlanche;
	}

	public int getMineMetal() {
		return mineMetal;
	}

	public void setMineMetal(int mineMetal) {
		this.mineMetal = mineMetal;
	}

	public int getMinePA() {
		return minePA;
	}

	public void setMinePA(int minePA) {
		this.minePA = minePA;
	}

	public int getPortePlanche() {
		return portePlanche;
	}

	public void setPortePlanche(int portePlanche) {
		this.portePlanche = portePlanche;
	}

	public int getPorteMetal() {
		return porteMetal;
	}

	public void setPorteMetal(int porteMetal) {
		this.porteMetal = porteMetal;
	}

	public int getPortePA() {
		return portePA;
	}

	public void setPortePA(int portePA) {
		this.portePA = portePA;
	}

	public int getMiradorPlanche() {
		return miradorPlanche;
	}

	public void setMiradorPlanche(int miradorPlanche) {
		this.miradorPlanche = miradorPlanche;
	}

	public int getMiradorMetal() {
		return miradorMetal;
	}

	public void setMiradorMetal(int miradorMetal) {
		this.miradorMetal = miradorMetal;
	}

	public int getMiradorPA() {
		return miradorPA;
	}

	public void setMiradorPA(int miradorPA) {
		this.miradorPA = miradorPA;
	}

	public int getAbrisPlanche() {
		return abrisPlanche;
	}

	public void setAbrisPlanche(int abrisPlanche) {
		this.abrisPlanche = abrisPlanche;
	}

	public int getAbrisMetal() {
		return abrisMetal;
	}

	public void setAbrisMetal(int abrisMetal) {
		this.abrisMetal = abrisMetal;
	}

	public int getAbrisPA() {
		return abrisPA;
	}

	public void setAbrisPA(int abrisPA) {
		this.abrisPA = abrisPA;
	}

	// ----------------------------------------------------------------------------------------------------------------------
	public void gestionChantier(ArrayList<ArrayList<ObjetJeu>> banque, Player p, LinkedList<Case> grilleDeJeu, int defense) {
			
			HotelDeVille hdv = new HotelDeVille("L", 13);
			int stockePlanche = HotelDeVille.getBanque().get(0).size();
			int stockeMetal = HotelDeVille.getBanque().get(1).size();
			
			Scanner sc = new Scanner(System.in);
			System.out.println("Que voulez-vous contruire/finir?" + "						Les resourses actuelles sont de " + stockePlanche + " planches et " + stockeMetal + " m�tals.\n"
					+ "Mur d'enceinte (20P et 5M et 10 PA) : 1\n"
					+ "Fil barbel�s (20P et 30M et 20 PA) : 2\n"
					+ "Fosse � zombies (50P et 25M et 30 PA) : 3\n"
					+ "Mine autour de la ville (10P et 50M et 30 PA) : 4\n"
					+ "Porte blind�es (50P et 50M et 40 PA) : 5\n"
					+ "Miradors avec mitrailleuse automatique (75P et 75M et 50 PA) : 6\n"
					+ "Abris anti-atomique (100P et 200M et 60 PA) : 7\n"
					+ "Ne rien faire : 9");
			int code = sc.nextInt();
			// s'il y a 10 Pa de donn� alors je vais check� a la banque s'il y a assez et je mets les variables � 0 pour dire que j'ai construit
			switch (code)
			{
			case 1 :
				System.out.println("ICICICICICIICIICI " + getMurPlanche());
				if (getMurPlanche() != -1 && getMurMetal() != -1 && banque.get(0).size() >= 20 && banque.get(1).size() >= 5) { // Alors je peux construire mon mur
					System.out.println("Vous venez d'utiliser 20 planches et 5 m�tals pour la r�alisation du mur!");
					// ERREUR ICI
					setMurPlanche(-1);
					setMurMetal(-1);					
					
					for (int i = 0; i < 20; i++) {
						HotelDeVille.getBanque().get(0).remove(0);
					}
					//System.out.println("TAILLE PLANCHES " + HotelDeVille.getBanque().get(0).size());
                                        
					for (int i = 0; i < 5; i++) {
						HotelDeVille.getBanque().get(1).remove(0);
					}
					
					if (p.getPa()>0) {
						int nbPa = -1;
						while (nbPa < 0 || nbPa > p.getPa()) {
							System.out.println("Voulez-vous utiliser des PA pour sa r�alisation?\n"
									+ "Vous disposer de " + p.getPa() + " PA. Combien voulez-vous en utiliser?");
							nbPa = sc.nextInt();
						}
						
						p.setPa(p.getPa() - nbPa);
						setMurPA(getMurPA() - nbPa);						
						
						System.out.println("Vous venez de lancer la construction du mur d'enceinte! Encore " + getMurPA() + " PA pour le finir!");
					}
					
				} else {
					if (getMurPA() > 0) {
						System.out.println("Il reste encore " + getMurPA() + " PA pour finir la construction!");
	
						int nbPa = -1;
						while (nbPa < 0 || nbPa > p.getPa() || nbPa > getMurPA()) {
							System.out.println("Vous disposer de " + p.getPa() + " PA. Combien voulez-vous en utiliser?");
							nbPa = sc.nextInt();
						}
	
						p.setPa(p.getPa() - nbPa);
						setMurPA(getMurPA() - nbPa);
						
						if (getMurPA() > 0) { 
							System.out.println("Encore " + getMurPA() + " PA pour le finir!");
						} else {
							if (getMurPA() == 0) {
								setMurPA(-1);
								defense += 20;
								System.out.println("Mur d'enceinte construit! Votre ville peut donc r�sister � " + defense + " zombies!");
							}
						}
						
					} else {
						System.out.println("D�j� Construit!");	
					}
				}
				
				hdv.actionDansLaVille(p, grilleDeJeu);
				
				break;
			case 2 :
				if (getFilPlanche() != -1 && getFilMetal() != -1 && banque.get(0).size() >= 20 && banque.get(1).size() >= 30) { // Alors je peux construire mes fils
					System.out.println("Vous venez d'utiliser 20 planches et 30 m�tals pour la r�alisation des fils barbel�s!");
					setFilPlanche(-1);
					setFilMetal(-1);
					
					if (p.getPa()>0) {
						int nbPa = -1;
						while (nbPa < 0 || nbPa > p.getPa()) {
							System.out.println("Voulez-vous utiliser des PA pour sa r�alisation?\n"
									+ "Vous disposer de " + p.getPa() + ". Combien voulez-vous en utiliser?");
							nbPa = sc.nextInt();
						}
						p.setPa(p.getPa() - nbPa);
						setFilPA(getFilPA() - nbPa);
										
						for (int i = 0; i < 20; i++) {
							banque.get(0).remove(0);
						}
	                                        
						for (int i = 0; i < 30; i++) {
							banque.get(1).remove(0);
						}
						
						System.out.println("Vous venez de lancer la construction des fils barbel�s! Encore " + getFilPA() + " PA pour les finir!");
					}
					
				} else {
					if (getFilPA() > 0) {
						System.out.println("Il reste encore " + getFilPA() + " PA pour finir la construction!");
	
						int nbPa = -1;
						while (nbPa < 0 || nbPa > p.getPa() || nbPa > getFilPA()) {
							System.out.println("Vous disposer de " + p.getPa() + " PA. Combien voulez-vous en utiliser?");
							nbPa = sc.nextInt();
						}
	
						p.setPa(p.getPa() - nbPa);
						setFilPA(getFilPA() - nbPa);
						
						if (getFilPA() > 0) { 
							System.out.println("Encore " + getFilPA() + " PA pour le finir!");
						} else {
							if (getFilPA() == 0) {
								setFilPA(-1);
								defense += 30;
								System.out.println("Fils barbel�s construit! Votre ville peut donc r�sister � " + defense + " zombies!");
							}
						}
						
					} else {
						System.out.println("D�j� Construit!");	
					}
				}
				
				hdv.actionDansLaVille(p, grilleDeJeu);
						
				break;
			case 3 :
				if (getFossePlanche() != -1 && getFosseMetal() != -1 && banque.get(0).size() >= 50 && banque.get(1).size() >= 25) { // Alors je peux construire ma fosse a zombies
					System.out.println("Vous venez d'utiliser 50 planches et 25 m�tals pour la r�alisation d'une fosse � zombies!");
					setFossePlanche(-1);
					setFosseMetal(-1);
					
					if (p.getPa()>0) {
						int nbPa = -1;
						while (nbPa < 0 || nbPa > p.getPa()) {
							System.out.println("Voulez-vous utiliser des PA pour sa r�alisation?\n"
									+ "Vous disposer de " + p.getPa() + ". Combien voulez-vous en utiliser?");
							nbPa = sc.nextInt();
						}
						p.setPa(p.getPa() - nbPa);
						setFossePA(getFossePA() - nbPa);
										
						for (int i = 0; i < 50; i++) {
							banque.get(0).remove(0);
						}
	                                        
						for (int i = 0; i < 25; i++) {
							banque.get(1).remove(0);
						}
						
						System.out.println("Vous venez de lancer la construction de la fosse � zombies! Encore " + getFossePA() + " PA pour les finir!");
					}
					
				} else {
					if (getFossePA() > 0) {
						System.out.println("Il reste encore " + getFossePA() + " PA pour finir la construction!");
	
						int nbPa = -1;
						while (nbPa < 0 || nbPa > p.getPa() || nbPa > getFossePA()) {
							System.out.println("Vous disposer de " + p.getPa() + " PA. Combien voulez-vous en utiliser?");
							nbPa = sc.nextInt();
						}
	
						p.setPa(p.getPa() - nbPa);
						setFossePA(getFossePA() - nbPa);
						
						if (getFossePA() > 0) { 
							System.out.println("Encore " + getFossePA() + " PA pour le finir!");
						} else {
							if (getFossePA() == 0) {
								setFossePA(-1);
								defense += 50;
								System.out.println("Fosse � zombies construite! Votre ville peut donc r�sister � " + defense + " zombies!");
							}
						}
						
					} else {
						System.out.println("D�j� Construit!");	
					}
				}
				
				hdv.actionDansLaVille(p, grilleDeJeu);
						
				break;
			case 4 :
				if (getMinePlanche() != -1 && getMineMetal() != -1 && banque.get(0).size() >= 10 && banque.get(1).size() >= 50) { // Alors je peux construire mes mines
					System.out.println("Vous venez d'utiliser 10 planches et 50 m�tals pour la r�alisation des mines autour de la ville!");
					setMinePlanche(-1);
					setMineMetal(-1);
					
					if (p.getPa()>0) {
						int nbPa = -1;
						while (nbPa < 0 || nbPa > p.getPa()) {
							System.out.println("Voulez-vous utiliser des PA pour sa r�alisation?\n"
									+ "Vous disposer de " + p.getPa() + ". Combien voulez-vous en utiliser?");
							nbPa = sc.nextInt();
						}
						p.setPa(p.getPa() - nbPa);
						setMinePA(getMinePA() - nbPa);
										
						for (int i = 0; i < 10; i++) {
							banque.get(0).remove(0);
						}
	                                        
						for (int i = 0; i < 50; i++) {
							banque.get(1).remove(0);
						}
						
						System.out.println("Vous venez de lancer la construction des mines autour de la ville! Encore " + getMinePA() + " PA pour les finir!");
					}
					
				} else {
					if (getMinePA() > 0) {
						System.out.println("Il reste encore " + getMinePA() + " PA pour finir la construction!");
	
						int nbPa = -1;
						while (nbPa < 0 || nbPa > p.getPa() || nbPa > getMinePA()) {
							System.out.println("Vous disposer de " + p.getPa() + " PA. Combien voulez-vous en utiliser?");
							nbPa = sc.nextInt();
						}
	
						p.setPa(p.getPa() - nbPa);
						setMinePA(getMinePA() - nbPa);
						
						if (getMinePA() > 0) { 
							System.out.println("Encore " + getMinePA() + " PA pour le finir!");
						} else {
							if (getMinePA() == 0) {
								setMinePA(-1);
								defense += 50;
								System.out.println("Mines autour de la ville construites! Votre ville peut donc r�sister � " + defense + " zombies!");
							}
						}
						
					} else {
						System.out.println("D�j� Construit!");	
					}
				}
				
				hdv.actionDansLaVille(p, grilleDeJeu);
						
				break;
			case 5 :
				if (getPortePlanche() != -1 && getPorteMetal() != -1 && banque.get(0).size() >= 50 && banque.get(1).size() >= 50) { // Alors je peux construire mes portes blind�es
					System.out.println("Vous venez d'utiliser 50 planches et 50 m�tals pour la r�alisation des portes blind�es!");
					setPortePlanche(-1);
					setPorteMetal(-1);
					
					if (p.getPa()>0) {
						int nbPa = -1;
						while (nbPa < 0 || nbPa > p.getPa()) {
							System.out.println("Voulez-vous utiliser des PA pour sa r�alisation?\n"
									+ "Vous disposer de " + p.getPa() + ". Combien voulez-vous en utiliser?");
							nbPa = sc.nextInt();
						}
						p.setPa(p.getPa() - nbPa);
						setPortePA(getPortePA() - nbPa);
										
						for (int i = 0; i < 50; i++) {
							banque.get(0).remove(0);
						}
	                                       
						for (int i = 0; i < 50; i++) {
							banque.get(1).remove(0);
						}
						
						System.out.println("Vous venez de lancer la construction des portes blind�es! Encore " + getPortePA() + " PA pour les finir!");
					}
					
				} else {
					if (getPortePA() > 0) {
						System.out.println("Il reste encore " + getPortePA() + " PA pour finir la construction!");
	
						int nbPa = -1;
						while (nbPa < 0 || nbPa > p.getPa() || nbPa > getPortePA()) {
							System.out.println("Vous disposer de " + p.getPa() + " PA. Combien voulez-vous en utiliser?");
							nbPa = sc.nextInt();
						}
	
						p.setPa(p.getPa() - nbPa);
						setPortePA(getPortePA() - nbPa);
						
						if (getPortePA() > 0) { 
							System.out.println("Encore " + getPortePA() + " PA pour le finir!");
						} else {
							if (getPortePA() == 0) {
								setPortePA(-1);
								defense += 100;
								System.out.println("Portes blind�es construites! Votre ville peut donc r�sister � " + defense + " zombies!");
							}
						}
						
					} else {
						System.out.println("D�j� Construit!");	
					}
				}
				
				hdv.actionDansLaVille(p, grilleDeJeu);
						
				break;
			case 6 :
				if (getMiradorPlanche() != -1 && getMiradorMetal() != -1 && banque.get(0).size() >= 75 && banque.get(1).size() >= 75) { // Alors je peux construire mes miradors
					System.out.println("Vous venez d'utiliser 75 planches et 75 m�tals pour la r�alisation des miradors avec mitrailleuses automatiques!");
					setMiradorPlanche(-1);
					setMiradorMetal(-1);
					
					if (p.getPa()>0) {
						int nbPa = -1;
						while (nbPa < 0 || nbPa > p.getPa()) {
							System.out.println("Voulez-vous utiliser des PA pour sa r�alisation?\n"
									+ "Vous disposer de " + p.getPa() + ". Combien voulez-vous en utiliser?");
							nbPa = sc.nextInt();
						}
						p.setPa(p.getPa() - nbPa);
						setMiradorPA(getMiradorPA() - nbPa);
										
						for (int i = 0; i < 75; i++) {
							banque.get(0).remove(0);
						}
	                                      
						for (int i = 0; i < 75; i++) {
							banque.get(1).remove(0);
						}
						
						System.out.println("Vous venez de lancer la construction des miradors! Encore " + getMiradorPA() + " PA pour les finir!");
					}
					
				} else {
					if (getMiradorPA() > 0) {
						System.out.println("Il reste encore " + getMiradorPA() + " PA pour finir la construction!");
	
						int nbPa = -1;
						while (nbPa < 0 || nbPa > p.getPa() || nbPa > getMiradorPA()) {
							System.out.println("Vous disposer de " + p.getPa() + " PA. Combien voulez-vous en utiliser?");
							nbPa = sc.nextInt();
						}
	
						p.setPa(p.getPa() - nbPa);
						setMiradorPA(getMiradorPA() - nbPa);
						
						if (getMiradorPA() > 0) { 
							System.out.println("Encore " + getMiradorPA() + " PA pour le finir!");
						} else {
							if (getMiradorPA() == 0) {
								setMiradorPA(-1);
								defense += 200;
								System.out.println("Miradors avec mitrailleuses automatiques construits! Votre ville peut donc r�sister � " + defense + " zombies!");
							}
						}
						
					} else {
						System.out.println("D�j� Construit!");	
					}
				}
				
				hdv.actionDansLaVille(p, grilleDeJeu);
						
				break;
				
			case 7 :
				if (getAbrisPlanche() != -1 && getAbrisMetal() != -1 && banque.get(0).size() >= 100 && banque.get(1).size() >= 200) { // Alors je peux construire mes abris anti-atomique
					System.out.println("Vous venez d'utiliser 100 planches et 200 m�tals pour la r�alisation des abris anti-atomique!");
					setAbrisPlanche(-1);
					setAbrisMetal(-1);
					
					if (p.getPa()>0) {
						int nbPa = -1;
						while (nbPa < 0 || nbPa > p.getPa()) {
							System.out.println("Voulez-vous utiliser des PA pour sa r�alisation?\n"
									+ "Vous disposer de " + p.getPa() + ". Combien voulez-vous en utiliser?");
							nbPa = sc.nextInt();
						}
						p.setPa(p.getPa() - nbPa);
						setAbrisPA(getAbrisPA() - nbPa);
										
						for (int i = 0; i < 100; i++) {
							banque.get(0).remove(0);
						}
	                                        
						for (int i = 0; i < 200; i++) {
							banque.get(1).remove(0);
						}
						
						System.out.println("Vous venez de lancer la construction des abris anti-atomique! Encore " + getAbrisPA() + " PA pour les finir!");
					}
					
				} else {
					if (getAbrisPA() > 0) {
						System.out.println("Il reste encore " + getAbrisPA() + " PA pour finir la construction!");
	
						int nbPa = -1;
						while (nbPa < 0 || nbPa > p.getPa() || nbPa > getAbrisPA()) {
							System.out.println("Vous disposer de " + p.getPa() + " PA. Combien voulez-vous en utiliser?");
							nbPa = sc.nextInt();
						}
	
						p.setPa(p.getPa() - nbPa);
						setAbrisPA(getAbrisPA() - nbPa);
						
						if (getAbrisPA() > 0) { 
							System.out.println("Encore " + getAbrisPA() + " PA pour le finir!");
						} else {
							if (getAbrisPA() == 0) {
								setAbrisPA(-1);
								defense += 500;
								System.out.println("Abris anti-atomique construits! Votre ville peut donc r�sister � " + defense + " zombies!");
							}
						}
						
					} else {
						System.out.println("D�j� Construit!");	
					}
				}
				
				hdv.actionDansLaVille(p, grilleDeJeu);
						
				break;
				
			case 9 :				
				hdv.actionDansLaVille(p, grilleDeJeu);
				break;
				
			}
	}
}
