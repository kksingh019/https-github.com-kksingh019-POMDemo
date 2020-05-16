package com.Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OrangeHRM_Login_Page {
	
	WebDriver driver;
	
	@FindBy(id="txtUsername")
	WebElement Username;
	
	@FindBy(id="txtPassword")
	WebElement Password;
	
	@FindBy(xpath="//*[@id='btnLogin']")
	WebElement Loginbtn;
	
	public OrangeHRM_Login_Page(WebDriver ldriver) {
		
		driver=ldriver;
		PageFactory.initElements(ldriver, this);
		
	}
	
	public void Login_username(String uname) {
		Username.sendKeys(uname);
	}
	
	public void Login_password(String pwd) {
		Password.sendKeys(pwd);
	}
	
	public void Login_button() {
		Loginbtn.click();
	}

}
