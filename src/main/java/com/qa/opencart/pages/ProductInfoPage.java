package com.qa.opencart.pages;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.qa.opencart.constants.AppConstants;
import com.qa.opencart.utils.ElementUtil;

public class ProductInfoPage {

	private WebDriver driver;
	private ElementUtil eleUtil;
	private By img = By.cssSelector("a.thumbnail img");
	private By productHeader = By.cssSelector("div h1");
	private By productMataData = By.xpath("(//div[@class='col-sm-4']//ul[@class='list-unstyled'])[1]//li");
	private By produtPriceData = By.xpath("(//div[@class='col-sm-4']//ul[@class='list-unstyled'])[2]//li");
	private Map<String, String> productData = new LinkedHashMap<>();

	public ProductInfoPage(WebDriver driver) {
		this.driver = driver;
		eleUtil = new ElementUtil(this.driver);
	}

	public int productImageCount() {
		int imageCount = eleUtil.waitForVisibilityOfElements(img, AppConstants.MEDIUM_DEFAULT_WAIT).size();
		System.out.println("Product " + getProductHeaderName() + " image count is: " + imageCount);
		return imageCount;
	}

	public String getProductHeaderName() {
		String productHeaderValue = eleUtil.doElementGetText(productHeader);
		System.out.println(productHeaderValue);
		return productHeaderValue;
	}

	private void getProductMataData() {
		List<WebElement> metaDataList = eleUtil.waitForVisibilityOfElements(productMataData,
				AppConstants.MEDIUM_DEFAULT_WAIT);
		for (WebElement e : metaDataList) {
			String data = e.getText();
			String dataKey = data.split(":")[0].trim();
			String dataValue = data.split(":")[1].trim();
			productData.put(dataKey, dataValue);
		}
	}

	private void getProductPriceData() {
		List<WebElement> priceDataList = eleUtil.waitForVisibilityOfElements(produtPriceData,
				AppConstants.MEDIUM_DEFAULT_WAIT);
		String productPrice = priceDataList.get(0).getText().trim();
		String productExTaxPrice = priceDataList.get(1).getText().split(":")[1].trim();
		productData.put("price", productPrice);
		productData.put("extaxprice", productExTaxPrice);
	}

	public Map<String, String> getProductDetails() {
		productData.put("productname", getProductHeaderName());
		getProductMataData();
		getProductPriceData();
		System.out.println(productData);
		return productData;
	}

}
