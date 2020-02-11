package gcm;

import java.sql.*;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.DefaultTableModel;



public class ListeRdv extends javax.swing.JFrame {
    Connection conx = null;
    Statement stmt = null;
    ResultSet res = null;
    public ListeRdv() throws SQLException {
        initComponents();
         affiche();
    }

  
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        decrdv = new javax.swing.JLabel();
        homerdv = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tablerdv = new javax.swing.JTable();
        jLabel6 = new javax.swing.JLabel();
        jMenuBar1 = new javax.swing.JMenuBar();
        listerdv = new javax.swing.JMenu();
        ajoutrdv = new javax.swing.JMenu();
        suprdv = new javax.swing.JMenu();
        modifrdv = new javax.swing.JMenu();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setLocation(new java.awt.Point(300, 100));
        setMinimumSize(new java.awt.Dimension(800, 600));
        setPreferredSize(new java.awt.Dimension(800, 600));
        setResizable(false);
        getContentPane().setLayout(null);

        decrdv.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gcm/image/deccc1.png"))); // NOI18N
        decrdv.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                decrdvMouseClicked(evt);
            }
        });
        getContentPane().add(decrdv);
        decrdv.setBounds(740, 60, 40, 30);

        homerdv.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gcm/image/home1.png"))); // NOI18N
        homerdv.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                homerdvMouseClicked(evt);
            }
        });
        getContentPane().add(homerdv);
        homerdv.setBounds(700, 60, 30, 29);

        jLabel4.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText(" Liste Des RDV");
        getContentPane().add(jLabel4);
        jLabel4.setBounds(160, 70, 200, 22);

        tablerdv.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID Rdv", "Heure", "date", "Nom Patient"
            }
        ));
        tablerdv.setRowHeight(28);
        jScrollPane1.setViewportView(tablerdv);

        getContentPane().add(jScrollPane1);
        jScrollPane1.setBounds(140, 180, 520, 140);

        jLabel6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gcm/image/rdvv.jpg"))); // NOI18N
        getContentPane().add(jLabel6);
        jLabel6.setBounds(0, 0, 800, 580);

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
        jMenuBar1.add(suprdv);

        modifrdv.setText("Modifier");
        modifrdv.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                modifrdvMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                modifrdvMouseEntered(evt);
            }
        });
        jMenuBar1.add(modifrdv);

        setJMenuBar(jMenuBar1);

        pack();
    }// </editor-fold>//GEN-END:initComponents
public ArrayList <Rendez_vous> Rdvlist() throws SQLException{
    ArrayList <Rendez_vous> listerdv = new  ArrayList <Rendez_vous>();
   
Connect c= new Connect();
String req = "select * from rdv";
stmt=  c.conx.createStatement();
Rendez_vous r;
ResultSet rs = stmt.executeQuery(req);
while (rs.next()) {
   r = new Rendez_vous(rs.getInt("idrdv"),rs.getString("date"),rs.getString("heure"),rs.getString("nom_patient"));
    listerdv.add(r);
}
return listerdv ;
}

public void affiche() throws SQLException{
ArrayList<Rendez_vous> liste = Rdvlist();
DefaultTableModel model = (DefaultTableModel)tablerdv.getModel();
Object[] r1 =new Object[4];
for(int i=0;i<liste.size();i++)
{
    r1[0]= liste.get(i).getIdrdv();
    r1[1]= liste.get(i).getDate();
    r1[2]= liste.get(i).getHeure();
    r1[3]= liste.get(i).getNompatient();
    
    model.addRow(r1);
}
} 

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

    private void listerdvMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_listerdvMouseClicked
     
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

    private void modifrdvMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_modifrdvMouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_modifrdvMouseEntered

    private void modifrdvMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_modifrdvMouseClicked
        // TODO add your handling code here:
        new ModifRdv().setVisible(true);
        dispose();
    }//GEN-LAST:event_modifrdvMouseClicked

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
            java.util.logging.Logger.getLogger(ListeRdv.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ListeRdv.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ListeRdv.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ListeRdv.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    new ListeRdv().setVisible(true);
                } catch (SQLException ex) {
                    Logger.getLogger(ListeRdv.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenu ajoutrdv;
    private javax.swing.JLabel decrdv;
    private javax.swing.JLabel homerdv;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JMenu listerdv;
    private javax.swing.JMenu modifrdv;
    private javax.swing.JMenu suprdv;
    private javax.swing.JTable tablerdv;
    // End of variables declaration//GEN-END:variables
}
