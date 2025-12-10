package com.qa.opencart.pagetests;

import java.util.Map;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.qa.opencart.basetest.BaseTest;
import com.qa.opencart.constants.AppConstants;
import com.qa.opencart.utils.ExcelUtil;

public class ProductInfoPageTest extends BaseTest {

	@BeforeClass
	public void productInfoSetUp() {
		accountPage = loginPage.doLogin("poojakhatiyan021@gmail.com", "Test@1234");
	}

	@DataProvider
	public Object[][] getSearchData() {
		return new Object[][] { { "MacBook", "MacBook Pro", 4 }, { "MacBook", "MacBook Air", 4 }, { "iMac", "iMac", 3 },
				{ "Samsung", "Samsung SyncMaster 941BW", 1 } };
	}
	
	@DataProvider
	public Object[] [] getSearchDataFromExcel(){
		return ExcelUtil.getTestData(AppConstants.PRODUCT_DATA_SHEET_NAME);
	}
//as we are reading data from data provider we are getting that in string,i.e imgCount we are converting from int to String

	@Test(dataProvider = "getSearchDataFromExcel")
	public void productImageCountTest(String searchKey, String productName, String imgCount) {
		searchResultPage = accountPage.doSearch(searchKey);
		productInfoPage = searchResultPage.selectProduct(productName);
		int actCount = productInfoPage.productImageCount();
		Assert.assertEquals(String.valueOf(actCount), imgCount);
	}

	@Test
	public void productInfoTest() {
		searchResultPage = accountPage.doSearch("MacBook");
		productInfoPage = searchResultPage.selectProduct("MacBook Pro");
		Map<String, String> productInfoMap = productInfoPage.getProductDetails();
		softAssert.assertEquals(productInfoMap.get("Brand"), "Apple");
		softAssert.assertEquals(productInfoMap.get("Product Code"), "Product 18");
		softAssert.assertEquals(productInfoMap.get("Reward Points"), "800");
		softAssert.assertEquals(productInfoMap.get("Availability"), "Out Of Stock");
		softAssert.assertEquals(productInfoMap.get("price"), "$2,000.00");
		softAssert.assertEquals(productInfoMap.get("extaxprice"), "$2,000.00");
		softAssert.assertAll();
	}

}
