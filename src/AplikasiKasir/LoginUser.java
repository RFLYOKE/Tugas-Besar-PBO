/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package AplikasiKasir;

/**
 *
 * @author Asus
 */
public class LoginUser extends User{
    public LoginUser(int userID, String nama, String username, String password, String role) throws ValidasiInputExceptions {
        super(userID, nama, username, password, role);
        if(username.isEmpty()){
            throw new ValidasiInputExceptions("Username tidak boleh kosong");
        }
        if (!password.matches("\\d{8}")) {
            throw new ValidasiInputExceptions("Password harus 8 karakter");
        }
        if (role.equals("Option") || role.isEmpty()) {
            throw new ValidasiInputExceptions("Role harus dipilih");
        }
    }
    
    public String getUsername(){
        return username;
    }
    
    public String getPassword(){
        return password;
    }
    public String getRole(){
        return role;
    }
}
