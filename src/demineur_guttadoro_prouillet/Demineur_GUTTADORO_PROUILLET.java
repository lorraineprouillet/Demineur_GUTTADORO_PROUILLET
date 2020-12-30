/*

 */
package demineur_guttadoro_prouillet;

/**
 *
 * @author Lorraine
 */
public class Demineur_GUTTADORO_PROUILLET {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
        //Tests méthodes:
        /**Joueur Lorraine = new Joueur("Lorraine");
        Lorraine.obtenirKits();
        Lorraine.utiliserKits();
        Grille uneGrille = new Grille();
        uneGrille.afficherGrilleSurConsole(); //on affiche la grille de jeu
        uneGrille.placerMines(2,15);
        //uneGrille.rendreVisibleCellule(3,16);
        //uneGrille.rendreVisibleCellule(2,16);
        uneGrille.placerKits(2,3);
        * 
        *  //On dévoile alors la case voulue 
                while (grillePartie.rendreVisibleCellule( ligne , colonne ) == false ) {
                    System.out.println("La case est déjà dévoilée, saisissez en une autre ");
                    //Si la case a déjà été dévoilée il faut en saisir une autre 
                    ligne = sca.nextInt() - 1; 
                    colonne = scc.nextInt() - 1;
                    grillePartie.rendreVisibleCellule(ligne , colonne );
                }
        * 
        * 
        uneGrille.placerMines(0,9);
        uneGrille.placerMines(2,16);
        uneGrille.placerMines(3,15);
        */
        
        Partie PartieDeJeu = new Partie();
        PartieDeJeu.debuterPartie();
        
        
    }
    
}
