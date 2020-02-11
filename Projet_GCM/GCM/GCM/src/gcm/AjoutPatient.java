
package gcm;

import com.sun.glass.events.KeyEvent;
import java.lang.invoke.MethodHandles;
import java.sql.*;
import java.text.SimpleDateFormat;

import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.JOptionPane;
import jdk.internal.cmm.SystemResourcePressureImpl;


public class AjoutPatient extends javax.swing.JFrame {
Connection conx = null;
    Statement stmt = null;
    PreparedStatement res = null;
    String nom1,prenom1,date1,mail1,mala1,adr1,sang1, numc1,tel1;
   
   
    
    public void ajoutPatient() {
     
       nom1 =(nompp.getText());
       prenom1 =(prenompp.getText());
     //  Date date1 =(Date) (date.getDate());
       SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
       date1 = sdf.format(datepp.getDate());
       tel1 =(telpp.getText());
       adr1 =(adr.getText());
       mail1 =(mailpp.getText());
       mala1 =(malapp.getText());
       sang1 =(sangpp.getText());
       numc1 =(numcpp.getText());
     try {           
           int x= Integer.parseInt(tel1);
           int y= Integer.parseInt(numc1);
         
 
// On déclare le pattern que l’on doit vérifier
Pattern p = Pattern.compile(".+@.+\\.[a-z]+");
// On déclare un matcher, qui comparera le pattern avec la
// string passée en argument
Matcher m = p.matcher(mail1);
// Si l’adresse mail saisie ne correspond au format d’une
// adresse mail on un affiche un message à l'utilisateur
if (!m.matches()) { 
 JOptionPane.showMessageDialog(null, "Email nom valide");}   
else if((nom1.equals(""))|| (prenom1.equals(""))|| (date1.equals(""))|| (x == 0)||(adr1.equals(""))|| (mail1.equals(""))||(mala1.equals(""))||(sang1.equals(""))|| (y==0))
          {
    
        JOptionPane.showMessageDialog(null, " veuillez saisir les champs obligatoires");
          }
      
       else {
           
Connect c= new Connect();
String req = "INSERT INTO `patient`(`numcnam`, `nom`, `prenom`, `adresse`, `mail`, `tel`, `date_naissance`, `maladie_chronique`, `sang`) VALUES ('"+y+"','"+nom1+"','"+prenom1+"','"+adr1+"','"+mail1+"','"+x+"','"+date1+"','"+mala1+"','"+sang1+"')";
stmt=  c.conx.createStatement();

int nb = stmt.executeUpdate(req);
    
    if(nb == 1)
        {
         JOptionPane.showMessageDialog(this, "ajout est effectuée avec succée","Ajouter un patient",JOptionPane.INFORMATION_MESSAGE);
			new AjoutPatient().setVisible(true);
	                 dispose();
        }
    else
         JOptionPane.showMessageDialog(null, "Erreur !!! ");
    
        }
        
     }catch(SQLException e) {JOptionPane.showMessageDialog(this, "Patient existe déja ","Erreur d'ajout",JOptionPane.ERROR_MESSAGE);}
    catch( NumberFormatException e) {JOptionPane.showMessageDialog(this, "Verifiez le tél ou le num de CNAM de patient","Erreur d'ajout",JOptionPane.WARNING_MESSAGE);}
   
    }
    public AjoutPatient() {
        initComponents();
    }

   
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        home = new javax.swing.JLabel();
        dec = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        malapp = new javax.swing.JTextField();
        prenompp = new javax.swing.JTextField();
        numcpp = new javax.swing.JTextField();
        adr = new javax.swing.JTextField();
        nompp = new javax.swing.JTextField();
        mailpp = new javax.swing.JTextField();
        telpp = new javax.swing.JTextField();
        sangpp = new javax.swing.JTextField();
        ajout = new javax.swing.JButton();
        datepp = new com.toedter.calendar.JDateChooser();
        jLabel1 = new javax.swing.JLabel();
        jMenuBar1 = new javax.swing.JMenuBar();
        listp = new javax.swing.JMenu();
        ajoutp = new javax.swing.JMenu();
        supp = new javax.swing.JMenu();
        modifp = new javax.swing.JMenu();
        rechp = new javax.swing.JMenu();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setLocation(new java.awt.Point(300, 90));
        setMinimumSize(new java.awt.Dimension(800, 600));
        setResizable(false);
        getContentPane().setLayout(null);

