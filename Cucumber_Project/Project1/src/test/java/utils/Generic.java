package utils;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

public class Generic {
	
	
	 public String generateUniqueReference() {
	        // Get current date in "yyMMdd" format (e.g., 250316 for 2025-03-16)
	        String datePart = new SimpleDateFormat("yyMMdd").format(new Date());

	        // Generate 10 random digits
	        Random random = new Random();
	        StringBuilder randomPart = new StringBuilder();
	        for (int i = 0; i < 10; i++) {
	            randomPart.append(random.nextInt(10)); // Random digit (0-9)
	        }

	        // Combine date part and random digits to form a 16-digit reference
	        return datePart + randomPart.toString();
	    }

	 
	/* public static void main(String[] args) {
		  String uniqueReference = generateUniqueReference();
	        System.out.println("Unique Reference: " + uniqueReference);
	 }*/
	 
	 

	
	
	

}
