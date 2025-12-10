package com.qa.opencart.pagetests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.qa.opencart.basetest.BaseTest;
import com.qa.opencart.constants.AppConstants;
import com.qa.opencart.pages.AccountsPage;

public class LoginPageTest extends BaseTest {

	@Test
	public void loginPageTitleTest() {
		String actTiltle = loginPage.getLoginPageTitle();
		Assert.assertEquals(actTiltle, AppConstants.LOGIN_PAGE_TITLE);
	}

	@Test
	public void loginPageUrlTest() {
		String actUrl = loginPage.getLoginPageUrl();
		Assert.assertTrue(actUrl.contains(AppConstants.LOGIN_PAGE_URL_FRACTION));
	}

	@Test
	public void logoExistTest() {
		boolean flag = loginPage.isLogoExist();
		Assert.assertEquals(flag, true);
	}

	@Test
	public void forgotLinkExistTest() {
		boolean flag = loginPage.isForgotPasswordLinkExist();
		Assert.assertEquals(flag, true);
	}

	@Test
	public void searchFieldExistTest() {
		boolean flag = loginPage.isSearchFieldExist();
		Assert.assertEquals(flag, true);
	}

	@Test(priority = 1)
	public void doLoginTest() {
		AccountsPage accountsPage = loginPage.doLogin(prop.getProperty("username"), prop.getProperty("password"));
		boolean flag = accountsPage.isLogotLinkExist();
		Assert.assertEquals(flag, true);
	}
}
