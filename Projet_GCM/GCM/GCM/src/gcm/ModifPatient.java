
package gcm;

import java.sql.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;



public class ModifPatient extends javax.swing.JFrame {
    Connection conx = null;
    Statement stmt = null;
    ResultSet res = null;
    String num;
   
    
    public ModifPatient() {
        initComponents();
   
    }

   
public void modifPatient() throws SQLException{
       
         String nom1 =(nomrp.getText());
         String prenom1 =(prenpr.getText());
         //String date1 =(datepr.getDateFormatString());
         SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
         String date1 = sdf.format(datepr.getDate());
         String tel1 =(telpr.getText());
         String adr1 =(adrpr.getText());
         String mail1 =(mailpr.getText());
         String mala1 =(malapr.getText());
         String sang1 =(sangpr.getText());
              
          try {       
              int x= Integer.parseInt(tel1);
       
        Connect c= new Connect();
String req = " UPDATE `patient` SET `nom`= '"+nom1+"',`prenom`='"+prenom1+"',`adresse`='"+adr1+"',`mail`='"+mail1+"',`tel`='"+x+"',`date_naissance`='"+date1+"',`maladie_chronique`='"+mala1+"',`sang`='"+sang1+"' where numcnam='"+num+"'";
     
stmt=  c.conx.createStatement();
int reponse = JOptionPane.showConfirmDialog(null, "voulez vous modifier les informations de votre patient","", JOptionPane.YES_NO_OPTION);
 if(reponse == JOptionPane.YES_OPTION){
 
      int nb = stmt.executeUpdate(req);
    
         if(nb == 1)
          {
       JOptionPane.showMessageDialog(null, " modification est effectuée avec succée");
	new ModifPatient().setVisible(true);
	 dispose();
          }             
}

    }catch (SQLException e  ){JOptionPane.showMessageDialog(null, "Erreur de modification !!! ");}
    catch( NumberFormatException e) {JOptionPane.showMessageDialog(this, "Verifiez le tél de patient","Erreur de modification",JOptionPane.WARNING_MESSAGE);}
}
        
    public void recherche()
    {num= numcr.getText();
                                                                                                                                                                
    try {
        int num1=Integer.parseInt(num);
        Connect c;
        c = new Connect();
        stmt=  c.conx.createStatement();
String req = "select * from patient where numcnam='"+num1+"'";

ResultSet rs = stmt.executeQuery(req);

while (rs.next()) {
   nomrp.setText(rs.getString("nom"));
   prenpr.setText(rs.getString("prenom"));
   adrpr.setText(rs.getString("adresse"));
   mailpr.setText(rs.getString("mail"));
   String d =rs.getString("date_naissance");
   java.util.Date date = null;
            try {
                date = new SimpleDateFormat("yyyy-MM-dd").parse(d);
            } catch (ParseException ex) {
                Logger.getLogger(ModifPatient.class.getName()).log(Level.SEVERE, null, ex);
            }
   datepr.setDate(date);
   telpr.setText(rs.getString("tel"));
   malapr.setText(rs.getString("maladie_chronique"));
   sangpr.setText(rs.getString("sang"));}}

    
 catch (SQLException ex) {
        {JOptionPane.showMessageDialog(this, "Erreur !!! ","Erreur de Recherche",JOptionPane.ERROR_MESSAGE);}
       }
     catch( NumberFormatException e) {JOptionPane.showMessageDialog(this, "Verifiez le tél ou le num de CNAM de patient","Erreur d'ajout",JOptionPane.WARNING_MESSAGE);}
        
    }
   
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel6 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        decpr = new javax.swing.JLabel();
        accpr = new javax.swing.JLabel();
        telpr = new javax.swing.JTextField();
        numcr = new javax.swing.JTextField();
        nomrp = new javax.swing.JTextField();
        malapr = new javax.swing.JTextField();
        sangpr = new javax.swing.JTextField();
        btnmodifp = new javax.swing.JButton();
        btnrechp = new javax.swing.JButton();
        adrpr = new javax.swing.JTextField();
        prenpr = new javax.swing.JTextField();
        jLabel15 = new javax.swing.JLabel();
        mailpr = new javax.swing.JTextField();
        datepr = new com.toedter.calendar.JDateChooser();
        jLabel1 = new javax.swing.JLabel();
        jMenuBar1 = new javax.swing.JMenuBar();
        listpr = new javax.swing.JMenu();
        ajoutpr = new javax.swing.JMenu();
        suppr = new javax.swing.JMenu();
        modifpr = new javax.swing.JMenu();
        rechpr = new javax.swing.JMenu();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setLocation(new java.awt.Point(300, 90));
        setMinimumSize(new java.awt.Dimension(800, 600));
        setPreferredSize(new java.awt.Dimension(800, 600));
        setResizable(false);
        getContentPane().setLayout(null);

