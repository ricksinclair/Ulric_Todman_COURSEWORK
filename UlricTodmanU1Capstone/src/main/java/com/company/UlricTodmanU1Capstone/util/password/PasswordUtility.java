package com.company.UlricTodmanU1Capstone.util.password;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

public class PasswordUtility {

    static PasswordEncoder pwdEnc = new BCryptPasswordEncoder();
    static String adminPassword = "password1";
    static String encryptedAdminPassword = pwdEnc.encode(adminPassword);
    static String managerPassword = "password2";
    static String encryptedManagerPassword = pwdEnc.encode(managerPassword);
    static String userPassword = "password3";
    static String encryptedUserPassword = pwdEnc.encode(userPassword);

    public static void main(String[] args) {
        System.out.println("Admin password: " + encryptedAdminPassword);
        System.out.println("Manager password: " + encryptedManagerPassword);
        System.out.println("User password: " + encryptedUserPassword);


    }

}
