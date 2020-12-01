/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package demineur_guttadoro_prouillet;

/**
 *
 * @author Rosanna Guttadoro
 */
public class Grille {
    
    Cellule[][] cellules = new Cellule[20][10]; //on génère notre grille en choisissant une taille 
    
    public Grille () {
        for (int i = 0; i < 6; i++) {
            for (int j = 0; j < 7; j++) {
                cellules[i][j] = new Cellule(); // initialise chaque cellules de notre grille avec objet cellule
            }
        }
    }
    
    public void afficherGrilleSurConcole () {
        // Pour l'affichage on parcours le tableau dans le sens inverse des lignes
        for ( int i=5 ; i>= 0 ; i--) {
            //En commencant par la ligne 5, puis 4 ect...
            for ( int j=0 ; j<=6 ; j++ ) {
               
                if  ( Cellules[i][j].jetonCourant == null ) {
                    if ( Cellules[i][j].trouNoir == true) {
                        System.out.print("T ");
                    // T corresponds à un trou noir
                    }else if ( Cellules[i][j].desintegrateur == true) {
                        System.out.print("D ");
                    // D corresponds a un désintégrateur
                    } else {
                        System.out.print("V ");
                    //V corresponds à  case vide
                    }
                } else {
                    
                    if (Cellules[i][j].jetonCourant.lireCouleur() == "rouge") {
                        System.out.print("R " );      
                    }
                    if (Cellules[i][j].jetonCourant.lireCouleur() == "jaune") {
                        System.out.print("J " );
                    }
                    
                 
                  // Si c'est aucune des précédentes cases, c'est donc forcément un jeton
                  // jetonCourant est de type jeton et un jeton a pour attribut une couleur
                } //(On lit sa couleur est affiche R ou J en fonction)
                if (j==6) {
                      System.out.print("\n");
                }
            }
        }
        
    }
        
        public void initialiser_mines_en_contact () { 
        for (int i=1;i<5;i++)
        {
            for(int j=1;j<5;j++)
            {
                if(cellules[i-1][j-1].presenceMines()==true) {
                    cellules[i][j].mines_en_contact++;
                }
                if(cellules[i][j-1].presenceMines()==true) { 
                    cellules[i][j].mines_en_contact++;
                }
   
                if(cellules[i][j+1].presenceMines()==true ) {
                    cellules[i][j].mines_en_contact++;
                }
                if(cellules[i+1][j-1].presenceMines()==true){
                    cellules[i][j].mines_en_contact++;
                }
                if(cellules[i-1][j].presenceMines()==true){
                    cellules[i][j].mines_en_contact++;
                }
                if(cellules[i+1][j].presenceMines()==true){
                    cellules[i][j].mines_en_contact++;
                }
                if(cellules[i+1][j+1].presenceMines()==true){
                    cellules[i][j].mines_en_contact++;
                }
                if(cellules[i-1][j+1].presenceMines()==true){
                    cellules[i][j].mines_en_contact++;
                }
                
            }
        }
    }
        
        
        
}