package AplikasiKasir;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */

import AplikasiKasir.DatabaseConnection;
import java.awt.Color;
import java.sql.*;
import javax.swing.JOptionPane;

/**
 *
 * @author Asus
 */
public class Menu extends javax.swing.JFrame {
    private Connection connection;
     /**
     * Creates new form InputUser
     */
    public Menu() {
        initComponents();
        inisialisasiDatabase();
        txtIdMenu.setEnabled(false);
    }
    
    private void inisialisasiDatabase() {
        DatabaseConnection dbConnection = new DatabaseConnection();
        this.connection = dbConnection.getConnection();
        if (connection == null) {
            JOptionPane.showMessageDialog(this, 
                "Failed to connect", 
                "Database Connection Error", 
                JOptionPane.ERROR_MESSAGE);
        }
    }
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        txtRole = new javax.swing.JComboBox<>();
        Menu = new javax.swing.JPanel();
        lblNamaMenu = new javax.swing.JLabel();
        btnInput = new javax.swing.JButton();
        lblMenu = new javax.swing.JLabel();
        lblHarga = new javax.swing.JLabel();
        lblStatus = new javax.swing.JLabel();
        lblKategori = new javax.swing.JLabel();
        lblIdMenu = new javax.swing.JLabel();
        txtKategori = new javax.swing.JComboBox<>();
        btnDetail = new javax.swing.JButton();
        btnBack = new javax.swing.JButton();
        txtIdMenu = new javax.swing.JTextField();
        txtNamaMenu = new javax.swing.JTextField();
        txtHarga = new javax.swing.JTextField();

