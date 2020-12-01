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