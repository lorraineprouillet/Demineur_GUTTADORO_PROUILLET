/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package demineur_guttadoro_prouillet;

import javax.management.timer.Timer;

/**
 *
 * @author Rosanna Guttadoro
 */
public class Joueur {
    
    // def des attributs:
    String Nom; //Le joueur a un nom 
    Timer tempsJoueur = new Timer();
    Timer temps = new Timer();//Permettra de classer les joueurs selon leur temps
    int NbKitsDeminage ; // Nombre kits pouvant être utilisé
    int NbVieRestante; // Nombre de vie qui permet au joueur de ne pas perdre à la premiere mine trouvée
    int NbCasesDecouvertes; // Permettra de se situer dans le jeu
    
    public Joueur (String unNom) { //constructeur permettant d'initialiser les attributs
        Nom = unNom;
        NbVieRestante = 3;
        NbKitsDeminage = 0;
        NbCasesDecouvertes = 0;
        
    }
     public boolean DeclencherChrono () { // Cette fonction va permettre d'obtenir le temps mis
        temps.start();
        //.out.println(temps.start());
        return true;
       
    }
    
    public boolean ArreterChrono() { //Temps de fin du joueur
        temps.stop();
        //tempsJoueur = (temps.start()-temps.stop());
        return true;
    } 
    
    public void obtenirKits() {
        NbKitsDeminage++; //Incrémente le nb kits du joueur lorsqu'il en récupère
        
    }
    
    public boolean utiliserKits () {
        if (NbKitsDeminage>0) { //Si le joueur en possède il peut en utiliser un
            NbKitsDeminage--; //Son nombre est donc décrementé
            System.out.println("Kits bien utilisé, plus que "+ NbKitsDeminage+ " restants");
            return true; 
        }
        else { 
            return false;
        }
    }
    
    public void PerdreVie () {
        NbVieRestante--; //Le nombre de vie est décrémenté.
        if (NbVieRestante == 0) { //Si le score arrive à 0 le joueur n'a plus de vie
            System.out.println("Oups! Plus de vie!");
        }
    }
}

