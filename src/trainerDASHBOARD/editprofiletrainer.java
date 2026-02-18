/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package trainerDASHBOARD;

/**
 *
 * @author Lloyd's PC
 */
public class editprofiletrainer extends javax.swing.JFrame {

    /**
     * Creates new form editprofiletrainer
     */
   public editprofiletrainer() {
    // 1. Check if a session exists before doing anything else
    if (config.UserSession.getInstance().getFullName() == null) {
        javax.swing.JOptionPane.showMessageDialog(null, "No active session. Redirecting to Login...");
        
        // Open landing page
        main.landing landingPage = new main.landing();
        landingPage.setVisible(true);
        
        // Use this.dispose() since this class IS the JFrame
        this.dispose(); 
        return; 
    }

    initComponents();
    idtrainer.setEditable(false);
    displayUserDetails();
}

private void displayUserDetails() {
config.config conf = new config.config();
    // This gets the t_id saved during login
    int session_id = config.UserSession.getInstance().getId(); 
    
    // Updated SQL to use the correct join and ID
    String sql = "SELECT * FROM tbl_trainers " +
                 "JOIN users_tbl ON tbl_trainers.u_id = users_tbl.u_id " +
                 "WHERE tbl_trainers.t_id = " + session_id;
    
    try (java.sql.Connection conn = conf.connectDB();
         java.sql.Statement stmt = conn.createStatement();
         java.sql.ResultSet rs = stmt.executeQuery(sql)) {
        
        if (rs.next()) {
            // Populate basic info from users_tbl
            idtrainer.setText(String.valueOf(rs.getInt("u_id"))); 
            fullnametrainer.setText(rs.getString("full_name"));
            emailtrainer1.setText(rs.getString("email"));
            phonetrainer.setText(rs.getString("phonenumber"));
            
            // CORRECTED: Removed 't_' prefix to match your DB screenshot
            specialty.setText(rs.getString("specialty")); 
            bio.setText(rs.getString("bio"));
            
            System.out.println("Success: Loaded Trainer " + rs.getString("full_name"));
        } else {
            System.out.println("Error: No data found for Trainer ID " + session_id);
            // If it hits here, your Login page isn't saving the t_id correctly.
        }
    } catch (java.sql.SQLException e) {
        System.out.println("Database Error: " + e.getMessage());
    }
}
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        editprofile = new javax.swing.JLabel();
        idtrainer = new javax.swing.JTextField();
        fullnametrainer = new javax.swing.JTextField();
        phonetrainer = new javax.swing.JTextField();
        specialty = new javax.swing.JTextField();
        editprotrainer = new javax.swing.JLabel();
        emailtrainer1 = new javax.swing.JTextField();
        bio = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(39, 41, 46));
        jPanel1.setPreferredSize(new java.awt.Dimension(910, 610));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(740, 440, -1, -1));

        editprofile.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/profile13.png"))); // NOI18N
        jPanel1.add(editprofile, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 170, -1, -1));

        idtrainer.setBackground(new java.awt.Color(39, 41, 46));
        idtrainer.setFont(new java.awt.Font("Segoe UI Black", 3, 18)); // NOI18N
        idtrainer.setForeground(new java.awt.Color(255, 255, 255));
        idtrainer.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        idtrainer.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "id", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI Black", 2, 14), new java.awt.Color(102, 255, 102))); // NOI18N
        idtrainer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                idtrainerActionPerformed(evt);
            }
        });
        jPanel1.add(idtrainer, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 50, 270, 80));

        fullnametrainer.setBackground(new java.awt.Color(39, 41, 46));
        fullnametrainer.setFont(new java.awt.Font("Segoe UI Black", 3, 18)); // NOI18N
        fullnametrainer.setForeground(new java.awt.Color(255, 255, 255));
        fullnametrainer.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        fullnametrainer.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Fullname", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI Black", 2, 14), new java.awt.Color(102, 255, 102))); // NOI18N
        fullnametrainer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                fullnametrainerActionPerformed(evt);
            }
        });
        jPanel1.add(fullnametrainer, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 140, 270, 80));

        phonetrainer.setBackground(new java.awt.Color(39, 41, 46));
        phonetrainer.setFont(new java.awt.Font("Segoe UI Black", 3, 18)); // NOI18N
        phonetrainer.setForeground(new java.awt.Color(255, 255, 255));
        phonetrainer.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        phonetrainer.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "phone", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI Black", 2, 14), new java.awt.Color(102, 255, 102))); // NOI18N
        phonetrainer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                phonetrainerActionPerformed(evt);
            }
        });
        jPanel1.add(phonetrainer, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 230, 270, 80));

        specialty.setBackground(new java.awt.Color(39, 41, 46));
        specialty.setFont(new java.awt.Font("Segoe UI Black", 3, 18)); // NOI18N
        specialty.setForeground(new java.awt.Color(255, 255, 255));
        specialty.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        specialty.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "specialty", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI Black", 2, 14), new java.awt.Color(102, 255, 102))); // NOI18N
        specialty.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                specialtyActionPerformed(evt);
            }
        });
        jPanel1.add(specialty, new org.netbeans.lib.awtextra.AbsoluteConstraints(620, 140, 270, 80));

        editprotrainer.setFont(new java.awt.Font("Segoe UI Black", 1, 24)); // NOI18N
        editprotrainer.setForeground(new java.awt.Color(255, 255, 255));
        editprotrainer.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/edits.png"))); // NOI18N
        editprotrainer.setText("Edit Profile");
        editprotrainer.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                editprotrainerMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                editprotrainerMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                editprotrainerMouseExited(evt);
            }
        });
        jPanel1.add(editprotrainer, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 420, -1, -1));

        emailtrainer1.setBackground(new java.awt.Color(39, 41, 46));
        emailtrainer1.setFont(new java.awt.Font("Segoe UI Black", 3, 18)); // NOI18N
        emailtrainer1.setForeground(new java.awt.Color(255, 255, 255));
        emailtrainer1.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        emailtrainer1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "email", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI Black", 2, 14), new java.awt.Color(102, 255, 102))); // NOI18N
        emailtrainer1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                emailtrainer1ActionPerformed(evt);
            }
        });
        jPanel1.add(emailtrainer1, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 320, 270, 80));

        bio.setBackground(new java.awt.Color(39, 41, 46));
        bio.setFont(new java.awt.Font("Segoe UI Black", 3, 18)); // NOI18N
        bio.setForeground(new java.awt.Color(255, 255, 255));
        bio.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        bio.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "bio", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI Black", 2, 14), new java.awt.Color(102, 255, 102))); // NOI18N
        bio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bioActionPerformed(evt);
            }
        });
        jPanel1.add(bio, new org.netbeans.lib.awtextra.AbsoluteConstraints(620, 50, 270, 80));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 904, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void idtrainerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_idtrainerActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_idtrainerActionPerformed

    private void fullnametrainerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_fullnametrainerActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_fullnametrainerActionPerformed

    private void phonetrainerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_phonetrainerActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_phonetrainerActionPerformed

    private void specialtyActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_specialtyActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_specialtyActionPerformed

    private void editprotrainerMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_editprotrainerMouseClicked
   config.config conf = new config.config();
    config.UserSession sess = config.UserSession.getInstance();
    
    try {
        // Get the u_id from the ID text field
        int userId = Integer.parseInt(idtrainer.getText().trim());
        
        String name = fullnametrainer.getText();
        String mail = emailtrainer1.getText();
        String contact = phonetrainer.getText();
        String spec = specialty.getText();
        String trainerBio = bio.getText();

        // 1. Update users_tbl (Name, Email, Phone)
        conf.addRecord("UPDATE users_tbl SET full_name = ?, email = ?, phonenumber = ? WHERE u_id = ?", 
                        name, mail, contact, userId);

        // 2. Update tbl_trainers (Specialty and Bio)
        // Corrected columns: specialty, bio
        conf.addRecord("UPDATE tbl_trainers SET specialty = ?, bio = ? WHERE u_id = ?", 
                        spec, trainerBio, userId);

        // 3. Update Session so dashboard name changes too
        sess.setFullName(name);
        sess.setEmail(mail);

        javax.swing.JOptionPane.showMessageDialog(null, "Profile Updated!");

        // 4. Return to Dashboard
        this.dispose();
        new DASHBOARDS.trainerdashboard(sess.getFullName()).setVisible(true); 

    } catch (Exception e) {
        javax.swing.JOptionPane.showMessageDialog(null, "Update Error: " + e.getMessage());
    }
    }//GEN-LAST:event_editprotrainerMouseClicked

    private void editprotrainerMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_editprotrainerMouseEntered
        editprotrainer.setForeground(new java.awt.Color(170, 231, 37));
    }//GEN-LAST:event_editprotrainerMouseEntered

    private void editprotrainerMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_editprotrainerMouseExited
        editprotrainer.setForeground(new java.awt.Color(255, 255, 255)); // White
    }//GEN-LAST:event_editprotrainerMouseExited

    private void emailtrainer1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_emailtrainer1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_emailtrainer1ActionPerformed

    private void bioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bioActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_bioActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
    /* Set the Nimbus look and feel */
    try {
        for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
            if ("Nimbus".equals(info.getName())) {
                javax.swing.UIManager.setLookAndFeel(info.getClassName());
                break;
            }
        }
    } catch (Exception ex) {
        ex.printStackTrace();
    }

    /* Create and display the form */
    java.awt.EventQueue.invokeLater(new Runnable() {
        public void run() {
            // LOCK THE PREVIEW: Only create the window if logged in
            if (config.UserSession.getInstance().getFullName() == null) {
                javax.swing.JOptionPane.showMessageDialog(null, "Please log in first!");
                new main.landing().setVisible(true);
                return; // STOP HERE
            }
            
            new editprofiletrainer().setVisible(true);
        }
    });
}
    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JTextField bio;
    private javax.swing.JLabel editprofile;
    private javax.swing.JLabel editprotrainer;
    public javax.swing.JTextField emailtrainer1;
    public javax.swing.JTextField fullnametrainer;
    public javax.swing.JTextField idtrainer;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    public javax.swing.JTextField phonetrainer;
    public javax.swing.JTextField specialty;
    // End of variables declaration//GEN-END:variables
}
