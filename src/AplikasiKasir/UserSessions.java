/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package AplikasiKasir;

/**
 *
 * @author Asus
 */
public class UserSessions {
    private static String namaKasir;
    private static String username;

    public static String getNamaKasir() {
        return namaKasir;
    }

    public static void setNamaKasir(String namaKasir) {
        UserSessions.namaKasir = namaKasir;
    }

    public static String getUsername() {
        return username;
    }

    public static void setUsername(String username) {
        UserSessions.username = username;
    }
}
