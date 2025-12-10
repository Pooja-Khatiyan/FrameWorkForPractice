package com.qa.opencart.pagetests;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.qa.opencart.basetest.BaseTest;
import com.qa.opencart.constants.AppConstants;
import com.qa.opencart.utils.ExcelUtil;

public class RegisterPageTest extends BaseTest {

	@BeforeClass
	public void regSetup() {
		registerPage = loginPage.navigateToRegisterPage();
	}

	private String getRandomEmailID() {
		return "testautomation" + System.currentTimeMillis() + "@opencart.com";
	}

	@DataProvider
	public Object[][] getUserRegTextExcelData() {
		Object data[][] = ExcelUtil.getTestData(AppConstants.REGISTER_DATA_SHEET_NAME);
		return data;
	}

	@Test(dataProvider = "getUserRegTextExcelData")
	public void userRegistrationTest(String firstName, String lastName, String telephone, String password,
			String isSubscribe) {
		boolean flag = registerPage.userRegistration(firstName, lastName, getRandomEmailID(), telephone, password,
				isSubscribe);
		Assert.assertTrue(flag);
	}
}
