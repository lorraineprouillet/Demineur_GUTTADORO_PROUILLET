/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
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
    Joueur Joueur1 = new  Joueur(sc.nextLine());
    
    
       
        do { // demande au joueur de choisir ce qu'il veut faire
           
            Scanner scs = new Scanner(System.in);
            
            System.out.print("Que voulez vous faire ? \n"+"1) Cliquer sur une case \n"+"2) utiliser un kit de déminage - pas possible actuellement  \n"+"3) définir bombe présumée - pas possible actuellement \n");
            int choix = scs.nextInt();
            if  ( choix != 1 ) { // pour l'instant on se concentre sur la fonctionnalité du choix 1 uniquement 
                System.out.println("saisissez un choix valide");
                choix = scs.nextInt();
                // si le choix n'est pas valide il doit le re saisir 
                
            } else {
                
                Scanner sca = new Scanner(System.in);
                System.out.println("Veuillez choisir une ligne ");
                int ligne  = sca.nextInt() ;  //Le joueur choisi sa ligne de jeu
                
                Scanner scc = new Scanner(System.in);
                System.out.println("Veuillez choisir une colone ");
                int colonne = scc.nextInt();
                
                while ( ligne > 10 && ligne < 1) {
                    System.out.println(" veuillez saisir une ligne valide ");
                    ligne = sca.nextInt(); //Si jamais il donne une mauavaise ligne 
                }
                
                while ( colonne > 20 && colonne < 1) {
                    System.out.println(" veuillez saisir une colonne valide ");
                    colonne = scc.nextInt(); //Si jamais il donne une mauavaise colonne
                }
                
                
                
                //On dévoile alors la case voulue 
                while (grillePartie.rendreVisibleCellule( ligne , colonne ) == false ) {
                    System.out.println(" la case est déjà dévoilée, saisissez en une autre ");
                    //Si la case a déjà été dévoilée il faut en saisir une autre 
                    ligne = sca.nextInt(); 
                    colonne = scc.nextInt();
                    grillePartie.rendreVisibleCellule(ligne , colonne );
                }
                
                grillePartie.afficherGrilleSurConsole(); //On affiche aprés avoir effectué l'action
              
            } 
            
        } while ( grillePartie.etreGagnant(joueurCourant) == false && joueurCourant.NbVieRestante > 0); 
        
// tant que le  joueur n'a  pas gagné la partie on affiche le menu et on continue la partie 
        if ( joueurCourant.NbVieRestante < 1 ) {
            System.out.println (" vous n'avez plus de vies la partie est fini ");
        } //termine automatiquement la partie pour le joueur si il n'a plus de vie
        
        if (grillePartie.etreGagnant(joueurCourant) == true ) {
            // il faut qu'on arrete le chrono
            System.out.println("Fin de la partie"); //
            
        }   
     
    }
    


public void initialiserPartie() {
    
    grillePartie.viderGrille(); // on vide la grille a chaque début de partie ( cases invisbles et pas de kits et de bombes ) 
    
    // on place les mines et les kits de facon aléatoire dans la grille : 
    for(int i=0;i<50;i++) {
        int x=(int)(Math.random()*((9-1)));
        int y=(int)(Math.random()*((19-1)));
        grillePartie.placerMines(x,y);
    } //placement aléatoire des mines en fonction d'un x et y aléatoires

    for(int j=0; j<10;j++) {
        int x=(int)(Math.random()*((9-1)));
        int y=(int)(Math.random()*((19-1)));
        grillePartie.placerKits(x,y);

    }
    
}

}

