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
                int ligne  = sca.nextInt() ;  //Le joueur choisi sa colonne de jeu
                
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
                while (grillePartie.ajouterJetondansColonne(jetonCourant , colonne ) == false ) {
                    System.out.println(" la colonne est pleine, saisissez en une autre ");
                    //Si jamais cette colonne est remplie, on demande de changer
                    colonne = sca.nextInt();
                    grillePartie.ajouterJetondansColonne(jetonCourant , colonne );
                }
                grillePartie.afficherGrilleSurConsole(); //On affiche aprés avoir effectué l'action
                joueurCourant = JoueurSuivant(joueurCourant);
            } //Enfin on change de joueur et recommence ce déroulement
            
        } while ( grillePartie.etreGagnantePourJoueur(joueurCourant) == false ); 
// tant que aucun joueur n'a gagné la partie on affiche le menu et on continue les tours de jeu
        if (grillePartie.etreGagnantePourJoueur(joueurCourant) == true || grillePartie.etreRemplie()) {
            System.out.println("Fin de la partie"); //Si la grille est remplie il est temps d'arreter
            if (grillePartie.etreGagnantePourJoueur(joueurCourant) == true) {
                System.out.println("Gagné pour le joueur "+ joueurCourant.Nom);
              // on affiche le nom de la gagnante lorsqu'un des joueur a aligné 4 pions
            }
            
        }   
     
    }
    


public void initialiserPartie() {
    
    for(int i=0;i<50;i++) {
        int x=(int)(Math.random()*((9-1)));
        int y=(int)(Math.random()*((19-1)));
        grillePartie.placerMines(x,y);
    }

    for(int j=0; j<10;j++) {
        int x=(int)(Math.random()*((9-1)));
        int y=(int)(Math.random()*((19-1)));
        grillePartie.placerKits(x,y);

    }
    
}

}

