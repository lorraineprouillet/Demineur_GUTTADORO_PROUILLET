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
public class PanneauGraphique extends javax.swing.JFrame {
    Joueur joueurCourant;
    Joueur[] listeJoueursGagnants;
    Grille grillePartie = new Grille();
    
    /**
     * Creates new form PanneauGraphique
     */
    public PanneauGraphique() {
        initComponents();
        PanneauGrille.setVisible(false); 
        
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 20; j++) {
                CellulesGraphique cellGraph = new CellulesGraphique(grillePartie.cellules[i][j]);
                PanneauGrille.add(cellGraph);
            }
        }
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        PanneauGrille = new javax.swing.JPanel();
        PanneauInfo = new javax.swing.JPanel();
        LabelNom = new javax.swing.JLabel();
        FieldNom = new javax.swing.JTextField();
        BoutonStart = new javax.swing.JButton();
        LabelVie = new javax.swing.JLabel();
        LabelKits = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        BoutonUtiliserKit = new javax.swing.JButton();
        BoutonDrapeau = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        PanneauGrille.setBackground(new java.awt.Color(204, 204, 255));
        PanneauGrille.setAlignmentX(5.0F);
        PanneauGrille.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        PanneauInfo.setBackground(new java.awt.Color(255, 204, 153));
        PanneauInfo.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        LabelNom.setText("Nom Joueur : ");
        PanneauInfo.add(LabelNom, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 50, -1, -1));

        FieldNom.setText(" ");
        FieldNom.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                FieldNomActionPerformed(evt);
            }
        });
        PanneauInfo.add(FieldNom, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 70, 130, -1));

        BoutonStart.setText("Start");
        BoutonStart.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BoutonStartActionPerformed(evt);
            }
        });
        PanneauInfo.add(BoutonStart, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 120, -1, -1));

        LabelVie.setText("Nombre de vie restantes :");
        PanneauInfo.add(LabelVie, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 280, -1, -1));

        LabelKits.setText("Nombre de kits :");
        PanneauInfo.add(LabelKits, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 390, -1, -1));
        PanneauInfo.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 500, -1, -1));

        BoutonUtiliserKit.setText("Utiliser un kit");
        PanneauInfo.add(BoutonUtiliserKit, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 450, -1, -1));

        BoutonDrapeau.setText("Placer un drapeau");
        PanneauInfo.add(BoutonDrapeau, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 490, -1, -1));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(PanneauGrille, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 26, Short.MAX_VALUE)
                .addComponent(PanneauInfo, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(PanneauGrille, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(PanneauInfo, javax.swing.GroupLayout.PREFERRED_SIZE, 664, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void FieldNomActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_FieldNomActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_FieldNomActionPerformed

    private void BoutonStartActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BoutonStartActionPerformed
        PanneauGrille.setVisible(true);
        
    }//GEN-LAST:event_BoutonStartActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(PanneauGraphique.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(PanneauGraphique.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(PanneauGraphique.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(PanneauGraphique.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new PanneauGraphique().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BoutonDrapeau;
    private javax.swing.JButton BoutonStart;
    private javax.swing.JButton BoutonUtiliserKit;
    private javax.swing.JTextField FieldNom;
    private javax.swing.JLabel LabelKits;
    private javax.swing.JLabel LabelNom;
    private javax.swing.JLabel LabelVie;
    private javax.swing.JPanel PanneauGrille;
    private javax.swing.JPanel PanneauInfo;
    private javax.swing.JLabel jLabel4;
    // End of variables declaration//GEN-END:variables
}
