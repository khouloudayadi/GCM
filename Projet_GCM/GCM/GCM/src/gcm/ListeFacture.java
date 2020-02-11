
package gcm;

import java.sql.*;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.DefaultTableModel;


public class ListeFacture extends javax.swing.JFrame {
   Connection conx = null;
    Statement stmt = null;
    ResultSet res = null;
    public ListeFacture() throws SQLException {
        initComponents();
        affiche();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        decfact = new javax.swing.JLabel();
        homefact = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tablefact = new javax.swing.JTable();
        jLabel6 = new javax.swing.JLabel();
        jMenuBar1 = new javax.swing.JMenuBar();
        listfact = new javax.swing.JMenu();
        ajoutfact = new javax.swing.JMenu();
        supfact = new javax.swing.JMenu();
        modiffact = new javax.swing.JMenu();
        jMenu1 = new javax.swing.JMenu();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setLocation(new java.awt.Point(300, 90));
        setMinimumSize(new java.awt.Dimension(800, 600));
        setPreferredSize(new java.awt.Dimension(800, 600));
        setResizable(false);
        getContentPane().setLayout(null);

        decfact.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gcm/image/deccc1.png"))); // NOI18N
        decfact.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                decfactMouseClicked(evt);
            }
        });
        getContentPane().add(decfact);
        decfact.setBounds(740, 60, 40, 30);

        homefact.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gcm/image/home1.png"))); // NOI18N
        homefact.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                homefactMouseClicked(evt);
            }
        });
        getContentPane().add(homefact);
        homefact.setBounds(700, 60, 40, 30);

        jLabel4.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Liste Des Factures");
        getContentPane().add(jLabel4);
        jLabel4.setBounds(140, 60, 200, 28);

        tablefact.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Réference ", "Montant", "Nom Patient", "Date paiement"
            }
        ));
        jScrollPane1.setViewportView(tablefact);

        getContentPane().add(jScrollPane1);
        jScrollPane1.setBounds(160, 200, 470, 160);

        jLabel6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gcm/image/facture.jpg"))); // NOI18N
        getContentPane().add(jLabel6);
        jLabel6.setBounds(0, 0, 800, 580);

        listfact.setText("Liste");
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
        supfact.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                supfactActionPerformed(evt);
            }
        });
        jMenuBar1.add(supfact);

        modiffact.setText("Modifier");
        modiffact.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                modiffactMouseClicked(evt);
            }
        });
        modiffact.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                modiffactActionPerformed(evt);
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
public ArrayList <Facture>listfact() throws SQLException{
    ArrayList <Facture> lfact = new  ArrayList <Facture>();
   
Connect c= new Connect();
String req = "select * from facture";
stmt=  c.conx.createStatement();
Facture f;
ResultSet rs = stmt.executeQuery(req);
while (rs.next()) {
  f = new Facture(rs.getInt("referencefacture"),rs.getString("montant"),rs.getString("nompatient"),rs.getString("date_paiement"));
    lfact.add(f);
}
return lfact;
}

public void affiche() throws SQLException{
ArrayList<Facture> liste = listfact();
DefaultTableModel model = (DefaultTableModel)tablefact.getModel();
Object[] f1 =new Object[4];
for(int i=0;i<liste.size();i++)
{
    f1[0]= liste.get(i).getReferencefacture();
    f1[1]= liste.get(i).getMontat();
    f1[2]= liste.get(i).getNompatient();
    f1[3]= liste.get(i).getDate_paiement();
    
    model.addRow(f1);
}
} 

    private void ajoutfactMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ajoutfactMouseClicked
        // TODO add your handling code here:
          new AjoutFacture().setVisible(true); dispose();
         dispose();
        
        
    }//GEN-LAST:event_ajoutfactMouseClicked

    private void supfactActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_supfactActionPerformed
        // TODO add your handling code here:
          new SupprimerFacture().setVisible(true);
         dispose();
    }//GEN-LAST:event_supfactActionPerformed

    private void modiffactActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_modiffactActionPerformed
        // TODO add your handling code here:
        
          new ModifiFacture().setVisible(true);
         dispose();
    }//GEN-LAST:event_modiffactActionPerformed

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

    private void supfactMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_supfactMouseClicked
        // TODO add your handling code here:
      new  SupprimerFacture().setVisible(true);
        dispose();
    }//GEN-LAST:event_supfactMouseClicked

    private void modiffactMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_modiffactMouseClicked
        // TODO add your handling code here:
        new ModifiFacture().setVisible(true);
        dispose();
    }//GEN-LAST:event_modiffactMouseClicked

    private void jMenu1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jMenu1MouseClicked
        // TODO add your handling code here:
         new Statistique().setVisible(true);
        dispose();
    }//GEN-LAST:event_jMenu1MouseClicked

    public static void main(String args[]) {
       
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    new ListeFacture().setVisible(true);
                } catch (SQLException ex) {
                    Logger.getLogger(ListeFacture.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenu ajoutfact;
    private javax.swing.JLabel decfact;
    private javax.swing.JLabel homefact;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JMenu listfact;
    private javax.swing.JMenu modiffact;
    private javax.swing.JMenu supfact;
    private javax.swing.JTable tablefact;
    // End of variables declaration//GEN-END:variables
}
