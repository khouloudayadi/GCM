
package gcm;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;


public class AjoutConsultation extends javax.swing.JFrame {

   Connection conx = null;
    PreparedStatement stmt = null;
    ResultSet res = null;
    String nom1,date1,numcnam1,analy1,pres1,observ1;
   
   
    
    public void ajoutConsultation() throws SQLException{
     
        nom1 =(nomcons.getText());
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        date1 = sdf.format(datecons.getDate());
        numcnam1 =(numcons.getText());
        analy1 =(anal.getText());
        pres1 =(presc.getText());
        observ1 =(observ.getText());
          try {
          int n = Integer.parseInt(numcnam1);
        
        if((nom1.equals(""))|| (date1.equals(""))|| (n==0)||(analy1.equals(""))|| (pres1.equals(""))||(observ1.equals("")))
        {
    
        JOptionPane.showMessageDialog(null, " veuillez saisir les champs obligatoires");
        }
        else {
 Connect c= new Connect();
stmt=  c.conx.prepareStatement("INSERT INTO consultation(`nom_maladie`, `prescription_medicale`,`observation`, `analyse`, `date_consultation`, `numero_cnam`) VALUES(?,?,?,?,?,?)" );
  stmt.setString(1, nom1);
  stmt.setString(2, pres1);
  stmt.setString(3, observ1);
  stmt.setString(4, analy1);
  stmt.setString(5, date1);
  stmt.setString(6, numcnam1);

int nb = stmt.executeUpdate();
    
    if(nb == 1)
    {
       int reponse = JOptionPane.showConfirmDialog(null, "ajout est effectuée avec succée", 
	"", JOptionPane.YES_NO_OPTION);
 
          if(reponse == JOptionPane.YES_OPTION){
	   new AjoutConsultation().setVisible(true);
	   dispose();}
    }
     else
     JOptionPane.showMessageDialog(null, "Erreur !!! ");
    
    } }  catch( NumberFormatException e) {JOptionPane.showMessageDialog(this, "Verifiez num de CNAM de patient","Erreur d'ajout",JOptionPane.WARNING_MESSAGE);}
   
       
    }
    public AjoutConsultation() {
        initComponents();
    }

    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        homecons = new javax.swing.JLabel();
        deccons = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        anal = new javax.swing.JTextField();
        numcons = new javax.swing.JTextField();
        nomcons = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        observ = new javax.swing.JTextArea();
        btnajout = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        presc = new javax.swing.JTextArea();
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

        jLabel6.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel6.setText("Nom Maladie:");
        getContentPane().add(jLabel6);
        jLabel6.setBounds(70, 180, 130, 30);

        jLabel8.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel8.setText("Num Cnam:");
        getContentPane().add(jLabel8);
        jLabel8.setBounds(80, 250, 100, 20);

        jLabel13.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel13.setText("Analyse:");
        getContentPane().add(jLabel13);
        jLabel13.setBounds(460, 250, 70, 20);

        jLabel11.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel11.setText("Observation: ");
        getContentPane().add(jLabel11);
        jLabel11.setBounds(440, 320, 90, 17);

        jLabel14.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel14.setText("Perscription:");
        getContentPane().add(jLabel14);
        jLabel14.setBounds(80, 310, 80, 30);

        jLabel7.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel7.setText("Date consultation:");
        getContentPane().add(jLabel7);
        jLabel7.setBounds(400, 180, 160, 30);
        getContentPane().add(anal);
        anal.setBounds(540, 240, 170, 40);

        numcons.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                numconsActionPerformed(evt);
            }
        });
        getContentPane().add(numcons);
        numcons.setBounds(190, 240, 180, 40);
        getContentPane().add(nomcons);
        nomcons.setBounds(190, 170, 180, 40);

        jLabel2.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Ajouter Un Consultation");
        getContentPane().add(jLabel2);
        jLabel2.setBounds(140, 67, 280, 40);

        observ.setColumns(20);
        observ.setRows(5);
        jScrollPane1.setViewportView(observ);

        getContentPane().add(jScrollPane1);
        jScrollPane1.setBounds(540, 310, 170, 90);

        btnajout.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        btnajout.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gcm/image/icon_ajout.png"))); // NOI18N
        btnajout.setText("Ajouter");
        btnajout.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnajoutActionPerformed(evt);
            }
        });
        getContentPane().add(btnajout);
        btnajout.setBounds(380, 460, 130, 40);

        presc.setColumns(20);
        presc.setRows(5);
        jScrollPane2.setViewportView(presc);

        getContentPane().add(jScrollPane2);
        jScrollPane2.setBounds(190, 310, 180, 90);
        getContentPane().add(datecons);
        datecons.setBounds(540, 170, 170, 40);

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
        // TODO add your handling code here:
        new Accueil().setVisible(true);
        dispose();
    }//GEN-LAST:event_homeconsMouseClicked

    private void decconsMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_decconsMouseClicked
        // TODO add your handling code here:
        new Login().setVisible(true);
        dispose();
    }//GEN-LAST:event_decconsMouseClicked

    private void numconsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_numconsActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_numconsActionPerformed

    private void btnajoutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnajoutActionPerformed
       try {
           // TODO add your handling code here:
           ajoutConsultation();
       } catch (SQLException ex) {
           Logger.getLogger(AjoutConsultation.class.getName()).log(Level.SEVERE, null, ex);
       }
    }//GEN-LAST:event_btnajoutActionPerformed

    private void listeconsMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_listeconsMouseClicked
       try {
           // TODO add your handling code here:
           new ListeConsultation().setVisible(true);
       } catch (SQLException ex) {
           Logger.getLogger(AjoutConsultation.class.getName()).log(Level.SEVERE, null, ex);
       }
        dispose();
    }//GEN-LAST:event_listeconsMouseClicked

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
                new AjoutConsultation().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenu ajoutcons;
    private javax.swing.JTextField anal;
    private javax.swing.JButton btnajout;
    private com.toedter.calendar.JDateChooser datecons;
    private javax.swing.JLabel deccons;
    private javax.swing.JLabel homecons;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
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
    private javax.swing.JTextArea observ;
    private javax.swing.JTextArea presc;
    private javax.swing.JMenu supcons;
    // End of variables declaration//GEN-END:variables
}
