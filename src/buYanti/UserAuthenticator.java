/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package buYanti;

import java.util.HashMap;
import java.util.Map;
/**
 *
 * @author RYVANDA
 */

public class UserAuthenticator {

    // Ganti jadi static biar bisa diakses dari class lain
    public static Map<String, String> userDatabase = new HashMap<>();

    // Hapus constructor kalau tidak dipakai
    public static boolean authenticate(String username, String password) {
        return userDatabase.containsKey(username) &&
               userDatabase.get(username).equals(password);
    }
}