        home.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gcm/image/home1.png"))); // NOI18N
        home.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                homeMouseClicked(evt);
            }
        });
        getContentPane().add(home);
        home.setBounds(700, 70, 30, 30);

        dec.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gcm/image/deccc1.png"))); // NOI18N
        dec.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                decMouseClicked(evt);
            }
        });
        getContentPane().add(dec);
        dec.setBounds(740, 70, 40, 30);

        jLabel2.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Ajouter un patient");
        getContentPane().add(jLabel2);
        jLabel2.setBounds(140, 70, 240, 28);

        jLabel6.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel6.setText("Nom:");
        getContentPane().add(jLabel6);
        jLabel6.setBounds(130, 180, 33, 30);

        jLabel7.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel7.setText("Prénom:");
        getContentPane().add(jLabel7);
        jLabel7.setBounds(420, 177, 60, 30);

        jLabel8.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel8.setText("Date Naissance:");
        getContentPane().add(jLabel8);
        jLabel8.setBounds(70, 240, 100, 20);

        jLabel9.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel9.setText("Maladies chronique:");
        getContentPane().add(jLabel9);
        jLabel9.setBounds(220, 417, 140, 30);

        jLabel10.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel10.setText("Num Cnam:");
        getContentPane().add(jLabel10);
        jLabel10.setBounds(90, 360, 90, 17);

        jLabel11.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel11.setText("E-mail:");
        getContentPane().add(jLabel11);
        jLabel11.setBounds(430, 300, 60, 17);

        jLabel12.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel12.setText("Sang:");
        getContentPane().add(jLabel12);
        jLabel12.setBounds(440, 350, 40, 20);

        jLabel13.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel13.setText("Tél:");
        getContentPane().add(jLabel13);
        jLabel13.setBounds(130, 290, 40, 20);

        jLabel14.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel14.setText("Adresse:");
        getContentPane().add(jLabel14);
        jLabel14.setBounds(420, 237, 60, 30);
        getContentPane().add(malapp);
        malapp.setBounds(360, 420, 170, 30);
        getContentPane().add(prenompp);
        prenompp.setBounds(500, 180, 170, 30);

        numcpp.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                numcppKeyTyped(evt);
            }
        });
        getContentPane().add(numcpp);
        numcpp.setBounds(190, 350, 170, 30);
        getContentPane().add(adr);
        adr.setBounds(500, 240, 170, 30);
        getContentPane().add(nompp);
        nompp.setBounds(190, 180, 170, 30);
        getContentPane().add(mailpp);
        mailpp.setBounds(500, 290, 170, 30);

        telpp.setToolTipText("");
        getContentPane().add(telpp);
        telpp.setBounds(190, 290, 170, 30);
        getContentPane().add(sangpp);
        sangpp.setBounds(500, 350, 170, 30);

        ajout.setFont(new java.awt.Font("Times New Roman", 1, 16)); // NOI18N
        ajout.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gcm/image/icon_ajout.png"))); // NOI18N
        ajout.setText("Ajouter");
        ajout.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ajoutActionPerformed(evt);
            }
        });
        getContentPane().add(ajout);
        ajout.setBounds(530, 490, 130, 40);
        getContentPane().add(datepp);
        datepp.setBounds(190, 240, 170, 30);

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gcm/image/accpatient_1_1.png"))); // NOI18N
        getContentPane().add(jLabel1);
        jLabel1.setBounds(0, 0, 800, 600);

        listp.setText("Liste");
        listp.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                listpMouseClicked(evt);
            }
        });
        listp.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                listpActionPerformed(evt);
            }
        });
        jMenuBar1.add(listp);

        ajoutp.setText("Ajouter");
        ajoutp.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                ajoutpMouseClicked(evt);
            }
        });
        jMenuBar1.add(ajoutp);

        supp.setText("Supprimer");
        supp.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                suppMouseClicked(evt);
            }
        });
        supp.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                suppActionPerformed(evt);
            }
        });
        jMenuBar1.add(supp);

        modifp.setText("Modifier");
        modifp.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                modifpMouseClicked(evt);
            }
        });
        jMenuBar1.add(modifp);

        rechp.setText("Rechercher");
        rechp.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                rechpMouseClicked(evt);
            }
        });
        jMenuBar1.add(rechp);

        setJMenuBar(jMenuBar1);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void suppActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_suppActionPerformed
        // TODO add your handling code here:
        
    }//GEN-LAST:event_suppActionPerformed

    private void homeMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_homeMouseClicked
        // TODO add your handling code here:
         new Accueil().setVisible(true);
         dispose();
    }//GEN-LAST:event_homeMouseClicked

    private void ajoutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ajoutActionPerformed
        ajoutPatient() ;
    }//GEN-LAST:event_ajoutActionPerformed

    private void listpActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_listpActionPerformed
        // TODO add your handling code here:
      
    }//GEN-LAST:event_listpActionPerformed

    private void listpMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_listpMouseClicked
    try {
        // TODO add your handling code here:
        new ListePatient().setVisible(true);
    } catch (SQLException ex) {
        Logger.getLogger(AjoutPatient.class.getName()).log(Level.SEVERE, null, ex);
    }
         dispose();
    }//GEN-LAST:event_listpMouseClicked

    private void ajoutpMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ajoutpMouseClicked
        // TODO add your handling code here:
        
    }//GEN-LAST:event_ajoutpMouseClicked

    private void suppMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_suppMouseClicked
        // TODO add your handling code here:
         new SupprimerPatient().setVisible(true);
         dispose();
           
    }//GEN-LAST:event_suppMouseClicked

    private void modifpMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_modifpMouseClicked
        // TODO add your handling code here:
         new ModifPatient().setVisible(true);
         dispose();
    }//GEN-LAST:event_modifpMouseClicked

    private void rechpMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_rechpMouseClicked
        // TODO add your handling code here:
         new RecherchePatient().setVisible(true);
         dispose();
    }//GEN-LAST:event_rechpMouseClicked

    private void decMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_decMouseClicked
        // TODO add your handling code here:
      new Login().setVisible(true);
         dispose();   
    }//GEN-LAST:event_decMouseClicked

    private void numcppKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_numcppKeyTyped
   
    }//GEN-LAST:event_numcppKeyTyped

    
    public static void main(String args[]) {
     
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new AjoutPatient().setVisible(true);
                new AjoutPatient().setLocationRelativeTo(null);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField adr;
    private javax.swing.JButton ajout;
    private javax.swing.JMenu ajoutp;
    private com.toedter.calendar.JDateChooser datepp;
    private javax.swing.JLabel dec;
    private javax.swing.JLabel home;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenu listp;
    private javax.swing.JTextField mailpp;
    private javax.swing.JTextField malapp;
    private javax.swing.JMenu modifp;
    private javax.swing.JTextField nompp;
    private javax.swing.JTextField numcpp;
    private javax.swing.JTextField prenompp;
    private javax.swing.JMenu rechp;
    private javax.swing.JTextField sangpp;
    private javax.swing.JMenu supp;
    private javax.swing.JTextField telpp;
    // End of variables declaration//GEN-END:variables
}
