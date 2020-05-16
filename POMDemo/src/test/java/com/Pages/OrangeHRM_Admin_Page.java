package com.Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class OrangeHRM_Admin_Page {
	
	WebDriver driver;
	
	@FindBy(id="menu_admin_viewAdminModule")
	WebElement AdminLink;
	
	@FindBy(id="searchSystemUser_userName")
	WebElement Adminusername;
	
	@FindBy(id="searchSystemUser_userType")
	WebElement UserRole;
	
	@FindBy(id="searchSystemUser_employeeName_empName")
	WebElement EmpName;
	
	@FindBy(id="searchSystemUser_status")
	WebElement Status;
	
	@FindBy(id="searchBtn")
	WebElement Searchbtn;
	
	public void selectdrop(WebElement element, String value) {
		Select select=new Select(element);
		select.selectByVisibleText(value);
	}
	
	public OrangeHRM_Admin_Page(WebDriver ldriver) {
		driver=ldriver;
		PageFactory.initElements(driver, this);
	}
	
	public void Admin_adminlink() {
		AdminLink.click();
	}
	
	public void Admin_adminuname(String Auname) {
		Adminusername.sendKeys(Auname);
	}
	
	public void Admin_DropRole(String text) {
		selectdrop(UserRole, text);
	}
	
	public void Admin_Employeename(String Ename) {
		EmpName.sendKeys(Ename);
	}
	
	public void Admin_DropStatus(String Dstatus) {
		selectdrop(Status, Dstatus);
	}
	
	public void Admin_Search() {
		Searchbtn.click();
	}

}
