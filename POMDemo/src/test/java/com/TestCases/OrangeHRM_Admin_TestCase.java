package com.TestCases;

import java.io.IOException;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.BaseClass.Library;
import com.Pages.OrangeHRM_Admin_Page;
import com.Pages.OrangeHRM_Login_Page;

public class OrangeHRM_Admin_TestCase extends Library{
	
	OrangeHRM_Login_Page login;
	OrangeHRM_Admin_Page admin;

	@BeforeClass
	public void Start() throws IOException {
		launchApp();
	}
	
	@Test(priority=2)
	public void Login() {
		login=new OrangeHRM_Login_Page(driver);
		login.Login_username(prop.getProperty("uname"));
		login.Login_password(prop.getProperty("pwd"));
		login.Login_button();
	}
	@Test(dependsOnMethods = "Login")
	public void Admin() {
		admin=new OrangeHRM_Admin_Page(driver);
		admin.Admin_adminlink();
		admin.Admin_adminuname(prop.getProperty("Auname"));
		admin.Admin_DropRole(prop.getProperty("Role"));
		admin.Admin_Employeename(prop.getProperty("Employeename"));
		admin.Admin_DropStatus(prop.getProperty("Status"));
		admin.Admin_Search();
	}
	@AfterClass
	public void teardown() {
		to_take_screenshot(prop.getProperty("AdminScreen"));
		closeApp();
	}
	
}
