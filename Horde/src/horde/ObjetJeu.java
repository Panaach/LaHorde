package horde;

public class ObjetJeu {	
	public static int getId(ObjetJeu obj) {	
		// C'EST PAS BEAU (d�sol�)
		if (String.valueOf(obj.getClass()).equals("class horde.Planche")) // si c'est une planche alors je renvoie le code 0
			return 0;
		else if (String.valueOf(obj.getClass()).equals("class horde.Metal")) // si c'est du m�tal alors je renvoie le code 1
			return 1;
		else if (String.valueOf(obj.getClass()).equals("class horde.Ration")) // si mon objet est une ration je renvoie le code 3
			return 2;
		else if (String.valueOf(obj.getClass()).equals("class horde.Gourde")) // si mon objet est une gourde je renvoie le code 2
			return 3;
		else if (String.valueOf(obj.getClass()).equals("class horde.Boisson")) // si mon objet est une boisson �nergisante je renvoie le code 4
			return 4;
		else
			return -1;
	}
}
