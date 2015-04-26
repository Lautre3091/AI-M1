/**
 * Created by Lautre on 16/03/2015.
 */
public class JoueurAlphaBeta implements Joueur{

    double val;
    double alpha;
    double beta;
    int meilleurCoup;
    FonctionEvaluationProf fonctionEvaluationProf = new FonctionEvaluationProf();
    Grille grille;

    @Override
    public Resultat coup(Grille grille, int joueur) {
        this.grille = grille;

        double A = FonctionEvaluationProf.MIN;
        double B = FonctionEvaluation.MAX;


        int[] coupsPossible = this.grille.generateurCoups();
        for (int coupActuel : coupsPossible) {
            this.grille = this.grille.copie();
            this.grille.joueEn(joueur,coupActuel);
            fonctionEvaluationProf.evaluation(this.grille,joueur);
            val = -alphaBeta(3, Grille.joueurSuivant(joueur),-A,-B); /*3 -> Profondeur*/

            if(val>=A) {
                A = val;
                meilleurCoup = coupActuel;
                if (A>=B) break;
            }
            this.grille = grille;//Annulation du coups actuel
        }
        return new Resultat(meilleurCoup,joueur);
    }

    public double alphaBeta(int profondeur, int joueur,double A,double B){
        Grille grilleTmp = this.grille.copie();
            if (profondeur <= 0)
                return fonctionEvaluationProf.evaluation(grille, joueur);

        int[] coupsPossible = this.grille.generateurCoups();
        for (int coupActuel : coupsPossible) {
            /*definition de la nouvelle grille*/
            this.grille.joueEn(joueur, coupActuel);
            /*Fonction eval*/
            fonctionEvaluationProf.evaluation(this.grille, joueur);
            val = -alphaBeta(profondeur - 1, joueur,-B,-A);
            this.grille = grilleTmp;

            if (val >= A){
                A = val ;
                meilleurCoup = coupActuel;
                if (A >= beta)
                    break;
            }
        }
        return alpha;
    }


    private double min(int profondeur, int joueur){
        Grille grilleTmp = this.grille.copie();
        if (profondeur==0){
            return fonctionEvaluationProf.evaluation(grille, joueur);
        }

        double min_val = FonctionEvaluationProf.MAX;

        int[] coupsPossible = this.grille.generateurCoups();
        for (int coupActuel : coupsPossible) {
            /*definition de la nouvelle grille*/
            this.grille = this.grille.copie();
            this.grille.joueEn(joueur, coupActuel);
            /*Fonction eval*/
            fonctionEvaluationProf.evaluation(this.grille, joueur);
            val = max(profondeur - 1, Grille.joueurSuivant(joueur));

            if (val < min_val) min_val = val;
            this.grille = grilleTmp;
        }
        return min_val;

    }

    private double max(int profondeur, int joueur){
        Grille grilleTmp = this.grille.copie();
        if (profondeur==0){
            return fonctionEvaluationProf.evaluation(grille, joueur);
        }

        double max_val = FonctionEvaluationProf.MIN;

        int[] coupsPossible = this.grille.generateurCoups();
        for (int coupActuel : coupsPossible) {
            /*definition de la nouvelle grille*/
            this.grille = this.grille.copie();
            this.grille.joueEn(joueur,coupActuel);
            /*Fonction eval*/
            fonctionEvaluationProf.evaluation(this.grille,joueur);
            val = min(profondeur - 1, Grille.joueurSuivant(joueur));

            if(val>max_val) max_val = val;
            this.grille=grilleTmp;
        }
        return max_val;

    }
}
