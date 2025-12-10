package com.qa.opencart.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.qa.opencart.constants.AppConstants;
import com.qa.opencart.utils.ElementUtil;

public class RegisterPage {
	private WebDriver driver;
	private ElementUtil eleUtil;
	private By firstName = By.id("input-firstname");
	private By lastName = By.id("input-lastname");
	private By email = By.id("input-email");
	private By telephone = By.id("input-telephone");
	private By password = By.id("input-password");
	private By confirmPassword = By.id("input-confirm");
	private By subscribeYes = By.xpath("//label[normalize-space()='Yes']");
	private By subscribeNo = By.xpath("//label[normalize-space()='No']");
	private By policyCheckbox = By.xpath("//input[@type='checkbox']");
	private By continueBtn = By.xpath("//input[@type='submit']");

	private By successMsg = By.cssSelector("div#content h1 ");
	private By logout = By.linkText("Logout");
	private By register = By.linkText("Register");

	public RegisterPage(WebDriver driver) {
		this.driver = driver;
		eleUtil = new ElementUtil(this.driver);
	}

	public boolean userRegistration(String firstName, String lastName, String email, String telephone, String password,
			String subscribe) {
		eleUtil.waitForVisibilityOfElement(this.firstName, AppConstants.MEDIUM_DEFAULT_WAIT).sendKeys(firstName);
		eleUtil.doSendKey(this.lastName, lastName);
		eleUtil.doSendKey(this.email, email);
		eleUtil.doSendKey(this.telephone, telephone);
		eleUtil.doSendKey(this.password, password);
		eleUtil.doSendKey(this.confirmPassword, password);

		if (subscribe.equalsIgnoreCase("yes")) {
			eleUtil.doClick(subscribeYes);
		} else {
			eleUtil.doClick(subscribeNo);
		}

		eleUtil.doClick(policyCheckbox);
		eleUtil.doClick(continueBtn);

		String msg = eleUtil.waitForVisibilityOfElement(successMsg, AppConstants.LONG_DEFAULT_WAIT).getText();
		System.out.println(msg);

		if (msg.contains(AppConstants.REGISTER_SUCCESS_MSG)) {
			eleUtil.doClick(logout);
			eleUtil.doClick(register);
			return true;
		}
		return false;

	}
}
