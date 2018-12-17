package horde;

import java.util.LinkedList;

public class VagueZombie {
	private int minZombie;
	private int maxZombie;
	
	public VagueZombie() {
		this.setMinZombie(0);
		this.setMaxZombie(10);
	}
	
	public int getMinZombie() {
		return minZombie;
	}
	public void setMinZombie(int minZombie) {
		this.minZombie = minZombie;
	}
	public int getMaxZombie() {
		return maxZombie;
	}
	public void setMaxZombie(int maxZombie) {
		this.maxZombie = maxZombie;
	}	
	
	public boolean attaqueZombie(int nbTour) {
		boolean attaque = false;
		if (nbTour%12 == 0 && nbTour != 0) {
			attaque = true;
		}
		return attaque;
	}
	
	public void tueJoueur(LinkedList<Player> listPlayer) {
		System.out.println("Les zombies sont rentrés dans la ville!");
		
		int nbJoueurMort = listPlayer.size()/2;
		
		for (int i = 0; i < nbJoueurMort; i++) {
			int idJoueur = (int) (Math.random() * listPlayer.size());
			System.out.println("Le joueur " + listPlayer.get(idJoueur).getPseudo() + " est mort! Paix à son âme!");
			listPlayer.remove(idJoueur);
			
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
}
