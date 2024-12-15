/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package AplikasiKasir;

/**
 *
 * @author Asus
 */
public class Transaksi {
    private String idTransaksi, namaPelanggan, menuPesanan, menuPendamping, minuman, tanggal;
    
    public Transaksi(String idTransaksi, String namaPelanggan, String menuPesanan, String menuPendamping, String minuman,
            String tanggal) throws ValidasiInputExceptions {
        if (namaPelanggan.isEmpty()) {
            throw new ValidasiInputExceptions("Nama Tidak boleh kosong...");
        }
        if(menuPesanan.equals("Choose")){
            throw new ValidasiInputExceptions("Wajib diisi dong menu utamanya...");
        }
        if(menuPendamping.equals("Choose")){
            throw new ValidasiInputExceptions("Wajib diisi dong jangan choose...");
        }
        if(minuman.equals("Choose")){
             throw new ValidasiInputExceptions("Wajib diisi dong minumnya ntar keselek...");
        }
        this.idTransaksi = idTransaksi;
        this.namaPelanggan = namaPelanggan;
        this.menuPesanan = menuPesanan;
        this.menuPendamping = menuPendamping;
        this.minuman = minuman;
        this.tanggal = tanggal;
    }

    public String getIdTransaksi() {
        return idTransaksi;
    }

    public String getNamaPelanggan() {
        return namaPelanggan;
    }

    public String getMenuPesanan() {
        return menuPesanan;
    }

    public String getMenuPendamping() {
        return menuPendamping;
    }

    public String getMinuman() {
        return minuman;
    }

    public String getTanggal() {
        return tanggal;
    }
    
    
    
}
