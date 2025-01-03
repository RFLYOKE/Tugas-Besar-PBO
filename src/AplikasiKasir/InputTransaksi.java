/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package AplikasiKasir;
import java.awt.Color;
import java.sql.*;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JSpinner;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Asus
 */
public class InputTransaksi extends javax.swing.JFrame {
    Connection connection = DatabaseConnection.getConnection();

    /**
     * Creates new form InputTransaksi
     */
    public InputTransaksi() {
        initComponents();
        txtIDTransaksi.setEnabled(false);
        txtTgl.setEnabled(false);
        
        loadComboBoxData(txtMenuPesanan, "menu utama");
        loadComboBoxData(txtMenuPendamping, "menu pendamping");
        loadComboBoxData(txtMinuman, "minuman");
        
        txtMenuPesanan.addActionListener(e -> {
            String selectedItem = (String) txtMenuPesanan.getSelectedItem();
            int harga = ambilHargaDariComboBox(selectedItem);
            System.out.println("Harga menu utama: " + harga);
        });

        txtMenuPendamping.addActionListener(e -> {
            String selectedItem = (String) txtMenuPendamping.getSelectedItem();
            int harga = ambilHargaDariComboBox(selectedItem);
            System.out.println("Harga menu pendamping: " + harga);
        });

        txtMinuman.addActionListener(e -> {
            String selectedItem = (String) txtMinuman.getSelectedItem();
            int harga = ambilHargaDariComboBox(selectedItem);
            System.out.println("Harga minuman: " + harga);
        });
    }
    
