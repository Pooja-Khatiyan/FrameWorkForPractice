package com.qa.opencart.constants;

import java.util.Arrays;
import java.util.List;

public class AppConstants {

	public static final String LOGIN_PAGE_TITLE = "Account Login";
	public static final String LOGIN_PAGE_URL_FRACTION = "route=account/login";
	public static final String ACCOUNT_PAGE_TITLE = "My Account";
	public static final String ACCOUNT_PAGE_URL_FRACTION = "account/account";
	public static final int SHORT_DEFAULT_WAIT = 5;
	public static final int MEDIUM_DEFAULT_WAIT = 10;
	public static final int LONG_DEFAULT_WAIT = 15;
	public static final int POLLING_DEFAULT_WAIT = 2;
	public static final int ACCOUNT_HEADER_COUNT = 4;
	public static final int PRODUCT_IMG_COUNT = 4;
	public static final String REGISTER_SUCCESS_MSG = "Your Account Has Been Created!";
	public static final List<String> EXPECTED_ACCOUNT_HEADERS = Arrays.asList("My Account", "My Orders", "My Affiliate Account", "Newsletter");
	public static final String REGISTER_DATA_SHEET_NAME = "register";
	public static final String PRODUCT_DATA_SHEET_NAME = "product";
	public static final String TEST_DATA_SHEET_PATH = "./src/test/resources/testdata/OpenCartTestData.xlsx";
	public static final String PRODUCT_DATA_SHEET_PATH = "./src/test/resources/testdata/ProductSearchData.xlsx";

}
