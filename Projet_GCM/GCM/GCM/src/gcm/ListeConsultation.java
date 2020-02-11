
package gcm;

import java.sql.*;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.DefaultTableModel;


public class ListeConsultation extends javax.swing.JFrame {

    Connection conx = null;
    Statement stmt = null;
    ResultSet res = null;
    public ListeConsultation() throws SQLException {
        initComponents();
         affiche();
    }

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel2 = new javax.swing.JLabel();
        homecons = new javax.swing.JLabel();
        deccons = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tablecons = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        jMenuBar1 = new javax.swing.JMenuBar();
        listecons = new javax.swing.JMenu();
        ajoutcons = new javax.swing.JMenu();
        supcons = new javax.swing.JMenu();
        modifcons = new javax.swing.JMenu();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setLocation(new java.awt.Point(300, 90));
        setMinimumSize(new java.awt.Dimension(800, 600));
        setPreferredSize(new java.awt.Dimension(800, 600));
        setResizable(false);
        getContentPane().setLayout(null);

        jLabel2.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Liste Des Consultations");
        getContentPane().add(jLabel2);
        jLabel2.setBounds(140, 67, 250, 40);

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

        tablecons.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Nom Maladie", "Prescription Medicale", "Observation", "Analyse", "Date consultation", "Num Cnam"
            }
        ));
        tablecons.setRowHeight(28);
        jScrollPane1.setViewportView(tablecons);

        getContentPane().add(jScrollPane1);
        jScrollPane1.setBounds(20, 250, 770, 150);

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gcm/image/aacueilcons.jpg"))); // NOI18N
        getContentPane().add(jLabel1);
        jLabel1.setBounds(0, 0, 800, 600);

        listecons.setText("Liste");
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

    
    public ArrayList <Consultation> consultationList() throws SQLException{
    ArrayList <Consultation> listecons = new  ArrayList <Consultation>();
   // nom_maladie,prescription_medicale,observation,analyse, date_cons,numero_cnam
Connect c= new Connect();
String req = "select * from consultation";
stmt=  c.conx.createStatement();
Consultation cons;
ResultSet rs = stmt.executeQuery(req);
while (rs.next()) {
   cons = new Consultation(rs.getString("nom_maladie"),rs.getString("prescription_medicale"),rs.getString("observation"),rs.getString("analyse"),rs.getString("date_consultation"),rs.getString("numero_cnam"));
    listecons.add(cons);
}
return listecons ;
}

public void affiche() throws SQLException{
ArrayList<Consultation> liste = consultationList();
DefaultTableModel model = (DefaultTableModel)tablecons.getModel();
Object[] C =new Object[6];
for(int i=0;i<liste.size();i++)
{
    C[0]= liste.get(i).getNom_maladie();
    C[1]= liste.get(i).getPrescription_medicale();
    C[2]= liste.get(i).getObservation();
    C[3]= liste.get(i).getAnalyse();
    C[4]= liste.get(i).getDate_consultation();
    C[5]= liste.get(i).getNumero_cnam();
 
   
    model.addRow(C);
}
 
}
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
        // TODO add your handling code here:
        new ModifConsultation().setVisible(true);
        dispose();
    }//GEN-LAST:event_modifconsMouseClicked

    
    public static void main(String args[]) {
       
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    new ListeConsultation().setVisible(true);
                } catch (SQLException ex) {
                    Logger.getLogger(ListeConsultation.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenu ajoutcons;
    private javax.swing.JLabel deccons;
    private javax.swing.JLabel homecons;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JMenu listecons;
    private javax.swing.JMenu modifcons;
    private javax.swing.JMenu supcons;
    private javax.swing.JTable tablecons;
    // End of variables declaration//GEN-END:variables
}
