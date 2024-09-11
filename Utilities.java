package com.seleniumproject.qa.tests;

import java.util.Date;

public class Utilities {
	
	public static String generateEmailTimestamp() {

		Date date = new Date();
		String timestamp=date.toString().replace(" ", "_").replace(":", "_");
		return "malay"+timestamp+"@demoemail.com";
		

	}

}
