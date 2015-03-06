/*
 * TP 2 - IA  : Taquin
 * 
 * @author Tassadit BOUADI.
 */

import java.util.Vector;


public class Taquin {
	
	public static void main(String[] args) {
		Etat etatInit1, etatInit2, etatFinal1, etatFinal2;
		
		int[][] tabInit1 = {
				{2,8,3},
				{1,6,4},
				{7,0,5}};
		
		int[][] tabInit2 = {
				{2,0,4},
				{1,6,3},
				{7,5,8}};

		FonctionHeuristique1 heurist1 = new FonctionHeuristique1();
		FonctionHeuristique2 heurist2 = new FonctionHeuristique2();
		
		//algo A* avec le 1er état initial
		System.out.println("Avec la 1ère heuristique");
		etatInit1 = new Etat(tabInit1, heurist1);
		etatFinal1 = algoAEtoile(etatInit1, heurist1);
		if(etatFinal1 != null){
			//etatFinal1.afficherParcours();
		}
		else{
			System.out.println("Aucune solution");
		}
		System.out.println("\n**********\n\n");
		
		System.out.println("Avec la 2ème heuristique");
		etatInit2 = new Etat(tabInit1, heurist2);
		etatFinal2 = algoAEtoile(etatInit1, heurist2);
		if(etatFinal2 != null){
			//etatFinal2.afficherParcours();
		}
		else{
			System.out.println("Aucune solution");
		}
		System.out.println("\n\n********************\n\n");
		

		//algo A* avec le 2ème état initial
		System.out.println("Avec la 1ère heuristique");
		etatInit2 = new Etat(tabInit2, heurist1);
		etatFinal1 = algoAEtoile(etatInit2, heurist1);
		if(etatFinal1 != null){
			//etatFinal1.afficherParcours();
		}
		else{
			System.out.println("Aucune solution");
		}
		System.out.println("\n**********\n\n");
		
		System.out.println("Avec la 2ème heuristique");
		etatInit2 = new Etat(tabInit2, heurist2);
		etatFinal2 = algoAEtoile(etatInit2, heurist2);
		if(etatFinal2 != null){
			//etatFinal2.afficherParcours();
		}
		else{
			System.out.println("Aucune solution");
		}
	}

	
	/**
	 * Méthode qui applique l'algorihtme A*, à partir de l'état intial donné
	 * et en utilisant l'heuristique donnée.
	 * @param etatInit : l'état initial.
	 * @param heurist : l'heuristique utilisée.
	 * @return l'état final.
	 */
	public static Etat algoAEtoile(Etat etatInit, FonctionHeuristique heurist){
		Etat etat, succ;
		Vector<Etat> succs;
		SetTaquin fermes = new SetTaquin();
		FileTaquin ouverts = new FileTaquin();
		int nbNoeuds = 0;
		Etat etatFin = null;
		
		//initialisation des SDD
		//à compléter
		
		//boucle sur ouverts
		while((!ouverts.isEmpty()) && (etatFin == null)){
			//à compléter
		}//while
					
		//affichage du nombre de noeuds créés
		System.out.println("Nombre de noeuds créés : " + nbNoeuds);
		
		return etatFin;
	}
}
