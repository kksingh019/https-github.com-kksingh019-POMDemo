package com.TestCases;

import java.io.IOException;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.BaseClass.Library;
import com.Pages.OrangeHRM_Login_Page;

public class OrangeHRM_Login_TestCase extends Library{
	
	OrangeHRM_Login_Page login;
	
	@BeforeClass
	public void Start() throws IOException {
		launchApp();
	}
	
	@Test(priority=1)
	public void Login() {
		login=new OrangeHRM_Login_Page(driver);
		
		login.Login_username(prop.getProperty("uname"));
		login.Login_password(prop.getProperty("pwd"));
		login.Login_button();
		
	}
	
	@AfterClass
	public void teardown() {
		to_take_screenshot(prop.getProperty("LoginScreen"));
		closeApp();
	}

}
