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
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        PanneauGrille.setBackground(new java.awt.Color(204, 204, 255));
        PanneauGrille.setAlignmentX(5.0F);
        PanneauGrille.setLayout(new java.awt.GridLayout(10, 20));

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
        PanneauInfo.add(LabelVie, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 200, -1, -1));

        LabelKits.setText("Nombre de kits :");
        PanneauInfo.add(LabelKits, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 260, -1, -1));
        PanneauInfo.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 500, -1, -1));

        BoutonUtiliserKit.setText("Utiliser un kit");
        PanneauInfo.add(BoutonUtiliserKit, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 320, -1, -1));

        BoutonDrapeau.setText("Placer un drapeau");
        PanneauInfo.add(BoutonDrapeau, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 380, -1, -1));

        jLabel1.setText("joueurcourant");
        PanneauInfo.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(49, 174, 80, 20));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(PanneauGrille, javax.swing.GroupLayout.PREFERRED_SIZE, 2600, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 26, Short.MAX_VALUE)
                .addComponent(PanneauInfo, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(PanneauGrille, javax.swing.GroupLayout.PREFERRED_SIZE, 1250, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(PanneauInfo, javax.swing.GroupLayout.PREFERRED_SIZE, 522, javax.swing.GroupLayout.PREFERRED_SIZE))
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
public void initialiserPartie() {
    
    grillePartie.viderGrille(); // on vide la grille a chaque début de partie ( cases invisbles et pas de kits et de bombes ) 
    
    // on place les mines et les kits de facon aléatoire dans la grille : 
    for(int i=0;i<=50;i++) { // un total de 50 bombes
        int x=(int)(Math.random()*((10))); // x maximal a 10 et y maximal a 20
        int y=(int)(Math.random()*((20)));
        grillePartie.placerMines(x,y);
    } //placement aléatoire des mines en fonction d'un x et y aléatoires

    for(int j=0; j<=10;j++) { //un total de 10 kits
        int x=(int)(Math.random()*((10)));
        int y=(int)(Math.random()*((20)));
        grillePartie.placerKits(x,y);
        
    }
    grillePartie.initialiser_mines_en_contact(); 
    String nomJ1 = FieldNom.getText();
    Joueur joueurCourant = new  Joueur(nomJ1);
    jLabel1.setText(nomJ1);
    

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
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel4;
    // End of variables declaration//GEN-END:variables
}
