/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package AplikasiKasir;

/**
 *
 * @author Akmal Rafly Dzunurain (2311103096)
 */
abstract class User {
    protected int userID;
    protected String nama, username, password, role;
    
    public User(int userID, String nama, String username, String password, String role){
        this.userID = userID;
        this.nama = nama;
        this.username = username;
        this.password = password;
        this.role = role;
    }
}
