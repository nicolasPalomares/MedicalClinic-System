package com.mycompany.util;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

/** 
 * Util class used to encrypt user passwords in the database 
 */

public class EncryptPassword {
	
	
	
	/*
	 * public static void main(String[] args) {
	 * 
	 * var password1; var password2;
	 * 
	 * System.out.println("User password: " + password1);
	 * System.out.println("Encrypted user password: " + encryptPassword(password1));
	 * 
	 * System.out.println("Admin password: " + password2);
	 * System.out.println("Encrypted admin password: " +
	 * encryptPassword(password2));
	 * 
	 * }
	 */
	 
	 

	/** 
	 * @return encrypted String password.
	 */
	public static String encryptPassword(String password) {
		
		BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
		return encoder.encode(password);
		
	}

}
