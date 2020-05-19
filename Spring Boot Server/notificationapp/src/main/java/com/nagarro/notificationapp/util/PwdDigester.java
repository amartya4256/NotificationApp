package com.nagarro.notificationapp.util;

import java.math.BigInteger;
import java.security.MessageDigest;

import org.springframework.stereotype.Service;

import com.nagarro.notificationapp.entity.User;

@Service
public class PwdDigester {

	public User disgestPassword(User user) {
		
		try { 
			  
            // Static getInstance method is called with hashing MD5 
            MessageDigest md = MessageDigest.getInstance("MD5"); 
  
            // digest() method is called to calculate message digest 
            //  of an input digest() return array of byte 
            byte[] messageDigest = md.digest(user.getPassword().getBytes()); 
  
            // Convert byte array into signum representation 
            BigInteger no = new BigInteger(1, messageDigest); 
  
            // Convert message digest into hex value 
            String hashtext = no.toString(16); 
            while (hashtext.length() < 32) { 
                hashtext = "0" + hashtext; 
            }
            user.setPassword(hashtext);
		} catch(Exception e) {
			
			user.setPassword(null);
		}
		
		return user;
	}
}
