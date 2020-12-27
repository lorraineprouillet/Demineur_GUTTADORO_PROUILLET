/* reste a faire : 
 * - problèmes avec les whiles qd case deja vues ou pas de kits + continuer la fonction 3 : les drapeaux
 * - permettre le comptage du chrono et affichage de ce chrono a la fin
 * - revoir la maniere de vraiment gagner la partie (comptage des cases décovertes)
 */
package demineur_guttadoro_prouillet;

import java.util.Scanner;

/**
 *
 * @author Rosanna Guttadoro
 */
public class Partie {
    Joueur joueurCourant;
    Joueur[] listeJoueursGagnants;
    Grille grillePartie = new Grille();
    
public void debuterPartie() {
    Scanner sc = new Scanner(System.in);
    System.out.println("Pseudo Joueur : ");
    Joueur joueurCourant = new  Joueur(sc.nextLine());
    
    initialiserPartie();
       
        do { // demande au joueur de choisir ce qu'il veut faire
           
            Scanner scs = new Scanner(System.in);
            
            System.out.print("Que voulez vous faire ? \n"+"1) Cliquer sur une case \n"+"2) utiliser un kit de déminage \n"+"3) définir bombe présumée - pas possible actuellement \n");
            int choix = scs.nextInt();
            if  ( choix != 1 && choix != 2 ) { 
                System.out.println("saisissez un choix valide");
                choix = scs.nextInt();
                // si le choix n'est pas valide il doit le re saisir 
                
            } else if ( choix == 1) {
                
                Scanner sca = new Scanner(System.in);
                System.out.println("Veuillez choisir une ligne ");
                int ligne  = sca.nextInt() -1;  //Le joueur choisi sa ligne de jeu
                
                Scanner scc = new Scanner(System.in);
                System.out.println("Veuillez choisir une colone ");
                int colonne = scc.nextInt()-1;
                
                while ( ligne > 10 && ligne < 1) {
                    System.out.println(" veuillez saisir une ligne valide ");
                    ligne = sca.nextInt()-1; //Si jamais il donne une mauavaise ligne 
                }
                
                while ( colonne > 20 && colonne < 1) {
                    System.out.println(" veuillez saisir une colonne valide ");
                    colonne = scc.nextInt()-1; //Si jamais il donne une mauavaise colonne
                }
                
                
                
                //On dévoile alors la case voulue 
                while (grillePartie.rendreVisibleCellule( ligne , colonne ) == false ) {
                    System.out.println(" la case est déjà dévoilée, saisissez en une autre ");
                    //Si la case a déjà été dévoilée il faut en saisir une autre 
                    ligne = sca.nextInt() - 1; 
                    colonne = scc.nextInt() - 1;
                    grillePartie.rendreVisibleCellule(ligne , colonne );
                }
                
                if (grillePartie.cellules[ligne][colonne].presenceMines() == true) {
                    joueurCourant.PerdreVie(); //décrémente le nb de vie du joueur
                    System.out.println("\n"+"Aie! Vous venez de perdre une vie, il vous en reste "+ joueurCourant.NbVieRestante);
                }
                
                if (grillePartie.cellules[ligne][colonne].presenceKits() == true) {
                    joueurCourant.obtenirKits(); // ajoute un kit au joueur courant et le supp de la case
                    grillePartie.cellules[ligne][colonne].recupererKits();
                    System.out.println("\n"+"Bravo! Vous venez de gagner un kit de déminage");
                }
                grillePartie.afficherGrilleSurConsole(); //On affiche aprés avoir effectué l'action
              
            } else if ( choix == 2 && joueurCourant.NbKitsDeminage > 0) {
                //Si le joueur décide de récuperer un kit (il est nécessaire d'en possèder au moins 1)
                Scanner sca = new Scanner(System.in);
                System.out.println("Veuillez choisir une ligne ");
                int ligne  = sca.nextInt() -1;  //Le joueur choisi sa ligne de jeu
                
                Scanner scc = new Scanner(System.in);
                System.out.println("Veuillez choisir une colone ");
                int colonne = scc.nextInt()-1;
                
                while ( ligne > 10 && ligne < 1) {
                    System.out.println(" veuillez saisir une ligne valide ");
                    ligne = sca.nextInt()-1; //Si jamais il donne une mauavaise ligne 
                }
                
                while ( colonne > 20 && colonne < 1) {
                    System.out.println(" veuillez saisir une colonne valide ");
                    colonne = scc.nextInt()-1; //Si jamais il donne une mauavaise colonne
                }
                
                
                
                
                while (grillePartie.desamorcerMines(ligne , colonne ) == false) {
                    System.out.println("Cette case ne contient pas de mine à désamorcer, saisissez en une autre ");
                    //Si la case a déjà été dévoilée il faut en saisir une autre 
                    ligne = sca.nextInt() - 1; 
                    colonne = scc.nextInt() - 1;
                    grillePartie.desamorcerMines(ligne , colonne );
                }
                
            System.out.println("Il vous reste "+ joueurCourant.NbKitsDeminage+" Kits");
            grillePartie.afficherGrilleSurConsole();
                
            }  
        } while ( grillePartie.etreGagnant(joueurCourant) == false && joueurCourant.NbVieRestante > 0); 
        
// tant que le  joueur n'a  pas gagné la partie on affiche le menu et on continue la partie 
        if ( joueurCourant.NbVieRestante < 1 ) {
            System.out.println ("Vous n'avez plus de vies, la partie est finie ");
            
        } //termine automatiquement la partie pour le joueur si il n'a plus de vie
        
        if (grillePartie.etreGagnant(joueurCourant) == true ) {
            // il faut qu'on arrete le chrono + gestion des scores
            System.out.println("Gagné! Fin de la partie"); 
            
        }   
     
    }
    


public void initialiserPartie() {
    
    grillePartie.viderGrille(); // on vide la grille a chaque début de partie ( cases invisbles et pas de kits et de bombes ) 
    
    // on place les mines et les kits de facon aléatoire dans la grille : 
    for(int i=0;i<=50;i++) { // un total de 50 bombes
        int x=(int)(Math.random()*((10))); // x maximal a 10 et y maximal a 20
        int y=(int)(Math.random()*((20)));
        grillePartie.placerMines(x,y);
    } //placement aléatoire des mines en fonction d'un x et y aléatoires

    for(int j=0; j<=10;j++) { //un total de 10 kits
        int x=(int)(Math.random()*((10)));
        int y=(int)(Math.random()*((20)));
        grillePartie.placerKits(x,y);
        
    }
    grillePartie.initialiser_mines_en_contact(); 
    grillePartie.afficherGrilleSurConsole();
    
}

}

