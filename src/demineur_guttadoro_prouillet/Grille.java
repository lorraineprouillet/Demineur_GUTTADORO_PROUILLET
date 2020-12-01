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
        for (int i = 0; i < 21; i++) {
            for (int j = 0; j < 11; j++) {
                cellules[i][j] = new Cellule(); // initialise chaque cellules de notre grille avec objet cellule
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
        
   public void  afficherGrilleSurConsole ( ) {
        //Affichage des colonnes en haut de la matrice pour permettre une meilleure lecture
        System.out.println("\n" +"1 2 3 4 5 6 7 8 9 10");
        
        for ( int i=20 ; i>= 0 ; i--) {
            
            for ( int j=0 ; j<=20 ; j++ ) {
               
                if  ( cellules[i][j].j == null ) {
                    if ( cellules[i][j].trouNoir == true) {
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