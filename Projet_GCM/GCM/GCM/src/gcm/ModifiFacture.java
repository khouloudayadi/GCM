
package gcm;

import java.sql.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;


public class ModifiFacture extends javax.swing.JFrame {
 Connection conx = null;
    Statement stmt = null;
    ResultSet res = null;
    String ref;
   
    public ModifiFacture() {
        initComponents();
    }
public void modifFacture() throws SQLException{
       
         SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
         String date1 = sdf.format(datefact.getDate());
         String nom1 =(nomfact.getText());
         String mont =(montfact.getText());
        
          try {       
              Float x= Float.parseFloat(mont);
       
        Connect c= new Connect();
String req = "UPDATE `facture` SET `nompatient`= '"+nom1+"',`montant`='"+x+"',`date_paiement`='"+date1+"' where referencefacture='"+ref+"'";
     
stmt=  c.conx.createStatement();
int reponse = JOptionPane.showConfirmDialog(null, "voulez vous modifier les informations de votre Facture ?","", JOptionPane.YES_NO_OPTION);
 if(reponse == JOptionPane.YES_OPTION){
 
      int nb = stmt.executeUpdate(req);
    
         if(nb == 1)
          {
       JOptionPane.showMessageDialog(null, " modification est effectuée avec succée");
	new ModifiFacture().setVisible(true);
	 dispose();
          }             
}

    }catch (SQLException e  )/*{JOptionPane.showMessageDialog(null, "Erreur de modification !!! ");}*/{e.printStackTrace();}
    catch( NumberFormatException e) {JOptionPane.showMessageDialog(this, "Verifiez le montant de votre facture","Erreur de modification",JOptionPane.WARNING_MESSAGE);}
}
        
    public void recherche()
    {ref= reffact.getText();
                                                                                                                                                                
    try {
        int num1=Integer.parseInt(ref);
        Connect c;
        c = new Connect();
        stmt=  c.conx.createStatement();
String req = "select * from facture where referencefacture='"+num1+"'";

ResultSet rs = stmt.executeQuery(req);

while (rs.next()) {
   nomfact.setText(rs.getString("nompatient"));
   montfact.setText(rs.getString("montant"));
   String d =rs.getString("date_paiement");
   java.util.Date date = null;
            try {
                date = new SimpleDateFormat("yyyy-MM-dd").parse(d);
            } catch (ParseException ex) {
                Logger.getLogger(ModifiFacture.class.getName()).log(Level.SEVERE, null, ex);
            }
   datefact.setDate(date);
   }}

    
 catch (SQLException ex) {
        {JOptionPane.showMessageDialog(this, "Erreur !!! ","Erreur de Recherche",JOptionPane.ERROR_MESSAGE);}
       }
     catch( NumberFormatException e) {JOptionPane.showMessageDialog(this, "Verifiez  le réference de votre facture","Erreur d'ajout",JOptionPane.WARNING_MESSAGE);}
        
    }

   
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel2 = new javax.swing.JLabel();
        decfact = new javax.swing.JLabel();
        homefact = new javax.swing.JLabel();
        montfact = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        rechfact = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        nomfact = new javax.swing.JTextField();
        modifierfact = new javax.swing.JButton();
        jLabel8 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        reffact = new javax.swing.JTextField();
        datefact = new com.toedter.calendar.JDateChooser();
        jLabel1 = new javax.swing.JLabel();
        jMenuBar1 = new javax.swing.JMenuBar();
        listfact = new javax.swing.JMenu();
        ajoutfact = new javax.swing.JMenu();
        supfact = new javax.swing.JMenu();
        modiffact = new javax.swing.JMenu();
        jMenu1 = new javax.swing.JMenu();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setLocation(new java.awt.Point(300, 90));
        setMinimumSize(new java.awt.Dimension(800, 600));
        setResizable(false);
        getContentPane().setLayout(null);

        jLabel2.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Modifier Un Facture");
        getContentPane().add(jLabel2);
        jLabel2.setBounds(140, 70, 220, 28);

