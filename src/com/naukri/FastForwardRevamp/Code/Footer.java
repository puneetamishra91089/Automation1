package com.naukri.FastForwardRevamp.Code;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.naukri.GenericFunctionsPack.GenericFunctions;

public class Footer {
	WebDriver driver;
	GenericFunctions generic;

	public Footer(WebDriver driver, GenericFunctions generic)
	{
		this.driver = driver;
		this.generic = generic;
	}
	
	public static final String FooterLinks_WE = "//footer[@class='bgBlack']//a";
	public static final String Footer_TwitterLink_Lnk = "//a[@class='footrTwitr']";
	public static final String Validate_TwitterLinkLanding_WE = "//input[@value='Log in and Tweet']";
	public static final String BreadCrumb_Common_WE = "//div[@class='wrap breadCrmb']";
	public static final String BreadCrumb_Feedback_WE = "(//div[@class='noPrint'])[2]";

	
	public List<String> Return_Footer_LinkNames(){
		List<String> Link_Names = new ArrayList<String>();
		
		List<WebElement> WE = driver.findElements(By.xpath(FooterLinks_WE));
		
		for (WebElement webElement : WE) {
			Link_Names.add(webElement.getText());
		}
		
		return Link_Names;
		
	}
	
	public List<String> Return_Footer_LinkURLs(){
		List<String> Link_URLs = new ArrayList<String>();
		
		List<WebElement> WE = driver.findElements(By.xpath(FooterLinks_WE));
		
		for (WebElement webElement : WE) {
			Link_URLs.add(webElement.getAttribute("href"));
		}
		
		return Link_URLs;
	}


}
