package com.mystore.utilities;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class ReadConfigProp {

	Properties properties;
	String path = "E:\\Eclips 2023\\GitProjectDemoX Person\\Config.Properties\\Config.Properties";

	public ReadConfigProp() {
		properties = new Properties();
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

	public String geturl() {
		String geturl = properties.getProperty("baseUrl");
		if (geturl != null)
			return geturl;
		else
			throw new RuntimeException();
	}

	public String getBrowser() {
		String getBrowser = properties.getProperty("browser");
		if (getBrowser != null)
			return getBrowser;
		else
			throw new RuntimeException();
	}

	
}
