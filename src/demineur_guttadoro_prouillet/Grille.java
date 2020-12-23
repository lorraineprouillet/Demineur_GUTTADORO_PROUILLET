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
    int nbcaserestantes; //attribut qui permettra de gagner la partie
    
    public Grille() {
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 20; j++) {
                cellules[i][j] = new Cellule(); // initialise chaque cellules de notre grille avec un objet cellule
            }
        }
        nbcaserestantes = 200; //initialise le nombre total de case de la grille à 200
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
                //en analysant la structure de notre grille nous avons choisi de simplifier 
                //les cases des coins avec un affichage constant à 0
                if ( cellules[i][j]==cellules[0][0]) {
                    cellules[i][j].mines_en_contact=0;
                    break;
                } //coin sup gauche
                
                if ( cellules[i][j]==cellules[9][19]) {
                    cellules[i][j].mines_en_contact=0;
                    break;
                } // coin inf droit
                
                if ( cellules[i][j]==cellules[9][0]) {
                    cellules[i][j].mines_en_contact=0;
                    break;
                } //coin inf gauche
                
                if ( cellules[i][j]==cellules[0][19]) {
                    cellules[i][j].mines_en_contact=0;
                    break;
                } //coin sup droit
                
                
                if ( cellules[i][j] == cellules [i][0]) {
                    // on regarde maintenant les cellules des contours, ici a 1ere colonne gauche
                    //on ne regardera donc pas a gauche ni dans les diagonales gauches(hautes et basses)
                    if (cellules[i][j + 1].presenceMines() == true) {
                        cellules[i][j].mines_en_contact++;
                    } // si une mine est présente a sa droite on incrémente

                    if (cellules[i - 1][j].presenceMines() == true) {
                        cellules[i][j].mines_en_contact++;
                    } //si une mine est présente en dessous on incremente
                    if (cellules[i + 1][j].presenceMines() == true) {
                        cellules[i][j].mines_en_contact++;
                    } //au dessus
                    if (cellules[i + 1][j + 1].presenceMines() == true) {
                        cellules[i][j].mines_en_contact++;
                    } //diagonale inferieure a droite
                    if (cellules[i - 1][j + 1].presenceMines() == true) {
                        cellules[i][j].mines_en_contact++;
                    }  //diagonale superieure a droite
                    break;
                }
                
                if ( cellules[i][j]==cellules[0][j]) {
                     // meme raisonnement qu'avant, on observe le contour supérieur cad la 1ere ligne
                   //il sera inutile de vérifier en haut et les deux diagonales supérieures
                    if (cellules[i][j - 1].presenceMines() == true) {
                        cellules[i][j].mines_en_contact++;
                    } //gauche

                    if (cellules[i][j + 1].presenceMines() == true) {
                        cellules[i][j].mines_en_contact++;
                    } //droite
                    if (cellules[i + 1][j - 1].presenceMines() == true) {
                        cellules[i][j].mines_en_contact++;
                    } //diag inférieure gauche
                    
                    if (cellules[i + 1][j].presenceMines() == true) {
                        cellules[i][j].mines_en_contact++;
                    } //en dessous
                    if (cellules[i + 1][j + 1].presenceMines() == true) {
                        cellules[i][j].mines_en_contact++;
                    } // diag inferieure droite
                    break;
                }
                
                if ( cellules[i][j]==cellules[i][19] ) {
                    //encore une fois le meme fonctionnement mais avec le contour droit
                    // pas nécessaire de regarder a droite et les diagonales droites
                    
                    if (cellules[i - 1][j - 1].presenceMines() == true) {
                        cellules[i][j].mines_en_contact++;
                    } //diag sup gauche
                    if (cellules[i][j - 1].presenceMines() == true) {
                        cellules[i][j].mines_en_contact++;
                    } // gauche
                    if (cellules[i + 1][j - 1].presenceMines() == true) {
                        cellules[i][j].mines_en_contact++;
                    } // diag inf gauche
                    if (cellules[i - 1][j].presenceMines() == true) {
                        cellules[i][j].mines_en_contact++;
                    } // en dessous
                    if (cellules[i + 1][j].presenceMines() == true) {
                        cellules[i][j].mines_en_contact++;
                    } // au dessus
                    break;
                }
                
                if ( cellules [i][j]== cellules[9][j] ) {
                    //enfin , dernier contour inferieur//
                    // on ne regarde pas en dessous ni les digonales inferieures
                    if (cellules[i - 1][j - 1].presenceMines() == true) {
                        cellules[i][j].mines_en_contact++;
                    } // diag sup gauche
                    if (cellules[i][j - 1].presenceMines() == true) {
                        cellules[i][j].mines_en_contact++;
                    } // a gauche

                    if (cellules[i][j + 1].presenceMines() == true) {
                        cellules[i][j].mines_en_contact++;
                    } // a droite

                    if (cellules[i - 1][j].presenceMines() == true) {
                        cellules[i][j].mines_en_contact++;
                    } // au dessus

                    if (cellules[i - 1][j + 1].presenceMines() == true) {
                        cellules[i][j].mines_en_contact++;
                    } // diag superieure droite
                    break;
                }
                
                else { // le else verifie chaque case autour de la cellule voulue sans réstrictions
                    if (cellules[i - 1][j - 1].presenceMines() == true) {
                        cellules[i][j].mines_en_contact++;
                    } //diag sup gauche
                    if (cellules[i][j - 1].presenceMines() == true) {
                        cellules[i][j].mines_en_contact++;
                    } // gauche

                    if (cellules[i][j + 1].presenceMines() == true) {
                        cellules[i][j].mines_en_contact++;
                    } // droite
                    
                    if (cellules[i + 1][j - 1].presenceMines() == true) {
                        cellules[i][j].mines_en_contact++;
                    } // diag inf gauche
                    if (cellules[i - 1][j].presenceMines() == true) {
                        cellules[i][j].mines_en_contact++;
                        System.out.print("Une bombe remarquée");
                    } // en haut 
                    if (cellules[i + 1][j].presenceMines() == true) {
                        cellules[i][j].mines_en_contact++;
                    } // en dessous
                    if (cellules[i + 1][j + 1].presenceMines() == true) {
                        cellules[i][j].mines_en_contact++;
                    } // diag inf droite
                    if (cellules[i - 1][j + 1].presenceMines() == true) {
                        cellules[i][j].mines_en_contact++;
                    } // diag sup droite
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
                    if (cellules[i][j].presenceMines() == true) {
                        System.out.print("M  ");
                        // M corresponds à une mine dans la case
                    } else if (cellules[i][j].presenceKits() == true) {
                        System.out.print("K  ");
                        // K corresponds a un kits de déminage
                    } else if (cellules[i][j].presenceMines() == false && cellules[i][j].presenceKits() == false) {
                        System.out.print(cellules[i][j].mines_en_contact+"  ");
                        //Cela correspondra à son nombre de mines en contact
                    }
                } else if (cellules[i][j].etrevisible() == false) {
                    System.out.print("-  ");
                    //On utilisera - pour une case qui n'est pas encore révélée

                }
                if (j == 19) {
                    System.out.print("\n");
                }
            }
        
        }

    }
    
    public boolean placerMines(int x, int y) {
        if (cellules[x][y].presenceMines()== false && cellules[x][y].presenceKits() == false ) {
            //Si l'action de placer la mine est faisable, aucunes mines ou kits deja présents
            cellules[x][y].Mines = true; //On la place
            System.out.print("Bombe placée!");
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
    
    public boolean recupererKitsSurCase (int x, int y) {
        //On tombe sur un kit et désire le récupérer
        if ( cellules[x][y].Kits == true ) { //S'il y en a un sur la case, booléen vrai
            cellules[x][y].Kits = false;  //On l'enlève et le booléen devient faux
            return true; // Renvoie vrai, il a bien était retiré
        } else {
            return false; //Aucun kits présent , renvoie faux.
        }
    }
    
    public boolean desamorcerMines(int x, int y) {
        //On désire utiliser un kit sur une certaine case 
        if (cellules[x][y].presenceMines()== true ) { //Si il ya bien une mine sur la case
            cellules[x][y].Mines = false;  // On la désactive en false
            return true; // Action faite on renvoie vrai
        } else {
            return false; // Sinon renvoie false 
        }
    }
    public boolean etreGagnant(Joueur Joueur1) {
        if (nbcaserestantes == 50) { //Nous avons placé en tout 50 Mines sur 200 cases
            //Ainsi, lorsque le nombre de case restantes est à 50 on sait que toutes les cases non minés sont découvertes
            return true; //La partie est alors gagnée
        } else {
            return false ;
        }
    }
}