    private void loadComboBoxData(JComboBox<String> comboBox, String kategori) {
        comboBox.removeAllItems();
        comboBox.addItem("Choose");

        String sql = "SELECT namaMenu, harga FROM menu WHERE kategori = ?";
        try (PreparedStatement pstmt = connection.prepareStatement(sql)) {
            pstmt.setString(1, kategori);
            ResultSet rs = pstmt.executeQuery();

            while (rs.next()) {
                String namaMenu = rs.getString("namaMenu");
                int harga = rs.getInt("harga");
                comboBox.addItem(namaMenu + " (" + harga + ")");
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error loading ComboBox data: " + e.getMessage());
        }
    }

    private void tblTransaksiMouseClicked(java.awt.event.MouseEvent evt) {                                         
        int selectedRow = tblTransaksi.getSelectedRow(); 
        if (selectedRow != -1) {
            String idTransaksi = tblTransaksi.getValueAt(selectedRow, 0).toString();
            String namaPelanggan = tblTransaksi.getValueAt(selectedRow, 1).toString();
            String menuPesanan = tblTransaksi.getValueAt(selectedRow, 2).toString();
            String jmlPesanan = tblTransaksi.getValueAt(selectedRow, 3).toString();
            String menuPendamping = tblTransaksi.getValueAt(selectedRow, 4).toString();
            String jmlPendamping = tblTransaksi.getValueAt(selectedRow, 5).toString();
            String minuman = tblTransaksi.getValueAt(selectedRow, 6).toString();
            String jmlMinuman = tblTransaksi.getValueAt(selectedRow, 7).toString();

            txtNamaPelanggan.setText(namaPelanggan);
            txtMenuPesanan.setSelectedItem(menuPesanan);
            txtMenuPendamping.setSelectedItem(menuPendamping);
            txtMinuman.setSelectedItem(minuman);

            countPesanan.setValue(Integer.parseInt(jmlPesanan));
            countPendamping.setValue(Integer.parseInt(jmlPendamping));
            countMinuman.setValue(Integer.parseInt(jmlMinuman));
        }
    }   

    
    private int getSpinnerValue(JSpinner spinner) {
        int value = (int) spinner.getValue(); 
        if (value < 0) {
            spinner.setValue(0);
            value = 0;
        }
        return value;
    }
    
    private int ambilHargaDariComboBox(String item) {
        if (item.equals("Choose")) {
            return 0; 
        }
        int bukaKurung = item.indexOf("(");
        int tutupKurung = item.indexOf(")");
        if (bukaKurung != -1 && tutupKurung != -1) {
            String hargaStr = item.substring(bukaKurung + 1, tutupKurung);
            hargaStr = hargaStr.replaceAll("[^0-9]", "");
            return Integer.parseInt(hargaStr);
        }
        return 0; 
    }
    
    private void loadTableData() {
        DefaultTableModel dataTransaksi = (DefaultTableModel) tblTransaksi.getModel();
        dataTransaksi.setRowCount(0); 

        String sql = "SELECT * FROM transaksi";
        try {
            Statement stmt = connection.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            while (rs.next()) {
                String idTransaksi = rs.getString("id_transaksi");
                String namaPelanggan = rs.getString("nama_pelanggan");
                String menuPesanan = rs.getString("menu_pesanan");
                String menuPendamping = rs.getString("menu_pendamping");
                String minuman = rs.getString("minuman");
                String tanggal = rs.getString("tanggal");

                int jmlPesanan = rs.getInt("jmlPesanan");
                int jmlPendamping = rs.getInt("jmlPendamping");
                int jmlMinuman = rs.getInt("jmlMinuman");
                int totalHarga = rs.getInt("totalHarga");

                dataTransaksi.addRow(new Object[] {
                    idTransaksi,namaPelanggan,
                    menuPesanan, jmlPesanan, menuPendamping, 
                    jmlPendamping, minuman, jmlMinuman, tanggal, totalHarga
                });
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error loading table data: " + e.getMessage());
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
        jButton1 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        txtIDTransaksi = new javax.swing.JTextField();
        lblIDTransaksi = new javax.swing.JLabel();
        txtNamaPelanggan = new javax.swing.JTextField();
        lblNamaPelanggan = new javax.swing.JLabel();
        lblMenuPesanan = new javax.swing.JLabel();
        txtMenuPesanan = new javax.swing.JComboBox<>();
        lblTgl = new javax.swing.JLabel();
        txtTgl = new javax.swing.JTextField();
        lblMenuPendamping = new javax.swing.JLabel();
        txtMenuPendamping = new javax.swing.JComboBox<>();
        txtMinuman = new javax.swing.JComboBox<>();
        lblMinuman = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        btnInput = new javax.swing.JButton();
        btnUpdate = new javax.swing.JButton();
        btnDelete = new javax.swing.JButton();
        btnStruk = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblTransaksi = new javax.swing.JTable();
        txtSukses = new javax.swing.JLabel();
        countPesanan = new javax.swing.JSpinner();
        countPendamping = new javax.swing.JSpinner();
        countMinuman = new javax.swing.JSpinner();
        btnClear = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(255, 248, 243));

        jButton1.setBackground(new java.awt.Color(64, 93, 114));
        jButton1.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jButton1.setForeground(new java.awt.Color(255, 255, 255));
        jButton1.setText("Logout");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(51, 51, 51));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Transaksi");

        txtIDTransaksi.setBackground(new java.awt.Color(247, 231, 220));
        txtIDTransaksi.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        txtIDTransaksi.setForeground(new java.awt.Color(51, 51, 51));

        lblIDTransaksi.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lblIDTransaksi.setForeground(new java.awt.Color(51, 51, 51));
        lblIDTransaksi.setText("ID Transaksi");

        txtNamaPelanggan.setBackground(new java.awt.Color(247, 231, 220));
        txtNamaPelanggan.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        txtNamaPelanggan.setForeground(new java.awt.Color(51, 51, 51));

        lblNamaPelanggan.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lblNamaPelanggan.setForeground(new java.awt.Color(51, 51, 51));
        lblNamaPelanggan.setText("Nama Pelanggan");

        lblMenuPesanan.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lblMenuPesanan.setForeground(new java.awt.Color(51, 51, 51));
        lblMenuPesanan.setText("Menu Pesanan");

        txtMenuPesanan.setBackground(new java.awt.Color(255, 255, 255));
        txtMenuPesanan.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        txtMenuPesanan.setForeground(new java.awt.Color(51, 51, 51));
        txtMenuPesanan.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Choose", "Bebek Panggang Original (20000)", "Bebek Panggang Pedas Manis (25000)", "Bebek Panggang Sambal Matah (26000)", "Bebek Panggang Madu (30000)", "Bebek Panggang Lada Hitam (28000)" }));

        lblTgl.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lblTgl.setForeground(new java.awt.Color(51, 51, 51));
        lblTgl.setText("Tanggal");

        txtTgl.setBackground(new java.awt.Color(247, 231, 220));
        txtTgl.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        txtTgl.setForeground(new java.awt.Color(51, 51, 51));

        lblMenuPendamping.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lblMenuPendamping.setForeground(new java.awt.Color(51, 51, 51));
        lblMenuPendamping.setText("Menu Pendamping");

        txtMenuPendamping.setBackground(new java.awt.Color(255, 255, 255));
        txtMenuPendamping.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        txtMenuPendamping.setForeground(new java.awt.Color(51, 51, 51));
        txtMenuPendamping.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Choose", "Nasi (3000)", "Ati Ampela (5000)", "Lalapan (1000)", "Tempe dan Tahu (3000)", "Gorengan (5000)", "tidak pake" }));

        txtMinuman.setBackground(new java.awt.Color(255, 255, 255));
        txtMinuman.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        txtMinuman.setForeground(new java.awt.Color(51, 51, 51));
        txtMinuman.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Choose", "Jus Alpukat (8000)", "Jus Mangga (8000)", "Es teh (3500)", "Es jeruk (5000)", "Nutrisari (4000)", "Susu (5000)", "tidak pake" }));

        lblMinuman.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lblMinuman.setForeground(new java.awt.Color(51, 51, 51));
        lblMinuman.setText("Minuman");

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));

