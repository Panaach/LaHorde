package horde;

public class ObjetJeu {
	Planche pl;
	Metal met;
	
	public boolean isPlanche(ObjetJeu obj) {
		if (obj.getClass() == pl.getClass())
			return true;
		else
			return false;
	}
	
	public int getId(ObjetJeu obj) {
		if ((Planche) obj != null) // si c'est une planche alors je renvoie le code 0
			return 0;
		else if ((Metal) obj != null) // si c'est du métal alors je renvoie le code 1
			return 1;
		else
			return -1;
	}
}
