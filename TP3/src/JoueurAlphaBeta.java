/**
 * Created by Lautre on 16/03/2015.
 */
public class JoueurAlphaBeta implements Joueur{

    double val;
    int meilleurCoup;
    FonctionEvaluation fonctionEvaluation=null;
    Grille grille;

    public JoueurAlphaBeta(FonctionEvaluation fonctionEvaluation){
        this.fonctionEvaluation = fonctionEvaluation;
    }

    @Override
    public Resultat coup(Grille grille, int joueur) {
        this.grille = grille;
        double alpha = FonctionEvaluationProf.MIN;

        int[] coupsPossible = this.grille.generateurCoups();
        for (int coupActuel : coupsPossible) {
            this.grille = this.grille.copie();
            this.grille.joueEn(joueur,coupActuel);
            fonctionEvaluation.evaluation(this.grille, joueur);
            val = alphaBeta(3, Grille.joueurSuivant(joueur), alpha, FonctionEvaluation.MAX, false); /*3 -> Profondeur*/

            if(val>alpha) {
                alpha = val;
                meilleurCoup = coupActuel;
            }
            this.grille = grille;
        }
        return new Resultat(meilleurCoup,joueur);
    }

    public double alphaBeta(int profondeur, int joueur,double alpha,double beta,boolean estEtatMax){
        Grille grilleTmp = grille.copie();
        if (profondeur <= 0) return fonctionEvaluation.evaluation(grille, joueur);

        int[] coupsPossible = this.grille.generateurCoups();
        if (estEtatMax) {
            for (int coupActuel : coupsPossible) {
                this.grille.joueEn(joueur, coupActuel);
                alpha = Math.max(alpha, alphaBeta(profondeur - 1, joueur, alpha, beta, true));
                if (alpha >= beta) {
                    this.grille = grilleTmp;
                    return alpha;
                }
            }
            this.grille = grilleTmp;
            return alpha;
        } else {
            for (int coupActuel : coupsPossible) {
                this.grille.joueEn(joueur, coupActuel);
                beta = Math.min(beta, alphaBeta(profondeur - 1, joueur, alpha, beta, false));
                if (beta <= alpha) {
                    this.grille = grilleTmp;
                    return beta;
                }
            }
            this.grille = grilleTmp;
            return beta;
        }
    }
}
