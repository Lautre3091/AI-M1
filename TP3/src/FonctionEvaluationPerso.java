
public class FonctionEvaluationPerso implements FonctionEvaluation {

	public double evaluation(Grille grille, int joueur) {
		int adversaire = Grille.joueurSuivant(joueur);

		return evaluer(grille, joueur) - evaluer(grille, adversaire);
    }

    private double evaluer(Grille grille, int joueur) {
		int res = 0;
		for (int l = 0; l < Grille.NB_LIGNES; l++) {
            for (int c = 0; c < Grille.NB_COLONNES; c++) {
                if (grille.getVal(l,c) == joueur ) {
                    int[] nbCaseOccupeJoueur = {grille.getNbCasesHorizontale(joueur, l, c),
                            grille.getNbCasesVerticale(joueur, l, c),
                            grille.getNbCasesDiagonale1(joueur, l, c),
                            grille.getNbCasesDiagonale2(joueur, l, c)};
                    for (int k : nbCaseOccupeJoueur) res += setScore(k,res);
                }
			}
		}
		return res;
	}

    private int setScore (int k, int res) {
        switch (k) {
            case 1 : return 1;
            case 2 : return 5;
            case 3 : return 50;
            case 4 : return 1000;
        }
        return res;
    }

}


