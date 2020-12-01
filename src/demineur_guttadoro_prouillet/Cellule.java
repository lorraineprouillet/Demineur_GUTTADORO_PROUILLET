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
public class Cellule {


    //Attributs
    
    boolean Kits;
    boolean Mines;
    int mines_en_contact;
    boolean visible;
    

    //Constructeur
    public Cellule( ) { // initialisation de la cellule sans kits ni mines 
        
        Kits = false;
        Mines=false;
        mines_en_contact = 0 ;
        visible = false;
    }
    
    public boolean presenceKits () {
        if ( Kits == true ) {
            return true;
        } else {
            return false;
        }
    }
    
    public boolean presenceMines () {
        if ( Mines == true ) {
            return true;
        } else {
            return false;
        }
    }
       
    public boolean recupererKits () {
        //On tombe sur un kit et désire le récupérer
        if ( Kits == true ) { //S'il y en a un sur la case, booléen vrai
            Kits=false;  //On l'enlève et le booléen devient faux
            return true; // Renvoie vrai, il a bien était retiré
        } else {
            return false; //Aucun kits présent , renvoie faux.
        }
    }
        
    public boolean rendrevisible () { 
        if ( visible = true ) {
            return false;
        } else {
            return true;
        }
        
    }
}

   