package com.fullstack.demo;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

public class PasswordEncoderUtil {

    public static void main(String[] args) {
        PasswordEncoder encoder = new BCryptPasswordEncoder();
        String rawPassword = "provider_password"; // Replace with your actual password
        String hashedPassword = encoder.encode(rawPassword);

        // Print the hash to the console
        System.out.println("Raw Password: " + rawPassword);
        System.out.println("BCrypt Hashed Password: " + hashedPassword);
    }
}
