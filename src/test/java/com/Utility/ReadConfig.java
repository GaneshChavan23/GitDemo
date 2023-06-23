package com.Utility;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class ReadConfig {

	Properties properties = new Properties();
	String path = "E:\\Eclips 2023\\SwagLabs\\Properties\\Config.properties";

	public ReadConfig() {
		try {
			FileInputStream fis = new FileInputStream(path);
			try {
				properties.load(fis);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public String GetUrl() {
		String url = properties.getProperty("url");
		if (url != null)
			return url;
		else
			throw new RuntimeException("Url not getting throught properties file");
	}

	public String GrtUnmae() {
		String uname = properties.getProperty("uname");
		if (uname != null)
			return uname;
		else
			throw new RuntimeException("uname not getting from properties file ");
	}

	public String Password() {
		String pass = properties.getProperty("password");
		if (pass != null)
			return pass;
		else
			throw new RuntimeException("password is not getting througjht property file");
	}

}
