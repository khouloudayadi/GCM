
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


public class SupprimerFacture extends javax.swing.JFrame {

  Connection conx = null;
    Statement stmt = null;
    ResultSet res = null;
     String ref;
    public SupprimerFacture() {
        initComponents();
    }

    public void supp() throws SQLException{
        
            
     
        Connect c= new Connect();
String req = "DELETE FROM facture WHERE referencefacture ='"+ref+"'";
     
stmt=  c.conx.createStatement();
int reponse = JOptionPane.showConfirmDialog(null, "Voulez-vous supprimer cette facture ?", 
			"", JOptionPane.YES_NO_OPTION);
 if(reponse == JOptionPane.YES_OPTION){
     int nb = stmt.executeUpdate(req);
    
    if(nb == 1)
    {
           JOptionPane.showMessageDialog(null, " Suppression est effectuée avec succeé");
	   new SupprimerFacture().setVisible(true);
	      dispose();
		}
       else
    {
        JOptionPane.showMessageDialog(null, "Erreur !!! ");}
    
    }  
   }
        
    public void rech()
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
                Logger.getLogger(SupprimerFacture.class.getName()).log(Level.SEVERE, null, ex);
            }
   datefact.setDate(date);
   }
    }
 catch (SQLException ex) {
        {JOptionPane.showMessageDialog(this, "Erreur !!! ","Erreur de Recherche",JOptionPane.ERROR_MESSAGE);}
       }
     catch( NumberFormatException e) {JOptionPane.showMessageDialog(this, "Verifiez  le réference de votre facture","Erreur d'ajout",JOptionPane.WARNING_MESSAGE);}
        
    }

    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel5 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        reffact = new javax.swing.JTextField();
        nomfact = new javax.swing.JTextField();
        montfact = new javax.swing.JTextField();
        rechfact = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jLabel15 = new javax.swing.JLabel();
        decfact = new javax.swing.JLabel();
        homefact = new javax.swing.JLabel();
        datefact = new com.toedter.calendar.JDateChooser();
        jLabel3 = new javax.swing.JLabel();
        jMenuBar1 = new javax.swing.JMenuBar();
        listfact = new javax.swing.JMenu();
        ajoutfact = new javax.swing.JMenu();
        supfact = new javax.swing.JMenu();
        modiffact = new javax.swing.JMenu();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setLocation(new java.awt.Point(300, 90));
        setMinimumSize(new java.awt.Dimension(800, 600));
        setResizable(false);
        getContentPane().setLayout(null);

        jLabel5.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Supprimer Un Facture");
        getContentPane().add(jLabel5);
        jLabel5.setBounds(130, 60, 250, 30);

        jLabel1.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel1.setText("Réference Facture :");
        getContentPane().add(jLabel1);
        jLabel1.setBounds(30, 180, 130, 20);

        jLabel7.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel7.setText("Montant :");
        getContentPane().add(jLabel7);
        jLabel7.setBounds(220, 370, 80, 17);

        jLabel8.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel8.setText("Nom du Patient :");
        getContentPane().add(jLabel8);
        jLabel8.setBounds(180, 290, 110, 17);

        jLabel9.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel9.setText("Date de paiement :");
        getContentPane().add(jLabel9);
        jLabel9.setBounds(160, 440, 117, 17);

        reffact.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                reffactActionPerformed(evt);
            }
        });
        getContentPane().add(reffact);
        reffact.setBounds(160, 170, 180, 40);
        getContentPane().add(nomfact);
        nomfact.setBounds(300, 280, 180, 40);
        getContentPane().add(montfact);
        montfact.setBounds(300, 360, 180, 40);

        rechfact.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        rechfact.setText("Rechercher");
        rechfact.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rechfactActionPerformed(evt);
            }
        });
        getContentPane().add(rechfact);
        rechfact.setBounds(370, 170, 120, 40);

        jButton2.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jButton2.setText("Supprimer");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton2);
        jButton2.setBounds(660, 170, 120, 40);

        jLabel15.setForeground(new java.awt.Color(255, 255, 255));
        jLabel15.setText("- - -  - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -- - -- - - - - - -- - - - - - - - - - - - - - - - - - - - - - - - - - - - - -  - - - - - - - - - - - - - - - - - - - - - - - - - - - - - ");
        getContentPane().add(jLabel15);
        jLabel15.setBounds(10, 230, 800, 14);

        decfact.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gcm/image/deccc1.png"))); // NOI18N
        getContentPane().add(decfact);
        decfact.setBounds(730, 60, 40, 30);

        homefact.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gcm/image/home1.png"))); // NOI18N
        homefact.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                homefactMouseClicked(evt);
            }
        });
        getContentPane().add(homefact);
        homefact.setBounds(700, 50, 30, 40);
        getContentPane().add(datefact);
        datefact.setBounds(300, 430, 180, 40);

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gcm/image/facture.jpg"))); // NOI18N
        getContentPane().add(jLabel3);
        jLabel3.setBounds(0, 0, 800, 580);

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
        jMenuBar1.add(supfact);

        modiffact.setText("Modifier");
        modiffact.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                modiffactMouseClicked(evt);
            }
        });
        jMenuBar1.add(modiffact);

        setJMenuBar(jMenuBar1);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void reffactActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_reffactActionPerformed
       
    }//GEN-LAST:event_reffactActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
      try {
         
          supp();
      } catch (SQLException ex) {
          Logger.getLogger(SupprimerFacture.class.getName()).log(Level.SEVERE, null, ex);
      }
    }//GEN-LAST:event_jButton2ActionPerformed

    private void listfactMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_listfactMouseClicked
        try {
            // TODO add your handling code here:
            new ListeFacture().setVisible(true);
        } catch (SQLException ex) {
            Logger.getLogger(SupprimerFacture.class.getName()).log(Level.SEVERE, null, ex);
        }
        dispose();
    }//GEN-LAST:event_listfactMouseClicked

    private void ajoutfactMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ajoutfactMouseClicked
        // TODO add your handling code here:
        
            new AjoutFacture().setVisible(true);
            dispose();
    }//GEN-LAST:event_ajoutfactMouseClicked

    private void modiffactMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_modiffactMouseClicked
        // TODO add your handling code here:
         new ModifiFacture().setVisible(true);
            dispose();
    }//GEN-LAST:event_modiffactMouseClicked

    private void homefactMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_homefactMouseClicked
        // TODO add your handling code here
         new Accueil().setVisible(true);
            dispose();
    }//GEN-LAST:event_homefactMouseClicked

    private void rechfactActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rechfactActionPerformed
        // TODO add your handling code here:*
        
        rech();
    }//GEN-LAST:event_rechfactActionPerformed

    
    public static void main(String args[]) {
        
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new SupprimerFacture().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenu ajoutfact;
    private com.toedter.calendar.JDateChooser datefact;
    private javax.swing.JLabel decfact;
    private javax.swing.JLabel homefact;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenu listfact;
    private javax.swing.JMenu modiffact;
    private javax.swing.JTextField montfact;
    private javax.swing.JTextField nomfact;
    private javax.swing.JButton rechfact;
    private javax.swing.JTextField reffact;
    private javax.swing.JMenu supfact;
    // End of variables declaration//GEN-END:variables
}
