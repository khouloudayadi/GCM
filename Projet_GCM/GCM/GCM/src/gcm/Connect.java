
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gcm;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
/**
 *
 * @author Client
 */
public class Connect {
     Connection conx=null ;
     
 public Connect() throws SQLException{

     try {
         Class.forName("com.mysql.jdbc.Driver");
         
           conx = DriverManager.getConnection("jdbc:mysql://localhost:3306/gcm","root","");
          System.out.println("Connexion établie");
     } catch (ClassNotFoundException ex) {
         Logger.getLogger(Connect.class.getName()).log(Level.SEVERE, null, ex);
     }
  
}}

