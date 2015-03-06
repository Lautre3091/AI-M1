/*
 * TP 2 - IA: Taquin
 * 
 * @author Tassadit BOUADI.
 */

import java.util.Vector;

public class Etat implements Comparable<Etat>{
	public static final int[][] ETAT_FINAL1 = {
		{1,2,3},
		{8,0,4},
		{7,6,5}};
	public static final int[][] ETAT_FINAL2 = {
		{1,2,3},
		{4,5,6},
		{7,8,0}};
	
	private Etat _pere; //l'état précédent 
	private int[][] _taquin; //la configuration de jeu
	private int _xVide; //les coordonnées de la case vide
	private int _yVide;
	private Vector<Deplacement> _coups; //la suite de déplacements de la case vide
	private int _nbCoups;
	private int _valG; //les valeurs des fonctions associées à la configuration
	private int _valF;
	
	
	/**
	 * Constructeur.
	 * @param tab : le tableau décrivant la configuration de jeu.
	 */
	public Etat(int[][] tab, FonctionHeuristique heurist){
		_pere = null;
		_taquin = new int[3][3];
		for(int i=0; i<3; i++){
			for(int j=0; j<3; j++){
				_taquin[i][j] = tab[i][j];
				if(_taquin[i][j] == 0){
					_xVide = i;
					_yVide = j;
				}
			}
		}
		_coups = new Vector<Deplacement>();
		_nbCoups = 0;
		_valG = 0;
		int valH = heurist.heuristique(this);
		_valF = _valG + valH;
	}
	
	
	/**
	 * Constructeur.
	 * @param tab : le tableau décrivant la configuration de jeu.
	 */
	public Etat(int[][] tab){
		_pere = null;
		_taquin = new int[3][3];
		for(int i=0; i<3; i++){
			for(int j=0; j<3; j++){
				_taquin[i][j] = tab[i][j];
				if(_taquin[i][j] == 0){
					_xVide = i;
					_yVide = j;
				}
			}
		}
		_coups = new Vector<Deplacement>();
		_nbCoups = 0;
		_valG = 0;
		_valF = _valG;
	}
	
	
	/**
	 * Constructeur qui recopie l'état e dans l'état courant.
	 * @param e : l'état à cloner.
	 */
	public Etat(Etat e){
		_pere = e._pere;
		_taquin = new int[3][3];
		for(int i=0; i<3; i++){
			for(int j=0; j<3; j++){
				_taquin[i][j] = e._taquin[i][j];
			}
		}
		_xVide = e._xVide;
		_yVide = e._yVide;
		_coups = new Vector<Deplacement>();
		for(int i=0; i<e._nbCoups; i++){
			_coups.add(e._coups.get(i));
		}
		_nbCoups = e._nbCoups;
		_valG = e._valG;
		_valF = e._valF;
	}
	
	
	
	/**
	 * Méthode qui donne le père de l'état courant.
	 * @return le père de l'état courant.
	 */
	public Etat getPere(){
		return _pere;
	}
	
	
	/**
	 * Méthode qui donne la valeur de la fonction d'évaluation g.
	 * @return la valeur de la fonction g.
	 */
	public int getValG(){
		return _valG;
	}
	
	
	/**
	 * Méthode qui donne la valeur de la fonction d'évaluation f.
	 * @return la valeur de la fonction f.
	 */
	public int getValF(){
		return _valF;
	}
	
	
	/**
	 * Méthode qui donne la valeur de la case de coordonnées données.
	 * @param i : l'abscisse de la case.
	 * @param j : l'ordonnée de la case.
	 * @return la valeur de la case.
	 */
	public int getVal(int i, int j){
		int val = -1;
		
		if((i>=0 && i<3) && (j>=0 && j<3)){
			val = _taquin[i][j];
		}
		
		return val;
	}
	
	
	/**
	 * Méthode qui donne l'abscisse du nombre n.
	 * @param n : le nombre considéré.
	 * @return l'abscisse de n.
	 */
	public int getX(int n){
		int x = -1;
		
		for(int i=0; i<3 && x==-1; i++){
			for(int j=0; j<3&& x==-1; j++){
				if(_taquin[i][j] == n){
					x = i;
				}
			}
		}
		
		return x;
	}
	
	
	/**
	 * Méthode qui donne ordonnée du nombre n.
	 * @param n : le nombre considéré.
	 * @return ordonnée de n.
	 */
	public int getY(int n){
		int y = -1;
		
		for(int i=0; i<3 && y==-1; i++){
			for(int j=0; j<3&& y==-1; j++){
				if(_taquin[i][j] == n){
					y = j;
				}
			}
		}
		
		return y;
	}
	
	
	/**
	 * Méthode qui dit si l'état courant est un état final.
	 * @return vrai si l'état courant correspond à un des 2 états finaux.
	 */
	public boolean estFinal(){
		Etat eFinal1 = new Etat(ETAT_FINAL1);
		Etat eFinal2 = new Etat(ETAT_FINAL2);
		
		return (equals(eFinal1) || equals(eFinal2));
	}
	
	
	
