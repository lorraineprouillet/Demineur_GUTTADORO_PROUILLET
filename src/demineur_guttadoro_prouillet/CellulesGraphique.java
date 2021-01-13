/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package demineur_guttadoro_prouillet;

import java.awt.Graphics;
import javax.swing.ImageIcon;
import javax.swing.JButton;

/**
 *
 * @author Rosanna Guttadoro
 */
public class CellulesGraphique extends JButton {
    Cellule celluleAssociee;
    ImageIcon img_visible = new javax.swing.ImageIcon(getClass().getResource("/images/CaseVisible.png"));
    ImageIcon img_invisible = new javax.swing.ImageIcon(getClass().getResource("/images/CaseInvisible.png"));
    ImageIcon img_drapeau = new javax.swing.ImageIcon(getClass().getResource("/images/CaseDrapeau.png"));
    ImageIcon img_bombe = new javax.swing.ImageIcon(getClass().getResource("/images/CaseBombe.png"));
    ImageIcon img_case1 = new javax.swing.ImageIcon(getClass().getResource("/images/Case1.png"));
    ImageIcon img_case2 = new javax.swing.ImageIcon(getClass().getResource("/images/Case2.png"));
    ImageIcon img_case3 = new javax.swing.ImageIcon(getClass().getResource("/images/Case3.png"));
    ImageIcon img_case4 = new javax.swing.ImageIcon(getClass().getResource("/images/Case4.png"));
    ImageIcon img_kits = new javax.swing.ImageIcon(getClass().getResource("/images/CaseKits.png"));
    
    public CellulesGraphique ( Cellule uneCellule ) {
        celluleAssociee = uneCellule;
        
        
    }
    
    @Override // permet de dessiner la cellule graphique 
    public void paintComponent(Graphics G ) {
        super.paintComponent(G);
        if (celluleAssociee.etrevisible() == true) {
                    
                    if (celluleAssociee.presenceMines() == true) {
                        setIcon(img_bombe);
                        
                        
                    } else if (celluleAssociee.presenceKits() == true) {
                        setIcon(img_kits);
                      
                    } else if (celluleAssociee.presenceMines() == false && celluleAssociee.presenceKits() == false) {
                        if (celluleAssociee.mines_en_contact == 1) {
                            setIcon(img_case1);
                        } else if (celluleAssociee.mines_en_contact == 2) {
                            setIcon(img_case2);
                        } else if (celluleAssociee.mines_en_contact == 3) {
                            setIcon(img_case3);
                        } else if (celluleAssociee.mines_en_contact == 4) {
                            setIcon(img_case4);
                        } else if ( celluleAssociee.mines_en_contact == 0 ) {
                            setIcon (img_visible );
                        }
//photo pour les autres cases!!
                        
                    }
        } else if (celluleAssociee.etrevisible() == false) {
                    if (celluleAssociee.drapeau == true) {
                        setIcon(img_drapeau) ;
                    } else {
                        setIcon(img_invisible);
                    }
                   

                }
    }     
}
