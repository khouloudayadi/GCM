
package gcm;

import java.sql.*;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;


public class AjoutRdv extends javax.swing.JFrame {
    Connection conx = null;
    PreparedStatement stmt = null;
    
    ResultSet res = null;
    String date1,heure1,nom1;
    
       public void ajoutRdv() throws SQLException{
        
         SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
          date1 = sdf.format(daterdv.getDate());
        
         heure1 =(heurerdv.getText());
         nom1 =(nomrdv.getText());
 
      try { 
       
        if((nom1.equals(""))|| (heure1.equals(""))|| (date1.equals("")))
        {
    
        JOptionPane.showMessageDialog(null, " veuillez saisir les champs obligatoires");
   }
        else {

 Connect c= new Connect();
stmt=  c.conx.prepareStatement("INSERT INTO rdv(`date`, `heure`,`nom_patient`) VALUES(?,?,?)" );
  stmt.setString(1, nom1);
  stmt.setString(2, heure1);
  stmt.setString(3, date1);
  
int nb = stmt.executeUpdate();
    
    if(nb == 1)
    {
         
        JOptionPane.showMessageDialog(null, "ajout est effectuée avec succée"); 
			new AjoutRdv().setVisible(true);
	                dispose();
		}
         else
    { JOptionPane.showMessageDialog(null, "Erreur !!! ");}
    
    }
       } catch(SQLException e) {JOptionPane.showMessageDialog(this, "Rendez-vouz existe déja ","Erreur d'ajout",JOptionPane.ERROR_MESSAGE);}
        
    
    }
  
    public AjoutRdv() {
        initComponents();
    }

   
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel4 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        heurerdv = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        nomrdv = new javax.swing.JTextField();
        homerdv = new javax.swing.JLabel();
        decrdv = new javax.swing.JLabel();
        btnajoutrdv = new javax.swing.JButton();
        daterdv = new com.toedter.calendar.JDateChooser();
        jLabel1 = new javax.swing.JLabel();
        jMenuBar2 = new javax.swing.JMenuBar();
        listrdv = new javax.swing.JMenu();
        ajoutrdv = new javax.swing.JMenu();
        modifrdv = new javax.swing.JMenu();
        suprdv = new javax.swing.JMenu();

        jLabel4.setText("jLabel4");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setLocation(new java.awt.Point(300, 90));
        setMinimumSize(new java.awt.Dimension(800, 600));
        setResizable(false);
        getContentPane().setLayout(null);

        jLabel2.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Ajouter Un Rendez-vous");
        getContentPane().add(jLabel2);
        jLabel2.setBounds(140, 70, 350, 28);

        jLabel6.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel6.setText("Heure :");
        getContentPane().add(jLabel6);
        jLabel6.setBounds(250, 220, 47, 30);
        getContentPane().add(heurerdv);
        heurerdv.setBounds(320, 210, 170, 40);

        jLabel8.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel8.setText("Date :");
        getContentPane().add(jLabel8);
        jLabel8.setBounds(250, 300, 60, 20);

        jLabel13.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel13.setText("Nom Maladie :");
        getContentPane().add(jLabel13);
        jLabel13.setBounds(210, 380, 120, 20);

        nomrdv.setToolTipText("");
        getContentPane().add(nomrdv);
        nomrdv.setBounds(320, 370, 170, 40);

        homerdv.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gcm/image/home1.png"))); // NOI18N
        homerdv.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                homerdvMouseClicked(evt);
            }
        });
        getContentPane().add(homerdv);
        homerdv.setBounds(700, 70, 30, 29);

        decrdv.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gcm/image/deccc1.png"))); // NOI18N
        decrdv.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                decrdvMouseClicked(evt);
            }
        });
        getContentPane().add(decrdv);
        decrdv.setBounds(740, 70, 78, 30);

        btnajoutrdv.setFont(new java.awt.Font("Times New Roman", 1, 16)); // NOI18N
        btnajoutrdv.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gcm/image/icon_ajout.png"))); // NOI18N
        btnajoutrdv.setText("Ajouter");
        btnajoutrdv.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnajoutrdvActionPerformed(evt);
            }
        });
        getContentPane().add(btnajoutrdv);
        btnajoutrdv.setBounds(480, 490, 130, 40);
        getContentPane().add(daterdv);
        daterdv.setBounds(320, 290, 170, 40);

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gcm/image/rdvv.jpg"))); // NOI18N
        getContentPane().add(jLabel1);
        jLabel1.setBounds(0, 0, 800, 600);

        listrdv.setText("Liste");
        listrdv.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                listrdvMouseClicked(evt);
            }
        });
        jMenuBar2.add(listrdv);

        ajoutrdv.setText("Ajouter");
        ajoutrdv.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                ajoutrdvMouseClicked(evt);
            }
        });
        jMenuBar2.add(ajoutrdv);

        modifrdv.setText("Modifier");
        modifrdv.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                modifrdvMouseClicked(evt);
            }
        });
        jMenuBar2.add(modifrdv);

        suprdv.setText("Supprimer");
        suprdv.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                suprdvMouseClicked(evt);
            }
        });
        jMenuBar2.add(suprdv);

        setJMenuBar(jMenuBar2);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnajoutrdvActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnajoutrdvActionPerformed
        try {
          
            ajoutRdv();
        } catch (SQLException ex) {
            Logger.getLogger(AjoutRdv.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnajoutrdvActionPerformed

    private void ajoutrdvMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ajoutrdvMouseClicked
        // TODO add your handling code here:
         new AjoutRdv().setVisible(true);
        dispose();
    }//GEN-LAST:event_ajoutrdvMouseClicked

    private void listrdvMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_listrdvMouseClicked
        try {
         

            new ListeRdv().setVisible(true);
        } catch (SQLException ex) {
            Logger.getLogger(AjoutRdv.class.getName()).log(Level.SEVERE, null, ex);
        }
        dispose();
    }//GEN-LAST:event_listrdvMouseClicked

    private void modifrdvMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_modifrdvMouseClicked
        
          new ModifRdv().setVisible(true);
        dispose();
    }//GEN-LAST:event_modifrdvMouseClicked

    private void suprdvMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_suprdvMouseClicked
        
          new SupprimerRdv().setVisible(true);
        dispose();
    }//GEN-LAST:event_suprdvMouseClicked

    private void homerdvMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_homerdvMouseClicked
        
          new Accueil().setVisible(true);
        dispose();
    }//GEN-LAST:event_homerdvMouseClicked

    private void decrdvMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_decrdvMouseClicked
        
          new Login().setVisible(true);
        dispose();
    }//GEN-LAST:event_decrdvMouseClicked

    
    public static void main(String args[]) {
        
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new AjoutRdv().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenu ajoutrdv;
    private javax.swing.JButton btnajoutrdv;
    private com.toedter.calendar.JDateChooser daterdv;
    private javax.swing.JLabel decrdv;
    private javax.swing.JTextField heurerdv;
    private javax.swing.JLabel homerdv;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JMenuBar jMenuBar2;
    private javax.swing.JMenu listrdv;
    private javax.swing.JMenu modifrdv;
    private javax.swing.JTextField nomrdv;
    private javax.swing.JMenu suprdv;
    // End of variables declaration//GEN-END:variables
}
