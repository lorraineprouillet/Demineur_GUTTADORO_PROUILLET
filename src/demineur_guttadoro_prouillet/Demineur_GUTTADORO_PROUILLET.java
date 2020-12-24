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
        Joueur Lorraine = new Joueur("Lorraine");
        Lorraine.obtenirKits();
        Lorraine.utiliserKits();
        Grille uneGrille = new Grille();
        uneGrille.afficherGrilleSurConsole(); //on affiche la grille de jeu
        uneGrille.placerMines(2,15);
        //uneGrille.rendreVisibleCellule(3,16);
        //uneGrille.rendreVisibleCellule(2,16);
        uneGrille.placerKits(2,3);
        uneGrille.placerMines(0,9);
        for (int i=0;i<10;i++) {
            for(int j=0;j<20;j++) {
                uneGrille.rendreVisibleCellule(i,j);
            }
        } // affichage complet de la grille pour vérifier la methode des mines en contact
        //uneGrille.recupererKitsSurCase(2,3);
        uneGrille.initialiser_mines_en_contact();
        //uneGrille.desamorcerMines(2,15);
        uneGrille.afficherGrilleSurConsole();
        
    }
    
}
