/**
 * Programme principal du jeu du puissance 4.
 * 
 */
public class Puissance4 {

	public static void main(String[] args) {
		//cr�ation des joueurs et appel de l33

		// a fonction jouer
		Joueur joueur1 = new JoueurAlphaBeta(new FonctionEvaluationPerso());
		Joueur joueur2 = new JoueurMinMax(new FonctionEvaluationPerso());
		
		jouer(joueur1, joueur2);
	}
	
	
	/**
	 * Fonction qui effectue la boucle de jeu.
	 * 
	 * @param joueur1 : le premier joueur.
	 * @param joueur2 : le second joueur.
	 */
	public static void jouer(Joueur joueur1, Joueur joueur2){
		Resultat res;
		Grille grille = new Grille();

		Joueur joueurCour = joueur1;
		int numJoueur = Grille.JOUEUR1; //le joueur 1 commence à jouer
		
		int vainqueur = 0;//match nul
		boolean jeuFini = false;
		
		
		//boucle de jeu
		while(!jeuFini){
			//affichage de la grille 
			System.out.println(grille);

            //faire jouer le joueur courant
            res = joueurCour.coup(grille,numJoueur);

                if (grille.coupGagnant((int) res.getValeur(), res.getColonne())) { //Si c'est un coup gagnant
                    jeuFini = true;
                    vainqueur = numJoueur;
                }
                if (grille.joueEn((int) res.getValeur(), res.getColonne())) { //Si il a pu jouer
                    if (joueurCour.equals(joueur1)) joueurCour = joueur2;
                    else if (joueurCour.equals(joueur2)) joueurCour = joueur1;

                    numJoueur = Grille.joueurSuivant(numJoueur);

                    if(grille.estPleine()) jeuFini=true;
            }

		}//while - boucle de jeu

		//affichage de la grille 
		System.out.println(grille);
		
		
		//affichage du vainqueur
		switch(vainqueur){
			case Grille.JOUEUR1:
				System.out.println("Victoire du joueur 1");
				break;
			case Grille.JOUEUR2:
				System.out.println("Victoire du joueur 2");
				break;
			default:
				System.out.println("Match nul");
		}
	}

}