        txtRole.setBackground(new java.awt.Color(255, 255, 255));
        txtRole.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        txtRole.setForeground(new java.awt.Color(0, 0, 0));
        txtRole.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "option", "kasir", "admin" }));
        txtRole.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtRoleActionPerformed(evt);
            }
        });

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        Menu.setBackground(new java.awt.Color(255, 248, 243));

        lblNamaMenu.setBackground(new java.awt.Color(102, 102, 102));
        lblNamaMenu.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        lblNamaMenu.setForeground(new java.awt.Color(102, 102, 102));
        lblNamaMenu.setText("Nama Menu");

        btnInput.setBackground(new java.awt.Color(64, 93, 114));
        btnInput.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        btnInput.setForeground(new java.awt.Color(255, 255, 255));
        btnInput.setText("Input");
        btnInput.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnInputActionPerformed(evt);
            }
        });

        lblMenu.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        lblMenu.setForeground(new java.awt.Color(102, 102, 102));
        lblMenu.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblMenu.setText("Menu");

        lblHarga.setBackground(new java.awt.Color(102, 102, 102));
        lblHarga.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        lblHarga.setForeground(new java.awt.Color(102, 102, 102));
        lblHarga.setText("Harga");

        lblStatus.setForeground(new java.awt.Color(51, 51, 51));
        lblStatus.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        lblKategori.setBackground(new java.awt.Color(102, 102, 102));
        lblKategori.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        lblKategori.setForeground(new java.awt.Color(102, 102, 102));
        lblKategori.setText("Kategori");

        lblIdMenu.setBackground(new java.awt.Color(102, 102, 102));
        lblIdMenu.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        lblIdMenu.setForeground(new java.awt.Color(102, 102, 102));
        lblIdMenu.setText("ID Menu");

        txtKategori.setBackground(new java.awt.Color(255, 255, 255));
        txtKategori.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        txtKategori.setForeground(new java.awt.Color(0, 0, 0));
        txtKategori.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Choose", "Menu Utama", "Menu Pendamping", "Minuman" }));

        btnDetail.setBackground(new java.awt.Color(64, 93, 114));
        btnDetail.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnDetail.setForeground(new java.awt.Color(255, 255, 255));
        btnDetail.setText("Detail Menu");
        btnDetail.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDetailActionPerformed(evt);
            }
        });

        btnBack.setBackground(new java.awt.Color(255, 0, 51));
        btnBack.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnBack.setForeground(new java.awt.Color(255, 255, 255));
        btnBack.setText("Back");
        btnBack.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBackActionPerformed(evt);
            }
        });

        txtIdMenu.setBackground(new java.awt.Color(247, 231, 220));
        txtIdMenu.setForeground(new java.awt.Color(51, 51, 51));
        txtIdMenu.setToolTipText("");

        txtNamaMenu.setBackground(new java.awt.Color(247, 231, 220));
        txtNamaMenu.setForeground(new java.awt.Color(51, 51, 51));

        txtHarga.setBackground(new java.awt.Color(247, 231, 220));
        txtHarga.setForeground(new java.awt.Color(51, 51, 51));

        javax.swing.GroupLayout MenuLayout = new javax.swing.GroupLayout(Menu);
        Menu.setLayout(MenuLayout);
        MenuLayout.setHorizontalGroup(
            MenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lblMenu, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, MenuLayout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addComponent(btnBack)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnDetail)
                .addGap(16, 16, 16))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, MenuLayout.createSequentialGroup()
                .addGap(41, 41, 41)
                .addGroup(MenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblIdMenu)
                    .addComponent(lblNamaMenu)
                    .addComponent(lblHarga)
                    .addComponent(lblKategori))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 59, Short.MAX_VALUE)
                .addGroup(MenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnInput, javax.swing.GroupLayout.PREFERRED_SIZE, 317, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(MenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(lblStatus, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(txtNamaMenu, javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(txtIdMenu, javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(txtKategori, javax.swing.GroupLayout.Alignment.LEADING, 0, 316, Short.MAX_VALUE)
                        .addComponent(txtHarga, javax.swing.GroupLayout.Alignment.LEADING)))
                .addGap(48, 48, 48))
        );
        MenuLayout.setVerticalGroup(
            MenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(MenuLayout.createSequentialGroup()
                .addGap(7, 7, 7)
                .addGroup(MenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnDetail)
                    .addComponent(btnBack))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lblMenu, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(60, 60, 60)
                .addGroup(MenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(MenuLayout.createSequentialGroup()
                        .addComponent(lblIdMenu, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(30, 30, 30))
                    .addGroup(MenuLayout.createSequentialGroup()
                        .addComponent(txtIdMenu)
                        .addGap(18, 18, 18)))
                .addGroup(MenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtNamaMenu, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblNamaMenu, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(MenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtHarga, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblHarga, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(MenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtKategori, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblKategori, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(lblStatus, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnInput, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(159, 159, 159))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(Menu, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(Menu, javax.swing.GroupLayout.PREFERRED_SIZE, 535, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnInputActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnInputActionPerformed
       try {
            String namaMenu = txtNamaMenu.getText().trim();
            String hargaText = txtHarga.getText().trim();
            String kategori = (String) txtKategori.getSelectedItem();

            if (namaMenu.isEmpty() || hargaText.isEmpty() || kategori.equals("Choose")) {
                lblStatus.setText("Semua field harus diisi!");
                lblStatus.setForeground(Color.red);
                return;
            }

            double harga;
            try {
                harga = Double.parseDouble(hargaText);
            } catch (NumberFormatException e) {
                lblStatus.setText("Harga harus berupa angka!");
                lblStatus.setForeground(Color.red);
                JOptionPane.showMessageDialog(this, "Harga harus berupa angka!", "Input Error!", JOptionPane.ERROR_MESSAGE);
                return;
            }

            String query = "INSERT INTO menu (namaMenu, harga, kategori) VALUES (?, ?, ?) " +
                           "ON DUPLICATE KEY UPDATE harga = VALUES(harga), kategori = VALUES(kategori)";

            try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
                preparedStatement.setString(1, namaMenu);
                preparedStatement.setDouble(2, harga);
                preparedStatement.setString(3, kategori);

                int rowsAffected = preparedStatement.executeUpdate();

                if (rowsAffected > 0) {
                    lblStatus.setText("Data berhasil disimpan atau diperbarui!");
                    lblStatus.setForeground(Color.green);
                    JOptionPane.showMessageDialog(this, "Data berhasil disimpan atau diperbarui!", "Sukses!", JOptionPane.INFORMATION_MESSAGE);

                    txtNamaMenu.setText("");
                    txtHarga.setText("");
                    txtKategori.setSelectedItem("Choose");
                } else {
                    lblStatus.setText("Operasi gagal!");
                    lblStatus.setForeground(Color.red);
                    JOptionPane.showMessageDialog(this, "Gagal menyimpan data!", "Error!", JOptionPane.ERROR_MESSAGE);
                }
            } catch (SQLException e) {
                lblStatus.setText("Error: " + e.getMessage());
                lblStatus.setForeground(Color.red);
                JOptionPane.showMessageDialog(this, "Terjadi kesalahan: " + e.getMessage(), "Database Error!", JOptionPane.ERROR_MESSAGE);
            }
        } catch (Exception e) {
            lblStatus.setText("Error: " + e.getMessage());
            lblStatus.setForeground(Color.red);
            JOptionPane.showMessageDialog(this, "Terjadi kesalahan: " + e.getMessage(), "Error!", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_btnInputActionPerformed

    private void txtRoleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtRoleActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtRoleActionPerformed

    private void btnBackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBackActionPerformed
        FrameAdmin back = new FrameAdmin();
        back.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnBackActionPerformed

    private void btnDetailActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDetailActionPerformed
        DetailMenu det = new DetailMenu();
        det.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnDetailActionPerformed

    /**
     * @param args the command line arguments
     */


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel Menu;
    private javax.swing.JButton btnBack;
    private javax.swing.JButton btnDetail;
    private javax.swing.JButton btnInput;
    private javax.swing.JLabel lblHarga;
    private javax.swing.JLabel lblIdMenu;
    private javax.swing.JLabel lblKategori;
    private javax.swing.JLabel lblMenu;
    private javax.swing.JLabel lblNamaMenu;
    private javax.swing.JLabel lblStatus;
    private javax.swing.JTextField txtHarga;
    private javax.swing.JTextField txtIdMenu;
    private javax.swing.JComboBox<String> txtKategori;
    private javax.swing.JTextField txtNamaMenu;
    private javax.swing.JComboBox<String> txtRole;
    // End of variables declaration//GEN-END:variables
}
