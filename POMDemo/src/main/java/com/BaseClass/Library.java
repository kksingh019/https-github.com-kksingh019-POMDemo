package com.BaseClass;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

public class Library {
	
	public static WebDriver driver;
	public static Properties prop;
	  
	public void launchApp() throws IOException 
	{
		
		FileInputStream fileIS = new FileInputStream("C:\\Users\\Hp\\eclipse-workspace\\POMDemo\\src\\test\\resources\\Config Properties\\config.properties"); // configuration property path should be here
		prop = new Properties();
		prop.load(fileIS);
		
		if(prop.getProperty("browser").equalsIgnoreCase("chrome")) 
		{
			System.setProperty("webdriver.chrome.driver", "C:\\Users\\Hp\\eclipse-workspace\\POMDemo\\src\\test\\resources\\Drivers\\chromedriver.exe");
			driver = new ChromeDriver();
		}
		
		else if (prop.getProperty("browser").equalsIgnoreCase("firefox"))
		{
			driver = new FirefoxDriver();
		}
		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get(prop.getProperty("url"));
		
	}
	
	public void to_take_screenshot(String path)
	{
		TakesScreenshot ss=(TakesScreenshot)driver;
		File src=ss.getScreenshotAs(OutputType.FILE);
		try {
			FileUtils.copyFile(src, new File(path));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	
	public void closeApp()
	{
		driver.close();
	}

}
