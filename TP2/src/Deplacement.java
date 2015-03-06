/*
 * TP 2 - IA: Taquin
 * 
 * @author Tassadit BOUADI.
 */

public enum Deplacement {
	haut, bas, gauche, droite;
	
	public static String toString(Deplacement d){
		String str = "";
		
		switch(d){
		case haut:
			str = "haut";
			break;
		case bas:
			str = "bas";
			break;
		case gauche:
			str = "gauche";
			break;
		case droite:
			str = "droite";
			break;
		}
		
		return str;
	}
}
