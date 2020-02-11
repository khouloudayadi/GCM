
package gcm;


import java.sql.*;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.DefaultTableModel;


public class ListePatient extends javax.swing.JFrame {
 Connection conx = null;
    Statement stmt = null;
    ResultSet res = null;
    
    public ListePatient() throws SQLException {
        initComponents();
        affiche();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        decp = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        homp = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        lpatient = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        jMenuBar1 = new javax.swing.JMenuBar();
        liste = new javax.swing.JMenu();
        ajouter = new javax.swing.JMenu();
        supprimer = new javax.swing.JMenu();
        modifier = new javax.swing.JMenu();
        rech = new javax.swing.JMenu();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setLocation(new java.awt.Point(300, 100));
        setMinimumSize(new java.awt.Dimension(800, 600));
        setPreferredSize(new java.awt.Dimension(800, 600));
        setResizable(false);
        getContentPane().setLayout(null);

        decp.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gcm/image/deccc1.png"))); // NOI18N
        decp.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                decpMouseClicked(evt);
            }
        });
        getContentPane().add(decp);
        decp.setBounds(740, 60, 40, 40);

        jLabel2.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Liste Des Patients");
        getContentPane().add(jLabel2);
        jLabel2.setBounds(140, 67, 200, 40);

        homp.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gcm/image/home1.png"))); // NOI18N
        homp.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                hompMouseClicked(evt);
            }
        });
        getContentPane().add(homp);
        homp.setBounds(700, 60, 30, 40);

        lpatient.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Num Cnam", "Nom", "Prenom", "Adresse", "E-mail", "Tél", "Date naissance", "Maladie chronique", "Sang"
            }
        ));
        lpatient.setRowHeight(28);
        jScrollPane2.setViewportView(lpatient);

        getContentPane().add(jScrollPane2);
        jScrollPane2.setBounds(30, 190, 750, 200);

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gcm/image/accpatient_1_1.png"))); // NOI18N
        getContentPane().add(jLabel1);
        jLabel1.setBounds(0, 0, 800, 600);

        liste.setText("Liste");
        liste.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                listeMouseClicked(evt);
            }
        });
        liste.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                listeActionPerformed(evt);
            }
        });
        liste.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                listeKeyPressed(evt);
            }
        });
        jMenuBar1.add(liste);

        ajouter.setText("Ajouter");
        ajouter.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                ajouterMouseClicked(evt);
            }
        });
        jMenuBar1.add(ajouter);

        supprimer.setText("Supprimer");
        supprimer.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                supprimerMouseClicked(evt);
            }
        });
        supprimer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                supprimerActionPerformed(evt);
            }
        });
        jMenuBar1.add(supprimer);

        modifier.setText("Modifier");
        modifier.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                modifierMouseClicked(evt);
            }
        });
        jMenuBar1.add(modifier);

        rech.setText("Rechercher");
        rech.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                rechMouseClicked(evt);
            }
        });
        jMenuBar1.add(rech);

        setJMenuBar(jMenuBar1);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void hompMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_hompMouseClicked
       
         new Accueil().setVisible(true);
         dispose();
    }//GEN-LAST:event_hompMouseClicked

    private void decpMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_decpMouseClicked
   
         new Login().setVisible(true);
         dispose();
    }//GEN-LAST:event_decpMouseClicked
public ArrayList <Patient> patientlist() throws SQLException{
    ArrayList <Patient> listep = new  ArrayList <Patient>();
   
Connect c= new Connect();
String req = "select * from patient";
stmt=  c.conx.createStatement();
Patient p;
ResultSet rs = stmt.executeQuery(req);
while (rs.next()) {
   p = new Patient(rs.getString("numcnam"),rs.getString("nom"),rs.getString("prenom"),rs.getString("adresse"),rs.getString("mail"),rs.getString("tel"),rs.getString("date_naissance"),rs.getString("maladie_chronique"),rs.getString("sang"));
    listep.add(p);
}
return listep ;
}

public void affiche() throws SQLException{
ArrayList<Patient> liste = patientlist();
DefaultTableModel model = (DefaultTableModel)lpatient.getModel();
Object[] p1 =new Object[9];
for(int i=0;i<liste.size();i++)
{
    p1[0]= liste.get(i).getNum();
    p1[1]= liste.get(i).getNom();
    p1[2]= liste.get(i).getPrenom();
    p1[3]= liste.get(i).getAdresse();
    p1[4]= liste.get(i).getMail();
    p1[5]= liste.get(i).getTel();
    p1[6]= liste.get(i).getDate();
    p1[7]= liste.get(i).getMaladie();
    p1[8]= liste.get(i).getSang();
    model.addRow(p1);
}
 

}
    private void listeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_listeActionPerformed
     try {
         affiche();
     } catch (SQLException ex) {
         Logger.getLogger(ListePatient.class.getName()).log(Level.SEVERE, null, ex);
     }
    }//GEN-LAST:event_listeActionPerformed

    private void supprimerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_supprimerActionPerformed
   
         new SupprimerPatient().setVisible(true);
         dispose();
           
    }//GEN-LAST:event_supprimerActionPerformed

    private void listeKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_listeKeyPressed

        
    }//GEN-LAST:event_listeKeyPressed

    private void listeMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_listeMouseClicked
       
    }//GEN-LAST:event_listeMouseClicked

    private void ajouterMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ajouterMouseClicked
     
        new AjoutPatient().setVisible(true);
         dispose();
    }//GEN-LAST:event_ajouterMouseClicked

    private void supprimerMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_supprimerMouseClicked
      
        new SupprimerPatient().setVisible(true);
         dispose();
    }//GEN-LAST:event_supprimerMouseClicked

    private void modifierMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_modifierMouseClicked
        new ModifPatient().setVisible(true);
         dispose();
    }//GEN-LAST:event_modifierMouseClicked

    private void rechMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_rechMouseClicked
        
        new RecherchePatient().setVisible(true);
         dispose();
    }//GEN-LAST:event_rechMouseClicked

   
    public static void main(String args[]) {
       
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    new ListePatient().setVisible(true);
                    new ListePatient().setLocationRelativeTo(null);
                } catch (SQLException ex) {
                    Logger.getLogger(ListePatient.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenu ajouter;
    private javax.swing.JLabel decp;
    private javax.swing.JLabel homp;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JMenu liste;
    private javax.swing.JTable lpatient;
    private javax.swing.JMenu modifier;
    private javax.swing.JMenu rech;
    private javax.swing.JMenu supprimer;
    // End of variables declaration//GEN-END:variables
}
