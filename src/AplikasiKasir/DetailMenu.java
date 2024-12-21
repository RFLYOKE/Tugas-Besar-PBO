/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package AplikasiKasir;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author ACER
 */
public class DetailMenu {
    private List<String> menuUtama;
    private List<String> menuPendamping;
    private List<String> menuMinuman;

    public DetailMenu() {
        menuUtama = new ArrayList<>();
        menuPendamping = new ArrayList<>();
        menuMinuman = new ArrayList<>();
    }

    public void tambahMenuUtama(String menu) {
        menuUtama.add(menu);
        System.out.println("Menu utama yang dipilih: " + menu);
    }

    public void tambahMenuPendamping(String menu) {
        menuPendamping.add(menu);
        System.out.println("Menu pendamping yang dipilih: " + menu);
    }

    public void tambahMenuMinuman(String menu) {
        menuMinuman.add(menu);
        System.out.println("Menu minuman yang dipilih: " + menu);
    }

    public List<String> getMenuUtama() {
        return menuUtama;
    }

    public List<String> getMenuPendamping() {
        return menuPendamping;
    }

    public List<String> getMenuMinuman() {
        return menuMinuman;
    }

    public static void main(String[] args) {
        DetailMenu detailMenu = new DetailMenu();

        // Menambahkan menu utama
        detailMenu.tambahMenuUtama("Nasi Bebek Bakar Spesial");
        detailMenu.tambahMenuUtama("Nasi Bebek Goreng + Lalapan");
        detailMenu.tambahMenuUtama("Mie Pedas Bebek Goreng");
        detailMenu.tambahMenuUtama("1 Ekor Bebek Bakar + Tahu + Tempe + Lalapan");

        // Menambahkan menu pendamping
        detailMenu.tambahMenuPendamping("Tahu Goreng");
        detailMenu.tambahMenuPendamping("Tempe Goreng");
        detailMenu.tambahMenuPendamping("Udang Crispy");
        detailMenu.tambahMenuPendamping("Kentang Goreng");

        // Menambahkan menu minuman
        detailMenu.tambahMenuMinuman("Teh Dingin/Hangat");
        detailMenu.tambahMenuMinuman("Air Kelapa");
        detailMenu.tambahMenuMinuman("Air Biasa/Dingin/Hangat");
        detailMenu.tambahMenuMinuman("Es Jeruk");
    }
}
