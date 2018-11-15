package horde;

import java.util.HashSet;

import horde.Grille.absisse;

public class Player {
	
	private String abscisse;
	private int ordonne;
	private String pseudo;
	private int indice;
	private int pa;
	private int pv;
	private HashSet sac;
	
	public Player(String pseudo, int indice) {
		this.setPseudo(pseudo);
		this.setPa(6);
		this.setPv(100);
		this.setIndice(indice);
		this.setAbscisse("L");
		this.setOrdonne(13);
	}
	
	public String getPseudo() {
		return pseudo;
	}
	
	public void setPseudo(String pseudo) {
		this.pseudo = pseudo;
	}
	
	public int getPa() {
		return pa;
	}
	
	public void setPa(int pa) {
		this.pa = pa;
	}
	
	public int getPv() {
		return pv;
	}
	
	public void setPv(int pv) {
		this.pv = pv;
	}
	
	public int getIndice() {
		return indice;
	}
	
	public void setIndice(int indice) {
		this.indice = indice;
	}

	public String getAbscisse() {
		return abscisse;
	}

	public void setAbscisse(String abscisse) {
		this.abscisse = abscisse;
	}

	public int getOrdonne() {
		return ordonne;
	}

	public void setOrdonne(int ordonne) {
		this.ordonne = ordonne;
	}
	
	public static void avancerDroite(Player p) {
		// Aller a la lettre suivante
		
		//p.setAbscisse(String.valueOf(absisse.valueOf(p.getAbscisse())).next());
		//int abs = Integer.parseUnsignedInt(String.valueOf((absisse.valueOf(p.getAbscisse()))));
		String abs = String.valueOf(absisse.valueOf(p.getAbscisse()));
		System.out.println(abs);
		
	}

}
