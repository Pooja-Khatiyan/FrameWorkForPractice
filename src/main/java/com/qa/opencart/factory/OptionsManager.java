package com.qa.opencart.factory;

import java.util.Properties;

import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxOptions;

public class OptionsManager {

	private Properties prop;
	private ChromeOptions co;
	private FirefoxOptions fo;
	private EdgeOptions eo;

	public OptionsManager(Properties prop) {
		this.prop = prop;
		this.co = new ChromeOptions();   
        this.fo = new FirefoxOptions();  
        this.eo = new EdgeOptions(); 
	}

	public ChromeOptions getChromeOption() {
		//to pass command from cmd : we can use System.getProperty("headless")
		if (Boolean.parseBoolean(prop.getProperty("headless").trim())) co.addArguments("--headless=new");
		if (Boolean.parseBoolean(prop.getProperty("incognito").trim())) co.addArguments("--incognito");
		return co;
	}

	public FirefoxOptions getFirefoxOption() {
		 boolean headless = Boolean.parseBoolean(
		            System.getProperty("headless", prop.getProperty("headless", "false"))
		    );

		    boolean incognito = Boolean.parseBoolean(
		            System.getProperty("incognito", prop.getProperty("incognito", "false"))
		    );

		    if (headless) fo.addArguments("--headless");
		    if (incognito) fo.addArguments("--private");
		return fo;
	}

	public EdgeOptions getEdgeOption() {
		if (Boolean.parseBoolean(prop.getProperty("headless").trim())) eo.addArguments("--headless=new");
		if (Boolean.parseBoolean(prop.getProperty("incognito").trim())) eo.addArguments("--inprivate");
		return eo;
	}
}
