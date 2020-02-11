
package gcm;

import java.sql.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

public class SupprimerPatient extends javax.swing.JFrame {

  Connection conx = null;
    Statement stmt = null;
    ResultSet res = null;
     String num;
    public SupprimerPatient() {
        initComponents();
    }
    
    public void supprimerPaient() throws SQLException{
        
             num= nump.getText();
       
       
       int num1=Integer.parseInt(num);
     
        Connect c= new Connect();
String req = "DELETE FROM patient WHERE numcnam='"+num1+"'";
     
stmt=  c.conx.createStatement();
int reponse = JOptionPane.showConfirmDialog(null, "Voulez-vous supprimer ce patient","", JOptionPane.YES_NO_OPTION);
 if(reponse == JOptionPane.YES_OPTION){
     int nb = stmt.executeUpdate(req);
    
    if(nb == 1)
    {
           JOptionPane.showMessageDialog(null, " Suppression est effectuée avec succée");
	   new SupprimerPatient().setVisible(true);
	      dispose();
		}
       else
    {
        JOptionPane.showMessageDialog(null, "Erreur !!! ");}
    
    }  
   }
 public void rech()
            
     {
         num= nump.getText();
                                                                                                                                                                
    try {
        int num1=Integer.parseInt(num);
        Connect c;
        c = new Connect();
        stmt=  c.conx.createStatement();
String req = "select * from patient where numcnam='"+num1+"'";

ResultSet rs = stmt.executeQuery(req);

while (rs.next()) {
   nomp.setText(rs.getString("nom"));
   prep.setText(rs.getString("prenom"));
   adrp.setText(rs.getString("adresse"));
   mailp.setText(rs.getString("mail"));
   String d =rs.getString("date_naissance");
   java.util.Date date = null;
            try {
                date = new SimpleDateFormat("yyyy-MM-dd").parse(d);
            } catch (ParseException ex) {
                Logger.getLogger(SupprimerPatient.class.getName()).log(Level.SEVERE, null, ex);
            }
   datep.setDate(date);
   telp.setText(rs.getString("tel"));
   mala.setText(rs.getString("maladie_chronique"));
   sangp.setText(rs.getString("sang"));}
    }
   
 catch (SQLException ex) {
        {JOptionPane.showMessageDialog(this, "Erreur !!! ","Erreur de Recherche",JOptionPane.ERROR_MESSAGE);}
       }
     catch( NumberFormatException e) {JOptionPane.showMessageDialog(this, "Verifiez le tél ou le num de CNAM de patient","Erreur d'ajout",JOptionPane.WARNING_MESSAGE);}
        
    }
  
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel2 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        nomp = new javax.swing.JTextField();
        prep = new javax.swing.JTextField();
        mailp = new javax.swing.JTextField();
        telp = new javax.swing.JTextField();
        mala = new javax.swing.JTextField();
        sangp = new javax.swing.JTextField();
        adrp = new javax.swing.JTextField();
        nump = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        datep = new com.toedter.calendar.JDateChooser();
        jLabel1 = new javax.swing.JLabel();
        jMenuBar2 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenu2 = new javax.swing.JMenu();
        jMenu3 = new javax.swing.JMenu();
        jMenu4 = new javax.swing.JMenu();
        jMenu5 = new javax.swing.JMenu();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setLocation(new java.awt.Point(300, 90));
        setMinimumSize(new java.awt.Dimension(800, 600));
        setPreferredSize(new java.awt.Dimension(800, 600));
        getContentPane().setLayout(null);

