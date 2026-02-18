/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package memberDASHBOARD;
import config.config;
import config.UserSession;
import java.sql.ResultSet; // Added import
import java.sql.SQLException; // Added import
import javax.swing.JOptionPane;
import javax.swing.plaf.basic.BasicInternalFrameUI; // Added import

public class enrollclass extends javax.swing.JInternalFrame {

    public enrollclass() {
        initComponents();
        displayClasses();
        
        // Remove Title Bar and Borders to fit perfectly inside your Dashboard
        this.setBorder(javax.swing.BorderFactory.createEmptyBorder(0, 0, 0, 0));
        BasicInternalFrameUI bi = (BasicInternalFrameUI) this.getUI();
        bi.setNorthPane(null);
    }

public void displayClasses() {
    config con = new config();
    // Use 't_id' to match your tbl_classes structure
    String query = "SELECT class_id, t_id, class_name, schedule FROM tbl_classes";
    con.displayData(query, classestable);
}

private void enrollLogic() {
    int rowIndex = classestable.getSelectedRow();
    
    if (rowIndex < 0) {
        JOptionPane.showMessageDialog(null, "Please select a class first!");
    } else {
        try {
            // Index 0 = class_id
            String c_id = classestable.getModel().getValueAt(rowIndex, 0).toString();
            // Index 1 = t_id (The number you wanted!)
            String t_id = classestable.getModel().getValueAt(rowIndex, 1).toString();
            // Index 2 = class_name
            String c_name = classestable.getModel().getValueAt(rowIndex, 2).toString();
            
            int u_id = UserSession.getInstance().getId(); 
            config con = new config();
            
            // Your class_enrollment table DOES use the name 'trainer_id'
            String sql = "INSERT INTO class_enrollment (m_id, class_id, trainer_id, enroll_date) " +
                         "VALUES ('" + u_id + "', '" + c_id + "', '" + t_id + "', '2026-02-18')";
            
            if (con.insertData(sql) == 1) {
                JOptionPane.showMessageDialog(null, "Successfully enrolled in " + c_name + "!");
            }
        } catch (Exception e) {
            System.out.println("Enrollment Error: " + e.getMessage());
        }
    }
}
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        BACKBOTTOMEMBERDASH = new javax.swing.JLabel();
        viewclasses = new javax.swing.JScrollPane();
        classestable = new javax.swing.JTable();
        enroll = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(39, 41, 46));
        jPanel1.setPreferredSize(new java.awt.Dimension(910, 610));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(740, 440, -1, -1));

        BACKBOTTOMEMBERDASH.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/back.png"))); // NOI18N
        BACKBOTTOMEMBERDASH.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                BACKBOTTOMEMBERDASHMouseClicked(evt);
            }
        });
        jPanel1.add(BACKBOTTOMEMBERDASH, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 570, -1, -1));

        classestable.setBackground(new java.awt.Color(39, 41, 46));
        classestable.setFont(new java.awt.Font("Segoe UI Black", 1, 18)); // NOI18N
        classestable.setForeground(new java.awt.Color(170, 231, 37));
        classestable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        classestable.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_ALL_COLUMNS);
        classestable.setGridColor(new java.awt.Color(153, 153, 153));
        classestable.setPreferredSize(new java.awt.Dimension(686, 514));
        classestable.setSelectionBackground(new java.awt.Color(204, 204, 204));
        classestable.setSelectionForeground(new java.awt.Color(204, 204, 204));
        viewclasses.setViewportView(classestable);

        jPanel1.add(viewclasses, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 80, 690, 420));

        enroll.setBackground(new java.awt.Color(170, 231, 37));
        enroll.setFont(new java.awt.Font("Segoe UI Black", 1, 36)); // NOI18N
        enroll.setForeground(new java.awt.Color(39, 41, 46));
        enroll.setText("Join Class");
        enroll.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 3, true));
        enroll.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                enrollMouseClicked(evt);
            }
        });
        enroll.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                enrollActionPerformed(evt);
            }
        });
        jPanel1.add(enroll, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 20, -1, 50));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void BACKBOTTOMEMBERDASHMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BACKBOTTOMEMBERDASHMouseClicked
        // 1. Get the dashboard window
        javax.swing.JFrame topFrame = (javax.swing.JFrame) javax.swing.SwingUtilities.getWindowAncestor(this);

        // 2. Create a fresh instance of the dashboard
        DASHBOARDS.memberdashboard md = new DASHBOARDS.memberdashboard();
        md.setVisible(true);

        // 3. Close the current window
        topFrame.dispose();        // TODO add your handling code here:
    }//GEN-LAST:event_BACKBOTTOMEMBERDASHMouseClicked

    private void enrollMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_enrollMouseClicked
     enrollLogic();
    }//GEN-LAST:event_enrollMouseClicked

    private void enrollActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_enrollActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_enrollActionPerformed

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
            java.util.logging.Logger.getLogger(enrollclass.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(enrollclass.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(enrollclass.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(enrollclass.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new enrollclass().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel BACKBOTTOMEMBERDASH;
    private javax.swing.JTable classestable;
    private javax.swing.JButton enroll;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane viewclasses;
    // End of variables declaration//GEN-END:variables
}
