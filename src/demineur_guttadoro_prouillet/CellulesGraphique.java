/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package demineur_guttadoro_prouillet;

import javax.swing.JButton;

/**
 *
 * @author Rosanna Guttadoro
 */
public class CellulesGraphique extends JButton {
    Cellule celluleAssociee;
    
    public CellulesGraphique ( Cellule uneCellule ) {
        celluleAssociee = uneCellule;
        
        
    }
}
