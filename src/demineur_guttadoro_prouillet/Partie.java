/* bilan classe partie  : 
 * le déroulement de la partie en mode console est fonctionnel 
 * seul petit bemole avec le while lorsque la case est déjà dévoilée 
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
            
            System.out.print("Que voulez vous faire ? \n"+"1) Cliquer sur une case \n"+"2) Utiliser un kit de déminage \n"+"3) Définir bombe présumée \n");
            int choix = scs.nextInt();
            //joueurCourant.DeclencherChrono(); //On débute le chronomètre du joueur
            if  ( choix != 1 && choix != 2 && choix != 3) { 
                System.out.println("Saisissez un choix valide");
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
                    System.out.println("La case est déjà dévoilée, saisissez en une autre ");
                    //Si la case a déjà été dévoilée il faut en saisir une autre
                    System.out.println("saisissez la ligne");
                    ligne = sca.nextInt() - 1; 
                    System.out.println("saisissez la colonne");
                    colonne = scc.nextInt() - 1;
                    grillePartie.rendreVisibleCellule(ligne , colonne );
                } 
                
                grillePartie.afficherGrilleSurConsole(); //On affiche aprés avoir effectué l'action
                
                if (grillePartie.cellules[ligne][colonne].presenceMines() == true) {
                    joueurCourant.PerdreVie(); //décrémente le nb de vie du joueur
                    System.out.println("\n"+"Aie! Vous venez de perdre une vie, il vous en reste "+ joueurCourant.NbVieRestante);
                }
                
                if (grillePartie.cellules[ligne][colonne].presenceKits() == true) {
                    joueurCourant.obtenirKits(); // ajoute un kit au joueur courant et le supp de la case
                    grillePartie.cellules[ligne][colonne].recupererKits();
                    System.out.println("\n"+"Bravo! Vous venez de gagner un kit de déminage");
                }
                
              
            } else if ( choix == 2 && joueurCourant.NbKitsDeminage > 0) {
                //Si le joueur décide d'utiliser un kit (il est nécessaire d'en possèder au moins 1)
                Scanner sca = new Scanner(System.in);
                System.out.println("Veuillez choisir une ligne ");
                int ligne  = sca.nextInt() -1;  //Le joueur choisi sa ligne de jeu
                
                Scanner scc = new Scanner(System.in);
                System.out.println("Veuillez choisir une colone ");
                int colonne = scc.nextInt()-1;
                
                while ( ligne > 10 && ligne < 1) {
                    System.out.println(" Veuillez saisir une ligne valide ");
                    ligne = sca.nextInt()-1; //Si jamais il donne une mauavaise ligne 
                }
                
                while ( colonne > 20 && colonne < 1) {
                    System.out.println(" Veuillez saisir une colonne valide ");
                    colonne = scc.nextInt()-1; //Si jamais il donne une mauavaise colonne
                }
                
                
                grillePartie.desamorcerMines(ligne , colonne );
                //On supprime la mine sur la case si il y en a une, si il n'y en avait pas, le kits est quand meme perdu  
                joueurCourant.utiliserKits();
                System.out.println("Il vous reste "+ joueurCourant.NbKitsDeminage+" Kits");
                grillePartie.afficherGrilleSurConsole();
                
            }  else if ( choix == 3 ) {
                //Si le joueur décide de marquer d'un drapeau la présence d'une mine 
                Scanner sca = new Scanner(System.in);
                System.out.println("Veuillez choisir une ligne ");
                int ligne  = sca.nextInt() -1;  
                
                Scanner scc = new Scanner(System.in);
                System.out.println("Veuillez choisir une colone ");
                int colonne = scc.nextInt() -1;
                
                while ( ligne > 10 && ligne < 1) {
                    System.out.println(" veuillez saisir une ligne valide ");
                    ligne = sca.nextInt()-1; //Si jamais il donne une mauavaise ligne 
                }
                
                while ( colonne > 20 && colonne < 1) {
                    System.out.println(" veuillez saisir une colonne valide ");
                    colonne = scc.nextInt()-1; //Si jamais il donne une mauavaise colonne
                }
                
                if (grillePartie.cellules[ligne][colonne].drapeau == false) {
                    grillePartie.placerDrapeau(ligne,colonne);
                    //On marque d'un drapeau la case voulue
                } else {
                    System.out.println("Raté, il y a deja un drapeau ici");
                }
                grillePartie.afficherGrilleSurConsole();
            }
        } while ( grillePartie.etreGagnant(joueurCourant) == false && joueurCourant.NbVieRestante > 0); 
        
// tant que le  joueur n'a  pas gagné la partie on affiche le menu et on continue la partie 
        if ( joueurCourant.NbVieRestante < 1 ) {
            joueurCourant.ArreterChrono();
            System.out.println ("Vous n'avez plus de vies, la partie est finie ");
            
        } //termine automatiquement la partie pour le joueur si il n'a plus de vie
        
        if (grillePartie.etreGagnant(joueurCourant) == true ) {
            // il faut qu'on arrete le chrono + gestion des scores
            joueurCourant.ArreterChrono();
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

