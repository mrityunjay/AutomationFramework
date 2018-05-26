package com.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.base.MainClass;
import com.util.UtilityFunction;

public class DashBoardPage extends MainClass{

	public DashBoardPage() {
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath=".//span[text()='Assign Leave']")
	public WebElement assignLeave;
	
	@FindBy(id="menu_admin_viewAdminModule")
	public WebElement link_adminMenu;
	
	@FindBy(id="menu_admin_UserManagement")
	public WebElement link_userManagement;
	
	@FindBy(id="menu_admin_viewSystemUsers")
	public WebElement link_user;
	
	@FindBy(id="searchSystemUser_userName")
	public WebElement username;
	
	public void clickOnUserSubMenu() {
		Actions actions=new Actions(driver);
		actions.moveToElement(link_adminMenu).build().perform();
		link_userManagement.click();
		link_user.click();
	}
	
	public void typeInUserName() {
		String usernameData=UtilityFunction.getCellData(1, 1);
		username.sendKeys(usernameData);
	}
	
	public void typeInUserName(String user) {
		username.sendKeys(user);
	}

}
