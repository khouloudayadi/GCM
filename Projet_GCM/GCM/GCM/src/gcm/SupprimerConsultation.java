/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gcm;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;


public class SupprimerConsultation extends javax.swing.JFrame {

   Connection conx = null;
   Statement stmt = null;
   ResultSet res = null;
   String num;
    public SupprimerConsultation() {
        initComponents();
    }

    public void supp() throws SQLException{
        
            
     
        Connect c= new Connect();
String req = "DELETE FROM consultation WHERE numero_cnam='"+num+"'";
     
stmt=  c.conx.createStatement();
int reponse = JOptionPane.showConfirmDialog(null, "Voulez-vous supprimer cette consultation ?", 
			"", JOptionPane.YES_NO_OPTION);
 if(reponse == JOptionPane.YES_OPTION){
     int nb = stmt.executeUpdate(req);
    
    if(nb == 1)
    {
           JOptionPane.showMessageDialog(null, " Suppression est effectuée avec succée");
	   new SupprimerConsultation().setVisible(true);
	      dispose();
		}
       else
    {
        JOptionPane.showMessageDialog(null, "Erreur !!! ");}
    
    }  
   }
        
    public void rech()
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
   analcons.setText(rs.getString("analyse"));
   prescons.setText(rs.getString("prescription_medicale"));
   observcons.setText(rs.getString("observation"));
   String d =rs.getString("date_consultation");
   java.util.Date date = null;
            try {
                date = new SimpleDateFormat("yyyy-MM-dd").parse(d);
            } catch (ParseException ex) {
                Logger.getLogger(SupprimerConsultation.class.getName()).log(Level.SEVERE, null, ex);
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

        jLabel2 = new javax.swing.JLabel();
        homecons = new javax.swing.JLabel();
        deccons = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        nomcons = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        numcons = new javax.swing.JTextField();
        analcons = new javax.swing.JTextField();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        btnrech = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        prescons = new javax.swing.JTextArea();
        jLabel11 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        observcons = new javax.swing.JTextArea();
        jLabel19 = new javax.swing.JLabel();
        btnsup = new javax.swing.JButton();
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

        jLabel2.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Supprimer Une Consultation");
        getContentPane().add(jLabel2);
        jLabel2.setBounds(140, 67, 300, 40);

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

        jLabel7.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel7.setText("Date consultation:");
        getContentPane().add(jLabel7);
        jLabel7.setBounds(40, 260, 160, 30);
        getContentPane().add(nomcons);
        nomcons.setBounds(180, 320, 180, 40);

        jLabel6.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel6.setText("Nom Maladie:");
        getContentPane().add(jLabel6);
        jLabel6.setBounds(70, 330, 130, 30);

        jLabel8.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel8.setText("Num Cnam:");
        getContentPane().add(jLabel8);
        jLabel8.setBounds(50, 160, 100, 30);

        numcons.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                numconsActionPerformed(evt);
            }
        });
        getContentPane().add(numcons);
        numcons.setBounds(150, 160, 120, 40);
        getContentPane().add(analcons);
        analcons.setBounds(510, 320, 170, 40);

        jLabel13.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel13.setText("Analyse:");
        getContentPane().add(jLabel13);
        jLabel13.setBounds(440, 330, 70, 20);

        jLabel14.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel14.setText("Perscription:");
        getContentPane().add(jLabel14);
        jLabel14.setBounds(80, 390, 80, 30);

        btnrech.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        btnrech.setText("Rechercher");
        btnrech.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnrechActionPerformed(evt);
            }
        });
        getContentPane().add(btnrech);
        btnrech.setBounds(310, 160, 130, 40);

        prescons.setColumns(20);
        prescons.setRows(5);
        jScrollPane2.setViewportView(prescons);

        getContentPane().add(jScrollPane2);
        jScrollPane2.setBounds(180, 400, 180, 90);

        jLabel11.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel11.setText("Observation: ");
        getContentPane().add(jLabel11);
        jLabel11.setBounds(420, 400, 90, 17);

        observcons.setColumns(20);
        observcons.setRows(5);
        jScrollPane1.setViewportView(observcons);

        getContentPane().add(jScrollPane1);
        jScrollPane1.setBounds(510, 400, 166, 90);

        jLabel19.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel19.setForeground(new java.awt.Color(255, 255, 255));
        jLabel19.setText("- - -  - - - - - - - - - - - - - - - - - - -- -- - -- - - - -  - - - - - - - - - - - - - - - - - - - - -  - - -- - - - - - - - - - - - - - - - - - - - - - - - - - - - - -");
        getContentPane().add(jLabel19);
        jLabel19.setBounds(20, 210, 770, 17);

        btnsup.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        btnsup.setText("Supprimer");
        btnsup.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnsupActionPerformed(evt);
            }
        });
        getContentPane().add(btnsup);
        btnsup.setBounds(600, 160, 130, 40);
        getContentPane().add(datecons);
        datecons.setBounds(180, 260, 180, 40);

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
      
        new Accueil().setVisible(true);
        dispose();
    }//GEN-LAST:event_homeconsMouseClicked

    private void decconsMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_decconsMouseClicked
    
        new Login().setVisible(true);
        dispose();
    }//GEN-LAST:event_decconsMouseClicked

    private void numconsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_numconsActionPerformed
       
    }//GEN-LAST:event_numconsActionPerformed

    private void btnsupActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnsupActionPerformed
       try {
           supp();
       } catch (SQLException ex) {
           Logger.getLogger(SupprimerConsultation.class.getName()).log(Level.SEVERE, null, ex);
       }
    }//GEN-LAST:event_btnsupActionPerformed

    private void btnrechActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnrechActionPerformed

          rech();
    }//GEN-LAST:event_btnrechActionPerformed

    private void listeconsMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_listeconsMouseClicked
        try {
            // TODO add your handling code here:
            new ListeConsultation().setVisible(true);
        } catch (SQLException ex) {
            Logger.getLogger(SupprimerConsultation.class.getName()).log(Level.SEVERE, null, ex);
        }
        dispose();
    }//GEN-LAST:event_listeconsMouseClicked

    private void ajoutconsMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ajoutconsMouseClicked
        // TODO add your handling code here:
        new AjoutConsultation().setVisible(true);
        dispose();
    }//GEN-LAST:event_ajoutconsMouseClicked

    private void supconsMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_supconsMouseClicked
      
    }//GEN-LAST:event_supconsMouseClicked

    private void modifconsMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_modifconsMouseClicked
        // TODO add your handling code here:
        new ModifConsultation().setVisible(true);
        dispose();
    }//GEN-LAST:event_modifconsMouseClicked

   
    public static void main(String args[]) {
      
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new SupprimerConsultation().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenu ajoutcons;
    private javax.swing.JTextField analcons;
    private javax.swing.JButton btnrech;
    private javax.swing.JButton btnsup;
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
    private javax.swing.JTextArea observcons;
    private javax.swing.JTextArea prescons;
    private javax.swing.JMenu supcons;
    // End of variables declaration//GEN-END:variables
}