        btnInput.setBackground(new java.awt.Color(204, 204, 204));
        btnInput.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnInput.setForeground(new java.awt.Color(0, 0, 0));
        btnInput.setText("Input");
        btnInput.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnInputActionPerformed(evt);
            }
        });

        btnUpdate.setBackground(new java.awt.Color(204, 204, 204));
        btnUpdate.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnUpdate.setForeground(new java.awt.Color(0, 0, 0));
        btnUpdate.setText("Update");
        btnUpdate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUpdateActionPerformed(evt);
            }
        });

        btnDelete.setBackground(new java.awt.Color(204, 204, 204));
        btnDelete.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnDelete.setForeground(new java.awt.Color(0, 0, 0));
        btnDelete.setText("Delete");
        btnDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeleteActionPerformed(evt);
            }
        });

        btnStruk.setBackground(new java.awt.Color(204, 204, 204));
        btnStruk.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnStruk.setForeground(new java.awt.Color(0, 0, 0));
        btnStruk.setText("Cetak Struk");
        btnStruk.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnStrukActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addComponent(btnInput, javax.swing.GroupLayout.DEFAULT_SIZE, 148, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addComponent(btnUpdate, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnDelete, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnStruk, javax.swing.GroupLayout.PREFERRED_SIZE, 188, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(16, 16, 16))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnInput)
                    .addComponent(btnUpdate)
                    .addComponent(btnDelete)
                    .addComponent(btnStruk))
                .addContainerGap())
        );

        tblTransaksi.setBackground(new java.awt.Color(255, 255, 255));
        tblTransaksi.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID Transaksi", "Nama Pelanggan", "Menu Pesanan", "jPesanan", "Side Menu", "jSideMenu", "Minuman", "jMinuman", "Tanggal", "Total Harga"
            }
        ));
        tblTransaksi.addInputMethodListener(new java.awt.event.InputMethodListener() {
            public void caretPositionChanged(java.awt.event.InputMethodEvent evt) {
            }
            public void inputMethodTextChanged(java.awt.event.InputMethodEvent evt) {
                tblTransaksiInputMethodTextChanged(evt);
            }
        });
        jScrollPane1.setViewportView(tblTransaksi);

        txtSukses.setForeground(new java.awt.Color(0, 0, 0));
        txtSukses.setText("Status");

        btnClear.setBackground(new java.awt.Color(64, 93, 114));
        btnClear.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnClear.setForeground(new java.awt.Color(255, 255, 255));
        btnClear.setText("Clear form");
        btnClear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnClearActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jButton1)
                        .addContainerGap())
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(lblTgl, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(txtTgl))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lblNamaPelanggan, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(lblIDTransaksi, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtIDTransaksi)
                                    .addComponent(txtNamaPelanggan))))
                        .addGap(35, 35, 35))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(35, 35, 35))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(lblMinuman, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(txtMinuman, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addComponent(lblMenuPesanan, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(txtMenuPesanan, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addComponent(lblMenuPendamping, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(txtMenuPendamping, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(countMinuman, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                            .addComponent(countPesanan, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(countPendamping, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 1, Short.MAX_VALUE))
                        .addGap(35, 35, 35))))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(txtSukses, javax.swing.GroupLayout.PREFERRED_SIZE, 531, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnClear)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jButton1)
                .addGap(18, 18, 18)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtIDTransaksi, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblIDTransaksi))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtNamaPelanggan, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblNamaPelanggan))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblMenuPesanan)
                    .addComponent(txtMenuPesanan, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(countPesanan, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblMenuPendamping)
                    .addComponent(txtMenuPendamping, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(countPendamping, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(countMinuman)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(lblMinuman)
                        .addComponent(txtMinuman, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblTgl)
                    .addComponent(txtTgl, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(31, 31, 31)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 178, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(txtSukses, javax.swing.GroupLayout.PREFERRED_SIZE, 18, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnClear))
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteActionPerformed
        int selectedRow = tblTransaksi.getSelectedRow(); 
        if (selectedRow == -1) {
            JOptionPane.showMessageDialog(null, "Pilih data yang ingin dihapus dari tabel!", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        String idTransaksi = tblTransaksi.getValueAt(selectedRow, 0).toString();
        int confirm = JOptionPane.showConfirmDialog(null, "Apakah Anda yakin ingin menghapus data ini?", "Konfirmasi", JOptionPane.YES_NO_OPTION);

        if (confirm == JOptionPane.YES_OPTION) {
            String query = "DELETE FROM transaksi WHERE id_transaksi = ?";
            try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
                preparedStatement.setString(1, idTransaksi);
                int rowsDeleted = preparedStatement.executeUpdate();
                if (rowsDeleted > 0) {
                    JOptionPane.showMessageDialog(null, "Data berhasil dihapus!");
                    loadTableData(); 
                } else {
                    JOptionPane.showMessageDialog(null, "Data tidak ditemukan!", "Error", JOptionPane.ERROR_MESSAGE);
                }
            } catch (SQLException e) {
                JOptionPane.showMessageDialog(null, "Error: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    }//GEN-LAST:event_btnDeleteActionPerformed

    private void btnStrukActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnStrukActionPerformed
            try {
                String sqlSelect = "SELECT * FROM transaksi";
                PreparedStatement pstSelect = connection.prepareStatement(sqlSelect, ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
                ResultSet rs = pstSelect.executeQuery();

                if (!rs.isBeforeFirst()) {
                    JOptionPane.showMessageDialog(null, "Tidak ada data transaksi untuk dicetak!", "Error", JOptionPane.ERROR_MESSAGE);
                    return;
                }

                int selectedRow = tblTransaksi.getSelectedRow(); 
                if (selectedRow == -1) {
                    JOptionPane.showMessageDialog(null, "Pilih transaksi yang ingin dicetak!", "Error", JOptionPane.ERROR_MESSAGE);
                    return;
                }

                rs.absolute(selectedRow + 1);

                String id = rs.getString("id_transaksi"); 
                String namaPelanggan = rs.getString("nama_pelanggan");
                String menuPesanan = rs.getString("menu_pesanan");
                int jmlPesanan = rs.getInt("jmlPesanan");
                String menuPendamping = rs.getString("menu_pendamping");
                int jmlPendamping = rs.getInt("jmlPendamping");
                String minuman = rs.getString("minuman");
                int jmlMinuman = rs.getInt("jmlMinuman");
                int totalHarga = rs.getInt("totalHarga");
                String tanggal = rs.getString("tanggal");

               String sqlData = "INSERT INTO detailTransaksi (id_transaksi, nama_pelanggan, menu_pesanan, jmlPesanan, "
                       + "menuPendamping, jmlPendamping, minuman, jmlMinuman, totalHarga, tanggal) "
                       + "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
                PreparedStatement pstInsertDetail = connection.prepareStatement(sqlData);
                pstInsertDetail.setString(1, id);
                pstInsertDetail.setString(2, namaPelanggan);
                pstInsertDetail.setString(3, menuPesanan);
                pstInsertDetail.setInt(4, jmlPesanan);
                pstInsertDetail.setString(5, menuPendamping);
                pstInsertDetail.setInt(6, jmlPendamping);
                pstInsertDetail.setString(7, minuman);
                pstInsertDetail.setInt(8, jmlMinuman);
                pstInsertDetail.setInt(9, totalHarga);
                pstInsertDetail.setString(10, tanggal);
                pstInsertDetail.executeUpdate();

                String sqlDelete1 = "SET FOREIGN_KEY_CHECKS = 0";
                String sqlDelete2 = "DELETE FROM transaksi WHERE id_transaksi = ?";
                String sqlDelete3 = "SET FOREIGN_KEY_CHECKS = 1";
                PreparedStatement pstDelete1 = connection.prepareStatement(sqlDelete1);
                PreparedStatement pstDelete2 = connection.prepareStatement(sqlDelete2);
                pstDelete2.setString(1, id);
                PreparedStatement pstDelete3 = connection.prepareStatement(sqlDelete3);
                pstDelete1.executeUpdate();
                pstDelete2.executeUpdate();
                pstDelete3.executeUpdate();

                StrukPembelian struk = new StrukPembelian();
                struk.setDataStruk(namaPelanggan, menuPesanan, jmlPesanan, menuPendamping,
                        jmlPendamping, minuman, jmlMinuman, totalHarga, tanggal);
                struk.setVisible(true);

                loadTableData();
                JOptionPane.showMessageDialog(null, "Transaksi berhasil dipindahkan dan struk dicetak!");

            } catch (SQLException e) {
                JOptionPane.showMessageDialog(null, "Error: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Error: Pilihan tidak valid!", "Error", JOptionPane.ERROR_MESSAGE);
            }
    }//GEN-LAST:event_btnStrukActionPerformed

    private void tblTransaksiInputMethodTextChanged(java.awt.event.InputMethodEvent evt) {//GEN-FIRST:event_tblTransaksiInputMethodTextChanged
        // TODO add your handling code here:
    }//GEN-LAST:event_tblTransaksiInputMethodTextChanged

    private void btnInputActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnInputActionPerformed
        String sqlData = "INSERT INTO transaksi (nama_pelanggan, menu_pesanan, jmlPesanan, "
                + "menu_pendamping, jmlPendamping, minuman, jmlMinuman, totalHarga) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
        String idTransaksi = "";
        String namaPelanggan = txtNamaPelanggan.getText().trim();
        String menuPes = (String) txtMenuPesanan.getSelectedItem();
        String menuPend = (String) txtMenuPendamping.getSelectedItem();
        String minuman = (String) txtMinuman.getSelectedItem();
        String tgl = "";

        int jmlPesanan = (Integer) countPesanan.getValue();
        int jmlPendamping = (Integer) countPendamping.getValue();
        int jmlMinuman = (Integer) countMinuman.getValue();

        if (namaPelanggan.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Nama pelanggan tidak boleh kosong!", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        if (jmlPesanan <= 0) {
            JOptionPane.showMessageDialog(null, "Jumlah pesanan tidak boleh 0 atau negatif!", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        if (!menuPend.equalsIgnoreCase("tidak pake (0)") && jmlPendamping <= 0) {
            JOptionPane.showMessageDialog(null, "Jumlah menu pendamping tidak boleh 0 atau negatif jika dipilih!", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        if (!minuman.equalsIgnoreCase("tidak pakai (0)") && jmlMinuman <= 0) {
            JOptionPane.showMessageDialog(null, "Jumlah minuman tidak boleh 0 atau negatif jika dipilih!", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        int hargaPesanan = ambilHargaDariComboBox(menuPes);
        int hargaPendamping = menuPend.equalsIgnoreCase("tidak pake") ? 0 : ambilHargaDariComboBox(menuPend);
        int hargaMinuman = minuman.equalsIgnoreCase("tidak pake") ? 0 : ambilHargaDariComboBox(minuman);

        int totalHarga = (hargaPesanan * jmlPesanan) + (hargaPendamping * jmlPendamping) + (hargaMinuman * jmlMinuman);

        try {
            PreparedStatement pst = connection.prepareStatement(sqlData, Statement.RETURN_GENERATED_KEYS);
            pst.setString(1, namaPelanggan);
            pst.setString(2, menuPes);
            pst.setInt(3, jmlPesanan);
            pst.setString(4, menuPend);
            pst.setInt(5, jmlPendamping);
            pst.setString(6, minuman);
            pst.setInt(7, jmlMinuman);
            pst.setInt(8, totalHarga);
            pst.executeUpdate();

            ResultSet generatedKeys = pst.getGeneratedKeys();
            if (generatedKeys.next()) {
                idTransaksi = generatedKeys.getString(1);
            }

            String tampilData = "SELECT tanggal FROM transaksi WHERE id_transaksi = ?";
            PreparedStatement stmt = connection.prepareStatement(tampilData);
            stmt.setString(1, idTransaksi);
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                tgl = rs.getString("tanggal");
            }

            JOptionPane.showMessageDialog(null, "Data berhasil disimpan");
            loadTableData();

            txtNamaPelanggan.setText("");
            txtMenuPesanan.setSelectedItem("Choose");
            txtMenuPendamping.setSelectedItem("Choose");
            txtMinuman.setSelectedItem("Choose");
            countPesanan.setValue(0);
            countPendamping.setValue(0);
            countMinuman.setValue(0);
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_btnInputActionPerformed

    private void btnUpdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUpdateActionPerformed
        tblTransaksi.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblTransaksiMouseClicked(evt);
            }
        });
        int selectedRow = tblTransaksi.getSelectedRow(); 
        if (selectedRow == -1) {
            JOptionPane.showMessageDialog(null, "Pilih data yang ingin diupdate dari tabel!", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        String idTransaksi = tblTransaksi.getValueAt(selectedRow, 0).toString();
        String namaPelanggan = txtNamaPelanggan.getText();
        String menuPesanan, menuPendamping, minuman;
        menuPesanan = (String)txtMenuPesanan.getSelectedItem();
        menuPendamping = (String)txtMenuPendamping.getSelectedItem();
        minuman = (String)txtMinuman.getSelectedItem();
        
        int jmlPesanan = (Integer) countPesanan.getValue();
        int jmlPendamping = (Integer) countPendamping.getValue();
        int jmlMinuman = (Integer) countMinuman.getValue();
        if (jmlPesanan <= 0) {
             JOptionPane.showMessageDialog(null, "Jumlah pesanan, pendamping, atau minuman tidak boleh 0 atau negatif!", "Error", JOptionPane.ERROR_MESSAGE);
             return;
         }

         if (menuPendamping.equals("tidak pake")) {
             if (jmlPendamping < 0) {
                 JOptionPane.showMessageDialog(null, "Jumlah menu pendamping tidak boleh negatif!", "Error", JOptionPane.ERROR_MESSAGE);
             }
         } else {
             if (jmlPendamping <= 0) {
                 JOptionPane.showMessageDialog(null, "Jumlah menu pendamping tidak boleh 0 atau negatif!", "Error", JOptionPane.ERROR_MESSAGE);
             }
         }

         if (minuman.equals("tidak pake")) {
             if (jmlMinuman < 0) {
                 JOptionPane.showMessageDialog(null, "Jumlah menu pendamping tidak boleh negatif!", "Error", JOptionPane.ERROR_MESSAGE);
             }
         } else {
             if (jmlMinuman <= 0) {
                 JOptionPane.showMessageDialog(null, "Jumlah menu pendamping tidak boleh 0 atau negatif!", "Error", JOptionPane.ERROR_MESSAGE);
             }
         }


        if (namaPelanggan.isEmpty() || menuPesanan.equals("Choose") || menuPendamping.equals("Choose") || minuman.equals("Choose")) {
            JOptionPane.showMessageDialog(null, "Semua bidang harus diisi!", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }
        
        int hargaPesanan = ambilHargaDariComboBox(menuPesanan);
        int hargaPendamping = ambilHargaDariComboBox(menuPendamping);
        int hargaMinuman = ambilHargaDariComboBox(minuman);
        int totalHarga = (hargaPesanan * jmlPesanan) + (hargaPendamping * jmlPendamping) + (hargaMinuman * jmlMinuman);

        String query = "UPDATE transaksi SET nama_pelanggan = ?, menu_pesanan = ?, jmlPesanan = ?, menu_pendamping = ?, "
                + "jmlPendamping = ?, minuman = ?, jmlMinuman = ?, totalHarga = ? WHERE id_transaksi = ?";
        try {
            PreparedStatement pst = connection.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
            pst.setString(1, namaPelanggan);
            pst.setString(2, menuPesanan);
            pst.setInt(3, jmlPesanan);
            pst.setString(4, menuPendamping);
            pst.setInt(5, jmlPendamping);
            pst.setString(6, minuman);
            pst.setInt(7, jmlMinuman);
            pst.setInt(8, totalHarga);
            pst.setString(9, idTransaksi);
            
            int rowsUpdated = pst.executeUpdate();
            if (rowsUpdated > 0) {
                JOptionPane.showMessageDialog(null, "Data berhasil diperbarui!");
                loadTableData();
                txtSukses.setText("Status");
                txtNamaPelanggan.setText("");
                txtMenuPesanan.setSelectedItem("Choose");
                txtMenuPendamping.setSelectedItem("Choose");
                txtMinuman.setSelectedItem("Choose");
                countPesanan.setValue(0);
                countPendamping.setValue(0);
                countMinuman.setValue(0);
            } else {
                JOptionPane.showMessageDialog(null, "Gagal memperbarui data!", "Error", JOptionPane.ERROR_MESSAGE);
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_btnUpdateActionPerformed

    private void btnClearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnClearActionPerformed
        txtNamaPelanggan.setText("");
        txtMenuPesanan.setSelectedItem("Choose");
        txtMenuPendamping.setSelectedItem("Choose");
        txtMinuman.setSelectedItem("Choose");
        countPesanan.setValue(0);
        countPendamping.setValue(0);
        countMinuman.setValue(0);

        tblTransaksi.clearSelection();
    }//GEN-LAST:event_btnClearActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        InputUser logout = new InputUser();
        logout.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jButton1ActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnClear;
    private javax.swing.JButton btnDelete;
    private javax.swing.JButton btnInput;
    private javax.swing.JButton btnStruk;
    private javax.swing.JButton btnUpdate;
    private javax.swing.JSpinner countMinuman;
    private javax.swing.JSpinner countPendamping;
    private javax.swing.JSpinner countPesanan;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblIDTransaksi;
    private javax.swing.JLabel lblMenuPendamping;
    private javax.swing.JLabel lblMenuPesanan;
    private javax.swing.JLabel lblMinuman;
    private javax.swing.JLabel lblNamaPelanggan;
    private javax.swing.JLabel lblTgl;
    private javax.swing.JTable tblTransaksi;
    private javax.swing.JTextField txtIDTransaksi;
    private javax.swing.JComboBox<String> txtMenuPendamping;
    private javax.swing.JComboBox<String> txtMenuPesanan;
    private javax.swing.JComboBox<String> txtMinuman;
    private javax.swing.JTextField txtNamaPelanggan;
    private javax.swing.JLabel txtSukses;
    private javax.swing.JTextField txtTgl;
    // End of variables declaration//GEN-END:variables
}
