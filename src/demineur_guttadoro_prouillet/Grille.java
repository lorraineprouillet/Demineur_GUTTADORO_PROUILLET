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

    public Grille() {
        for (int i = 0; i < 21; i++) {
            for (int j = 0; j < 11; j++) {
                cellules[i][j] = new Cellule(); // initialise chaque cellules de notre grille avec objet cellule
            }
        }
    }
    
        
    public void initialiser_mines_en_contact () { 
        for (int i=0;i<10;i++) {
            for(int j=0;j<20;j++) {
                
            
                if ( cellules[i][j]==cellules[0][0]) {
                    cellules[i][j].mines_en_contact=0;
                }
                
                if ( cellules[i][j]==cellules[9][19]) {
                    cellules[i][j].mines_en_contact=0;
                }
                
                if ( cellules[i][j]==cellules[9][0]) {
                    cellules[i][j].mines_en_contact=0;
                }
                
                if ( cellules[i][j]==cellules[0][19]) {
                    cellules[i][j].mines_en_contact=0;
                }
                
                if ( cellules[i][j] == cellules [i][0]) {
                      
                    if (cellules[i][j + 1].presenceMines() == true) {
                        cellules[i][j].mines_en_contact++;
                    }

                    if (cellules[i - 1][j].presenceMines() == true) {
                        cellules[i][j].mines_en_contact++;
                    }
                    if (cellules[i + 1][j].presenceMines() == true) {
                        cellules[i][j].mines_en_contact++;
                    }
                    if (cellules[i + 1][j + 1].presenceMines() == true) {
                        cellules[i][j].mines_en_contact++;
                    }
                    if (cellules[i - 1][j + 1].presenceMines() == true) {
                        cellules[i][j].mines_en_contact++;
                    }   
                    
                }
                
                if ( cellules[i][j]==cellules[0][j]) {
                     
                   
                    if (cellules[i][j - 1].presenceMines() == true) {
                        cellules[i][j].mines_en_contact++;
                    }

                    if (cellules[i][j + 1].presenceMines() == true) {
                        cellules[i][j].mines_en_contact++;
                    }
                    if (cellules[i + 1][j - 1].presenceMines() == true) {
                        cellules[i][j].mines_en_contact++;
                    }
                    
                    if (cellules[i + 1][j].presenceMines() == true) {
                        cellules[i][j].mines_en_contact++;
                    }
                    if (cellules[i + 1][j + 1].presenceMines() == true) {
                        cellules[i][j].mines_en_contact++;
                    }
                    
                }
                
                if ( cellules[i][j]==cellules[i][19] ) {
                    
                    if (cellules[i - 1][j - 1].presenceMines() == true) {
                        cellules[i][j].mines_en_contact++;
                    }
                    if (cellules[i][j - 1].presenceMines() == true) {
                        cellules[i][j].mines_en_contact++;
                    }
                    if (cellules[i + 1][j - 1].presenceMines() == true) {
                        cellules[i][j].mines_en_contact++;
                    }
                    if (cellules[i - 1][j].presenceMines() == true) {
                        cellules[i][j].mines_en_contact++;
                    }
                    if (cellules[i + 1][j].presenceMines() == true) {
                        cellules[i][j].mines_en_contact++;
                    }
             
                }
                
                if ( cellules [i][j]== cellules[9][j] ) {
                    
                    if (cellules[i - 1][j - 1].presenceMines() == true) {
                        cellules[i][j].mines_en_contact++;
                    }
                    if (cellules[i][j - 1].presenceMines() == true) {
                        cellules[i][j].mines_en_contact++;
                    }

                    if (cellules[i][j + 1].presenceMines() == true) {
                        cellules[i][j].mines_en_contact++;
                    }

                    if (cellules[i - 1][j].presenceMines() == true) {
                        cellules[i][j].mines_en_contact++;
                    }

                    if (cellules[i - 1][j + 1].presenceMines() == true) {
                        cellules[i][j].mines_en_contact++;
                    } 
                }
                
                else {
                    if (cellules[i - 1][j - 1].presenceMines() == true) {
                        cellules[i][j].mines_en_contact++;
                    }
                    if (cellules[i][j - 1].presenceMines() == true) {
                        cellules[i][j].mines_en_contact++;
                    }

                    if (cellules[i][j + 1].presenceMines() == true) {
                        cellules[i][j].mines_en_contact++;
                    }
                    if (cellules[i + 1][j - 1].presenceMines() == true) {
                        cellules[i][j].mines_en_contact++;
                    }
                    if (cellules[i - 1][j].presenceMines() == true) {
                        cellules[i][j].mines_en_contact++;
                    }
                    if (cellules[i + 1][j].presenceMines() == true) {
                        cellules[i][j].mines_en_contact++;
                    }
                    if (cellules[i + 1][j + 1].presenceMines() == true) {
                        cellules[i][j].mines_en_contact++;
                    }
                    if (cellules[i - 1][j + 1].presenceMines() == true) {
                        cellules[i][j].mines_en_contact++;
                    }
                }               

            }
        }
    }

    public void afficherGrilleSurConsole() {
        //Affichage des colonnes en haut de la matrice pour permettre une meilleure lecture
        System.out.println("\n" + "1 2 3 4 5 6 7 8 9 10");

        for (int i = 0; i < 21; i++) {
            for (int j = 0; j < 11; j++) {

                if (cellules[i][j].etrevisible() == true) {

                    if (cellules[i][j].presenceMines()) {
                        System.out.print("M ");
                        // M corresponds à une mine dans la case
                    } else if (cellules[i][j].Kits == true) {
                        System.out.print("D ");
                        // K corresponds a un kits de déminage
                    } else {
                        System.out.print(cellules[i][j].mines_en_contact);
                        //Cela correspondra à son nombre de mines en contact
                    }
                } else {
                    System.out.print("O ");
                    //On utilisera O pour une case qui n'est pas encore révélée

                }
                if (j == 9) {
                    System.out.print("\n");
                }
            }
        }

    }
}
