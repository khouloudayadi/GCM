package gcm;

import java.sql.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

public class RecherchePatient extends javax.swing.JFrame {
 Connection conx = null;
    Statement stmt = null;
    ResultSet res = null;
    String num;
   
    public RecherchePatient() {
        initComponents();
    }
 public void recherche()
    {num= cnampat.getText();
                                                                                                                                                                
    try {
        int num1=Integer.parseInt(num);
        Connect c;
        c = new Connect();
        stmt=  c.conx.createStatement();
String req = "select * from patient where numcnam='"+num1+"'";

ResultSet rs = stmt.executeQuery(req);
//if(rs.next()){
while (rs.next()) {
   nompat.setText(rs.getString("nom"));
   prenompat.setText(rs.getString("prenom"));
   adrpat.setText(rs.getString("adresse"));
   mailpat.setText(rs.getString("mail"));
   String d =rs.getString("date_naissance");
   java.util.Date date = null;
            try {
                date = new SimpleDateFormat("yyyy-MM-dd").parse(d);
            } catch (ParseException ex) {
                Logger.getLogger(RecherchePatient.class.getName()).log(Level.SEVERE, null, ex);
            }
   datep.setDate(date);
   telpat.setText(rs.getString("tel"));
   malapat.setText(rs.getString("maladie_chronique"));
   sangpat.setText(rs.getString("sang"));}
    }
   // else {JOptionPane.showMessageDialog(this, "Patient n'existe pas ! ","Erreur de Recherche",JOptionPane.INFORMATION_MESSAGE);}
   // }
 catch (SQLException ex) {
        {JOptionPane.showMessageDialog(this, "Erreur !!! ","Erreur de Recherche",JOptionPane.ERROR_MESSAGE);}
       }
     catch( NumberFormatException e) {JOptionPane.showMessageDialog(this, "Verifiez le tél ou le num de CNAM de patient","Erreur d'ajout",JOptionPane.WARNING_MESSAGE);}
        
    }
   
  
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel3 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        cnampat = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        datep = new com.toedter.calendar.JDateChooser();
        jLabel17 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        sangpat = new javax.swing.JTextField();
        mailpat = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        adrpat = new javax.swing.JTextField();
        jLabel14 = new javax.swing.JLabel();
        prenompat = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        nompat = new javax.swing.JTextField();
        telpat = new javax.swing.JTextField();
        malapat = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jMenuBar1 = new javax.swing.JMenuBar();
        liste = new javax.swing.JMenu();
        ajout = new javax.swing.JMenu();
        modif = new javax.swing.JMenu();
        supp = new javax.swing.JMenu();
        rech = new javax.swing.JMenu();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setLocation(new java.awt.Point(300, 90));
        setMaximumSize(new java.awt.Dimension(800, 600));
        setMinimumSize(new java.awt.Dimension(800, 600));
        setPreferredSize(new java.awt.Dimension(803, 603));
        getContentPane().setLayout(null);

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gcm/image/deccc1.png"))); // NOI18N
        jLabel3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel3MouseClicked(evt);
            }
        });
        getContentPane().add(jLabel3);
        jLabel3.setBounds(740, 70, 40, 30);

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gcm/image/home1.png"))); // NOI18N
        jLabel2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel2MouseClicked(evt);
            }
        });
        getContentPane().add(jLabel2);
        jLabel2.setBounds(700, 70, 30, 29);

        jLabel4.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Rechercher Un Patient");
        getContentPane().add(jLabel4);
        jLabel4.setBounds(160, 77, 250, 30);

        jLabel19.setForeground(new java.awt.Color(255, 255, 255));
        jLabel19.setText("- - -  - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -- - -- - - - - - -- - - - - - - - - - - - - - - - - - - - - - - - - - - - - -  - - - - - - - - - - - - - - - - - - - - - - - - - - - - - ");
        getContentPane().add(jLabel19);
        jLabel19.setBounds(20, 220, 800, 14);

        jLabel10.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel10.setText("Num Cnam:");
        getContentPane().add(jLabel10);
        jLabel10.setBounds(30, 170, 90, 17);
        getContentPane().add(cnampat);
        cnampat.setBounds(120, 160, 170, 40);

        jLabel5.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel5.setText("Date naissance :");
        getContentPane().add(jLabel5);
        jLabel5.setBounds(60, 350, 120, 20);
        getContentPane().add(datep);
        datep.setBounds(190, 340, 180, 40);

        jLabel17.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel17.setText("Nom:");
        getContentPane().add(jLabel17);
        jLabel17.setBounds(120, 280, 33, 30);

        jLabel12.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel12.setText("Sang:");
        getContentPane().add(jLabel12);
        jLabel12.setBounds(440, 490, 40, 20);

        sangpat.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                sangpatActionPerformed(evt);
            }
        });
        getContentPane().add(sangpat);
        sangpat.setBounds(490, 480, 190, 40);
        getContentPane().add(mailpat);
        mailpat.setBounds(490, 410, 190, 40);

        jLabel11.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel11.setText("E-mail:");
        getContentPane().add(jLabel11);
        jLabel11.setBounds(430, 420, 60, 17);
        getContentPane().add(adrpat);
        adrpat.setBounds(490, 340, 190, 40);

        jLabel14.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel14.setText("Adresse:");
        getContentPane().add(jLabel14);
        jLabel14.setBounds(420, 350, 60, 30);
        getContentPane().add(prenompat);
        prenompat.setBounds(490, 270, 190, 40);

        jLabel7.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel7.setText("Prénom:");
        getContentPane().add(jLabel7);
        jLabel7.setBounds(420, 280, 60, 30);
        getContentPane().add(nompat);
        nompat.setBounds(190, 270, 180, 40);

        telpat.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                telpatActionPerformed(evt);
            }
        });
        getContentPane().add(telpat);
        telpat.setBounds(190, 410, 180, 40);
        getContentPane().add(malapat);
        malapat.setBounds(190, 480, 180, 40);

        jLabel9.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel9.setText("Maladies chronique:");
        getContentPane().add(jLabel9);
        jLabel9.setBounds(40, 490, 140, 30);

        jLabel13.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel13.setText("Tél:");
        getContentPane().add(jLabel13);
        jLabel13.setBounds(130, 420, 40, 20);

        jButton1.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jButton1.setText("Rechercher");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1);
        jButton1.setBounds(320, 160, 120, 40);

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gcm/image/accpatient_1_1.png"))); // NOI18N
        jLabel1.setText("jLabel1");
        getContentPane().add(jLabel1);
        jLabel1.setBounds(0, 4, 800, 600);

        liste.setText("Liste");
        liste.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                listeMouseClicked(evt);
            }
        });
        jMenuBar1.add(liste);

        ajout.setText("Ajouter");
        ajout.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                ajoutMouseClicked(evt);
            }
        });
        jMenuBar1.add(ajout);

        modif.setText("Modifier");
        modif.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                modifMouseClicked(evt);
            }
        });
        jMenuBar1.add(modif);

        supp.setText("Supprimer");
        supp.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                suppMouseClicked(evt);
            }
        });
        jMenuBar1.add(supp);

        rech.setText("Rechercher");
        rech.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                rechMouseClicked(evt);
            }
        });
        jMenuBar1.add(rech);

        setJMenuBar(jMenuBar1);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void sangpatActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_sangpatActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_sangpatActionPerformed

    private void telpatActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_telpatActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_telpatActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        recherche();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void rechMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_rechMouseClicked
        // TODO add your handling code here:
        
       new RecherchePatient().setVisible(true);
        dispose();
    }//GEN-LAST:event_rechMouseClicked

    private void suppMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_suppMouseClicked
        // TODO add your handling code here:
        new SupprimerPatient().setVisible(true);
        dispose();
        
    }//GEN-LAST:event_suppMouseClicked

    private void modifMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_modifMouseClicked
     
         new ModifPatient().setVisible(true);
        dispose();
    }//GEN-LAST:event_modifMouseClicked

    private void ajoutMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ajoutMouseClicked
        // TODO add your handling code here:
        new AjoutPatient().setVisible(true);
        dispose();
    }//GEN-LAST:event_ajoutMouseClicked

    private void listeMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_listeMouseClicked
        try {
            // TODO add your handling code here:
            new ListePatient().setVisible(true);
            dispose();
        } catch (SQLException ex) {
            Logger.getLogger(RecherchePatient.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_listeMouseClicked

    private void jLabel3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel3MouseClicked
        // TODO add your handling code here:
        new Login().setVisible(true);
        dispose();
    }//GEN-LAST:event_jLabel3MouseClicked

    private void jLabel2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel2MouseClicked
        // TODO add your handling code here:
        new Accueil().setVisible(true);
        dispose();
    }//GEN-LAST:event_jLabel2MouseClicked

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
            java.util.logging.Logger.getLogger(RecherchePatient.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(RecherchePatient.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(RecherchePatient.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(RecherchePatient.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new RecherchePatient().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField adrpat;
    private javax.swing.JMenu ajout;
    private javax.swing.JTextField cnampat;
    private com.toedter.calendar.JDateChooser datep;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenu liste;
    private javax.swing.JTextField mailpat;
    private javax.swing.JTextField malapat;
    private javax.swing.JMenu modif;
    private javax.swing.JTextField nompat;
    private javax.swing.JTextField prenompat;
    private javax.swing.JMenu rech;
    private javax.swing.JTextField sangpat;
    private javax.swing.JMenu supp;
    private javax.swing.JTextField telpat;
    // End of variables declaration//GEN-END:variables
}
