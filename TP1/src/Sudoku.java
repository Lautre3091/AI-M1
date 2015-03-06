/*
 * TP 1 - IA Informatique : TP1.Sudoku
 * 
 * @author Tassadit BOUADI.
 */

import java.util.Stack;


public class Sudoku {
	public static int TAILLE = 9;


	public static void main(String[] args) {
		int[][] grille1 = {
				{0,8,0,4,0,2,0,6,0},
				{0,3,4,0,0,0,9,1,0},
				{9,6,0,0,0,0,0,8,4},
				{0,0,0,2,1,6,0,0,0},
				{0,0,0,0,0,0,0,0,0},
				{0,0,0,3,5,7,0,0,0},
				{8,4,0,0,0,0,0,7,5},
				{0,2,6,0,0,0,1,3,0},
				{0,9,0,7,0,1,0,4,0}
		};

		//initialisation
		Grille grilleInit1 = new Grille(TAILLE, grille1);
		grilleInit1.afficheGrille();

		Stack<Grille> pile = new Stack<Grille>();
		pile.push(grilleInit1);


		boolean resul = resoudreSudoku(pile);


		if(resul){
			System.out.println("La grille a été résolue");
			Grille grilleResul = pile.peek();
			grilleResul.afficheGrille();
		}
		else{
			System.out.println("Aucune solution n'a été trouvée");
			Grille grilleResul = pile.peek();
			grilleResul.afficheGrille();
		}
	}//main


	/*
	 * Fonction récursive qui recherche la solution,
	 * en utilisant éventuellement des retours-arriére.
	 */
	public static boolean resoudreSudoku(Stack<Grille> pileGrilles){
		Grille grille;
		while (!pileGrilles.empty()){
			grille = pileGrilles.pop();
			resoudreSudokuAux(grille);
		}
		return false;
	}//resoudreSudoku

	private static Grille resoudreSudokuAux(Grille grille){
		if(grille.getNbCasesVides()==0){
			return grille;
		}
		else {
			Case caseVide = grille.getCasePossible();
			if (caseVide != null) {
				for (int val = 1; val < 10; val++) {
					Grille grille1 = new Grille(grille); //copie de la TP1.Grille grille
					if (grille1.casePossible(caseVide, val)) {
						grille1.setCase(caseVide, val);
						grille = resoudreSudokuAux(grille1);
						if (grille != null) return grille;
					}
				}
			}
		}
		return null;
	}
}