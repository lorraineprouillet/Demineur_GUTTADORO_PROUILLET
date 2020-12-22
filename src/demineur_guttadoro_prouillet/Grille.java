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

    Cellule[][] cellules = new Cellule[10][20]; //on génère notre grille en choisissant une taille 
    int nbcaserestantes;
    
    public Grille() {
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 20; j++) {
                cellules[i][j] = new Cellule(); // initialise chaque cellules de notre grille avec objet cellule
            }
        }
        nbcaserestantes = 200;
    }
    
    public void viderGrille ( ) {
        //Pour une nouvelle partie on souhaite vider la grille
        for ( int i=0 ; i < 10 ; i++ ) {
            //On parcours encore une fois toute la grille
            for ( int j=0 ; j<20; j++ ) {
                //Pour chaque cellule on la rend invisible, on supprime les ktis et les mines 
                cellules[i][j].visible = false;
                cellules[i][j].Kits = false;
                cellules[i][j].Mines = false;
                                       
            }
                       
        }       
    }
        
    public void initialiser_mines_en_contact () { 
        for (int i=0;i<10;i++) {
            for(int j=0;j<20;j++) {
                
            
                if ( cellules[i][j]==cellules[0][0]) {
                    cellules[i][j].mines_en_contact=0;
                    break;
                }
                
                if ( cellules[i][j]==cellules[9][19]) {
                    cellules[i][j].mines_en_contact=0;
                    break;
                }
                
                if ( cellules[i][j]==cellules[9][0]) {
                    cellules[i][j].mines_en_contact=0;
                    break;
                }
                
                if ( cellules[i][j]==cellules[0][19]) {
                    cellules[i][j].mines_en_contact=0;
                    break;
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
        System.out.println("\n" + "    1  2  3  4  5  6  7  8  9  10 11 12 13 14 15 16 17 18 19 20");

        for (int i = 0; i < 10; i++) { // affichage des lignes pour faciliter le jeu
            if (i==9) {
                System.out.print((i+1+"| ")); 
            } else {
                System.out.print((i+1+" | ")); //meilleure mise en page pour le 10
            }
            
            for (int j = 0; j < 20; j++) {

                if (cellules[i][j].etrevisible() == true) {
                    // si la cellule est visible on affiche sa caractèristiques
                    if (cellules[i][j].presenceMines()) {
                        System.out.print("M  ");
                        // M corresponds à une mine dans la case
                    } else if (cellules[i][j].presenceKits()) {
                        System.out.print("K  ");
                        // K corresponds a un kits de déminage
                    } else {
                        System.out.print(cellules[i][j].mines_en_contact+"  ");
                        //Cela correspondra à son nombre de mines en contact
                    }
                } else if (cellules[i][j].etrevisible() == false) {
                    System.out.print("-  ");
                    //On utilisera O pour une case qui n'est pas encore révélée

                }
                if (j == 19) {
                    System.out.print("\n");
                }
            }
        
        }

    }
    
    public boolean placerMines(int x, int y) {
        if (cellules[x][y].presenceMines()== false && cellules[x][y].presenceKits() == false ) {
            //Si l'action de placer la mine est faisable, aucunes mines ou kits présents
            cellules[x][y].Mines = true;
            return true;//L'action a été faite on renvoie vrai
           
        } else {
            return false; //Faux sinon
        }
    }
    
    public boolean placerKits(int x, int y) { //Meme principe que les mines
       if (cellules[x][y].presenceKits() == false && cellules[x][y].presenceMines() == false) {
           //Si l'action de placer le kit est faisable donc aucun kits ou mines deja présentes
           cellules[x][y].Kits= true; // on le place
           return true;//L'action a été faite on renvoie vrai
           
        } else {
           return false; //Faux sinon
        } 
    }
    
    public boolean rendreVisibleCellule(int x, int y) {
        if (cellules[x-1][y-1].etrevisible() == false) { // si la cellule n'sst pas deja visible
            // prise en compte du décalage avec le -1
            cellules[x-1][y-1].visible = true ; //la cellule est désormais visible
            nbcaserestantes--;
            return true;
        } else {
            return false ; // action impossible
        }
    }
    
    public boolean etreGagnant(Joueur Joueur1) {
        if (nbcaserestantes == 50) {
            return true; 
        } else {
            return false ;
        }
    }
}



