
package gcm;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;


public class ModifRdv extends javax.swing.JFrame {

   Connection conx = null;
    Statement stmt = null;
    ResultSet res = null;
     String nom;
    public ModifRdv() {
        initComponents();
    }

    public void modifrdv() throws SQLException{
        
        
        
         SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
         String date1 = sdf.format(daterdv.getDate());
         String heure1 =(heurerdv.getText());
    try{     
        Connect c= new Connect();
String req = " UPDATE `rdv` SET `date`= '"+date1+"',`heure`='"+heure1+"'";
     
stmt=  c.conx.createStatement();
int reponse = JOptionPane.showConfirmDialog(null, "voulez vous modifier ce rdv ?", 
			"", JOptionPane.YES_NO_OPTION);
 if(reponse == JOptionPane.YES_OPTION){
 
int nb = stmt.executeUpdate(req);
    
    if(nb == 1)
    {
       JOptionPane.showMessageDialog(null, " modification est effectuée avec succeé");
	new ModifRdv().setVisible(true);
	 dispose();
		}
    }
    
   }catch (SQLException e  ){JOptionPane.showMessageDialog(null, "Erreur de modification !!! ");}
   
    }
        
   @SuppressWarnings("empty-statement")
    public void recherche() throws SQLException
    {nom= nomrdv.getText();
   
     try {     
        Connect c;
        c = new Connect();
        stmt=  c.conx.createStatement();

String req = "select * from rdv where nom_patient='"+nom+"'";
ResultSet rs = stmt.executeQuery(req);
/*ResultSetMetaData metadata = rs.getMetaData(); 
nbr_cl += metadata.getColumnCount();*/

    while (rs.next()) {
        String d =rs.getString("date");
        java.util.Date date = null;
            try {
                date = new SimpleDateFormat("yyyy-MM-dd").parse(d);
            } catch (ParseException ex) {
                Logger.getLogger(ModifRdv.class.getName()).log(Level.SEVERE, null, ex);
            }
   daterdv.setDate(date);
   heurerdv.setText(rs.getString("heure"));
    }
     }

catch (SQLException ex) 
 {JOptionPane.showMessageDialog(this, "Erreur !!! ","Erreur de Recherche",JOptionPane.ERROR_MESSAGE);}
     
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel2 = new javax.swing.JLabel();
        dechome = new javax.swing.JLabel();
        homerdv = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        heurerdv = new javax.swing.JTextField();
        nomrdv = new javax.swing.JTextField();
        btnrech = new javax.swing.JButton();
        btnmodif = new javax.swing.JButton();
        daterdv = new com.toedter.calendar.JDateChooser();
        jLabel9 = new javax.swing.JLabel();
        jMenuBar1 = new javax.swing.JMenuBar();
        listerdv = new javax.swing.JMenu();
        ajoutrdv = new javax.swing.JMenu();
        suprdv = new javax.swing.JMenu();
        modifrdv = new javax.swing.JMenu();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setLocation(new java.awt.Point(100, 90));
        setMinimumSize(new java.awt.Dimension(800, 600));
        setResizable(false);
        getContentPane().setLayout(null);

        jLabel2.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Modifier Un RDV");
        getContentPane().add(jLabel2);
        jLabel2.setBounds(130, 70, 230, 28);

        dechome.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gcm/image/deccc1.png"))); // NOI18N
        dechome.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                dechomeMouseClicked(evt);
            }
        });
        getContentPane().add(dechome);
        dechome.setBounds(750, 70, 40, 30);

        homerdv.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gcm/image/home1.png"))); // NOI18N
        homerdv.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                homerdvMouseClicked(evt);
            }
        });
        getContentPane().add(homerdv);
        homerdv.setBounds(710, 70, 30, 30);

        jLabel6.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel6.setText("Date :");
        getContentPane().add(jLabel6);
        jLabel6.setBounds(250, 330, 50, 17);

        jLabel19.setForeground(new java.awt.Color(255, 255, 255));
        jLabel19.setText("- - -  - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -- - -- - - - - - -- - - - - - - - - - - - - - - - - - - - - - - - - - - - - -  - - - - - - - - - - - - - - - - - - - - - - - - - - - - - ");
        getContentPane().add(jLabel19);
        jLabel19.setBounds(10, 240, 800, 14);

        jLabel7.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel7.setText("Heure:");
        getContentPane().add(jLabel7);
        jLabel7.setBounds(240, 410, 50, 17);

        jLabel8.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel8.setText("Nom du Patient :");
        getContentPane().add(jLabel8);
        jLabel8.setBounds(40, 180, 110, 17);
        getContentPane().add(heurerdv);
        heurerdv.setBounds(330, 400, 210, 40);
        getContentPane().add(nomrdv);
        nomrdv.setBounds(150, 170, 190, 40);

        btnrech.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        btnrech.setText("Rechercher");
        btnrech.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnrechActionPerformed(evt);
            }
        });
        getContentPane().add(btnrech);
        btnrech.setBounds(350, 170, 110, 40);

        btnmodif.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        btnmodif.setText("Modifier");
        btnmodif.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnmodifMouseClicked(evt);
            }
        });
        getContentPane().add(btnmodif);
        btnmodif.setBounds(660, 170, 110, 40);
        getContentPane().add(daterdv);
        daterdv.setBounds(330, 320, 210, 40);

        jLabel9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gcm/image/rdvv.jpg"))); // NOI18N
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
        suprdv.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                suprdvMouseClicked(evt);
            }
        });
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

    private void dechomeMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_dechomeMouseClicked
        // TODO add your handling code here:
        new Login().setVisible(true);
        dispose();
    }//GEN-LAST:event_dechomeMouseClicked

    private void homerdvMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_homerdvMouseClicked
        // TODO add your handling code here:
        new Accueil().setVisible(true);
        dispose();
    }//GEN-LAST:event_homerdvMouseClicked

    private void suprdvActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_suprdvActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_suprdvActionPerformed

    private void listerdvMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_listerdvMouseClicked
        try {
            // TODO add your handling code here:

            new ListeRdv().setVisible(true);
        } catch (SQLException ex) {
            Logger.getLogger(ModifRdv.class.getName()).log(Level.SEVERE, null, ex);
        }
        dispose();
    }//GEN-LAST:event_listerdvMouseClicked

    private void ajoutrdvMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ajoutrdvMouseClicked
        // TODO add your handling code here:
        
       new AjoutRdv().setVisible(true);
       dispose();
    }//GEN-LAST:event_ajoutrdvMouseClicked

    private void suprdvMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_suprdvMouseClicked
        // TODO add your handling code here:
        new SupprimerRdv().setVisible(true);
        dispose();
    }//GEN-LAST:event_suprdvMouseClicked

    private void modifrdvMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_modifrdvMouseClicked
        // TODO add your handling code here:
        new ModifRdv().setVisible(true);
        dispose();
    }//GEN-LAST:event_modifrdvMouseClicked

    private void btnrechActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnrechActionPerformed
       try {
           // TODO add your handling code here:
           recherche();
       } catch (SQLException ex) {
           Logger.getLogger(ModifRdv.class.getName()).log(Level.SEVERE, null, ex);
       }
    }//GEN-LAST:event_btnrechActionPerformed

    private void btnmodifMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnmodifMouseClicked
       try {
           // TODO add your handling code here:
           modifrdv();
       } catch (SQLException ex) {
           Logger.getLogger(ModifRdv.class.getName()).log(Level.SEVERE, null, ex);
       }
    }//GEN-LAST:event_btnmodifMouseClicked

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
            java.util.logging.Logger.getLogger(ModifRdv.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ModifRdv.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ModifRdv.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ModifRdv.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ModifRdv().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenu ajoutrdv;
    private javax.swing.JButton btnmodif;
    private javax.swing.JButton btnrech;
    private com.toedter.calendar.JDateChooser daterdv;
    private javax.swing.JLabel dechome;
    private javax.swing.JTextField heurerdv;
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
    private javax.swing.JTextField nomrdv;
    private javax.swing.JMenu suprdv;
    // End of variables declaration//GEN-END:variables
}
