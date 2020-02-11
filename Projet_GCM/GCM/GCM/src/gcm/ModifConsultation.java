
package gcm;

import java.sql.*;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;


public class ModifConsultation extends javax.swing.JFrame {

     Connection conx = null;
    Statement stmt = null;
    ResultSet res = null;
    String num;
    public ModifConsultation() {
        initComponents();
    }
public void modifConsultation() throws SQLException{
       
         SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
         String date1 = sdf.format(datecons.getDate());
         String nom1 =(nomcons.getText());
         String ana1 =(anal.getText());
         String pres1 =(pres.getText());
         String obser =(observ.getText());
        // num= numcons.getText();    
          try {       
              int x= Integer.parseInt(num);
       
        Connect c= new Connect();
String req = "UPDATE `consultation` SET `nom_maladie`= '"+nom1+"',`prescription_medicale`='"+pres1+"',`observation`='"+obser+"',`analyse`='"+ana1+"',`date_consultation`='"+date1+"' where numero_cnam='"+num+"'";
     
stmt=  c.conx.createStatement();
int reponse = JOptionPane.showConfirmDialog(null, "voulez vous modifier les informations de votre consultation ?","", JOptionPane.YES_NO_OPTION);
 if(reponse == JOptionPane.YES_OPTION){
 
      int nb = stmt.executeUpdate(req);
    
         if(nb == 1)
          {
       JOptionPane.showMessageDialog(null, " modification est effectuée avec succée");
	new ModifConsultation().setVisible(true);
	 dispose();
          }             
}

    }catch (SQLException e  )/*{JOptionPane.showMessageDialog(null, "Erreur de modification !!! ");}*/{e.printStackTrace();}
    catch( NumberFormatException e) {JOptionPane.showMessageDialog(this, "Verifiez le Num CNAM de patient","Erreur de modification",JOptionPane.WARNING_MESSAGE);}
}
        
    public void recherche()
    {num= numcons.getText();
                                                                                                                                                                
    try {
        int num1=Integer.parseInt(num);
        Connect c;
        c = new Connect();
        stmt=  c.conx.createStatement();
String req = "select * from consultation where numero_cnam='"+num1+"'";

ResultSet rs = stmt.executeQuery(req);


       
while (rs.next()) {
   nomcons.setText(rs.getString("nom_maladie"));
   anal.setText(rs.getString("analyse"));
   pres.setText(rs.getString("prescription_medicale"));
   observ.setText(rs.getString("observation"));
   String d =rs.getString("date_consultation");
   java.util.Date date = null;
            try {
                date = new SimpleDateFormat("yyyy-MM-dd").parse(d);
            } catch (ParseException ex) {
                Logger.getLogger(ModifConsultation.class.getName()).log(Level.SEVERE, null, ex);
            }
   datecons.setDate(date);
   
 }
 }
 catch (SQLException ex) {
        {JOptionPane.showMessageDialog(this, "Erreur !!! ","Erreur de Recherche",JOptionPane.ERROR_MESSAGE);}
       }
     catch( NumberFormatException e) {JOptionPane.showMessageDialog(this, "Verifiez  le num de CNAM de patient","Erreur d'ajout",JOptionPane.WARNING_MESSAGE);}
        
    }

    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        homecons = new javax.swing.JLabel();
        deccons = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        numcons = new javax.swing.JTextField();
        btnrech = new javax.swing.JButton();
        jLabel8 = new javax.swing.JLabel();
        btnmodif = new javax.swing.JButton();
        anal = new javax.swing.JTextField();
        jLabel13 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        nomcons = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        pres = new javax.swing.JTextArea();
        jLabel11 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        observ = new javax.swing.JTextArea();
        jLabel19 = new javax.swing.JLabel();
        datecons = new com.toedter.calendar.JDateChooser();
        jLabel1 = new javax.swing.JLabel();
        jMenuBar1 = new javax.swing.JMenuBar();
        listecons = new javax.swing.JMenu();
        ajoutcons = new javax.swing.JMenu();
        supcons = new javax.swing.JMenu();
        modifcons = new javax.swing.JMenu();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setLocation(new java.awt.Point(300, 90));
        setMinimumSize(new java.awt.Dimension(800, 600));
        setResizable(false);
        getContentPane().setLayout(null);