	/**
	 * Méthode qui donne les états successeurs de l'état courant,
	 * calculés selon l'emplacement de la case vide et en utilisant
	 * la fonction heuristique donnée.
	 * @return les états successeurs.
	 */
	public Vector<Etat> getSuccesseurs(FonctionHeuristique heurist){
		Deplacement d;
		Vector<Etat> succs = new Vector<Etat>();
		
		Deplacement[] depl = Deplacement.values(); //l'ensemble des déplacements
		//à compléter...
		
		return succs;
	}
	
	
	/**
	 * Méthode qui dit s'il est possible de déplacer la case vide,
	 * dans la direction donnée par d.
	 * @param d : la direction pour déplacer la case vide.
	 * @return vrai si la case vide peut être déplacée dans la direction d.
	 */
	private boolean deplacementPossible(Deplacement d){
		boolean depl = true;
		
		//à compléter...
		
		return depl;
	}
	
	
	/**
	 * Méthode qui étend l'état courant, en déplaçant la case vide
	 * dans la direction donnée par d.
	 * @param d : la direction pour déplacer la case vide.
	 * @return l'état créé à partir de l'état courant
	 */
	private Etat etendEtat(Deplacement d, FonctionHeuristique heurist){
		Etat etat = new Etat(this);
		etat._pere = this;
		
		//déplacement de la case vide
		//à compléter...
		
		//mise à jour des fonctions d'évaluation 
		//à compléter...
		
		return etat;
	}
	
	
	
	/**
	 * Méthode qui affiche la séquence de configurations.
	 */
	public void afficherParcours(){
		if(_pere != null){
			_pere.afficherParcours();
		}
		System.out.println(this);
	}
	

	/**
	 * Méthode qui donne la représentation de l'état, sous forme de chaîne.
	 * @return la chaîne représentant l'état.
	 */
	public String toString(){
		String str = "";
		
		//la configuration de jeu
		str += "-------\n";
		for(int i=0; i<3; i++){
			str += "|";
			for(int j=0; j<3; j++){
				if(j > 0) str += " ";
				str += _taquin[i][j];
			}
			str += "|\n";
		}
		str += "-------\n";
		
		//les valeurs des fonctions
		str += "f = " + _valF + " (g = " + _valG + ")\n";
		
		//les déplacements de la case vide
		str += _nbCoups + " déplacements : ";
		for(int i = 0; i < _nbCoups; i++){
			if(i > 0) str += " - ";
			switch(_coups.get(i)){
			case haut:
				str += "haut";
				break;
			case bas:
				str += "bas";
				break;
			case gauche:
				str += "gauche";
				break;
			case droite:
				str += "droite";
				break;
			}
		}//for i
		
		return str;
	}
	
	
	/**
	 * Méthode qui dit si 2 états sont égaux, au niveau des configurations.
	 * @param e : l'état avec lequel comparer l'état courant.
	 * @return vrai si les états correspondent à la même configuration.
	 */
	public boolean equals(Etat e){
		boolean eq = true;
		
		for(int i=0; i<3 && eq; i++){
			for(int j=0; j<3 && eq; j++){
				eq = (_taquin[i][j] == e._taquin[i][j]);
			}
		}
		
		return eq;
	}
	
	
	/**
	 * Méthode de l'interface Comparable, à implémenter.
	 * @param e : l'état avec lequel comparer l'état courant.
	 * @return -1, 0 ou 1 selon que l'état e est inférieur, égal
	 * ou supérieur à l'état courant, respectivement.
	 */
	public int compareTo(Etat e){
		int res = -1;
		
		//classement dans l'ordre croissant de f 
		//puis dans l'ordre décroissant de g
		if(e._valF < _valF){
			res = -1;
		}
		else if(e._valF > _valF){
			res = 1;
		}
		else{
			if(e._valG > _valG){
				res = -1;
			}
			else if(e._valG < _valG){
				res = 1;
			}
			else{
				res = 0;
			}
		}
		
		return res;
	}
	
}