        jLabel6.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel6.setText("Nom:");
        getContentPane().add(jLabel6);
        jLabel6.setBounds(120, 290, 33, 30);

        jLabel8.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel8.setText("Date Naissance:");
        getContentPane().add(jLabel8);
        jLabel8.setBounds(60, 350, 100, 20);

        jLabel13.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel13.setText("Tel:");
        getContentPane().add(jLabel13);
        jLabel13.setBounds(130, 400, 40, 20);

        jLabel10.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel10.setText("Num Cnam:");
        getContentPane().add(jLabel10);
        jLabel10.setBounds(30, 180, 90, 17);

        jLabel9.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel9.setText("Maladies chronique:");
        getContentPane().add(jLabel9);
        jLabel9.setBounds(30, 440, 140, 30);

        jLabel12.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel12.setText("Sang:");
        getContentPane().add(jLabel12);
        jLabel12.setBounds(430, 450, 40, 14);

        jLabel11.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel11.setText("E-mail:");
        getContentPane().add(jLabel11);
        jLabel11.setBounds(420, 400, 60, 17);

        jLabel14.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel14.setText("Adresse:");
        getContentPane().add(jLabel14);
        jLabel14.setBounds(410, 340, 60, 30);

        jLabel7.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel7.setText("Prénom:");
        getContentPane().add(jLabel7);
        jLabel7.setBounds(410, 290, 60, 30);

        jLabel2.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Modifier Un Patient");
        getContentPane().add(jLabel2);
        jLabel2.setBounds(150, 70, 240, 28);

