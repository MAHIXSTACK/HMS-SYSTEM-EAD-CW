/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package hospitalmanagement;
import java.sql.*;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;


/**
 *
 * @author Mahima
 */
public class PatientManagement extends javax.swing.JFrame {
private int selectedPatientId = -1;

    /**
     * Creates new form PatientManagement
     */
    public PatientManagement() {
        initComponents();
        loadPatients(""); 
        
        tblPatients.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                tableRowClicked();
            }
        });
    }

  private void tableRowClicked() {
        int selectedRow = tblPatients.getSelectedRow();
        if (selectedRow != -1) {
            // Get data from the table model
            DefaultTableModel model = (DefaultTableModel) tblPatients.getModel();
            selectedPatientId = (int) model.getValueAt(selectedRow, 0);
            String name = (String) model.getValueAt(selectedRow, 1);
            int age = (int) model.getValueAt(selectedRow, 2);
            String gender = (String) model.getValueAt(selectedRow, 3);
            String contact = (String) model.getValueAt(selectedRow, 4);

            // Set the data into the input fields
            txtPatientName.setText(name);
            txtPatientAge.setText(String.valueOf(age));
            cmbGender.setSelectedItem(gender);
            txtPatientContact.setText(contact);
        }
    }

 private void clearForm() {
        txtPatientName.setText("");
        txtPatientAge.setText("");
        txtPatientContact.setText("");
        txtSearch.setText("");
        tblPatients.clearSelection();
        selectedPatientId = -1;
    }

    
     private void loadPatients(String searchTerm) {
         DefaultTableModel model = (DefaultTableModel) tblPatients.getModel();
        model.setRowCount(0); 

        String sql = "SELECT * FROM patients WHERE name LIKE ?";
        
        try (Connection conn = DBConnection.connect();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setString(1, "%" + searchTerm + "%"); 
            ResultSet rs = pstmt.executeQuery();

            while (rs.next()) {
                model.addRow(new Object[]{
                    rs.getInt("patient_id"), 
                    rs.getString("name"), 
                    rs.getInt("age"), 
                    rs.getString("gender"), 
                    rs.getString("contact")
                });
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(this, "Error loading patients: " + e.getMessage(), "Database Error", JOptionPane.ERROR_MESSAGE);

        }
 }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        tblPatients = new javax.swing.JTable();
        txtSearch = new javax.swing.JTextField();
        btnSearch = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        txtPatientName = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        txtPatientAge = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        cmbGender = new javax.swing.JComboBox<>();
        jLabel5 = new javax.swing.JLabel();
        txtPatientContact = new javax.swing.JTextField();
        btnSavePatient = new javax.swing.JButton();
        btnDelete = new javax.swing.JButton();
        btnUpdate = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        btnback = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        btnrefresh = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        tblPatients.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "Patient ID", "Name", "Age", "Gender", "Contact"
            }
        ));
        tblPatients.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblPatientsMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblPatients);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(121, 384, 798, 260));

        txtSearch.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        getContentPane().add(txtSearch, new org.netbeans.lib.awtextra.AbsoluteConstraints(395, 345, 98, -1));

        btnSearch.setBackground(new java.awt.Color(255, 255, 153));
        btnSearch.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        btnSearch.setText("Search");
        btnSearch.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnSearch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSearchActionPerformed(evt);
            }
        });
        getContentPane().add(btnSearch, new org.netbeans.lib.awtextra.AbsoluteConstraints(556, 342, 75, -1));

        jLabel2.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel2.setText("Name");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(59, 143, 88, -1));

        txtPatientName.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        getContentPane().add(txtPatientName, new org.netbeans.lib.awtextra.AbsoluteConstraints(153, 140, 231, -1));

        jLabel3.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel3.setText("Age");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(59, 210, 76, -1));

        txtPatientAge.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        getContentPane().add(txtPatientAge, new org.netbeans.lib.awtextra.AbsoluteConstraints(153, 207, 231, -1));

        jLabel4.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel4.setText("Gender");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 143, -1, -1));

        cmbGender.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        cmbGender.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Male", "Female" }));
        getContentPane().add(cmbGender, new org.netbeans.lib.awtextra.AbsoluteConstraints(658, 140, 261, -1));

        jLabel5.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel5.setText("Contact No");
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 210, -1, -1));

        txtPatientContact.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        getContentPane().add(txtPatientContact, new org.netbeans.lib.awtextra.AbsoluteConstraints(658, 207, 261, -1));

        btnSavePatient.setBackground(new java.awt.Color(0, 102, 204));
        btnSavePatient.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        btnSavePatient.setForeground(new java.awt.Color(255, 255, 255));
        btnSavePatient.setText("Save");
        btnSavePatient.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSavePatientActionPerformed(evt);
            }
        });
        getContentPane().add(btnSavePatient, new org.netbeans.lib.awtextra.AbsoluteConstraints(254, 276, 95, -1));

        btnDelete.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        btnDelete.setForeground(new java.awt.Color(255, 0, 51));
        btnDelete.setText("Delete");
        btnDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeleteActionPerformed(evt);
            }
        });
        getContentPane().add(btnDelete, new org.netbeans.lib.awtextra.AbsoluteConstraints(637, 276, -1, -1));

        btnUpdate.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        btnUpdate.setForeground(new java.awt.Color(0, 102, 51));
        btnUpdate.setText("Update");
        btnUpdate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUpdateActionPerformed(evt);
            }
        });
        getContentPane().add(btnUpdate, new org.netbeans.lib.awtextra.AbsoluteConstraints(452, 276, -1, -1));

        jPanel1.setBackground(new java.awt.Color(102, 102, 102));
        jPanel1.setForeground(new java.awt.Color(255, 255, 255));

        jLabel6.setBackground(new java.awt.Color(255, 255, 255));
        jLabel6.setFont(new java.awt.Font("Segoe UI Black", 1, 24)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("Patient Management");

        btnback.setBackground(new java.awt.Color(102, 102, 102));
        btnback.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/backs.png"))); // NOI18N
        btnback.setBorder(null);
        btnback.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnbackActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addComponent(btnback)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 307, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(267, 267, 267))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(23, 23, 23)
                        .addComponent(jLabel6))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(btnback)))
                .addContainerGap(23, Short.MAX_VALUE))
        );

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 6, 1011, -1));

        jPanel2.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 966, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 206, Short.MAX_VALUE)
        );

        getContentPane().add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 120, 970, 210));

        btnrefresh.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        btnrefresh.setText("Refresh");
        btnrefresh.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnrefreshActionPerformed(evt);
            }
        });
        getContentPane().add(btnrefresh, new org.netbeans.lib.awtextra.AbsoluteConstraints(660, 340, -1, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnSavePatientActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSavePatientActionPerformed
  String name = txtPatientName.getText();
        String ageText = txtPatientAge.getText();
        
        if (name.isEmpty() || ageText.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Name and Age fields cannot be empty.", "Input Error", JOptionPane.ERROR_MESSAGE);
            return;
        }
 try {
            int age = Integer.parseInt(ageText);
            String gender = cmbGender.getSelectedItem().toString();
            String contact = txtPatientContact.getText();

            String sql = "INSERT INTO patients(name, age, gender, contact) VALUES(?,?,?,?)";

            try (Connection conn = DBConnection.connect();
                 PreparedStatement pstmt = conn.prepareStatement(sql)) {

                pstmt.setString(1, name);
                pstmt.setInt(2, age);
                pstmt.setString(3, gender);
                pstmt.setString(4, contact);
                pstmt.executeUpdate();

                JOptionPane.showMessageDialog(this, "Patient added successfully!");
                loadPatients(""); 
                
                // Clear input fields
                txtPatientName.setText("");
                txtPatientAge.setText("");
                txtPatientContact.setText("");

            } catch (SQLException e) {
                JOptionPane.showMessageDialog(this, "Error saving patient: " + e.getMessage());
            }
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Please enter a valid number for Age.", "Input Error", JOptionPane.ERROR_MESSAGE);
        }



    }//GEN-LAST:event_btnSavePatientActionPerformed

    private void btnSearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSearchActionPerformed
       String searchTerm = txtSearch.getText();
        loadPatients(searchTerm);


    }//GEN-LAST:event_btnSearchActionPerformed

    private void btnDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteActionPerformed
        int selectedRow = tblPatients.getSelectedRow();

        if (selectedRow == -1) {
            JOptionPane.showMessageDialog(this, "Please select a patient from the table to delete.", "No Selection", JOptionPane.WARNING_MESSAGE);
            return;
        }

        // Confirmation dialog
        int confirm = JOptionPane.showConfirmDialog(this, "Are you sure you want to delete this patient?", "Confirm Deletion", JOptionPane.YES_NO_OPTION);

        if (confirm == JOptionPane.YES_OPTION) {
            // Get patient ID from the first column of the selected row
            int patientId = (int) tblPatients.getValueAt(selectedRow, 0);

            String sql = "DELETE FROM patients WHERE patient_id = ?";

            try (Connection conn = DBConnection.connect();
                 PreparedStatement pstmt = conn.prepareStatement(sql)) {

                pstmt.setInt(1, patientId);
                int affectedRows = pstmt.executeUpdate();

                if (affectedRows > 0) {
                     JOptionPane.showMessageDialog(this, "Patient deleted successfully!");
                    clearForm();
                    loadPatients(""); 
                } else {
                    JOptionPane.showMessageDialog(this, "Patient could not be deleted.", "Error", JOptionPane.ERROR_MESSAGE);
 }

            } catch (SQLException e) {
                // This can happen if a patient has existing appointments (foreign key constraint)
                JOptionPane.showMessageDialog(this, "Error deleting patient: " + e.getMessage(), "Database Error", JOptionPane.ERROR_MESSAGE);
            }
        }

    }//GEN-LAST:event_btnDeleteActionPerformed

    private void btnUpdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUpdateActionPerformed
       if (selectedPatientId == -1) {
            JOptionPane.showMessageDialog(this, "Please select a patient from the table to update.", "No Selection", JOptionPane.WARNING_MESSAGE);
            return;
        }

        String name = txtPatientName.getText();
        String ageText = txtPatientAge.getText();
        
 if (name.isEmpty() || ageText.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Name and Age fields cannot be empty.", "Input Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        try {
            int age = Integer.parseInt(ageText);
            String gender = cmbGender.getSelectedItem().toString();
            String contact = txtPatientContact.getText();

            String sql = "UPDATE patients SET name = ?, age = ?, gender = ?, contact = ? WHERE patient_id = ?";
            
            try (Connection conn = DBConnection.connect();
                 PreparedStatement pstmt = conn.prepareStatement(sql)) {
                
                pstmt.setString(1, name);
                pstmt.setInt(2, age);
                pstmt.setString(3, gender);
                pstmt.setString(4, contact);
                pstmt.setInt(5, selectedPatientId); 
 int affectedRows = pstmt.executeUpdate();
                if (affectedRows > 0) {
                    JOptionPane.showMessageDialog(this, "Patient details updated successfully!");
                    clearForm();
                    loadPatients(""); 
                } else {
                    JOptionPane.showMessageDialog(this, "Failed to update patient details.", "Update Error", JOptionPane.ERROR_MESSAGE);
                }
            } catch (SQLException e) {
                JOptionPane.showMessageDialog(this, "Error updating patient: " + e.getMessage(), "Database Error", JOptionPane.ERROR_MESSAGE);
            }

        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Please enter a valid number for Age.", "Input Error", JOptionPane.ERROR_MESSAGE);
        }

    }//GEN-LAST:event_btnUpdateActionPerformed

    private void btnbackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnbackActionPerformed
       new Dashboard().setVisible(true);
         this.hide();
    }//GEN-LAST:event_btnbackActionPerformed

    private void tblPatientsMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblPatientsMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_tblPatientsMouseClicked

    private void btnrefreshActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnrefreshActionPerformed
        loadPatients("");
        txtSearch.setText("");
    }//GEN-LAST:event_btnrefreshActionPerformed

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
            java.util.logging.Logger.getLogger(PatientManagement.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(PatientManagement.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(PatientManagement.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(PatientManagement.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new PatientManagement().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnDelete;
    private javax.swing.JButton btnSavePatient;
    private javax.swing.JButton btnSearch;
    private javax.swing.JButton btnUpdate;
    private javax.swing.JButton btnback;
    private javax.swing.JButton btnrefresh;
    private javax.swing.JComboBox<String> cmbGender;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tblPatients;
    private javax.swing.JTextField txtPatientAge;
    private javax.swing.JTextField txtPatientContact;
    private javax.swing.JTextField txtPatientName;
    private javax.swing.JTextField txtSearch;
    // End of variables declaration//GEN-END:variables
}
