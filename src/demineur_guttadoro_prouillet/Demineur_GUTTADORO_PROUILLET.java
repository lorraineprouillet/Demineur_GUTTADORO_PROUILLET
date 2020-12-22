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
        
        //Tests méthodes Joueur:
        Joueur Lorraine = new Joueur("Lorraine");
        Lorraine.obtenirKits();
        Lorraine.utiliserKits();
        Grille uneGrille = new Grille();
        uneGrille.afficherGrilleSurConsole(); //on affiche la grille de jeu
        uneGrille.placerMines(2, 15);
        uneGrille.rendreVisibleCellule(2,15);
        uneGrille.rendreVisibleCellule(2,16);
        uneGrille.afficherGrilleSurConsole();
    }
    
}
