package com.mindtree.utilities;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class ReadProperties {
	Properties prop;
	public ReadProperties() {
		File file= new File("./testdata/config.properties");
		FileInputStream fin;
		try {
			fin= new FileInputStream(file);
			prop= new Properties();
			prop.load(fin);
		} catch (FileNotFoundException e) {
			System.out.println("File not found!");
			e.printStackTrace();
		} catch (IOException e) {
			System.out.println("Property file not loaded!");
			e.printStackTrace();
		}catch(NullPointerException np){
			System.out.println("NPE");
			np.printStackTrace();
		}
	}
	
	public String getUrl() {
		return prop.getProperty("url");
	}
	public String getExtentReportPath() {
		return prop.getProperty("extentreportpath");
	}
	public String getChormeDriverPath() {
		return prop.getProperty("chromedriverpath");
	}
	public int getImplicitWaitTime() {
		return Integer.parseInt(prop.getProperty("implicitWait"));
	}
}
