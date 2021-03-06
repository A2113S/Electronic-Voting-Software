import java.sql.*;

import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Administrator
 */
public class Results extends javax.swing.JFrame {

    /**
     * Creates new form Results
     */
    public Results() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        Post_Title = new javax.swing.JLabel();
        jButton3 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        post = new javax.swing.JComboBox<>();
        jLabel5 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbl = new javax.swing.JTable();
        jLabel6 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        Post_Title.setFont(new java.awt.Font("Cambria", 1, 80)); // NOI18N
        Post_Title.setForeground(new java.awt.Color(255, 255, 255));
        Post_Title.setText("Voting Results");
        getContentPane().add(Post_Title, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 30, 570, 100));

        jButton3.setFont(new java.awt.Font("Poor Richard", 3, 36)); // NOI18N
        jButton3.setText("Reset votes");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton3, new org.netbeans.lib.awtextra.AbsoluteConstraints(760, 350, 280, 80));

        jButton2.setFont(new java.awt.Font("Tempus Sans ITC", 3, 36)); // NOI18N
        jButton2.setText("Main Screen");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(750, 480, 320, 60));

        post.setFont(new java.awt.Font("Poor Richard", 2, 36)); // NOI18N
        post.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Head_Boy", "Head_Girl", "Deputy_Head_Boy", "Deputy_Head_Girl", "Cleanliness_In_Charge", "Discipline_In_Charge", "Sports_Captain" }));
        post.setToolTipText("POST");
        post.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                postActionPerformed(evt);
            }
        });
        getContentPane().add(post, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 160, 360, 70));

        jLabel5.setFont(new java.awt.Font("Poor Richard", 1, 36)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Select Post");
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 160, 180, 70));

        jButton1.setFont(new java.awt.Font("Poor Richard", 3, 36)); // NOI18N
        jButton1.setText("Get Results");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(760, 250, 280, 80));

        tbl.setAutoCreateRowSorter(true);
        tbl.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        tbl.setFont(new java.awt.Font("Vrinda", 0, 26)); // NOI18N
        tbl.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Name", "Votes"
            }
        ));
        tbl.setName(""); // NOI18N
        tbl.setRowHeight(40);
        tbl.setRowMargin(9);
        jScrollPane1.setViewportView(tbl);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 260, 610, 330));

        jLabel6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Arrival_4K_Motion_Background_Loop.gif"))); // NOI18N
        getContentPane().add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, -14, 1970, 790));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
       
        DefaultTableModel model=(DefaultTableModel)tbl.getModel();
        model.setRowCount(0);
        String Post=(String) post.getSelectedItem();
        try{
            Class.forName("java.sql.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost/test","root","") ;
            model.setRowCount(0);
            Statement stmt=con.createStatement();
            String query;
            query = ("Select * from electiontb where post='"+Post+"' order by Votes Desc; ");
            ResultSet hello;
            hello=stmt.executeQuery(query);
            while(hello.next())
            { model.addRow(new Object[]{hello.getInt(1),hello.getString("Name"),hello.getString("Votes"),});

            }

            
            stmt.close();
            con.close();
  
        }       catch (Exception e) {
            JOptionPane.showMessageDialog(null,e);

        }        }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        this.setVisible(false);
        new Welcome_Screen().setVisible(true);
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        try{
            Class.forName("java.sql.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost/test","root","") ;
            Statement stmt=con.createStatement();
            String query;
            query = ("Update electiontb set votes=0 where Post='"+post.getSelectedItem()+"';");
           stmt.executeUpdate(query);
            stmt.close();
            con.close();


        }       catch (Exception e) {
            JOptionPane.showMessageDialog(null,e);

        }
     
        DefaultTableModel model=(DefaultTableModel)tbl.getModel();
        model.setRowCount(0);
        String Post=(String) post.getSelectedItem();
        try{
            Class.forName("java.sql.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost/test","root","") ;
            model.setRowCount(0);
            Statement stmt=con.createStatement();
            String query;
            query = ("Select * from electiontb where post='"+post.getSelectedItem()+"' order by Votes Desc ; ");
            ResultSet hello;
            hello=stmt.executeQuery(query);
            while(hello.next())
            { model.addRow(new Object[]{hello.getInt(1),hello.getString("Name"),hello.getString("Votes"),});

            }

            
            stmt.close();
            con.close();
            JOptionPane.showMessageDialog(null,"Deleted Succesfully");

        }       catch (Exception e) {
            JOptionPane.showMessageDialog(null,e);

        }// TODO add your handling code here:
    }//GEN-LAST:event_jButton3ActionPerformed

    private void postActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_postActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_postActionPerformed

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
            java.util.logging.Logger.getLogger(Results.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Results.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Results.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Results.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Results().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel Post_Title;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JComboBox<String> post;
    private javax.swing.JTable tbl;
    // End of variables declaration//GEN-END:variables
}
