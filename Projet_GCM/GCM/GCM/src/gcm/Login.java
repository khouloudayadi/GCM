/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gcm;

import java.sql.*;
import javax.swing.JOptionPane;

/**
 *
 * @author Client
 */
public class Login extends javax.swing.JFrame {
    Connection conx = null;
    Statement stmt = null;
    ResultSet res = null;
    public Login() {
        initComponents();
    }

   
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        user = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        annul = new javax.swing.JButton();
        connect = new javax.swing.JButton();
        pass = new javax.swing.JPasswordField();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setLocation(new java.awt.Point(400, 200));
        setMinimumSize(new java.awt.Dimension(500, 400));
        setPreferredSize(new java.awt.Dimension(500, 400));
        setResizable(false);
        getContentPane().setLayout(null);

        user.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                userActionPerformed(evt);
            }
        });
        getContentPane().add(user);
        user.setBounds(120, 120, 150, 30);

        jLabel3.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel3.setText("User  :");
        getContentPane().add(jLabel3);
        jLabel3.setBounds(50, 117, 50, 30);

        jLabel4.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel4.setText("Password :");
        getContentPane().add(jLabel4);
        jLabel4.setBounds(30, 187, 80, 20);

        jLabel2.setFont(new java.awt.Font("Times New Roman", 1, 20)); // NOI18N
        jLabel2.setText("Authentification");
        getContentPane().add(jLabel2);
        jLabel2.setBounds(140, 40, 140, 30);

        annul.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        annul.setText("Annuler");
        annul.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                annulActionPerformed(evt);
            }
        });
        getContentPane().add(annul);
        annul.setBounds(200, 270, 100, 30);

        connect.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        connect.setText("Connecter");
        connect.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                connectActionPerformed(evt);
            }
        });
        getContentPane().add(connect);
        connect.setBounds(70, 270, 100, 30);
        getContentPane().add(pass);
        pass.setBounds(120, 180, 150, 30);

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gcm/image/login.jpg"))); // NOI18N
        getContentPane().add(jLabel1);
        jLabel1.setBounds(0, 0, 500, 400);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void userActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_userActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_userActionPerformed

    private void connectActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_connectActionPerformed
      
         String usr=(user.getText());
							
	 char[] pswd=pass.getPassword();
	 String pswd1 =new String(pswd);
        
      
            
            if((usr.equals(""))||(pswd1.equals("")))
     JOptionPane.showMessageDialog(null, "veuillez saisir les champs obligatoires", "INCONNU", JOptionPane.ERROR_MESSAGE);                        
            else {	      			
      try  {
	Connect c = new Connect();
	stmt=  c.conx.createStatement();
	ResultSet rs = stmt.executeQuery("Select* from medecin");
	boolean tests=false;
                              
	while(rs.next()){
		if(usr.equals(rs.getObject("login")) && pswd1.equals(rs.getObject("password"))){
			
					
			tests=true;
							
			new Accueil().setVisible(true);
                        dispose();
			}
			}
		//si user ou mdp invalide, on affiche un message d'erreur
	       if(tests==false){
              JOptionPane.showMessageDialog(null, "Le nom d'utilisateur ou le mot de pass est incorrect", "INCONNU", JOptionPane.ERROR_MESSAGE);                        
					}
        }catch(SQLException ex){
	ex.printStackTrace();
	JOptionPane.showMessageDialog(null,"ERREUR DE CONNEXION","Message d’avertissement",JOptionPane.ERROR_MESSAGE);}
        catch(Exception e) {
	e.printStackTrace();
	//System.out.println("Echec de connexion");
        }}
    }//GEN-LAST:event_connectActionPerformed

    private void annulActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_annulActionPerformed
        pass.setText("");
        user.setText("");
    }//GEN-LAST:event_annulActionPerformed

   
    public static void main(String args[]) {
        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Login().setLocationRelativeTo(null);
                new Login().setVisible(true);
               
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton annul;
    private javax.swing.JButton connect;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPasswordField pass;
    private javax.swing.JTextField user;
    // End of variables declaration//GEN-END:variables
}
