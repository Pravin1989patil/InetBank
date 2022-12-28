package com.inetbank.utilities;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class ReadConfig {
	FileInputStream fis = null;
	Properties prop = null;
	
	public ReadConfig() throws IOException {
		
		try {
			fis = new FileInputStream("./configuration/config.properties");
			prop = new Properties();
			prop.load(fis);
		} catch (FileNotFoundException fnfe) {
			fnfe.printStackTrace();
		} catch (IOException ioe) {
			ioe.printStackTrace();
		} finally {
			fis.close();
		}

	}
	
	public String getBaseUrl() {
		return prop.getProperty("baseURL");
		
	}
	public String getUserName() {
		return prop.getProperty("userName");
		
	}
	public String getPassword() {
		return prop.getProperty("password");
		
	}

}
