package com.qa.opencart.pagetests;

import java.util.List;

import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.qa.opencart.basetest.BaseTest;
import com.qa.opencart.constants.AppConstants;

public class AccountPageTest extends BaseTest {

	@BeforeTest
	public void accSetUp() {
		accountPage = loginPage.doLogin("poojakhatiyan021@gmail.com", "Test@1234");
		// accountPage = new AccountsPage(driver);
	}

	@Test
	public void logoutLinkExistTest() {
		Assert.assertTrue(accountPage.isLogotLinkExist());
	}

	@Test
	public void accountPageUrlTest() {
		String accUrl = accountPage.getAccountPageUrl();
		Assert.assertTrue(accUrl.contains(AppConstants.ACCOUNT_PAGE_URL_FRACTION));
	}

	@Test
	public void accountPageTitleTest() {
		String accTitle = accountPage.getAccountPageTitle();
		Assert.assertEquals(accTitle, AppConstants.ACCOUNT_PAGE_TITLE);
	}

	@Test
	public void accPageHeaderCountTest() {
		int headerCount = accountPage.getAccountHeader().size();
		Assert.assertEquals(headerCount, AppConstants.ACCOUNT_HEADER_COUNT);
	}

	@Test
	public void accPageHeaderTest() {
		List<String> actHeader = accountPage.getAccountHeader();
		Assert.assertTrue(actHeader.equals(AppConstants.EXPECTED_ACCOUNT_HEADERS));
	}

	@Test(priority = 1)
	public void doSearchTest() {
		searchResultPage = accountPage.doSearch("macbook");
		productInfoPage = searchResultPage.selectProduct("MacBook Pro");
		String actProductHeaderValue = productInfoPage.getProductHeaderName();
		Assert.assertEquals(actProductHeaderValue, "MacBook Pro");
	}
}
