package horde;

public class ObjetJeu {	
	public static int getId(ObjetJeu obj) {	
		// C'EST PO BEAU (désolé)
		if (String.valueOf(obj.getClass()).equals("class horde.Planche")) // si c'est une planche alors je renvoie le code 0
			return 0;
		else if (String.valueOf(obj.getClass()).equals("class horde.Metal")) // si c'est du métal alors je renvoie le code 1
			return 1;
		else if (String.valueOf(obj.getClass()).equals("class horde.Gourde")) // si mon objet est une gourde je renvoie le code 2
			return 2;
		else
			return -1;
	}
}