        homecons.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gcm/image/home1.png"))); // NOI18N
        homecons.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                homeconsMouseClicked(evt);
            }
        });
        getContentPane().add(homecons);
        homecons.setBounds(700, 60, 30, 40);

        deccons.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gcm/image/deccc1.png"))); // NOI18N
        deccons.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                decconsMouseClicked(evt);
            }
        });
        getContentPane().add(deccons);
        deccons.setBounds(740, 60, 40, 40);

        jLabel2.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Modifier Une Consultation");
        getContentPane().add(jLabel2);
        jLabel2.setBounds(140, 67, 280, 40);

        numcons.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                numconsActionPerformed(evt);
            }
        });
        getContentPane().add(numcons);
        numcons.setBounds(170, 150, 90, 30);

        btnrech.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        btnrech.setText("Rechercher");
        btnrech.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnrechActionPerformed(evt);
            }
        });
        getContentPane().add(btnrech);
        btnrech.setBounds(270, 150, 130, 30);

        jLabel8.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel8.setText("Num Cnam:");
        getContentPane().add(jLabel8);
        jLabel8.setBounds(80, 150, 100, 30);

        btnmodif.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        btnmodif.setText("Modifier");
        btnmodif.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnmodifActionPerformed(evt);
            }
        });
        getContentPane().add(btnmodif);
        btnmodif.setBounds(590, 150, 130, 30);
        getContentPane().add(anal);
        anal.setBounds(510, 310, 170, 30);

        jLabel13.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel13.setText("Analyse:");
        getContentPane().add(jLabel13);
        jLabel13.setBounds(440, 310, 70, 20);

        jLabel7.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel7.setText("Date consultation:");
        getContentPane().add(jLabel7);
        jLabel7.setBounds(40, 260, 160, 30);
        getContentPane().add(nomcons);
        nomcons.setBounds(170, 310, 170, 30);

        jLabel6.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel6.setText("Nom Maladie:");
        getContentPane().add(jLabel6);
        jLabel6.setBounds(70, 310, 130, 30);

        jLabel14.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel14.setText("Perscription:");
        getContentPane().add(jLabel14);
        jLabel14.setBounds(80, 370, 80, 30);

        pres.setColumns(20);
        pres.setRows(5);
        jScrollPane2.setViewportView(pres);

        getContentPane().add(jScrollPane2);
        jScrollPane2.setBounds(170, 380, 166, 90);

        jLabel11.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel11.setText("Observation: ");
        getContentPane().add(jLabel11);
        jLabel11.setBounds(420, 380, 90, 17);

        observ.setColumns(20);
        observ.setRows(5);
        jScrollPane1.setViewportView(observ);

        getContentPane().add(jScrollPane1);
        jScrollPane1.setBounds(510, 380, 166, 90);

        jLabel19.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel19.setForeground(new java.awt.Color(255, 255, 255));
        jLabel19.setText("- - -  - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -- - -- - - - - - -- - - - - - - - - - - - - - - - - - - - - - - - - - - - - -  - - - - - - - - - - - - - - - - - - - - - - - - - - - - - ");
        getContentPane().add(jLabel19);
        jLabel19.setBounds(20, 210, 800, 17);
        getContentPane().add(datecons);
        datecons.setBounds(170, 260, 170, 30);

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gcm/image/aacueilcons.jpg"))); // NOI18N
        getContentPane().add(jLabel1);
        jLabel1.setBounds(0, 0, 800, 600);

        listecons.setText("Liste");
        listecons.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                listeconsMouseClicked(evt);
            }
        });
        jMenuBar1.add(listecons);

        ajoutcons.setText("Ajouter");
        ajoutcons.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                ajoutconsMouseClicked(evt);
            }
        });
        jMenuBar1.add(ajoutcons);

        supcons.setText("Supprimer");
        supcons.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                supconsMouseClicked(evt);
            }
        });
        jMenuBar1.add(supcons);

        modifcons.setText("Modifier");
        modifcons.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                modifconsMouseClicked(evt);
            }
        });
        jMenuBar1.add(modifcons);

        setJMenuBar(jMenuBar1);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void homeconsMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_homeconsMouseClicked
        // TODO add your handling code here:
        new Accueil().setVisible(true);
        dispose();
    }//GEN-LAST:event_homeconsMouseClicked

    private void decconsMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_decconsMouseClicked
        // TODO add your handling code here:
        new Login().setVisible(true);
        dispose();
    }//GEN-LAST:event_decconsMouseClicked

    private void numconsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_numconsActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_numconsActionPerformed

    private void btnrechActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnrechActionPerformed
        // TODO add your handling code here:
        recherche();
    }//GEN-LAST:event_btnrechActionPerformed

    private void btnmodifActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnmodifActionPerformed
         try {
             // TODO add your handling code here:
             modifConsultation();
         } catch (SQLException ex) {
             Logger.getLogger(ModifConsultation.class.getName()).log(Level.SEVERE, null, ex);
         }
    }//GEN-LAST:event_btnmodifActionPerformed

    private void listeconsMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_listeconsMouseClicked
        try {
            // TODO add your handling code here:
            new ListeConsultation().setVisible(true);
        } catch (SQLException ex) {
            Logger.getLogger(ModifConsultation.class.getName()).log(Level.SEVERE, null, ex);
        }
        dispose();
    }//GEN-LAST:event_listeconsMouseClicked

    private void ajoutconsMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ajoutconsMouseClicked
        // TODO add your handling code here:
        new AjoutConsultation().setVisible(true);
        dispose();
    }//GEN-LAST:event_ajoutconsMouseClicked

    private void supconsMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_supconsMouseClicked
        // TODO add your handling code here:
        new SupprimerConsultation().setVisible(true);
        dispose();
    }//GEN-LAST:event_supconsMouseClicked

    private void modifconsMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_modifconsMouseClicked
    new ModifConsultation().setVisible(true);
    dispose();
    }//GEN-LAST:event_modifconsMouseClicked

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
            java.util.logging.Logger.getLogger(ModifConsultation.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ModifConsultation.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ModifConsultation.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ModifConsultation.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ModifConsultation().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenu ajoutcons;
    private javax.swing.JTextField anal;
    private javax.swing.JButton btnmodif;
    private javax.swing.JButton btnrech;
    private com.toedter.calendar.JDateChooser datecons;
    private javax.swing.JLabel deccons;
    private javax.swing.JLabel homecons;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JMenu listecons;
    private javax.swing.JMenu modifcons;
    private javax.swing.JTextField nomcons;
    private javax.swing.JTextField numcons;
    private javax.swing.JTextArea observ;
    private javax.swing.JTextArea pres;
    private javax.swing.JMenu supcons;
    // End of variables declaration//GEN-END:variables
}
