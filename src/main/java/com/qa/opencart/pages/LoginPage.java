package com.qa.opencart.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.qa.opencart.constants.AppConstants;
import com.qa.opencart.utils.ElementUtil;

public class LoginPage {
	private WebDriver driver;
	private ElementUtil eleUtil;
	private By logo = By.xpath("//img");
	private By search = By.cssSelector("div#search");
	private By email = By.cssSelector("div input#input-email");
	private By pwd = By.cssSelector("div input#input-password");
	private By loginBtn = By.xpath("//div //input[@type ='submit']");
	private By fogetPwd = By.cssSelector("input#input-password");
	private By register = By.linkText("Register");

	public LoginPage(WebDriver driver) {
		this.driver = driver;
		eleUtil = new ElementUtil(this.driver);
	}

	public String getLoginPageTitle() {
		String title = eleUtil.waitForTitleIs("Account Login", AppConstants.MEDIUM_DEFAULT_WAIT);
		System.out.println("title is : " + title);
		return title;
	}

	public String getLoginPageUrl() {
		String actUrl = eleUtil.waitForUrlContains("route=account/login", AppConstants.MEDIUM_DEFAULT_WAIT);
		System.out.println("title is : " + actUrl);
		return actUrl;
	}

	public boolean isLogoExist() {
		return eleUtil.waitForVisibilityOfElement(logo, AppConstants.SHORT_DEFAULT_WAIT).isDisplayed();
	}

	public boolean isForgotPasswordLinkExist() {
		return eleUtil.waitForVisibilityOfElement(fogetPwd, AppConstants.SHORT_DEFAULT_WAIT).isDisplayed();
	}

	public boolean isSearchFieldExist() {
		return eleUtil.waitForVisibilityOfElement(search, AppConstants.SHORT_DEFAULT_WAIT).isDisplayed();
	}

	public AccountsPage doLogin(String emailValue, String pwdValue) {
		System.out.println("Credentials are: " + emailValue + " ; " + pwdValue);
		eleUtil.waitForVisibilityOfElement(email, AppConstants.MEDIUM_DEFAULT_WAIT).sendKeys(emailValue);
		eleUtil.doSendKey(pwd, pwdValue);
		eleUtil.doClick(loginBtn);
		return new AccountsPage(driver);
	}

	public RegisterPage navigateToRegisterPage() {
		eleUtil.waitForVisibilityOfElement(register, AppConstants.SHORT_DEFAULT_WAIT).click();
		return new RegisterPage(driver);
	}
}
