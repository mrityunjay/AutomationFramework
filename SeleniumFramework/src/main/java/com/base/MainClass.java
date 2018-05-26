package com.base;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class MainClass {
	
	public static WebDriver driver;
	public static Properties properties;
	
	public MainClass() {	
		System.out.println("MainClass object got created");
		
	}
	
	public static void init() {
		properties=new Properties();
		File file=new File(".\\src\\main\\java\\com\\testData\\config.properties");
		FileInputStream inStream;
		try {
			inStream = new FileInputStream(file);
			properties.load(inStream);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\mrityunjay\\selenium_learn\\chromedriver.exe");
		//Launch a browser
		driver=new ChromeDriver();
	}

	
	public static void navigateToURL(String url) {
		driver.get(url);
	}
	
	public String getTitle() {
		return driver.getTitle();
	}
	
	public static void closeBroswer() {
		driver.quit();
	}

}
