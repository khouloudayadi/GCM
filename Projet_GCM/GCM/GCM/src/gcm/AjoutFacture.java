
package gcm;

import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

public class AjoutFacture extends javax.swing.JFrame {
 
    
    Connection conx = null;
     Statement stmt = null;
    ResultSet res = null;
   String ref1,mont1,nom1,date1;
   
   
   public void ajoutFacture() throws SQLException{
     
        ref1 =(reffact.getText());
        mont1 =(montfact.getText());
        nom1 =(nomfact.getText());
         SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
         date1 = sdf.format(datefact.getDate());
      try {
           int r= Integer.parseInt(ref1);
           Float m = Float.parseFloat(mont1);
      
        if((nom1.equals(""))|| (date1.equals(""))|| (m == 0.0)||(r== 0))
        {
    
        JOptionPane.showMessageDialog(null, " veuillez saisir les champs obligatoires");
   }
        else {
 
        Connect c= new Connect();
        String req ="INSERT INTO `facture`(`referencefacture`, `montant`, `nompatient`, `date_paiement`) VALUES ('"+r+"','"+m+"','"+nom1+"','"+date1+"')";
         stmt=  c.conx.createStatement();

int nb = stmt.executeUpdate(req);   
    if(nb == 1)
    {

		int reponse = JOptionPane.showConfirmDialog(null, "ajout est effectuée avec succeé", 
			"", JOptionPane.YES_NO_OPTION);
 
		if(reponse == JOptionPane.YES_OPTION){
			new AjoutFacture().setVisible(true);
	                dispose();
		}}
    
    else
     JOptionPane.showMessageDialog(null, "Erreur !!! ");
        }
     }catch(SQLException e) {JOptionPane.showMessageDialog(this, "Facture existe déja ","Erreur d'ajout",JOptionPane.ERROR_MESSAGE);}
         catch( NumberFormatException e) {JOptionPane.showMessageDialog(this, "Verifiez le champs entreé","Erreur d'ajout",JOptionPane.WARNING_MESSAGE);}
    
    }
    public AjoutFacture() {
        initComponents();
    }

  
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel2 = new javax.swing.JLabel();
        decfact = new javax.swing.JLabel();
        homefact = new javax.swing.JLabel();
        montfact = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        reffact = new javax.swing.JTextField();
        ajouterfact = new javax.swing.JButton();
        jLabel8 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        nomfact = new javax.swing.JTextField();
        datefact = new com.toedter.calendar.JDateChooser();
        jLabel10 = new javax.swing.JLabel();
        jMenuBar1 = new javax.swing.JMenuBar();
        listfact = new javax.swing.JMenu();
        ajoutfact = new javax.swing.JMenu();
        supfact = new javax.swing.JMenu();
        modiffact = new javax.swing.JMenu();
        jMenu1 = new javax.swing.JMenu();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setLocation(new java.awt.Point(300, 90));
        setMinimumSize(new java.awt.Dimension(800, 600));
        setPreferredSize(new java.awt.Dimension(800, 600));
        getContentPane().setLayout(null);

        jLabel2.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Ajouter Un Facture");
        getContentPane().add(jLabel2);
        jLabel2.setBounds(130, 70, 220, 28);

