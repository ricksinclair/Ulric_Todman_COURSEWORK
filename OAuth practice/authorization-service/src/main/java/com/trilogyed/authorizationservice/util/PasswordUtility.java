package com.trilogyed.authorizationservice.util;


import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

public class PasswordUtility {
    public static void main(String[] args) {

        PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

        String password = "jdoeRoCkS!!!";
        String encodedPass = passwordEncoder.encode(password);
        System.out.println(encodedPass);



    }
}
