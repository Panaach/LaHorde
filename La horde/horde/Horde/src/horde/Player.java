package horde;

public class Player {
	
	private String pseudo;
	private int indice;
	private int pa;
	private int pv;
	
	public Player(String pseudo, int indice) {
		this.setPseudo(pseudo);
		this.setPa(6);
		this.setPv(100);
		this.setIndice(indice);
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

}
