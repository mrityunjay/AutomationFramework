package com.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.base.MainClass;

public class LoginPage extends MainClass{

	public LoginPage() {
		PageFactory.initElements(driver, this);
	}
	
	//public WebElement userName=driver.findElement(By.id("txtUsername"));
	@FindBy(id="txtUsername")
	public WebElement userName;
	
	@FindBy(id="txtPassword")
	public WebElement password;
	
	@FindBy(xpath=".//input[@id='btnLogin']")
	public WebElement loginButton;
	
	public void typeUserName(String user) {
		if(userName.isDisplayed()) {
			userName.clear();
			userName.sendKeys(user);
		}
	}
	
	public DashBoardPage login() {
		typeUserName(properties.getProperty("username"));
        password.sendKeys(properties.getProperty("password"));
        loginButton.click();
        return new DashBoardPage();
	}
	
	
	
	
}