        decfact.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gcm/image/deccc1.png"))); // NOI18N
        decfact.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                decfactMouseClicked(evt);
            }
        });
        getContentPane().add(decfact);
        decfact.setBounds(750, 70, 40, 40);

        homefact.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gcm/image/home1.png"))); // NOI18N
        homefact.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                homefactMouseClicked(evt);
            }
        });
        getContentPane().add(homefact);
        homefact.setBounds(710, 70, 30, 29);
        getContentPane().add(montfact);
        montfact.setBounds(290, 340, 180, 40);

        jLabel9.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel9.setText("Date de paiement :");
        getContentPane().add(jLabel9);
        jLabel9.setBounds(140, 420, 117, 17);

        rechfact.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        rechfact.setText("Rechercher");
        rechfact.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rechfactActionPerformed(evt);
            }
        });
        getContentPane().add(rechfact);
        rechfact.setBounds(350, 160, 120, 40);

        jLabel6.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel6.setText("Reference facture :");
        getContentPane().add(jLabel6);
        jLabel6.setBounds(20, 170, 130, 17);
        getContentPane().add(nomfact);
        nomfact.setBounds(290, 270, 180, 40);

        modifierfact.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        modifierfact.setText("Modifier");
        modifierfact.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                modifierfactActionPerformed(evt);
            }
        });
        getContentPane().add(modifierfact);
        modifierfact.setBounds(630, 160, 120, 40);

        jLabel8.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel8.setText("Nom du Patient :");
        getContentPane().add(jLabel8);
        jLabel8.setBounds(150, 280, 110, 17);

        jLabel15.setForeground(new java.awt.Color(255, 255, 255));
        jLabel15.setText("- - -  - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -- - -- - - - - - -- - - - - - - - - - - - - - - - - - - - - - - - - - - - - -  - - - - - - - - - - - - - - - - - - - - - - - - - - - - - ");
        getContentPane().add(jLabel15);
        jLabel15.setBounds(10, 230, 800, 14);

        jLabel7.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel7.setText("Montant :");
        getContentPane().add(jLabel7);
        jLabel7.setBounds(190, 350, 80, 17);

        reffact.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                reffactActionPerformed(evt);
            }
        });
        getContentPane().add(reffact);
        reffact.setBounds(150, 160, 180, 40);
        getContentPane().add(datefact);
        datefact.setBounds(290, 410, 180, 40);

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gcm/image/facture.jpg"))); // NOI18N
        getContentPane().add(jLabel1);
        jLabel1.setBounds(0, 0, 800, 590);

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

    private void modifierfactActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_modifierfactActionPerformed
     try {
         // TODO add your handling code here:

         modifFacture();
     } catch (SQLException ex) {
         Logger.getLogger(ModifiFacture.class.getName()).log(Level.SEVERE, null, ex);
     }
    }//GEN-LAST:event_modifierfactActionPerformed

    private void reffactActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_reffactActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_reffactActionPerformed

    private void listfactMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_listfactMouseClicked
        try {
            // TODO add your handling code here:
            new ListeFacture().setVisible(true);
        } catch (SQLException ex) {
            Logger.getLogger(ModifiFacture.class.getName()).log(Level.SEVERE, null, ex);
        }
        dispose();
    }//GEN-LAST:event_listfactMouseClicked

    private void ajoutfactMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ajoutfactMouseClicked
        // TODO add your handling code here:
        
         new AjoutFacture().setVisible(true);
        dispose();
    }//GEN-LAST:event_ajoutfactMouseClicked

    private void supfactMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_supfactMouseClicked
        // TODO add your handling code here:
        
         new SupprimerFacture().setVisible(true);
        dispose();
    }//GEN-LAST:event_supfactMouseClicked

    private void modiffactMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_modiffactMouseClicked
        // TODO add your handling code here:
         new ModifiFacture().setVisible(true);
        dispose();
    }//GEN-LAST:event_modiffactMouseClicked

    private void homefactMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_homefactMouseClicked
        // TODO add your handling code here:
        
         new Accueil().setVisible(true);
        dispose();
    }//GEN-LAST:event_homefactMouseClicked

    private void decfactMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_decfactMouseClicked
        // TODO add your handling code here:
        
         new Login().setVisible(true);
        dispose();
    }//GEN-LAST:event_decfactMouseClicked

    private void rechfactActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rechfactActionPerformed
        // TODO add your handling code here:
        recherche();
    }//GEN-LAST:event_rechfactActionPerformed

    private void jMenu1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jMenu1MouseClicked
        // TODO add your handling code here:
         new Statistique().setVisible(true);
        dispose();
    }//GEN-LAST:event_jMenu1MouseClicked

   
    public static void main(String args[]) {
        
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ModifiFacture().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenu ajoutfact;
    private com.toedter.calendar.JDateChooser datefact;
    private javax.swing.JLabel decfact;
    private javax.swing.JLabel homefact;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenu listfact;
    private javax.swing.JMenu modiffact;
    private javax.swing.JButton modifierfact;
    private javax.swing.JTextField montfact;
    private javax.swing.JTextField nomfact;
    private javax.swing.JButton rechfact;
    private javax.swing.JTextField reffact;
    private javax.swing.JMenu supfact;
    // End of variables declaration//GEN-END:variables
}