        decfact.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gcm/image/deccc1.png"))); // NOI18N
        decfact.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                decfactMouseClicked(evt);
            }
        });
        getContentPane().add(decfact);
        decfact.setBounds(710, 70, 40, 40);

        homefact.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gcm/image/home1.png"))); // NOI18N
        homefact.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                homefactMouseClicked(evt);
            }
        });
        getContentPane().add(homefact);
        homefact.setBounds(670, 70, 40, 30);
        getContentPane().add(montfact);
        montfact.setBounds(320, 320, 200, 40);

        jLabel9.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel9.setText("Date de paiement :");
        getContentPane().add(jLabel9);
        jLabel9.setBounds(180, 410, 117, 17);

        jLabel6.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel6.setText("Réference facture :");
        getContentPane().add(jLabel6);
        jLabel6.setBounds(190, 210, 130, 17);
        getContentPane().add(reffact);
        reffact.setBounds(320, 200, 200, 40);

        ajouterfact.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        ajouterfact.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gcm/image/icon_ajout.png"))); // NOI18N
        ajouterfact.setText("Ajouter");
        ajouterfact.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ajouterfactActionPerformed(evt);
            }
        });
        getContentPane().add(ajouterfact);
        ajouterfact.setBounds(360, 470, 140, 40);

        jLabel8.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel8.setText("Nom du Patient :");
        getContentPane().add(jLabel8);
        jLabel8.setBounds(200, 270, 110, 17);

        jLabel7.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel7.setText("Montant :");
        getContentPane().add(jLabel7);
        jLabel7.setBounds(240, 330, 80, 17);
        getContentPane().add(nomfact);
        nomfact.setBounds(320, 260, 200, 40);
        getContentPane().add(datefact);
        datefact.setBounds(320, 390, 200, 40);

        jLabel10.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gcm/image/facture.jpg"))); // NOI18N
        getContentPane().add(jLabel10);
        jLabel10.setBounds(0, 0, 800, 600);

        listfact.setText("Liste");
        listfact.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                listfactMouseClicked(evt);
            }
        });
        jMenuBar1.add(listfact);

        ajoutfact.setText("Ajouter");
        ajoutfact.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                ajoutfactMouseClicked(evt);
            }
        });
        jMenuBar1.add(ajoutfact);

        supfact.setText("Supprimer");
        supfact.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                supfactMouseClicked(evt);
            }
        });
        jMenuBar1.add(supfact);

        modiffact.setText("Modifier");
        modiffact.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                modiffactMouseClicked(evt);
            }
        });
        jMenuBar1.add(modiffact);

        jMenu1.setText("Statistique");
        jMenu1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jMenu1MouseClicked(evt);
            }
        });
        jMenuBar1.add(jMenu1);

        setJMenuBar(jMenuBar1);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void ajouterfactActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ajouterfactActionPerformed
        try {
            ajoutFacture();
        } catch (SQLException ex) {
            Logger.getLogger(AjoutFacture.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }//GEN-LAST:event_ajouterfactActionPerformed

    private void homefactMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_homefactMouseClicked
        // TODO add your handling code here
        new Accueil().setVisible(true);
        dispose( );
    }//GEN-LAST:event_homefactMouseClicked

    private void listfactMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_listfactMouseClicked
        try {
            // TODO add your handling code here:
            new ListeFacture().setVisible(true);
        } catch (SQLException ex) {
            Logger.getLogger(AjoutFacture.class.getName()).log(Level.SEVERE, null, ex);
        }
        dispose( );
    }//GEN-LAST:event_listfactMouseClicked

    private void ajoutfactMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ajoutfactMouseClicked
        // TODO add your handling code here:
         new AjoutFacture().setVisible(true);
        dispose( );
    }//GEN-LAST:event_ajoutfactMouseClicked

    private void supfactMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_supfactMouseClicked
        // TODO add your handling code here:
         new SupprimerFacture().setVisible(true);
        dispose( );
    }//GEN-LAST:event_supfactMouseClicked

    private void modiffactMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_modiffactMouseClicked
        // TODO add your handling code here:
         new ModifiFacture().setVisible(true);
        dispose( );
    }//GEN-LAST:event_modiffactMouseClicked

    private void decfactMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_decfactMouseClicked
        // TODO add your handling code here:
         new Login().setVisible(true);
        dispose( );
    }//GEN-LAST:event_decfactMouseClicked

    private void jMenu1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jMenu1MouseClicked
        // TODO add your handling code here:
         new Statistique().setVisible(true);
        dispose();
    }//GEN-LAST:event_jMenu1MouseClicked

    
    public static void main(String args[]) {
  
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new AjoutFacture().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton ajouterfact;
    private javax.swing.JMenu ajoutfact;
    private com.toedter.calendar.JDateChooser datefact;
    private javax.swing.JLabel decfact;
    private javax.swing.JLabel homefact;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenu listfact;
    private javax.swing.JMenu modiffact;
    private javax.swing.JTextField montfact;
    private javax.swing.JTextField nomfact;
    private javax.swing.JTextField reffact;
    private javax.swing.JMenu supfact;
    // End of variables declaration//GEN-END:variables
}
