package gcm;

import java.awt.Color;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.renderer.category.BarRenderer;
import org.jfree.data.category.CategoryDataset;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.data.jdbc.JDBCCategoryDataset;


public class Statistique extends javax.swing.JFrame {
Connection conx = null;
    Statement stmt = null;
    PreparedStatement res = null;
    
    public Statistique() {
        initComponents();
        Statistique();
    }

    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        homecons = new javax.swing.JLabel();
        deccons = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        stat = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jMenuBar1 = new javax.swing.JMenuBar();
        listecons = new javax.swing.JMenu();
        ajoutcons = new javax.swing.JMenu();
        supcons = new javax.swing.JMenu();
        modifcons = new javax.swing.JMenu();
        jMenu1 = new javax.swing.JMenu();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setLocation(new java.awt.Point(300, 90));
        setMinimumSize(new java.awt.Dimension(800, 600));
        setPreferredSize(new java.awt.Dimension(800, 600));
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
        deccons.setBounds(740, 60, 50, 50);

        jLabel2.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Liste Des Consultations");
        getContentPane().add(jLabel2);
        jLabel2.setBounds(140, 67, 250, 40);
        getContentPane().add(stat);
        stat.setBounds(100, 130, 670, 470);

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gcm/image/aacueilcons.jpg"))); // NOI18N
        jLabel1.setText("jLabel1");
        getContentPane().add(jLabel1);
        jLabel1.setBounds(0, 4, 800, 600);

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

        jMenu1.setText("Statistique");
        jMenuBar1.add(jMenu1);

        setJMenuBar(jMenuBar1);

        pack();
    }// </editor-fold>//GEN-END:initComponents
public void Statistique(){
    try {
         
            String req = "select montant,date_paiement from facture" ;  
          
           Connect c= new Connect();
           
            JDBCCategoryDataset dataset = new JDBCCategoryDataset(c.conx,req);
            System.out.println("ffffff"+ dataset);
            //API java permettant de créer des graphique et de diagramme
            JFreeChart chart = ChartFactory.createBarChart("Statistique", "Date Paiement", "Montant", dataset,PlotOrientation.VERTICAL,false,true,true);
            //
            BarRenderer renderer = null;
            //renvoie l'axe du domaine pour le tracé
            CategoryPlot plot= null ;
            renderer= new BarRenderer();
            ChartPanel p1 =new ChartPanel(chart);
            p1.setSize(200, 200);
            stat.add(p1);
    }catch(Exception e){e.printStackTrace();}

   
   
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
            java.util.logging.Logger.getLogger(Statistique.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Statistique.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Statistique.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Statistique.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Statistique().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenu ajoutcons;
    private javax.swing.JLabel deccons;
    private javax.swing.JLabel homecons;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenu listecons;
    private javax.swing.JMenu modifcons;
    private javax.swing.JPanel stat;
    private javax.swing.JMenu supcons;
    // End of variables declaration//GEN-END:variables
}
