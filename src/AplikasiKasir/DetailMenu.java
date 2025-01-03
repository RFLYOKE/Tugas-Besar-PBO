/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package AplikasiKasir;

import java.sql.*;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Asus
 */
public class DetailMenu extends javax.swing.JFrame {
    Connection connection;


    /**
     * Creates new form DetailMenu
     */
    
    //Konstruktor buat penghubung koneksi ke database
    public DetailMenu() {
        initComponents();
        connection = DatabaseConnection.getConnection();
        loadDataDetailMenu();
    }
    
     private void loadDataDetailMenu() {
        // Mendapatkan model tabel dari komponen tblDetailMenu untuk manipulasi data
        DefaultTableModel model = (DefaultTableModel) tblDetailMenu.getModel();
        // Menghapus semua baris yang ada pada tabel sebelum memuat data baru
        model.setRowCount(0); 

        try {
            String sql = "SELECT * FROM menu";
            PreparedStatement pst = connection.prepareStatement(sql);
            ResultSet rs = pst.executeQuery();
            
            // Loop melalui setiap baris data yang diambil dari database
            while (rs.next()) {
                Object[] row = new Object[] {
                    rs.getString("idMenu"),
                    rs.getString("namaMenu"),
                    rs.getInt("harga"),
                    rs.getString("kategori"),
                };
                // Menambahkan baris data ke dalam model tabel
                model.addRow(row); 
            }
        } catch (SQLException e) {
            // Menangani kesalahan SQL dan mencetak detail kesalahan ke konsol
            e.printStackTrace();
            // Menampilkan pesan kesalahan kepada pengguna        
            javax.swing.JOptionPane.showMessageDialog(this, "Error loading data: " + e.getMessage());
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

        jPanel1 = new javax.swing.JPanel();
        lblMenu = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblDetailMenu = new javax.swing.JTable();
        btnOut = new javax.swing.JButton();
        btnDelete = new javax.swing.JButton();
        btnBack = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(255, 248, 243));
        jPanel1.setForeground(new java.awt.Color(51, 51, 51));

        lblMenu.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        lblMenu.setForeground(new java.awt.Color(102, 102, 102));
        lblMenu.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblMenu.setText("Detail Menu");

        tblDetailMenu.setBackground(new java.awt.Color(255, 255, 255));
        tblDetailMenu.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID Menu", "Nama Menu", "Harga", "Kategori"
            }
        ));
        jScrollPane1.setViewportView(tblDetailMenu);

        btnOut.setBackground(new java.awt.Color(64, 93, 114));
        btnOut.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnOut.setForeground(new java.awt.Color(255, 255, 255));
        btnOut.setText("Logout");
        btnOut.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnOutActionPerformed(evt);
            }
        });

        btnDelete.setBackground(new java.awt.Color(255, 0, 51));
        btnDelete.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnDelete.setForeground(new java.awt.Color(255, 255, 255));
        btnDelete.setText("Delete Menu");
        btnDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeleteActionPerformed(evt);
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

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lblMenu, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnBack)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnOut)
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnDelete))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(22, 22, 22)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 695, Short.MAX_VALUE)))
                .addGap(21, 21, 21))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(7, 7, 7)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnOut)
                    .addComponent(btnBack))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblMenu, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(31, 31, 31)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 495, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnDelete)
                .addContainerGap(22, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnOutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnOutActionPerformed
        InputUser logout = new InputUser();
        logout.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnOutActionPerformed

    private void btnDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteActionPerformed
        // Mendapatkan indeks baris yang dipilih pada tabel
        int selectedRow = tblDetailMenu.getSelectedRow();
        // Jika tidak ada baris yang dipilih, tampilkan pesan error
        if (selectedRow == -1) {
            javax.swing.JOptionPane.showMessageDialog(this, "Pilih data yang ingin dihapus terlebih dahulu!", "Error", javax.swing.JOptionPane.ERROR_MESSAGE);
            return;
        }

        String idMenu = tblDetailMenu.getValueAt(selectedRow, 0).toString();

        int confirm = javax.swing.JOptionPane.showConfirmDialog(this, "Apakah Anda yakin ingin menghapus data dengan ID Menu: " + idMenu + "?", "Konfirmasi Hapus", javax.swing.JOptionPane.YES_NO_OPTION);
        if (confirm != javax.swing.JOptionPane.YES_OPTION) {
            return;
        }

        try {
            String query = "DELETE FROM menu WHERE idMenu = ?";
            try (PreparedStatement pst = connection.prepareStatement(query)) {
                pst.setString(1, idMenu);

                int rowsDeleted = pst.executeUpdate();
                if (rowsDeleted > 0) {
                    javax.swing.JOptionPane.showMessageDialog(this, "Data berhasil dihapus!", "Sukses", javax.swing.JOptionPane.INFORMATION_MESSAGE);

                    loadDataDetailMenu();
                } else {
                    javax.swing.JOptionPane.showMessageDialog(this, "Data gagal dihapus. Coba lagi.", "Error", javax.swing.JOptionPane.ERROR_MESSAGE);
                }
            }
        } catch (SQLException e) {
            javax.swing.JOptionPane.showMessageDialog(this, "Terjadi kesalahan: " + e.getMessage(), "Error", javax.swing.JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_btnDeleteActionPerformed

    private void btnBackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBackActionPerformed
        Menu back = new Menu();
        back.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnBackActionPerformed

    /**
     * @param args the command line arguments
     */

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBack;
    private javax.swing.JButton btnDelete;
    private javax.swing.JButton btnOut;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblMenu;
    private javax.swing.JTable tblDetailMenu;
    // End of variables declaration//GEN-END:variables
}
