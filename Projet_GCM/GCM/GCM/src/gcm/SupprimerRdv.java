
package gcm;


import gcm.Accueil;
import gcm.ModifPatient;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;


public class SupprimerRdv extends javax.swing.JFrame {
Connection conx = null;
    Statement stmt = null;
    ResultSet res = null;
     String nomp;
    
    public SupprimerRdv() {
        initComponents();
    }

    public void supp() throws SQLException{
 
 Connect c= new Connect();
String req = "DELETE FROM rdv WHERE nom_patient='"+nomp+"'";
     
stmt=  c.conx.createStatement();
int reponse = JOptionPane.showConfirmDialog(null, "Voulez-vous supprimer ce RDV","", JOptionPane.YES_NO_OPTION);
 if(reponse == JOptionPane.YES_OPTION){
     int nb = stmt.executeUpdate(req);
    
    if(nb == 1)
    {
           JOptionPane.showMessageDialog(null, " suppression est effectuée avec succée");
	   new SupprimerRdv().setVisible(true);
	      dispose();
		}
       else
    {
        JOptionPane.showMessageDialog(null, "Erreur !!! ");}
    
    } 
}
    
    public void rech()
    {nomp= nomrech.getText();
          
        Connect c;
    try {
        c = new Connect();
        stmt=  c.conx.createStatement();

String req = "select * from rdv where nom_patient='"+nomp+"'";

ResultSet rs = stmt.executeQuery(req);

while (rs.next()) {
     String d =rs.getString("date");
      java.util.Date date = null;
         
            try {
                date = new SimpleDateFormat("yyyy-MM-dd").parse(d);
            } catch (ParseException ex) {
                Logger.getLogger(SupprimerRdv.class.getName()).log(Level.SEVERE, null, ex);
            }
           
      daterech.setDate(date);
  
      heurerech.setText(rs.getString("heure"));
       }
 } catch (SQLException ex) {
        {JOptionPane.showMessageDialog(this, "Erreur !!! ","Erreur de Recherche",JOptionPane.ERROR_MESSAGE);}
    }
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel2 = new javax.swing.JLabel();
        decrdv = new javax.swing.JLabel();
        homerdv = new javax.swing.JLabel();
        btnrech = new javax.swing.JButton();
        btnsup = new javax.swing.JButton();
        jLabel19 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        heurerech = new javax.swing.JTextField();
        nomrech = new javax.swing.JTextField();
        daterech = new com.toedter.calendar.JDateChooser();
        jLabel9 = new javax.swing.JLabel();
        jMenuBar1 = new javax.swing.JMenuBar();
        listerdv = new javax.swing.JMenu();
        ajoutrdv = new javax.swing.JMenu();
        suprdv = new javax.swing.JMenu();
        modifrdv = new javax.swing.JMenu();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setLocation(new java.awt.Point(300, 90));
        setMinimumSize(new java.awt.Dimension(800, 600));
        setResizable(false);
        getContentPane().setLayout(null);

        jLabel2.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Supprimer Un RDV");
        getContentPane().add(jLabel2);
        jLabel2.setBounds(150, 70, 230, 28);

        decrdv.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gcm/image/deccc1.png"))); // NOI18N
        decrdv.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                decrdvMouseClicked(evt);
            }
        });
        getContentPane().add(decrdv);
        decrdv.setBounds(750, 70, 40, 30);

        homerdv.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gcm/image/home1.png"))); // NOI18N
        homerdv.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                homerdvMouseClicked(evt);
            }
        });
        getContentPane().add(homerdv);
        homerdv.setBounds(710, 70, 40, 29);

        btnrech.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        btnrech.setText("Rechercher");
        btnrech.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnrechActionPerformed(evt);
            }
        });
        getContentPane().add(btnrech);
        btnrech.setBounds(320, 180, 110, 30);

        btnsup.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        btnsup.setText("Supprimer");
        btnsup.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnsupMouseClicked(evt);
            }
        });
        btnsup.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnsupActionPerformed(evt);
            }
        });
        getContentPane().add(btnsup);
        btnsup.setBounds(660, 180, 100, 30);

        jLabel19.setForeground(new java.awt.Color(255, 255, 255));
        jLabel19.setText("- - -  - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -- - -- - - - - - -- - - - - - - - - - - - - - - - - - - - - - - - - - - - - -  - - - - - - - - - - - - - - - - - - - - - - - - - - - - - ");
        getContentPane().add(jLabel19);
        jLabel19.setBounds(10, 240, 800, 14);

        jLabel6.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel6.setText("Date :");
        getContentPane().add(jLabel6);
        jLabel6.setBounds(230, 310, 50, 17);

        jLabel7.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel7.setText("Heure:");
        getContentPane().add(jLabel7);
        jLabel7.setBounds(230, 390, 50, 17);

        jLabel8.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel8.setText("Nom du Patient :");
        getContentPane().add(jLabel8);
        jLabel8.setBounds(30, 180, 120, 20);
        getContentPane().add(heurerech);
        heurerech.setBounds(310, 380, 210, 40);

        nomrech.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nomrechActionPerformed(evt);
            }
        });
        getContentPane().add(nomrech);
        nomrech.setBounds(140, 180, 170, 30);
        getContentPane().add(daterech);
        daterech.setBounds(310, 300, 210, 40);

        jLabel9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gcm/image/accpatient_1_1.png"))); // NOI18N
        getContentPane().add(jLabel9);
        jLabel9.setBounds(0, 0, 800, 600);

        listerdv.setText("Liste");
        listerdv.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                listerdvMouseClicked(evt);
            }
        });
        jMenuBar1.add(listerdv);

        ajoutrdv.setText("Ajouter");
        ajoutrdv.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                ajoutrdvMouseClicked(evt);
            }
        });
        jMenuBar1.add(ajoutrdv);

        suprdv.setText("Supprimer");
        suprdv.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                suprdvActionPerformed(evt);
            }
        });
        jMenuBar1.add(suprdv);

        modifrdv.setText("Modifier");
        modifrdv.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                modifrdvMouseClicked(evt);
            }
        });
        jMenuBar1.add(modifrdv);

        setJMenuBar(jMenuBar1);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnrechActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnrechActionPerformed
        // TODO add your handling code here:
        rech();
    }//GEN-LAST:event_btnrechActionPerformed

    private void homerdvMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_homerdvMouseClicked
        // TODO add your handling code here:
         new Accueil().setVisible(true);
         dispose();
    }//GEN-LAST:event_homerdvMouseClicked

    private void decrdvMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_decrdvMouseClicked
        // TODO add your handling code here:
         new Login().setVisible(true);
         dispose();
       
    }//GEN-LAST:event_decrdvMouseClicked

    private void nomrechActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nomrechActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_nomrechActionPerformed

    private void suprdvActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_suprdvActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_suprdvActionPerformed

    private void listerdvMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_listerdvMouseClicked
        try {
            // TODO add your handling code here:

            new ListeRdv().setVisible(true);
        } catch (SQLException ex) {
            Logger.getLogger(SupprimerRdv.class.getName()).log(Level.SEVERE, null, ex);
        }
         dispose();
    }//GEN-LAST:event_listerdvMouseClicked

    private void ajoutrdvMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ajoutrdvMouseClicked
        // TODO add your handling code here:
         new AjoutRdv().setVisible(true);
         dispose();
    }//GEN-LAST:event_ajoutrdvMouseClicked

    private void modifrdvMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_modifrdvMouseClicked
        // TODO add your handling code here:
         new ModifRdv().setVisible(true);
         dispose();
    }//GEN-LAST:event_modifrdvMouseClicked

    private void btnsupMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnsupMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_btnsupMouseClicked

    private void btnsupActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnsupActionPerformed
    try {
        // TODO add your handling code here:
        
        supp();
    } catch (SQLException ex) {
        Logger.getLogger(SupprimerRdv.class.getName()).log(Level.SEVERE, null, ex);
    }
    }//GEN-LAST:event_btnsupActionPerformed

   
    public static void main(String args[]) {
        

      
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new SupprimerRdv().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenu ajoutrdv;
    private javax.swing.JButton btnrech;
    private javax.swing.JButton btnsup;
    private com.toedter.calendar.JDateChooser daterech;
    private javax.swing.JLabel decrdv;
    private javax.swing.JTextField heurerech;
    private javax.swing.JLabel homerdv;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenu listerdv;
    private javax.swing.JMenu modifrdv;
    private javax.swing.JTextField nomrech;
    private javax.swing.JMenu suprdv;
    // End of variables declaration//GEN-END:variables
}
