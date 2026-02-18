/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DASHBOARDS;
import config.UserSession; // Ensure this import exists
import main.landing; // Update this to match your new package name
import memberDASHBOARD.editprofile;
import memberDASHBOARD.enrollclass;
public class memberdashboard extends javax.swing.JFrame {

    // Main constructor used by the Login redirect
    public memberdashboard(String name) {
        // --- SECURITY CHECK START ---
        if (config.UserSession.getInstance().getFullName() == null) {
            javax.swing.JOptionPane.showMessageDialog(null, "Access Denied: Please log in first!");
            new main.landing().setVisible(true);
            this.dispose();
            return; 
        }
        // --- SECURITY CHECK END ---

        initComponents();
        displayUserInfo(); 
    }

    // Default constructor
    public memberdashboard() {
        // --- SECURITY CHECK START ---
        if (config.UserSession.getInstance().getFullName() == null) {
            javax.swing.JOptionPane.showMessageDialog(null, "Access Denied: Please log in first!");
            new main.landing().setVisible(true);
            this.dispose();
            return; 
        }
        // --- SECURITY CHECK END ---

        initComponents();
        displayUserInfo();
    }
    private void displayUserInfo() {
        UserSession sess = UserSession.getInstance();
        
        
        if (sess.getFullName() != null) {
            namemem.setText("Name: " + sess.getFullName());
            gmailmem.setText("Email: " + sess.getEmail());
            usertypemem.setText("UserType: " + sess.getType());
        } else {
            namemem.setText("Name: Guest");
            gmailmem.setText("Email: N/A");
            usertypemem.setText("UserType: N/A");
        }
    }
   public static void main(String args[]) {
        /* Set Nimbus look and feel */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (Exception ex) {
            java.util.logging.Logger.getLogger(memberdashboard.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }

        /* Create and display the form with Security Check */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                // Check if session exists before showing the dashboard
                if (config.UserSession.getInstance().getFullName() == null) {
                    javax.swing.JOptionPane.showMessageDialog(null, "Security Alert: Login required.");
                    new main.landing().setVisible(true);
                } else {
                    // Open the dashboard normally if session is found
                    new memberdashboard().setVisible(true); 
                }
            }
        });
    }
   
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        enrollclass = new javax.swing.JLabel();
        viewclasses = new javax.swing.JLabel();
        logout = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        editprofile = new javax.swing.JLabel();
        namemem = new javax.swing.JLabel();
        gmailmem = new javax.swing.JLabel();
        usertypemem = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(39, 41, 46));
        jPanel1.setPreferredSize(new java.awt.Dimension(910, 610));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        enrollclass.setBackground(new java.awt.Color(51, 51, 51));
        enrollclass.setFont(new java.awt.Font("Segoe UI Black", 3, 36)); // NOI18N
        enrollclass.setForeground(new java.awt.Color(170, 231, 37));
        enrollclass.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        enrollclass.setText("2.        Enroll in a Class");
        enrollclass.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                enrollclassMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                enrollclassMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                enrollclassMouseExited(evt);
            }
        });
        jPanel1.add(enrollclass, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 300, -1, -1));

        viewclasses.setBackground(new java.awt.Color(51, 51, 51));
        viewclasses.setFont(new java.awt.Font("Segoe UI Black", 3, 36)); // NOI18N
        viewclasses.setForeground(new java.awt.Color(170, 231, 37));
        viewclasses.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        viewclasses.setText("1.        View Available Classes");
        viewclasses.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                viewclassesMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                viewclassesMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                viewclassesMouseExited(evt);
            }
        });
        jPanel1.add(viewclasses, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 200, -1, -1));

        logout.setBackground(new java.awt.Color(51, 51, 51));
        logout.setFont(new java.awt.Font("Segoe UI Black", 3, 36)); // NOI18N
        logout.setForeground(new java.awt.Color(170, 231, 37));
        logout.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        logout.setText("Log out");
        logout.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                logoutMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                logoutMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                logoutMouseExited(evt);
            }
        });
        jPanel1.add(logout, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 560, -1, -1));

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/view.png"))); // NOI18N
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 190, -1, -1));

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/enroll.png"))); // NOI18N
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 290, -1, -1));
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(740, 440, -1, -1));

        editprofile.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/profile1.png"))); // NOI18N
        editprofile.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                editprofileMouseClicked(evt);
            }
        });
        jPanel1.add(editprofile, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, -1, -1));

        namemem.setBackground(new java.awt.Color(170, 231, 37));
        namemem.setFont(new java.awt.Font("Segoe UI Black", 2, 18)); // NOI18N
        namemem.setForeground(new java.awt.Color(170, 231, 37));
        namemem.setText("Name:");
        jPanel1.add(namemem, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 10, 220, -1));

        gmailmem.setBackground(new java.awt.Color(170, 231, 37));
        gmailmem.setFont(new java.awt.Font("Segoe UI Black", 2, 18)); // NOI18N
        gmailmem.setForeground(new java.awt.Color(170, 231, 37));
        gmailmem.setText("gmail:");
        jPanel1.add(gmailmem, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 10, 240, -1));

        usertypemem.setBackground(new java.awt.Color(170, 231, 37));
        usertypemem.setFont(new java.awt.Font("Segoe UI Black", 2, 18)); // NOI18N
        usertypemem.setForeground(new java.awt.Color(170, 231, 37));
        usertypemem.setText("UserType:");
        jPanel1.add(usertypemem, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 40, 270, -1));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(0, 0, 0))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void enrollclassMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_enrollclassMouseClicked
        enrollclass ec = new enrollclass();
    jPanel1.removeAll();
    
    // Absolute Constraints (since your dashboard uses Absolute Layout)
    org.netbeans.lib.awtextra.AbsoluteConstraints constraints = 
        new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, jPanel1.getWidth(), jPanel1.getHeight());
    
    jPanel1.add(ec, constraints);
    ec.setVisible(true);
    jPanel1.revalidate();
    jPanel1.repaint();
    }//GEN-LAST:event_enrollclassMouseClicked

    private void enrollclassMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_enrollclassMouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_enrollclassMouseEntered

    private void enrollclassMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_enrollclassMouseExited
        // TODO add your handling code here:
    }//GEN-LAST:event_enrollclassMouseExited

    private void viewclassesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_viewclassesMouseClicked
    // 1. Create the instance of your internal frame
    memberDASHBOARD.viewclasses vc = new memberDASHBOARD.viewclasses();
    
    // 2. Clear the main panel (jPanel1)
    jPanel1.removeAll();
    
    // 3. Define where the frame should go (Absolute Constraints)
    // We create a new constraint at 0,0 (top left)
    org.netbeans.lib.awtextra.AbsoluteConstraints constraints = 
        new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, jPanel1.getWidth(), jPanel1.getHeight());
    
    // 4. Add the internal frame WITH the constraints
    jPanel1.add(vc, constraints);
    
    // 5. Finalize the display
    vc.setVisible(true);
    jPanel1.revalidate();
    jPanel1.repaint();
    }//GEN-LAST:event_viewclassesMouseClicked

    private void viewclassesMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_viewclassesMouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_viewclassesMouseEntered

    private void viewclassesMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_viewclassesMouseExited
        // TODO add your handling code here:
    }//GEN-LAST:event_viewclassesMouseExited

    private void logoutMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_logoutMouseClicked
        // 1. (Optional) Clear the user session if you want to be secure
    UserSession.getInstance().setFullName(null);
    UserSession.getInstance().setEmail(null);
    UserSession.getInstance().setType(null);

    // 2. Open the landing page
    // Replace 'landingpage' with the actual name of your landing page class
    landing land = new landing();
    land.setVisible(true);

    // 3. Close the current dashboard
    this.dispose();
    }//GEN-LAST:event_logoutMouseClicked

    private void logoutMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_logoutMouseEntered
        // TODO add your handling code here:
        logout.setForeground(java.awt.Color.RED);
    }//GEN-LAST:event_logoutMouseEntered

    private void logoutMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_logoutMouseExited
        // TODO add your handling code here:
        logout.setForeground(new java.awt.Color(170, 231, 37));
    }//GEN-LAST:event_logoutMouseExited

    private void editprofileMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_editprofileMouseClicked
// 1. Create the instance of the internal frame
    memberDASHBOARD.editprofile ep = new memberDASHBOARD.editprofile();
    
    // 2. Clear jPanel1 since that is your main container
    jPanel1.removeAll(); 
    
    // 3. Define constraints to make it fill the panel
    org.netbeans.lib.awtextra.AbsoluteConstraints constraints = 
        new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, jPanel1.getWidth(), jPanel1.getHeight());
    
    // 4. Add and Show
    jPanel1.add(ep, constraints);
    ep.setVisible(true);
    
    // 5. Refresh the UI
    jPanel1.revalidate();
    jPanel1.repaint();
    }//GEN-LAST:event_editprofileMouseClicked

    /**
     * @param args the command line arguments
     */
        /* Create and display the form */
        /* Create and display the form */


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel editprofile;
    private javax.swing.JLabel enrollclass;
    private javax.swing.JLabel gmailmem;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel logout;
    private javax.swing.JLabel namemem;
    private javax.swing.JLabel usertypemem;
    private javax.swing.JLabel viewclasses;
    // End of variables declaration//GEN-END:variables
}
