package com.qa.opencart.pages;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.qa.opencart.constants.AppConstants;
import com.qa.opencart.utils.ElementUtil;

public class AccountsPage {
	private WebDriver driver;
	private ElementUtil eleUtil;

	public AccountsPage(WebDriver driver) {
		this.driver = driver;
		eleUtil = new ElementUtil(driver);
	}

	private By logout = By.linkText("Logout");
	private By accHeader = By.cssSelector("div#content h2");
	private By search = By.cssSelector("div#search input");
	private By searchIcon = By.cssSelector("div#search button");

	public boolean isLogotLinkExist() {
		return eleUtil.waitForVisibilityOfElement(logout, AppConstants.SHORT_DEFAULT_WAIT).isDisplayed();
	}

	public void logout() {
		if (isLogotLinkExist()) {
			eleUtil.doClick(logout);
		}
	}
	
	public String getAccountPageTitle() {
		String title = eleUtil.waitForTitleIs("My Account", AppConstants.SHORT_DEFAULT_WAIT);
		System.out.println("title is : " + title);
		return title;
	}

	public String getAccountPageUrl() {
		String actUrl = eleUtil.waitForUrlContains("route=account/account", AppConstants.SHORT_DEFAULT_WAIT);
		System.out.println("title is : " + actUrl);
		return actUrl;
	}

	public List<String> getAccountHeader() {
		List<WebElement> headerList = eleUtil.waitForVisibilityOfElements(accHeader, AppConstants.SHORT_DEFAULT_WAIT);
		List<String> headersValList = new ArrayList<String>();
		for(WebElement e : headerList) {
			String text = e.getText();
			headersValList.add(text);
		}
		return headersValList;
	}
	
	public SearchResultPage doSearch(String searchKey) {
		eleUtil.waitForVisibilityOfElement(search, AppConstants.MEDIUM_DEFAULT_WAIT).clear();
		eleUtil.waitForVisibilityOfElement(search, AppConstants.MEDIUM_DEFAULT_WAIT).sendKeys(searchKey);
		eleUtil.doClick(searchIcon);
		return new SearchResultPage(driver);
		
	}
}
