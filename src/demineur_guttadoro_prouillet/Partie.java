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
    
}

public void initialiserPartie() {
    
    
}
}