        jLabel2.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Supprimer Un Patient");
        getContentPane().add(jLabel2);
        jLabel2.setBounds(140, 70, 250, 28);

        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gcm/image/home1.png"))); // NOI18N
        jLabel4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel4MouseClicked(evt);
            }
        });
        getContentPane().add(jLabel4);
        jLabel4.setBounds(710, 70, 30, 30);

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gcm/image/deccc1.png"))); // NOI18N
        jLabel3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel3MouseClicked(evt);
            }
        });
        getContentPane().add(jLabel3);
        jLabel3.setBounds(750, 70, 40, 30);

        jLabel5.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel5.setText("Num Cnam :");
        getContentPane().add(jLabel5);
        jLabel5.setBounds(60, 180, 80, 17);

        jLabel6.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel6.setText("Nom :");
        getContentPane().add(jLabel6);
        jLabel6.setBounds(130, 270, 70, 17);

        jLabel7.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel7.setText("Prenom :");
        getContentPane().add(jLabel7);
        jLabel7.setBounds(120, 330, 70, 17);

        jLabel8.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel8.setText("Date Naissance :");
        getContentPane().add(jLabel8);
        jLabel8.setBounds(70, 390, 110, 17);

        jLabel9.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel9.setText("Tél :");
        getContentPane().add(jLabel9);
        jLabel9.setBounds(520, 270, 50, 17);

        jLabel10.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel10.setText("Maladie chronique :");
        getContentPane().add(jLabel10);
        jLabel10.setBounds(430, 330, 140, 17);

        jLabel11.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel11.setText("Sang :");
        getContentPane().add(jLabel11);
        jLabel11.setBounds(510, 390, 60, 17);

        jLabel15.setForeground(new java.awt.Color(255, 255, 255));
        jLabel15.setText("- - -  - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -- - -- - - - - - -- - - - - - - - - - - - - - - - - - - - - - - - - - - - - -  - - - - - - - - - - - - - - - - - - - - - - - - - - - - - ");
        getContentPane().add(jLabel15);
        jLabel15.setBounds(20, 220, 800, 14);

        jLabel12.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel12.setText("E-mail :");
        getContentPane().add(jLabel12);
        jLabel12.setBounds(120, 460, 60, 17);

        jLabel13.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel13.setText("Adresse :");
        getContentPane().add(jLabel13);
        jLabel13.setBounds(490, 450, 80, 17);
        getContentPane().add(nomp);
        nomp.setBounds(200, 260, 160, 40);

        prep.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                prepActionPerformed(evt);
            }
        });
        getContentPane().add(prep);
        prep.setBounds(200, 320, 160, 40);
        getContentPane().add(mailp);
        mailp.setBounds(200, 450, 160, 40);
        getContentPane().add(telp);
        telp.setBounds(580, 260, 160, 40);

        mala.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                malaActionPerformed(evt);
            }
        });
        getContentPane().add(mala);
        mala.setBounds(580, 320, 160, 40);
        getContentPane().add(sangp);
        sangp.setBounds(580, 380, 160, 40);

        adrp.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                adrpActionPerformed(evt);
            }
        });
        getContentPane().add(adrp);
        adrp.setBounds(580, 450, 160, 40);

        nump.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                numpActionPerformed(evt);
            }
        });
        getContentPane().add(nump);
        nump.setBounds(150, 170, 130, 30);

        jButton1.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jButton1.setText("Rechercher");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1);
        jButton1.setBounds(320, 170, 110, 30);

        jButton2.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jButton2.setText("Supprimer");
        jButton2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton2MouseClicked(evt);
            }
        });
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton2);
        jButton2.setBounds(630, 170, 110, 30);
        getContentPane().add(datep);
        datep.setBounds(200, 380, 160, 40);

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gcm/image/accpatient_1_1.png"))); // NOI18N
        getContentPane().add(jLabel1);
        jLabel1.setBounds(0, 0, 800, 600);

        jMenu1.setText("Liste");
        jMenu1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jMenu1MouseClicked(evt);
            }
        });
        jMenuBar2.add(jMenu1);

        jMenu2.setText("Ajouter");
        jMenu2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jMenu2MouseClicked(evt);
            }
        });
        jMenuBar2.add(jMenu2);

        jMenu3.setText("Supprimer");
        jMenu3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jMenu3MouseClicked(evt);
            }
        });
        jMenuBar2.add(jMenu3);

        jMenu4.setText("Modifier");
        jMenu4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jMenu4MouseClicked(evt);
            }
        });
        jMenuBar2.add(jMenu4);

        jMenu5.setText("Rechercher");
        jMenu5.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jMenu5MouseClicked(evt);
            }
        });
        jMenuBar2.add(jMenu5);

        setJMenuBar(jMenuBar2);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void adrpActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_adrpActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_adrpActionPerformed

    private void numpActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_numpActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_numpActionPerformed

    private void prepActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_prepActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_prepActionPerformed

    private void malaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_malaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_malaActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        rech();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jMenu1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jMenu1MouseClicked
        try {
            // TODO add your handling code here:

            new ListePatient().setVisible(true);
        } catch (SQLException ex) {
            Logger.getLogger(SupprimerPatient.class.getName()).log(Level.SEVERE, null, ex);
        }
        dispose();
    }//GEN-LAST:event_jMenu1MouseClicked

    private void jMenu2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jMenu2MouseClicked
        // TODO add your handling code here:
        
         new AjoutPatient().setVisible(true);
        dispose();
    }//GEN-LAST:event_jMenu2MouseClicked

    private void jMenu3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jMenu3MouseClicked
        // TODO add your handling code here:
        
         new SupprimerPatient().setVisible(true);
        dispose();
    }//GEN-LAST:event_jMenu3MouseClicked

    private void jMenu4MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jMenu4MouseClicked
        // TODO add your handling code here:
        
         new ModifPatient().setVisible(true);
        dispose();
    }//GEN-LAST:event_jMenu4MouseClicked

    private void jMenu5MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jMenu5MouseClicked
        // TODO add your handling code here:
         new RecherchePatient().setVisible(true);
        dispose();
    }//GEN-LAST:event_jMenu5MouseClicked

    private void jLabel4MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel4MouseClicked
        // TODO add your handling code here:
        
         new Accueil().setVisible(true);
        dispose();
    }//GEN-LAST:event_jLabel4MouseClicked

    private void jLabel3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel3MouseClicked
        // TODO add your handling code here:
         new Login().setVisible(true);
        dispose();
    }//GEN-LAST:event_jLabel3MouseClicked

    private void jButton2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton2MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton2MouseClicked

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
      try {
          // TODO add your handling code here:

          supprimerPaient();
      } catch (SQLException ex) {
          Logger.getLogger(SupprimerPatient.class.getName()).log(Level.SEVERE, null, ex);
      }
    }//GEN-LAST:event_jButton2ActionPerformed

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
            java.util.logging.Logger.getLogger(SupprimerPatient.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(SupprimerPatient.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(SupprimerPatient.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(SupprimerPatient.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new SupprimerPatient().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField adrp;
    private com.toedter.calendar.JDateChooser datep;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenu jMenu3;
    private javax.swing.JMenu jMenu4;
    private javax.swing.JMenu jMenu5;
    private javax.swing.JMenuBar jMenuBar2;
    private javax.swing.JTextField mailp;
    private javax.swing.JTextField mala;
    private javax.swing.JTextField nomp;
    private javax.swing.JTextField nump;
    private javax.swing.JTextField prep;
    private javax.swing.JTextField sangp;
    private javax.swing.JTextField telp;
    // End of variables declaration//GEN-END:variables
}