        decpr.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gcm/image/deccc1.png"))); // NOI18N
        decpr.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                decprMouseClicked(evt);
            }
        });
        getContentPane().add(decpr);
        decpr.setBounds(740, 70, 40, 30);

        accpr.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gcm/image/home1.png"))); // NOI18N
        accpr.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                accprMouseClicked(evt);
            }
        });
        getContentPane().add(accpr);
        accpr.setBounds(700, 70, 30, 30);

        telpr.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                telprActionPerformed(evt);
            }
        });
        getContentPane().add(telpr);
        telpr.setBounds(190, 390, 170, 30);
        getContentPane().add(numcr);
        numcr.setBounds(120, 170, 170, 30);
        getContentPane().add(nomrp);
        nomrp.setBounds(190, 290, 170, 30);
        getContentPane().add(malapr);
        malapr.setBounds(190, 440, 170, 30);
        getContentPane().add(sangpr);
        sangpr.setBounds(490, 440, 170, 30);

        btnmodifp.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        btnmodifp.setText("Modifier");
        btnmodifp.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnmodifpActionPerformed(evt);
            }
        });
        getContentPane().add(btnmodifp);
        btnmodifp.setBounds(660, 170, 110, 30);

        btnrechp.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        btnrechp.setText("Rechercher");
        btnrechp.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnrechpActionPerformed(evt);
            }
        });
        getContentPane().add(btnrechp);
        btnrechp.setBounds(310, 170, 110, 30);
        getContentPane().add(adrpr);
        adrpr.setBounds(490, 340, 170, 30);
        getContentPane().add(prenpr);
        prenpr.setBounds(490, 290, 170, 30);

        jLabel15.setForeground(new java.awt.Color(255, 255, 255));
        jLabel15.setText("- - -  - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -- - -- - - - - - -- - - - - - - - - - - - - - - - - - - - - - - - - - - - - -  - - - - - - - - - - - - - - - - - - - - - - - - - - - - - ");
        getContentPane().add(jLabel15);
        jLabel15.setBounds(20, 220, 800, 14);
        getContentPane().add(mailpr);
        mailpr.setBounds(490, 390, 170, 30);
        getContentPane().add(datepr);
        datepr.setBounds(190, 340, 170, 30);

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gcm/image/accpatient_1_1.png"))); // NOI18N
        getContentPane().add(jLabel1);
        jLabel1.setBounds(0, 0, 800, 600);

        listpr.setText("Liste");
        listpr.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                listprMouseClicked(evt);
            }
        });
        jMenuBar1.add(listpr);

        ajoutpr.setText("Ajouter");
        ajoutpr.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                ajoutprMouseClicked(evt);
            }
        });
        jMenuBar1.add(ajoutpr);

        suppr.setText("Supprimer");
        suppr.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                supprMouseClicked(evt);
            }
        });
        suppr.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                supprActionPerformed(evt);
            }
        });
        jMenuBar1.add(suppr);

        modifpr.setText("Modifier");
        modifpr.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                modifprMouseClicked(evt);
            }
        });
        jMenuBar1.add(modifpr);

        rechpr.setText("Rechercher");
        rechpr.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                rechprMouseClicked(evt);
            }
        });
        jMenuBar1.add(rechpr);

        setJMenuBar(jMenuBar1);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void telprActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_telprActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_telprActionPerformed

    private void btnmodifpActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnmodifpActionPerformed
    try {
        // TODO add your handling code here:
        modifPatient();
    } catch (SQLException ex) {
        Logger.getLogger(ModifPatient.class.getName()).log(Level.SEVERE, null, ex);
    }
    }//GEN-LAST:event_btnmodifpActionPerformed

    private void btnrechpActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnrechpActionPerformed
        // TODO add your handling code here:
        
        recherche();
    }//GEN-LAST:event_btnrechpActionPerformed

    private void supprActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_supprActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_supprActionPerformed

    private void listprMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_listprMouseClicked
    try {
        // TODO add your handling code here:
        new ListePatient().setVisible(true);
    } catch (SQLException ex) {
        Logger.getLogger(ModifPatient.class.getName()).log(Level.SEVERE, null, ex);
    }
        dispose();
    }//GEN-LAST:event_listprMouseClicked

    private void ajoutprMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ajoutprMouseClicked
        // TODO add your handling code here:
        new AjoutPatient().setVisible(true);
        dispose();
    }//GEN-LAST:event_ajoutprMouseClicked

    private void supprMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_supprMouseClicked
        // TODO add your handling code here:
           new SupprimerPatient().setVisible(true);
        dispose();
    }//GEN-LAST:event_supprMouseClicked

    private void modifprMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_modifprMouseClicked
        // TODO add your handling code here:
           new ModifPatient().setVisible(true);
        dispose();
    }//GEN-LAST:event_modifprMouseClicked

    private void rechprMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_rechprMouseClicked
        // TODO add your handling code here:
           new RecherchePatient().setVisible(true);
        dispose();
    }//GEN-LAST:event_rechprMouseClicked

    private void accprMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_accprMouseClicked
   
        new Accueil().setVisible(true);
   
        dispose();
    }//GEN-LAST:event_accprMouseClicked

    private void decprMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_decprMouseClicked
        // TODO add your handling code here:
           new Login().setVisible(true);
        dispose();
    }//GEN-LAST:event_decprMouseClicked

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
            java.util.logging.Logger.getLogger(ModifPatient.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ModifPatient.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ModifPatient.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ModifPatient.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ModifPatient().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel accpr;
    private javax.swing.JTextField adrpr;
    private javax.swing.JMenu ajoutpr;
    private javax.swing.JButton btnmodifp;
    private javax.swing.JButton btnrechp;
    private com.toedter.calendar.JDateChooser datepr;
    private javax.swing.JLabel decpr;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenu listpr;
    private javax.swing.JTextField mailpr;
    private javax.swing.JTextField malapr;
    private javax.swing.JMenu modifpr;
    private javax.swing.JTextField nomrp;
    private javax.swing.JTextField numcr;
    private javax.swing.JTextField prenpr;
    private javax.swing.JMenu rechpr;
    private javax.swing.JTextField sangpr;
    private javax.swing.JMenu suppr;
    private javax.swing.JTextField telpr;
    // End of variables declaration//GEN-END:variables
}
