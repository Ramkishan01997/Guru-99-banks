package com.inetBanking.utilities;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

public class ReadConfig {

	Properties pro;

	public ReadConfig() {// for reading file create constructor
		File src = new File("./Configuration/config.properties");

		try {
			FileInputStream fis = new FileInputStream(src);
			pro = new Properties();
			pro.load(fis);
		} catch (Exception e) {
			System.out.println("Exceptionis " + e.getMessage());
		}
	}

	public String getApplicationUrl() { // read url from property file
		String url = pro.getProperty("baseUrl");
		return url;
	}

	public String getUserName() {
		String username = pro.getProperty("username");
		return username;
	}

	public String getPassword() {
		String pass = pro.getProperty("password");
		return pass;
	}

	public String getChromePath() {
		String chrome = pro.getProperty("chromepath");
		return chrome;
	}

	public String getEdgePath() {
		String edge = pro.getProperty("edgepath");
		return edge;
	}

}
